package com.cerr.school_api.dao;

import com.cerr.school_api.entity.User;

public interface UserDao {

    /**
     * 根据用户名和密码查找用户
     * @param username
     * @param password
     * @return User
     */
    public User queryUserByNameAndPassword(String username,String password);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User queryUserByUserName(String username);

    /**
     * 新增用户
     * @param username
     * @param password
     */
    public void insertUser(String username,String password);

    /**
     * 修改用户密码
     * @param username：用户名
     * @param password：原密码
     * @param newPassword：新密码
     * @return
     */
    public boolean updateUserPassword(String username,String password,String newPassword);

}
