package com.axamit.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResponseForPeriod {

    private Integer allVisits;
    private Integer uniqueUsers;
    private Integer regularUsers;

    public ResponseForPeriod() {
    }

    public ResponseForPeriod(Integer allVisits, Integer uniqueUsers, Integer regularUsers) {
        this.allVisits = allVisits;
        this.uniqueUsers = uniqueUsers;
        this.regularUsers = regularUsers;
    }

    public Integer getAllVisits() {
        return allVisits;
    }

    public void setAllVisits(Integer allVisits) {
        this.allVisits = allVisits;
    }

    public Integer getUniqueUsers() {
        return uniqueUsers;
    }

    public void setUniqueUsers(Integer uniqueUsers) {
        this.uniqueUsers = uniqueUsers;
    }

    public Integer getRegularUsers() {
        return regularUsers;
    }

    public void setRegularUsers(Integer regularUsers) {
        this.regularUsers = regularUsers;
    }
}
