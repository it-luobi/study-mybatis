package com.luobi.study.mybatis.mapper;

import com.luobi.study.mybatis.model.StudentDto;
import com.luobi.study.mybatis.model.Teacher;

import java.util.List;

public interface StudentMapper {

    List<StudentDto> listStudent();

    List<StudentDto> listStudent2();

    Teacher getTeacherById(int id);

}
