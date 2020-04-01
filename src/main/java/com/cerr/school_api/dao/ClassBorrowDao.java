package com.cerr.school_api.dao;

import com.cerr.school_api.entity.ClassBorrow;

import java.util.List;


public interface ClassBorrowDao {

    /**
     * 插入教室申请
     * @param classBorrow
     */
    public void insertClassBorrow(ClassBorrow classBorrow);

    /**
     * 根据id删除教室申请
     * @param id
     */
    public void deleteClassBorrow(Integer id);

    /**
     * 根据学生学号来查找所有教室申请记录
     * @param stuId
     * @return
     */
    public List<ClassBorrow> selectClassBorrowByStuId(String stuId);

    /**
     * 修改教室申请
     * @param classBorrow
     */
    public void updateClassBorrow(ClassBorrow classBorrow);

    /**
     * 根据申请状态来查询所有教室申请记录
     * @param status
     * @return
     */
    public List<ClassBorrow> selectClassBorrowByStatus(Integer status);

    /**
     * 根据id查找教室申请记录
     * @param id
     * @return
     */
    public ClassBorrow selectClassBorrowById(Integer id);
}
