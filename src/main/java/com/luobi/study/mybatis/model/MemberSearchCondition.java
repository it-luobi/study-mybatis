package com.luobi.study.mybatis.model;

import lombok.Data;

@Data
public class MemberSearchCondition {

    private String gender;  // 性别
    private Integer minAge; // 最小年龄
    private Integer maxAge; // 最大年龄
    private String city;    // 所在城市

}
