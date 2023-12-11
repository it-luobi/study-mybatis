package com.luobi.study.mybatis.mapper;

import com.luobi.study.mybatis.config.MybatisConfig;
import com.luobi.study.mybatis.model.Hero;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class HeroMapperTest {

    private SqlSession sqlSession;

    @Before
    public void setUp() throws RuntimeException {
        // 获得SqlSession对象
        sqlSession = MybatisConfig.getSqlSession();
    }

    @After
    public void tearDown() throws RuntimeException {
        // 关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void getHeroList() {
        System.out.println("========== 方式一：getMapper ========== ");
        HeroMapper mapper = sqlSession.getMapper(HeroMapper.class);
        List<Hero> heroList = mapper.getHeroList();

        for (Hero hero : heroList) {
            System.out.println(hero);
        }
    }

    @Test
    public void getHeroList2() {
        System.out.println("========== 方式二 ==========");
        List<Hero> heros = sqlSession.selectList("com.luobi.study.mybatis.mapper.HeroMapper.getHeroList");

        for (Hero hero : heros) {
            System.out.println(hero);
        }
    }

    @Test
    public void getHeroById() {
        HeroMapper mapper = sqlSession.getMapper(HeroMapper.class);
        Hero hero = mapper.getHeroById(1);
        System.out.println(hero);
    }


    @Test
    public void addHero() {
        Hero hero = Hero.builder().id(7).name("姜维").city("甘肃").build();
        HeroMapper mapper = sqlSession.getMapper(HeroMapper.class);
        int num = mapper.addHero(hero);

        if (num <= 0) {
            System.out.println("新增失败");
            return;
        }

        System.out.println("新增成功");

        // 增、删、改 需要提交事务
        sqlSession.commit();
    }

    @Test
    public void updateHero() {
        Hero hero = Hero.builder().id(7).name("孙权").city("浙江").build();
        HeroMapper mapper = sqlSession.getMapper(HeroMapper.class);
        int num = mapper.updateHero(hero);

        if (num <= 0) {
            System.out.println("修改失败");
            return;
        }

        System.out.println("修改成功");

        // 增、删、改 需要提交事务
        sqlSession.commit();
    }

    @Test
    public void deleteHero() {
        HeroMapper mapper = sqlSession.getMapper(HeroMapper.class);
        int num = mapper.deleteHero(7);

        if (num <= 0) {
            System.out.println("删除失败");
            return;
        }

        System.out.println("删除成功");

        // 增、删、改 需要提交事务
        sqlSession.commit();
    }

    @Test
    public void listHeroWithCondition() {
        HeroMapper mapper = sqlSession.getMapper(HeroMapper.class);
        List<Hero> heroList = mapper.listHeroWithCondition(1, "庞");

        for (Hero hero : heroList) {
            System.out.println(hero);
        }
    }

}
