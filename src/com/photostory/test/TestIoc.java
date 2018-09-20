package com.photostory.test;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.photostory.dao.userMapper;
import com.photostory.dao.userMapperCURD;
import com.photostory.entity.User;

import org.springframework.test.context.ContextConfiguration;

@RunWith(SpringJUnit4ClassRunner.class) //指定测试用例的运行器 这里是指定了Junit4
@ContextConfiguration(locations = {"classpath*:application-Ioc.xml"})//装配Spring
public class TestIoc {
	/**
	 * Spring IoC测试
	 */
	
	
	@Resource(name="userCURD")
	private userMapperCURD user;
	
	@Test
	public void test() {
		
		
	}
}