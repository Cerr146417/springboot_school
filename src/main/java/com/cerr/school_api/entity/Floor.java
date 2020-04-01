package com.cerr.school_api.entity;

import java.util.List;

public class Floor {

    private Integer id;

    private Integer floorNum;   //层数

    //所属教学楼
    private String buildName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(Integer floorNum) {
        this.floorNum = floorNum;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public Floor(Integer floorNum, String buildName) {
        this.floorNum = floorNum;
        this.buildName = buildName;
    }

    public Floor() {
    }


    @Override
    public String toString() {
        return "Floor{" +
                "id=" + id +
                ", floorNum=" + floorNum +
                ", buildName='" + buildName + '\'' +
                '}';
    }




}
