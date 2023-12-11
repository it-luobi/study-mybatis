package com.luobi.study.mybatis.mapper;

import com.luobi.study.mybatis.model.Student;
import com.luobi.study.mybatis.model.TeacherDto;

import java.util.List;

public interface TeacherMapper {

    List<TeacherDto> listTeacher();

    List<TeacherDto> listTeacher2();

    List<Student> listStudentByTeacherId(int teacherId);

}
