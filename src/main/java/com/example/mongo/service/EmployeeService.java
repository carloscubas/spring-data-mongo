package com.example.mongo.service;

import static com.example.mongo.converter.EmployeeConverter.toEntity;
import static com.example.mongo.converter.EmployeeConverter.toVo;
import java.util.List;
import com.example.mongo.exception.NotFoundException;
import com.example.mongo.model.Employee;
import com.example.mongo.repository.EmployeeRepository;
import com.example.mongo.vo.EmployeeSummaryVO;
import com.example.mongo.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void create(final EmployeeVO employeeVO) {
        employeeRepository.save(toEntity(employeeVO));
    }

    public void update(String id, EmployeeVO vo) {
        Employee employee = employeeRepository.findById(id).orElseThrow(NotFoundException::new);
        employeeRepository.save(toEntity(employee, vo));
    }

    public EmployeeVO get(String id) {
        return toVo(employeeRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    public List<EmployeeVO> findAll() {
        return toVo(employeeRepository.findAll());
    }

    public EmployeeSummaryVO sumary () {
        return employeeRepository.getSummary();
    }
}
