package com.example.mongo.repository;

import com.example.mongo.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface EmployeeRepository extends MongoRepository<Employee, String> {




}
