package com.neuedu.myspringboot.user.service;

import com.neuedu.myspringboot.user.entity.StudentEntity;
import com.neuedu.myspringboot.user.entity.StudentNoteEntity;
import com.neuedu.myspringboot.user.mapper.StudentMapper;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    @Autowired
    private StudentMapper studentMapper;
    public List<StudentEntity> queryStudent(Integer id, String name) {

//        List<StudentEntity> studentList = studentMapper.queryStudent(id, name);
        List<StudentEntity> studentList = studentMapper.selectAll();
        return studentList;

    }

    public List<StudentEntity> queryStudent2(StudentEntity studentEntity) {
        List<StudentEntity>  studentList=studentMapper.queryStudent2(studentEntity);
        return  studentList;
    }


    public int saveStudent (StudentEntity studentEntity) {

//        业务逻辑,根据插入 student 的成绩总和判断是否合格, 如果成绩总和大于 200 就认为是合格, 否则不合格
//        注意 student 表的 id 要和 student_note 表的 student_id 相对应

//        获得成绩总和
        int sum = studentEntity.getChinese() + studentEntity.getMath() + studentEntity.getEnglish();

//        根据总和判断是否合格
        String note = (sum >= 200 ? "合格" : "不合格");

//        存入表 student
        studentMapper.saveStudent(studentEntity);

//        获取 student 表返回的主键 id
        int studentId = studentEntity.getId();

//        创建实例对象 studentNoteEntity
        StudentNoteEntity studentNoteEntity = new StudentNoteEntity();

//        存放 student 表返回的主键 id
        studentNoteEntity.setStudent_id(studentId);

//        存放逻辑处理的合格或者不合格的字段
        studentEntity.setNote(note);

//        存入表student_note
        return studentMapper.saveStudentNote(studentNoteEntity);


    }

    public int deleteStudent (StudentEntity studentEntity){

        String []ids = studentEntity.getIds().split(",");
        for (int i = 0; i < ids.length; i++){
            Integer id = Integer.valueOf(ids[i]);
            studentMapper.deleteStudent(id);
        }
        return ids.length;

    }

    public int deleteStudent2(StudentEntity studentEntity){

        String []ids = studentEntity.getIds().split(",");
        return studentMapper.deleteStudent2(ids);

    }

    public int deleteStudent3(StudentEntity studentEntity){

        List idList = studentEntity.getIdList();

        return studentMapper.deleteStudent3(idList);

    }

}
