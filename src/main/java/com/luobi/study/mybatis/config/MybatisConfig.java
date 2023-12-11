package com.luobi.study.mybatis.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisConfig {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            // 使用 mybatis 第一步：获取 SqlSessionFactory 对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 有了 SqlSessionFactory ，就可以从中获得 SqlSession 的实例
     * SqlSession 完全包含了面向数据库执行 SQL 命令所需的所有方法
     */
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

}
