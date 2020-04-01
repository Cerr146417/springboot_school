package com.cerr.school_api.entity;

/**
 * 教室实体类
 */
public class ClassRoom {
    private Integer id;
    private Integer capacity;   //教室容量
    private Integer floor;      //楼层
    private String buildName;   //所属教学楼名字
    private String extra;       //额外信息

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public ClassRoom(Integer capacity, Integer floor, String buildName, String extra) {
        this.capacity = capacity;
        this.floor = floor;
        this.buildName = buildName;
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", floor=" + floor +
                ", buildName='" + buildName + '\'' +
                ", extra='" + extra + '\'' +
                '}';
    }
}
