package com.cerr.school_api.dao;

import com.cerr.school_api.entity.Student;
import org.springframework.stereotype.Service;


public interface StudentDao {

    /**
     * 通过id获取学生
     * @param id
     * @return
     */
    public Student getStudentById(String id);

    /**
     * 新增学生
     * @param student
     */
    public void addStudent(Student student);

    /**
     * 删除学生
     * @param id
     */
    public void deleteStudentById(String id);

    /**
     * 修改学生
     * @param student
     */
    public void updateStudent(Student student);

}
