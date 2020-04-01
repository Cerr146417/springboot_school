package com.cerr.school_api.dao;

import com.cerr.school_api.entity.ClassRoom;

import java.util.List;

public interface ClassRoomDao {


    /**
     * 根据教学楼名字和楼层来查所有教室
     * @param buildName
     * @param floor
     * @return
     */
    public List<ClassRoom> selectClassRoomByFloorAndBuild(String buildName,Integer floor);

    /**
     * 根据教学楼名字和楼层和教室名来查所有教室
     * @param buildName
     * @param floor
     * @return
     */
    public ClassRoom selectClassRoomByFloorAndBuildAndClass(String buildName,Integer floor,String extra);

    /**
     * 新增教室
     * @param classRoom：教室类
     */
    public void insertClassRoom(ClassRoom classRoom);


}
