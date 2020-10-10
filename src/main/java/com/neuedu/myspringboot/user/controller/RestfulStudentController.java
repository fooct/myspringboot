package com.neuedu.myspringboot.user.controller;


import com.neuedu.myspringboot.common.exp.Student;
import com.neuedu.myspringboot.user.entity.StudentEntity;
import com.neuedu.myspringboot.user.entity.StudentVO;
import com.neuedu.myspringboot.user.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@Slf4j
public class RestfulStudentController {


    @Autowired
    private StudentService studentService;
    /*查询*/
    @GetMapping("/student")
    public List<StudentEntity> queryStudent(Integer id, String name) {
        log.info("进入学生类controller");
        List<StudentEntity> studentList = studentService.queryStudent(id, name);
        return studentList;
    }
    /*添加*/
    @PostMapping("/student")
    public String  saveStudent(StudentEntity studentEntity) {
        log.info("进入学生成绩新增方法");
        String resultMessage=null;
        int num= studentService.saveStudent(studentEntity);
        if(num>0){
            resultMessage="新增成功了"+num+"条记录";
        }else {
            resultMessage="新增失败";
        }
        return resultMessage;
    }
    /*修改*/
    @PatchMapping("/student/{id}")
    public String  updateStudent(@PathVariable("id") int id,@RequestParam("name") String name) {
        log.info("进入学生成绩修改方法");
        String resultMessage="修改成功";
        StudentEntity studentEntity=new StudentEntity();
        studentEntity.setId(id);
        studentEntity.setName(name);
        int num= studentService.updateStudent(studentEntity);
        return resultMessage;
    }
    /*删除*/
    @DeleteMapping("/student/{id}")
    public String  deleteStudent(@PathVariable("id") int id) {
        log.info("进入学生成绩删除方法");
        String resultMessage=null;
        StudentVO studentVO=new StudentVO();
        studentVO.setIds(String.valueOf(id));
        int num= studentService.deleteStudent(studentVO);
        if(num>0){
            resultMessage="删除删除了"+num+"条记录";
        }else {
            resultMessage="删除失败";
        }
        return resultMessage;
    }


}
