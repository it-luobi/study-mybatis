package com.luobi.study.mybatis.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {

    // 封装会话工厂
    private static SqlSessionFactory sqlSessionFactory;

    // 在进行对象的跨层传递的时，使用 ThreadLocal 可以避免多次传递，打破层次间的约束
    private static final ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 封装 getSqlSessionFactory 方法
    // public static SqlSessionFactory getSqlSessionFactory() {
    //     return sqlSessionFactory;
    // }

    // 封装 sqlSession 会话
    public static SqlSession getSqlSession(boolean IsAutoCommit) {
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession(IsAutoCommit);
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    // 使用泛型封装 getMapper
    public static <T> T getMapper(Class<T> c) {
        SqlSession sqlSession = getSqlSession(true);
        return sqlSession.getMapper(c);
    }

}
