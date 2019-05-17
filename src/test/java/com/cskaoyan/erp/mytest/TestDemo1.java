package com.cskaoyan.erp.mytest;

import com.erp.production.ssm.bean.BeanTest;
import com.erp.production.ssm.mapper.MapperTest;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestDemo1 {
    private SqlSession sqlSession;
    private MapperTest mapperTest;
    private InputStream inputStream;
    @Before
    public void init() throws Exception{
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sessionFactory.openSession();
        mapperTest = sqlSession.getMapper(MapperTest.class);
    }
    @After
    public void after() throws Exception{
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void test1(){
        List<BeanTest> beanTests = mapperTest.findAll();
        for (BeanTest mt : beanTests) {
            System.out.println(mt);
        }
    }
}
