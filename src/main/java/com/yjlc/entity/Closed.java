package com.yjlc.entity;

import java.util.Date;

public class Closed {
    private Integer id;

    private Date startTime;

    private Date endTime;

    private Date addTime;

    private String inamonth;

    private Integer subscribeTimeId;

    private String week;

    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getInamonth() {
        return inamonth;
    }

    public void setInamonth(String inamonth) {
        this.inamonth = inamonth == null ? null : inamonth.trim();
    }

    public Integer getSubscribeTimeId() {
        return subscribeTimeId;
    }

    public void setSubscribeTimeId(Integer subscribeTimeId) {
        this.subscribeTimeId = subscribeTimeId;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week == null ? null : week.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}