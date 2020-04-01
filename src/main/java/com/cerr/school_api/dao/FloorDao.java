package com.cerr.school_api.dao;

import com.cerr.school_api.entity.Floor;

import java.util.List;

public interface FloorDao {

    //根据教学楼名字来查所有楼层
    public List<Floor> queryFloorByBuildName(String buildName);

    //新增楼层
    public void addFloor(Floor floor);

    //删除一个楼层
    public void deleteFloor(Floor floor);

    //根据教学楼名字和层数来查楼层
    public Floor queryFloorByBuildNameAndFloorNum(Floor floor);
}
