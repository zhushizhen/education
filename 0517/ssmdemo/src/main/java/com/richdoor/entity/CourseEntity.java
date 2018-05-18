package com.richdoor.entity;

public class CourseEntity {
    private Integer id;

    private String coursename;

    private String courseinfo;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
    }

    public String getCourseinfo() {
        return courseinfo;
    }

    public void setCourseinfo(String courseinfo) {
        this.courseinfo = courseinfo == null ? null : courseinfo.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}