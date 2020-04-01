package com.cerr.school_api.service;

import com.cerr.school_api.dao.ClassBorrowDao;
import com.cerr.school_api.entity.ClassBorrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassBorrowService {

    @Autowired
    ClassBorrowDao classBorrowDao;

    /**
     * 根据id删除申请教室记录
     * @param id
     * @return 存在则返回true并删除；不存在则返回false
     */
    public boolean deleteClassBorrowById(Integer id){
        ClassBorrow classBorrow = null;
        classBorrow = classBorrowDao.selectClassBorrowById(id);
        //不存在
        if (classBorrow == null){
            return false;
        }
        classBorrowDao.deleteClassBorrow(id);
        return true;
    }

    /**
     * 根据申请状态来查找申请教室记录
     * @param status：申请状态
     * @return：List
     */
    public List<ClassBorrow> queryClassBorrowByStatus(Integer status){
        return classBorrowDao.selectClassBorrowByStatus(status);
    }

    public List<ClassBorrow> queryClassBorrowByStuId(String stuId){
        return classBorrowDao.selectClassBorrowByStuId(stuId);
    }
}
