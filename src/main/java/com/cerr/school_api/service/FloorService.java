package com.cerr.school_api.service;

import com.cerr.school_api.dao.FloorDao;
import com.cerr.school_api.entity.Floor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorService {
    @Autowired
    FloorDao floorDao ;

    /**
     * 根据教学楼名字来查该教学楼所有楼层
     * @param buildName：教学楼名字
     * @return List<楼层>
     */
    public List<Floor> getListFloor(String buildName){
        return floorDao.queryFloorByBuildName(buildName);
    }

    /**
     * 新增一个楼层
     * @param buildName：教学楼名字
     * @param floorNum：楼层
     * @return 楼层已存在返回false，新建成功返回true
     */
    public boolean addFloor(String buildName,Integer floorNum){
        Floor floor = new Floor(floorNum,buildName);
        //该楼层存在
        if(floorDao.queryFloorByBuildNameAndFloorNum(floor) != null)    return false;

        floorDao.addFloor(floor);
        return true;
    }

    /**
     * 删除一个楼层
     * @param buildName
     * @param floorNum
     * @return 楼层不存在返回false，删除成功返回true
     */
    public boolean deleteFloor(String buildName,Integer floorNum){
        Floor floor = new Floor(floorNum,buildName);
        //该楼层不存在
        if(floorDao.queryFloorByBuildNameAndFloorNum(floor) == null)    return false;
        floorDao.deleteFloor(floor);
        return true;
    }

}
