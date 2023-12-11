package com.luobi.study.mybatis.mapper;

import com.luobi.study.mybatis.model.Member;
import com.luobi.study.mybatis.model.MemberChooseCondition;
import com.luobi.study.mybatis.model.MemberSearchCondition;

import java.util.List;

public interface MemberMapper {

    List<Member> searchMember(MemberSearchCondition condition);

    List<Member> searchMemberByCity(List<String> cityList);

    List<Member> searchMemberByIdOrNick(MemberChooseCondition condition);

    int addMember(Member member);

    int updateMember(Member member);

    int deleteMember(List<Integer> memberIds);

}
