package com.axamit.dto;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResponseForDay {
    private Integer allVisitsToday;
    private Integer uniqueUsersToday;

    public ResponseForDay() {
    }

    public ResponseForDay(Integer allVisitsToday, Integer uniqueUsersToday) {
        this.allVisitsToday = allVisitsToday;
        this.uniqueUsersToday = uniqueUsersToday;
    }

    public Integer getAllVisitsToday() {
        return allVisitsToday;
    }

    public void setAllVisitsToday(Integer allVisitsToday) {
        this.allVisitsToday = allVisitsToday;
    }

    public Integer getUniqueUsersToday() {
        return uniqueUsersToday;
    }

    public void setUniqueUsersToday(Integer uniqueUsersToday) {
        this.uniqueUsersToday = uniqueUsersToday;
    }
}
