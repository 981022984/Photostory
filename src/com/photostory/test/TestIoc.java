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
 * ����spring��junit���ϣ�junit����ʱ����springIOC���� spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class) //ָ������������������ ������ָ����Junit4
@ContextConfiguration(locations = {"classpath*:application-dao.xml"})//װ��Spring
public class TestIoc {
	/**
	 * Spring IoC����
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