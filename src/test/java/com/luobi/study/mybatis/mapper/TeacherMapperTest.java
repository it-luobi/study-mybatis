package com.luobi.study.mybatis.mapper;

import com.luobi.study.mybatis.config.MybatisConfig;
import com.luobi.study.mybatis.model.Student;
import com.luobi.study.mybatis.model.TeacherDto;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * 一对多查询
 */
public class TeacherMapperTest {

    private SqlSession sqlSession;

    @Before
    public void setUp() throws RuntimeException {
        // 第一步：获得SqlSession对象
        sqlSession = MybatisConfig.getSqlSession();
    }

    @After
    public void tearDown() throws RuntimeException {
        // 关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void listTeacher() {
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<TeacherDto> list = mapper.listTeacher();

        for (TeacherDto dto : list) {
            System.out.println(dto);
        }
    }

    @Test
    public void listTeacher2() {
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<TeacherDto> list = mapper.listTeacher2();

        for (TeacherDto dto : list) {
            System.out.println(dto);
        }
    }

    @Test
    public void listStudentByTeacherId() {
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Student> list = mapper.listStudentByTeacherId(2);

        for (Student student : list) {
            System.out.println(student);
        }
    }

}
