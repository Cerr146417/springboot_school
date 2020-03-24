package com.cerr.school_api.controller;

import com.cerr.school_api.service.UserService;
import com.cerr.school_api.utils.MySessionContext;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@Api(value = "用户接口",tags = "用户操作")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /***
     * 用户登录
     * @param username：用户名
     * @param password：密码
     * @param request：HttpServletRequest
     * @return
     */
    @ApiOperation(value = "用户登录",notes = "处理用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "username",value = "用户名",dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "password",value = "用户密码",dataType = "String"),
            @ApiImplicitParam(paramType = "header",name = "request",value = "请求头",dataType = "HttpRequest")
    })
    @GetMapping(value = "/login")
    public Map<String,Object> getLogin(String username, String password, HttpServletRequest request) throws NoSuchAlgorithmException {
        Map<String,Object> json = new HashMap<>();
        if(userService.userLogin(username,password) == true){
            //System.out.println(request.getSession());
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(60*60*24);   //设置session过期时间：以秒为单位
            String sessionId = session.getId();
            //System.out.println(sessionId);
            json.put("sessionId",sessionId);
            json.put("user",username);
            json.put("status",1);
            json.put("message","登录成功");
        }else {
            json.put("status",0);
            json.put("message","登录失败");
        }
        return json;
    }


    /***
     * 退出登录
     * @param sessionId：sessionid
     * @return json
     */
    @ApiOperation(value = "退出登录",notes = "处理用户注销")
    @GetMapping(value = "/logout")
    public Map<String,Object> getLogout(@ApiParam(name = "sessionId",value = "sessionId") @RequestHeader("sessionId") String sessionId){
        Map<String,Object> json = new HashMap<>();
        if (sessionId == null){
            json.put("status",0);
            json.put("message","没有登录，无需退出");
            return json;
        }
        //使session失效
        HttpSession session = MySessionContext.getSessionById(sessionId);
        if (session != null){
            //销毁session
            session.invalidate();
            json.put("message","退出成功");
            json.put("status",1);
        }
        return json;
    }

    /**
     * 注册用户
     * @param username：用户名
     * @param password：密码
     * @return
     */
    @ApiOperation(value = "用户注册",notes = "用户注册操作")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名",required = true,dataType = "query"),
            @ApiImplicitParam(name = "password",value = "密码",required = true,dataType = "query")
    })
    @GetMapping("/register")
    public Map<String,Object> registerUser(String username,String password) throws NoSuchAlgorithmException {
        Map<String,Object> json = new HashMap<>();
        Map<String,Object> map = userService.addUser(username,password);
        if (map.get("code").toString().equals("0")){
            json.put("status",1);
        }else {
            json.put("status",0);
        }
        json.put("message",map.get("message"));
        return json;
    }

    /**
     * 修改密码
     * @param username：用户名
     * @param password：原密码
     * @param newPassword：新密码
     * @return
     */
    @ApiOperation(value = "修改密码",notes = "用户修改密码操作")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名",required = true,dataType = "query"),
            @ApiImplicitParam(name = "password",value = "原密码",required = true,dataType = "query"),
            @ApiImplicitParam(name = "newPassword",value = "新密码",required = true,dataType = "query")
    })
    @GetMapping("/updatePassword")
    public Map<String,Object> updatePassword(String username,String password,String newPassword) throws NoSuchAlgorithmException {
        Map<String,Object> json = new HashMap<>();
        if (password.equals(newPassword)){
            json.put("status",0);
            json.put("message","原密码和新密码不能相同");
            return json;
        }
        boolean is = userService.updatePassword(username,password,newPassword);
        if (is != true){
            //密码错误
            json.put("status",0);
            json.put("message","用户名或者旧密码错误");
            return json;
        }
        json.put("status",1);
        json.put("message","密码修改成功");
        return json;
    }

}
