package com.luobi.study.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private Integer memberId;
    private String memberNick;
    private String memberGender;
    private Integer memberAge;
    private String memberCity;

}
