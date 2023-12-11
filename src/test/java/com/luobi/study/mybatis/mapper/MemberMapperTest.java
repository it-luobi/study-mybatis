package com.luobi.study.mybatis.mapper;

import com.luobi.study.mybatis.config.MybatisUtil;
import com.luobi.study.mybatis.model.Member;
import com.luobi.study.mybatis.model.MemberChooseCondition;
import com.luobi.study.mybatis.model.MemberSearchCondition;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MemberMapperTest {

    @Test
    public void searchMember() {
        MemberSearchCondition condition = new MemberSearchCondition();
        condition.setGender("女");
        condition.setCity("成都");
        condition.setMinAge(20);
        condition.setMaxAge(30);

        MemberMapper memberMapper = MybatisUtil.getMapper(MemberMapper.class);
        List<Member> memberList = memberMapper.searchMember(condition);

        for (Member member : memberList) {
            System.out.println(member);
        }
    }

    @Test
    public void searchMemberByCity() {
        List<String> cityList = new ArrayList<>();
        cityList.add("上海");
        cityList.add("武汉");

        MemberMapper memberMapper = MybatisUtil.getMapper(MemberMapper.class);
        List<Member> memberList = memberMapper.searchMemberByCity(cityList);

        for (Member member : memberList) {
            System.out.println(member);
        }
    }

    @Test
    public void searchMemberByIdOrNick() {
        MemberChooseCondition condition = new MemberChooseCondition();
        // condition.setMemberId(1);
        // condition.setMemberNick("花");

        MemberMapper memberMapper = MybatisUtil.getMapper(MemberMapper.class);
        List<Member> memberList = memberMapper.searchMemberByIdOrNick(condition);

        for (Member member : memberList) {
            System.out.println(member);
        }
    }

    @Test
    public void addMember() {
        Member member = new Member();
        member.setMemberId(10);
        member.setMemberNick("孙尚香");
        member.setMemberGender("女");
        member.setMemberAge(18);
        member.setMemberCity("杭州");

        MemberMapper memberMapper = MybatisUtil.getMapper(MemberMapper.class);
        memberMapper.addMember(member);
    }

    @Test
    public void updateMember() {
        Member member = new Member();
        member.setMemberId(10);
        member.setMemberNick("关羽");
        member.setMemberGender("男");
        member.setMemberAge(35);
        member.setMemberCity("山西");

        MemberMapper memberMapper = MybatisUtil.getMapper(MemberMapper.class);
        memberMapper.updateMember(member);
    }

    @Test
    public void deleteMember() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(11);

        MemberMapper memberMapper = MybatisUtil.getMapper(MemberMapper.class);
        memberMapper.deleteMember(list);
    }

}
