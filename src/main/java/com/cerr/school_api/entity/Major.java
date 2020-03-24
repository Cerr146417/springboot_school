package com.cerr.school_api.entity;

/**
 * 专业实体类
 */
public class Major {
    private Integer id;
    private String majorName;   //专业名
    private Integer deptId;     //所属学院

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}
