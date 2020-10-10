package com.neuedu.myspringboot.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.myspringboot.user.entity.StudentEntity;
import com.neuedu.myspringboot.user.entity.StudentVO;
import com.neuedu.myspringboot.user.entity.StudentNoteEntity;
import com.neuedu.myspringboot.user.mapper.StudentMapper;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public List<StudentEntity> queryStudent(Integer id, String name) {
        // List<StudentEntity>  studentList=studentMapper.queryStudent(id,name);
        List<StudentEntity> studentList = studentMapper.selectAll();
        return studentList;
    }

    public PageInfo<StudentEntity> queryStudent2(StudentEntity studentEntity, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<StudentEntity> studentList = studentMapper.queryStudent2(studentEntity);
        PageInfo<StudentEntity> pageInfo=new PageInfo<StudentEntity>(studentList);
        return pageInfo;
    }
    public List<StudentEntity>  queryStudent3(StudentEntity studentEntity) {
        List<StudentEntity> studentList = studentMapper.queryStudent3(studentEntity);
        return studentList;
    }
    /*存入学生表 多表操作*/
    @Transactional(rollbackFor = Exception.class)
    public int saveStudent(StudentEntity studentEntity) {
        //业务逻辑 根据插入student 的成绩总和判断是否合格 如果成绩总和大于等于200 就认为是合格 否则不合格 存入表student_note 的note 字段[合格，不合格]
        //注意 student表的id 要和student_note 表的student_id 相对应

        //获取成绩总和
        int sum = studentEntity.getChinese() + studentEntity.getEnglish() + studentEntity.getMath();
        //根据总和判断是否合格
        String note = (sum >= 200 ? "合格" : "不合格");
        //存入表student
        studentMapper.saveStudent(studentEntity);
        //获取student 表返回的主键id
        int studentId = studentEntity.getId();
        //创建实例对象 studentNoteEntity
        StudentNoteEntity studentNoteEntity = new StudentNoteEntity();
        //存放student 表返回的主键id
        studentNoteEntity.setStudent_id(studentId);
        //存放逻辑处理的 合格或者不合格的字段
        studentNoteEntity.setNote(note);
        //存入表student_note
        return studentMapper.saveStudentNote(studentNoteEntity);

    }
    /*传入的删除数据id 为字符串格式*/
    public int deleteStudent(StudentVO studentEntity) {
        String []ids=studentEntity.getIds().split(",");
        //遍历数组 循环删除
        for(int i=0;i<ids.length;i++){
            Integer id= Integer.valueOf(ids[i]);
            studentMapper.deleteStudent(id);
        }
        return ids.length;
    }
    /*传入的删除数据id 为字符串格式*/
    public int deleteStudent2(StudentVO studentEntity) {
        String []ids=studentEntity.getIds().split(",");
        //利用mybatis 的foreach标签来做
        return  studentMapper.deleteStudent2(ids);
    }
    /*传入的删除id 为一个list*/
    public int deleteStudent3(StudentVO studentEntity) {
        List idList=studentEntity.getIdList();
        //利用mybatis 的foreach标签来做
        return  studentMapper.deleteStudent3(idList);
    }

    public int updateStudent(StudentEntity studentEntity) {
        return studentMapper.updateStudent(studentEntity);
    }

    public List<StudentEntity> queryStudent4() {
        return studentMapper.queryStudent4();
    }
}
