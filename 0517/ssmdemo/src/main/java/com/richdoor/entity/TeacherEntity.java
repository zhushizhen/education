package com.richdoor.entity;

public class TeacherEntity {
    private String id;

    private String reatid;

    private Integer workid;

    private String opinion;

    private String managerassess;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getReatid() {
        return reatid;
    }

    public void setReatid(String reatid) {
        this.reatid = reatid == null ? null : reatid.trim();
    }

    public Integer getWorkid() {
        return workid;
    }

    public void setWorkid(Integer workid) {
        this.workid = workid;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion == null ? null : opinion.trim();
    }

    public String getManagerassess() {
        return managerassess;
    }

    public void setManagerassess(String managerassess) {
        this.managerassess = managerassess == null ? null : managerassess.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}