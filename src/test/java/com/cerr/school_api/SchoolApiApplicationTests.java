package com.cerr.school_api;

import com.cerr.school_api.dao.ClassBorrowDao;
import com.cerr.school_api.dao.ClassRoomDao;
import com.cerr.school_api.dao.FloorDao;
import com.cerr.school_api.dao.StudentDao;
import com.cerr.school_api.entity.ClassBorrow;
import com.cerr.school_api.entity.ClassRoom;
import com.cerr.school_api.entity.Floor;
import com.cerr.school_api.entity.Student;
import com.cerr.school_api.service.ClassRoomService;
import com.cerr.school_api.utils.shaEncryption;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

@SpringBootTest
class SchoolApiApplicationTests {

//    @Autowired
//    private StudentDao studentDao;
//    @Autowired
    //private FloorDao floorDao;
    @Autowired
    private ClassRoomDao classRoomDao;
    @Autowired
    private ClassRoomService service;
    @Autowired
    private ClassBorrowDao classBorrowDao;


    /**
     * 测试教室申请
     */
    @Test
    void testClassBorrowDao(){
        //插入教室申请：success
        classBorrowDao.insertClassBorrow(new ClassBorrow("171110102",new Date(),"1-",new Date(),"开班会",0,1));
        //删除教室申请：success
        //classBorrowDao.deleteClassBorrow(2);
        //根据学生学号来查找所有教室申请记录：success
        //System.out.println(classBorrowDao.selectClassBorrowByStuId("171110102"));
        //修改教室申请：success
        //classBorrowDao.updateClassBorrow(new ClassBorrow(1,"171110102",new Date(),"1-",new Date(),"开班会",0,1));
        //根据申请状态来查询所有教室申请记录：success
        //System.out.println(classBorrowDao.selectClassBorrowByStatus(0));
        //根据id查教室
        System.out.println(classBorrowDao.selectClassBorrowById(1));
    }

//    @Test
//    void testClassroom(){
//        boolean is = service.addClassRoom(new ClassRoom(56,6,"锡科","601"));
//        System.out.println(is);
//
//        //System.out.println(classRoomDao.selectClassRoomByFloorAndBuild("锡科",5));
//    }

    /**
     * 测试楼层Dao
     */
//    @Test
//    void testFloorDao(){
//        System.out.println("2.99-3.00="+(2.99-3.00));
        //测试新增
        //floorDao.addFloor(new Floor(4,"锡科"));
        //测试删除
        //floorDao.deleteFloor(new Floor(3,"锡科"));
        //测试查询所有
//        List<Floor> floors = floorDao.queryFloorByBuildName("锡科");
//        for (Floor f : floors){
//            System.out.println(f);
//        }
        //根据floor来查floor
        //System.out.println(floorDao.queryFloorByBuildNameAndFloorNum(new Floor(2,"锡科")));
    //}

//    @Test
//    void testStudentDao() {
//        Student student = studentDao.getStudentById("171110101");
//        System.out.println(student);
//    }

//    /**
//     * 测试加密
//     */
//    @Test
//    void testJM() throws NoSuchAlgorithmException {
//        String str = "123456";
//        //System.out.println();
//        System.out.println(shaEncryption.encryption(str));//b7i830ns2h47l608mjskhb1ukjcemr4b
//
//    }

}
