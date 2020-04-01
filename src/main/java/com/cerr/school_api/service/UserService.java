package com.cerr.school_api.service;

import com.cerr.school_api.dao.UserDao;
import com.cerr.school_api.entity.Student;
import com.cerr.school_api.utils.shaEncryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private StudentService studentService;

    /**
     * 检查账号密码是否正确
     * @param username：用户名
     * @param password：密码
     * @return
     */
    private boolean checkUserAccount(String username,String password){
        if (userDao.queryUserByNameAndPassword(username,password) == null)  return false;

        return true;
    }

    /**
     * 用户登录
     * @param username：用户名
     * @param password：密码
     * @return
     */
    public boolean userLogin(String username,String password) throws NoSuchAlgorithmException {
        if (username.equals("") || password.equals("")) return false;
        //加密
        String shaPassword = shaEncryption.encryption(password);
        //检查账号密码是否正确
        return checkUserAccount(username,shaPassword);
    }

    /**
     * 添加用户
     * @param username：用户名
     * @param password：密码
     * @return
     */
    public Map<String,Object> addUser(String username, String password) throws NoSuchAlgorithmException {
        Map<String,Object> map = new HashMap<>();
        //账号密码为空
        if (username == null || password == null){
            map.put("code","1");
            map.put("message","账号密码为空");
            return map;
        }
        //学生表中没有该学生
        if (studentService.isExistStudent(username) == false){
            map.put("code","2");
            map.put("message","学生表中没有该学生");
            return map;
        }
        //该学生已经注册过
        if (userDao.queryUserByUserName(username) != null){
            map.put("code","3");
            map.put("message","该学生已经注册过");
            return map;
        }
        //加密
        String shaPassword = shaEncryption.encryption(password);
        userDao.insertUser(username,shaPassword);
        map.put("code","0");
        map.put("message","注册成功");
        return map;
    }

    /**
     * 修改密码
     * @param username：用户名
     * @param password：原密码
     * @param newPassword：新密码
     * @return  成功则返回true，失败返回false
     * @throws NoSuchAlgorithmException
     */
    public boolean updatePassword(String username,String password,String newPassword) throws NoSuchAlgorithmException {
        //账号密码错误
        if(checkUserAccount(username,shaEncryption.encryption(password)) != true){
            System.out.println("111");
            return false;
        }
        //加密
        String passW = shaEncryption.encryption(newPassword);
        userDao.updateUserPassword(username,password,passW);
        return true;
    }
}
