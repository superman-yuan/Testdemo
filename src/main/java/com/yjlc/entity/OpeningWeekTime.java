package com.yjlc.entity;

import java.util.Date;

public class OpeningWeekTime {
    private Integer subscribeTimeId;

    private Date subscribeTimeStart;

    private Date subscribeTimeEnd;

    private String subscribeTimeDescription;

    private String week;

    private Integer delete;

    private Integer type;

    public Integer getSubscribeTimeId() {
        return subscribeTimeId;
    }

    public void setSubscribeTimeId(Integer subscribeTimeId) {
        this.subscribeTimeId = subscribeTimeId;
    }

    public Date getSubscribeTimeStart() {
        return subscribeTimeStart;
    }

    public void setSubscribeTimeStart(Date subscribeTimeStart) {
        this.subscribeTimeStart = subscribeTimeStart;
    }

    public Date getSubscribeTimeEnd() {
        return subscribeTimeEnd;
    }

    public void setSubscribeTimeEnd(Date subscribeTimeEnd) {
        this.subscribeTimeEnd = subscribeTimeEnd;
    }

    public String getSubscribeTimeDescription() {
        return subscribeTimeDescription;
    }

    public void setSubscribeTimeDescription(String subscribeTimeDescription) {
        this.subscribeTimeDescription = subscribeTimeDescription == null ? null : subscribeTimeDescription.trim();
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week == null ? null : week.trim();
    }

    public Integer getDelete() {
        return delete;
    }

    public void setDelete(Integer delete) {
        this.delete = delete;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}