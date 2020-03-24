package com.cerr.school_api.service;

import com.cerr.school_api.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    /**
     * 根据id判断是否存在该学生
     * @param id
     * @return 存在则返回true，否则返回false
     */
    public boolean isExistStudent(String id){
        if (id == null) return false;

        if (studentDao.getStudentById(id) == null)  return false;

        return true;
    }
}
