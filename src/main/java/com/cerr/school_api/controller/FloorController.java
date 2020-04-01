package com.cerr.school_api.controller;

import com.cerr.school_api.entity.Floor;
import com.cerr.school_api.service.FloorService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "楼层接口",tags = "对楼层进行操作")
@RestController
@RequestMapping(value = "/floor")
public class FloorController {

    @Autowired
    FloorService floorService;

    /**
     * 查出该教学楼有的楼层列表
     * @param buildName：教学楼名称
     * @return  json
     */
    @ApiOperation(value = "查楼层列表",notes = "根据教学楼来查楼层列表")
    @GetMapping(value = "/floors")
    public Map<String,Object> getFloors(@ApiParam(name = "buildName",value = "教学楼名称",required = true) String buildName){
        Map<String,Object> json = new HashMap<>();
        if (buildName == null){
            json.put("status",0);
            json.put("message","教学楼不能为空");
            return json;
        }
        List<Floor> floors = floorService.getListFloor(buildName);
        json.put("floorList",floors);
        json.put("status",1);
        json.put("message","查询成功");
        return json;
    }

    /**
     * 新增楼层
     * @param buildName：教学楼名称
     * @param floorNum：楼层数字
     * @return  json
     */
    @ApiOperation(value = "新增楼层")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "buildName",dataType = "String",paramType = "query",required = true,value = "教学楼名称"),
        @ApiImplicitParam(name = "floorNum",dataType = "Integer",paramType = "query",required = true,value = "楼层数字")
    })
    @PostMapping(value = "/floor")
    public Map<String,Object> addFloor(String buildName,Integer floorNum){
        Map<String,Object> json = new HashMap<>();
        if (buildName == null || floorNum == null){
            json.put("status",0);
            json.put("message","教学楼或楼层数不能为空");
            return json;
        }
        boolean res = floorService.addFloor(buildName,floorNum);
        //楼层已经存在
        if ( res == false){
            json.put("status",0);
            json.put("message","该楼层已存在");
            return json;
        }
        //添加成功
        json.put("status",1);
        json.put("message","添加成功");
        return json;
    }

    /**
     * 删除楼层
     * @param buildName：教学楼名称
     * @param floorNum：楼层数字
     * @return  json
     */
    @ApiOperation(value = "删除楼层")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "buildName",dataType = "String",paramType = "query",required = true,value = "教学楼名称"),
            @ApiImplicitParam(name = "floorNum",dataType = "Integer",paramType = "query",required = true,value = "楼层数字")
    })
    @DeleteMapping(value = "/floor")
    public Map<String,Object> deleteFloor(String buildName,Integer floorNum){
        Map<String,Object> json = new HashMap<>();
        if (buildName == null || floorNum == null){
            json.put("status",0);
            json.put("message","教学楼或楼层数不能为空");
            return json;
        }
        System.out.println("sss");
        boolean res = floorService.deleteFloor(buildName,floorNum);
        //楼层不存在
        if ( res == false){
            json.put("status",0);
            json.put("message","该楼层不存在");
            return json;
        }
        //删除成功
        json.put("status",1);
        json.put("message","删除成功");
        return json;
    }
}
