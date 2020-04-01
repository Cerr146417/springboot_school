package com.cerr.school_api.controller;

import com.cerr.school_api.entity.ClassRoom;
import com.cerr.school_api.entity.Floor;
import com.cerr.school_api.service.ClassRoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "教室接口",tags = "教室接口")
@RequestMapping(value = "/classroom")
@RestController
public class ClassRoomController {

    @Autowired
    ClassRoomService classRoomService;

    /**
     * 根据楼层和教学楼查出所有教室
     * @param floor：楼层
     * @param buildName：教学楼
     * @return：教室
     */
    @ApiOperation(value = "根据楼层和教学楼查出所有教室")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "floor",dataType = "Integer",paramType = "query",required = true,value = "教学楼名称"),
            @ApiImplicitParam(name = "buildName",dataType = "String",paramType = "query",required = true,value = "楼层数字")
    })
    @GetMapping(value = "/classrooms_all")
    public Map<String,Object> getClassRoomByFloorAndBuild(Integer floor,String buildName){
        Map<String,Object> map = new HashMap<>();
        List<ClassRoom> classRooms = new ArrayList<>();
        if (floor == null || buildName == null || buildName.equals("")){
            map.put("status",0);
            map.put("message","信息不能为空");
            return map;
        }
        classRooms= classRoomService.getClassRoomByFloorAndBuild(floor,buildName);
        map.put("status",1);
        map.put("message","查询成功");
        map.put("classrooms",classRooms);
        return map;
    }


    /**
     * 新增教室
     * @param capacity：教室容量
     * @param floor：所属楼层
     * @param buildName：所属教学楼
     * @param extra：附属信息
     * @return：json
     */
    @ApiOperation(value = "新增教室")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "capacity",dataType = "Integer",paramType = "query",required = true,value = "教室容量"),
            @ApiImplicitParam(name = "floor",dataType = "Integer",paramType = "query",required = true,value = "所属楼层"),
            @ApiImplicitParam(name = "buildName",dataType = "String",paramType = "query",required = true,value = "所属教学楼名字"),
            @ApiImplicitParam(name = "extra",dataType = "String",paramType = "query",required = true,value = "教室名字(例如501)")
    })
    @PostMapping(value = "/classroom")
    public Map<String,Object> addClassRoom(Integer capacity, Integer floor, String buildName, String extra){
        Map<String,Object> map = new HashMap<>();
        if(capacity == null || floor == null || buildName ==null || extra == null) {
            map.put("status",0);
            map.put("message","信息不能为空");
            return map;
        }
        ClassRoom classRoom = new ClassRoom(capacity,floor,buildName,extra);
        boolean res = classRoomService.addClassRoom(classRoom);
        //教室已存在
        if (res == false){
            map.put("status",0);
            map.put("message","该教室已经存在，添加失败");
            return map;
        }
        map.put("status",1);
        map.put("message","添加成功");
        return map;
    }
}
