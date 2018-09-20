package com.photostory.test;

import java.util.HashMap;

import javax.annotation.Resource;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.photostory.dao.UserDao;
import com.photostory.entity.User;

import org.springframework.test.context.ContextConfiguration;


/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class) //指定测试用例的运行器 这里是指定了Junit4
@ContextConfiguration(locations = {"classpath*:application-dao.xml"})//装配Spring
public class TestIoc {
	/**
	 * Spring IoC测试
	 */
	
	
	@Resource
	private UserDao userCURD;
	
	@Test
	public void test() {
		HashMap<String, Object> hashmap = new HashMap<>();
		User user = new User();
		User user2 = new User();
		user.setUserID("1415241");
		user.setUserPassword("123456");
		hashmap.put("123", user);		
		user2 = userCURD.selectUser(hashmap);
		System.out.println(user.getUserID());
		
	}
}