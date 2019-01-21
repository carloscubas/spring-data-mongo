package com.example.mongo.converter;

import com.example.mongo.model.Employee;
import com.example.mongo.vo.EmployeeVO;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeConverter {

    public static Employee toEntity(EmployeeVO vo){
        Employee entity = new Employee();
        entity.setName(vo.getName());
        entity.setPosition(vo.getPosition());
        entity.setSalary(vo.getSalary());
        return entity;
    }

    public static EmployeeVO toVo(Employee entity) {
        EmployeeVO vo = new EmployeeVO();
        vo.setName(entity.getName());
        vo.setPosition(entity.getPosition());
        vo.setSalary(entity.getSalary());
        return vo;
    }

    public static List<EmployeeVO> toVo(List<Employee> entitys) {
        return  entitys.stream().map(EmployeeConverter::toVo).collect(Collectors.toList());
    }

    public static Employee toEntity(String id, EmployeeVO vo) {
        Employee employee = toEntity(vo);
        employee.set_id(id);
        return employee;
    }
}
