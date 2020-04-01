package com.cerr.school_api.controller;

import com.cerr.school_api.entity.ClassBorrow;
import com.cerr.school_api.service.ClassBorrowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "教室申请接口",tags = "教室申请接口")
@RequestMapping(value = "/classborrow")
@RestController
public class ClassBorrowController {

    @Autowired
    ClassBorrowService classBorrowService;

    /**
     * 根据id删除一条教室申请记录
     * @param id
     * @return：json
     */
    @ApiOperation(value = "根据id删除一条教室申请记录")
    @DeleteMapping(value = "/classborrow/{id}")
    public Map<String,Object> deleteClassBorrowById(@ApiParam(name = "id",value = "id") @PathVariable("id") Integer id){
        Map<String,Object> map = new HashMap<>();
        boolean res = classBorrowService.deleteClassBorrowById(id);
        if (res == false){
            map.put("status",0);
            map.put("message","该记录不存在，删除失败");
        }else {
            map.put("status",1);
            map.put("message","删除成功");
        }
        return map;
    }

    /**
     * 根据申请状态码查找所有符合条件的教室申请记录
     * @param status：申请状态
     * @return：json
     */
    @ApiOperation(value = "根据状态码status查找所有符合条件的教室申请记录")
    @PostMapping(value = "/classborrow_status")
    public Map<String,Object> queryClassBorrowByStatus(@ApiParam(name = "status",value = "申请状态") Integer status){
        Map<String,Object> map = new HashMap<>();
        List<ClassBorrow> classBorrows = new ArrayList<>();
        classBorrows = classBorrowService.queryClassBorrowByStatus(status);
        //有
        if (classBorrows.size() > 0){
            map.put("status",1);
            map.put("message","查找成功");
            map.put("classBorrowList",classBorrows);
        }else {
            map.put("status",0);
            map.put("message","暂无需要审批的申请");
        }
        return map;
    }


    /**
     * 根据学生学号查找所有符合条件的教室申请记录
     * @param stuId
     * @return
     */
    @ApiOperation(value = "根据学生学号查找所有符合条件的教室申请记录")
    @PostMapping(value = "/classborrow_stuid")
    public Map<String,Object> queryClassBorrowByStuId(@ApiParam(name = "stuId",value = "学生学号") String stuId){
        Map<String,Object> map = new HashMap<>();
        List<ClassBorrow> classBorrows = new ArrayList<>();
        classBorrows = classBorrowService.queryClassBorrowByStuId(stuId);
        //有
        if (classBorrows.size() > 0){
            map.put("status",1);
            map.put("message","查找成功");
            map.put("classBorrowList",classBorrows);
        }else {
            map.put("status",0);
            map.put("message","找不到该学生的申请");
        }
        return map;
    }


}
