package com.cerr.school_api.entity;

/**
 * 学院实体类
 */
public class Dept {

    private Integer id;
    private String deptName;    //学院姓名

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
