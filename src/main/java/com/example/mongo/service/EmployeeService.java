package com.example.mongo.service;

import com.example.mongo.converter.EmployeeConverter;
import com.example.mongo.exception.NotFoundException;
import com.example.mongo.model.Employee;
import com.example.mongo.repository.EmployeeRepository;
import com.example.mongo.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import static com.example.mongo.converter.EmployeeConverter.toEntity;
import static com.example.mongo.converter.EmployeeConverter.toVo;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void create(final EmployeeVO employeeVO) {
        employeeRepository.save(toEntity(employeeVO));
    }

    public void update(String id, EmployeeVO vo) {
        Optional<Employee> employeeFind = employeeRepository.findById(id);
        if(employeeFind.isPresent()){
            Employee employee = employeeFind.get();
            employee.setSalary(vo.getSalary());
            employee.setPosition(vo.getPosition());
            employee.setName(vo.getName());
            employeeRepository. save(employee);
        }
    }

    public EmployeeVO get(String id) {
        return toVo(employeeRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    public List<EmployeeVO> findAll() {
        return toVo(employeeRepository.findAll());
    }
}
