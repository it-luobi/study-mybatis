package com.luobi.study.mybatis.mapper;

import com.luobi.study.mybatis.config.MybatisConfig;
import com.luobi.study.mybatis.model.StudentDto;
import com.luobi.study.mybatis.model.Teacher;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * 多对一查询
 */
public class StudentMapperTest {

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
    public void listStudent() {
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<StudentDto> list = mapper.listStudent();

        for (StudentDto dto : list) {
            System.out.println(dto);
        }
    }

    @Test
    public void listStudent2() {
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<StudentDto> list = mapper.listStudent2();

        for (StudentDto dto : list) {
            System.out.println(dto);
        }
    }

    @Test
    public void getTeacherById() {
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Teacher teacher = mapper.getTeacherById(1);
        System.out.println(teacher);
    }

}
