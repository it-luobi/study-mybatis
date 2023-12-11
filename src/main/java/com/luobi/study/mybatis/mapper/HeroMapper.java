package com.luobi.study.mybatis.mapper;

import com.luobi.study.mybatis.model.Hero;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HeroMapper {

    List<Hero> getHeroList();

    Hero getHeroById(int id);

    int addHero(Hero hero);

    int updateHero(Hero hero);

    int deleteHero(int id);

    /**
     * 面向接口编程：使用注解开发
     * 本质：反射机制实现
     * 底层：动态代理
     * 说明：方法存在多个参数，所有的参数前面必须加上 @Param 注解
     * 关于注解 @Param ：
     *      如果只有一个基本类型的参数，可以不加；
     *      基本类型 或者 String 类型的参数，需要加上，引用类型不需要加；
     *      在SQL中引用的是 @Param() 中设定的属性名
     */
    @Select("SELECT * FROM hero WHERE id = #{id} OR name LIKE CONCAT('%', #{name}, '%')")
    List<Hero> listHeroWithCondition(@Param("id") int heroId, @Param("name") String heroName);

}
