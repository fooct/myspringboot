package com.neuedu.myspringboot.user.mapper;

import com.neuedu.myspringboot.common.exp.Student;
import com.neuedu.myspringboot.user.entity.StudentEntity;
import com.neuedu.myspringboot.user.entity.StudentNoteEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface StudentMapper extends tk.mybatis.mapper.common.Mapper<StudentEntity> {

     List<StudentEntity> queryStudent(@Param("id") Integer id, @Param("userName") String username);
     List<StudentEntity> queryStudent2(StudentEntity studentEntity);


     int saveStudent (StudentEntity studentEntity);

     int saveStudentNote(StudentNoteEntity studentNoteEntity);

     int deleteStudent(Integer studentEntity);

     int deleteStudent2(String[] ids);
}
