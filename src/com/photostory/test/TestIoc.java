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
import com.photostory.entity.User;

import org.springframework.test.context.ContextConfiguration;

@RunWith(SpringJUnit4ClassRunner.class) //指定测试用例的运行器 这里是指定了Junit4
@ContextConfiguration(locations = {"classpath*:application-Ioc.xml"})//装配Spring
public class TestIoc {
	/**
	 * Spring IoC测试
	 */
	
	@Resource(name="sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	/*@Resource(name="user")
	private User user;*/
	
	@Test
	public void test() {
		/*ApplicationContext context = new ClassPathXmlApplicationContext("application-dao.xml");
		User user = (User) context.getBean("user");*/
		//加载配置文件
		/*System.out.println(user)*/;
		//String str = loginservice.modifyPassword("1415241", "123456", "654321", "654321");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userID", "1415243");
		map.put("userPassword","123456");
		User user = new User();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			userMapper mapper = sqlSession.getMapper(userMapper.class);
			user = mapper.selectUser(map);
			System.out.println(""+user.getUserName());
		}finally {
			sqlSession.close();
		}
		System.out.println("123---"+sqlSessionFactory);
		
	}
}