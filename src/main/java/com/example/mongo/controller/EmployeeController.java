package com.example.mongo.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.FOUND;
import static org.springframework.http.HttpStatus.GONE;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import com.example.mongo.exception.NotFoundException;
import com.example.mongo.service.EmployeeService;
import com.example.mongo.vo.EmployeeSummaryVO;
import com.example.mongo.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    public static final String REQUEST_EMPLOYEE_CREATE = "/create";
    public static final String REQUEST_EMPLOYEE_UPDATE = "/update/{id}";
    public static final String REQUEST_EMPLOYEE_GET = "/{id}";
    public static final String REQUEST_EMPLOYEE_ALL = "/";
    public static final String REQUEST_EMPLOYEE_SUMMARY = "/summary";
    public static final String REQUEST_EMPLOYEE_DELETE = "/{id}";


    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = REQUEST_EMPLOYEE_CREATE)
    public ResponseEntity create(@RequestBody EmployeeVO vo) {
        employeeService.create(vo);
        return new ResponseEntity<>(CREATED);
    }

    @PutMapping(value = REQUEST_EMPLOYEE_UPDATE)
    public ResponseEntity update(@PathVariable("id") final String id, @RequestBody EmployeeVO vo) {
        try{
            employeeService.update(id, vo);
            return new ResponseEntity<>(OK);
        }catch (NotFoundException e){
            return new ResponseEntity(NOT_FOUND);
        }
    }

    @GetMapping(value = REQUEST_EMPLOYEE_GET)
    public ResponseEntity<EmployeeVO> get(@PathVariable("id") final String id) {
        try{
            return new ResponseEntity<EmployeeVO>(employeeService.get(id), FOUND);
        }catch (NotFoundException e){
            return new ResponseEntity(NOT_FOUND);
        }
    }

    @GetMapping(value = REQUEST_EMPLOYEE_ALL)
    public ResponseEntity<List<EmployeeVO>> getAll() {
        try{
            return new ResponseEntity<List<EmployeeVO>>(employeeService.findAll(), FOUND);
        }catch (NotFoundException e){
            return new ResponseEntity(NOT_FOUND);
        }
    }

    @GetMapping(value = REQUEST_EMPLOYEE_SUMMARY)
    public ResponseEntity<EmployeeSummaryVO> getAllAvg() {
        return new ResponseEntity<EmployeeSummaryVO>(employeeService.sumary(), FOUND);
    }

    @DeleteMapping(value = REQUEST_EMPLOYEE_DELETE)
    public ResponseEntity delete(@PathVariable("id") final String id) {
        employeeService.delete(id);
        return new ResponseEntity(GONE);
    }
}
