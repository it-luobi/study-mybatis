package com.luobi.study.mybatis.model;

import lombok.Data;

@Data
public class StudentDto {

    private Integer studentId;
    private String studentName;
    private Teacher teacher;

}
