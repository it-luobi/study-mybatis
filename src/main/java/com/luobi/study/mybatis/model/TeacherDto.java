package com.luobi.study.mybatis.model;

import lombok.Data;

import java.util.List;

@Data
public class TeacherDto {

    private Integer teacherId;
    private String teacherName;
    private List<Student> studentList;

}
