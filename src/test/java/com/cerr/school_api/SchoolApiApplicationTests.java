package com.cerr.school_api;

import com.cerr.school_api.dao.StudentDao;
import com.cerr.school_api.entity.Student;
import com.cerr.school_api.utils.shaEncryption;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.NoSuchAlgorithmException;

@SpringBootTest
class SchoolApiApplicationTests {

    @Autowired
    private StudentDao studentDao;

    @Test
    void testStudentDao() {
        Student student = studentDao.getStudentById("171110101");
        System.out.println(student);
    }

    /**
     * 测试加密
     */
    @Test
    void testJM() throws NoSuchAlgorithmException {
        String str = "123456";
        //System.out.println();
        System.out.println(shaEncryption.encryption(str));//b7i830ns2h47l608mjskhb1ukjcemr4b

    }

}
