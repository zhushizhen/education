package com.richdoor.entity;

public class StudentEntity {
    private String id;

    private String restuid;

    private String workid;

    private String money;

    private Integer courseid;

    private Double score;

    private String retid;

    private String opinion;

    private String teaassess;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRestuid() {
        return restuid;
    }

    public void setRestuid(String restuid) {
        this.restuid = restuid == null ? null : restuid.trim();
    }

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid == null ? null : workid.trim();
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getRetid() {
        return retid;
    }

    public void setRetid(String retid) {
        this.retid = retid == null ? null : retid.trim();
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion == null ? null : opinion.trim();
    }

    public String getTeaassess() {
        return teaassess;
    }

    public void setTeaassess(String teaassess) {
        this.teaassess = teaassess == null ? null : teaassess.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}