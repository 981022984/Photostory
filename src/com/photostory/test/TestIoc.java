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

@RunWith(SpringJUnit4ClassRunner.class) //ָ������������������ ������ָ����Junit4
@ContextConfiguration(locations = {"classpath*:application-Ioc.xml"})//װ��Spring
public class TestIoc {
	/**
	 * Spring IoC����
	 */
	
	
	@Resource(name="userCURD")
	private userMapperCURD user;
	
	@Test
	public void test() {
		
		
	}
}