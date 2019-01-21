package com.example.mongo.repository;

import com.example.mongo.vo.EmployeeSummaryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.rest.core.config.Projection;


import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

public class EmployeeCustomImpl implements EmployeeCustom{

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public EmployeeSummaryVO getSummary() {
        Aggregation agg = newAggregation(
                group() .count().as("total")
                .avg("salary").as("avg")
                .sum("salary").as("sum"),
                project("total", "avg","sum"));

        AggregationResults<EmployeeSummaryVO> result = mongoTemplate
                .aggregate(agg, "employee", EmployeeSummaryVO.class);
        return result.getUniqueMappedResult();
    }
}
