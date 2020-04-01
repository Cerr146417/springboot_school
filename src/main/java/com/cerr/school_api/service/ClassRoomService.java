package com.cerr.school_api.service;

import com.cerr.school_api.dao.ClassRoomDao;
import com.cerr.school_api.entity.ClassRoom;
import com.cerr.school_api.entity.Floor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassRoomService {

    @Autowired
    ClassRoomDao classRoomDao ;

    /**
     *
     * @param floor
     * @param buildName
     * @return
     */
    public List<ClassRoom> getClassRoomByFloorAndBuild(Integer floor,String buildName){
        List<ClassRoom> classRooms = new ArrayList<>();
        classRooms = classRoomDao.selectClassRoomByFloorAndBuild(buildName,floor);
        return classRooms;
    }

    /**
     * 新增教室
     * @param classRoom：教室实体类
     * @return：boolean
     */
    public boolean addClassRoom(ClassRoom classRoom){
        if (classRoomDao.selectClassRoomByFloorAndBuildAndClass(classRoom.getBuildName(),classRoom.getFloor(),classRoom.getExtra())!=null){
            return false;
        }
        classRoomDao.insertClassRoom(classRoom);
        return true;
    }
}
