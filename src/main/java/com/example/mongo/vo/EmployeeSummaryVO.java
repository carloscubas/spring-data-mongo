package com.example.mongo.vo;

/**
 * @author s2it_csilva
 * @version $Revision: $<br/>
 * $Id: $
 * @since 1/21/19 1:30 PM
 */
public class EmployeeSummaryVO {

    Long sum;

    Double avg;

    Long count;

    public Long getSum () {
        return sum;
    }

    public void setSum (final Long sum) {
        this.sum = sum;
    }

    public Double getAvg () {
        return avg;
    }

    public void setAvg (final Double avg) {
        this.avg = avg;
    }

    public Long getCount () {
        return count;
    }

    public void setCount (final Long count) {
        this.count = count;
    }
}
