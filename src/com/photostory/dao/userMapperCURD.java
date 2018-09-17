package com.photostory.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.photostory.entity.User;

/**
 * userMapper映射文件中CURD语句对应接口的实现类
 * @author zuo
 * @time 2018年9月11日21:12:50
 * @vision 1.0 
 * @time 2018年9月12日21:28:53
 * @vision 2.0
 * @修改	整合Spring,使用依赖注入
 */
public class userMapperCURD implements userMapper{
	
    //依赖注入
	@Resource(name="sqlSessionFactory")     
	private SqlSessionFactory sqlSessionFactory;
	
	
	/*//没有整合Spring时，由单例模式创建sqlSessionFactory从而得到sqlSession
	private static SqlSessionFactory sqlSessionFactory;
	
	 * 单例创建一个SqlSessionFactory对象，供获取SqlSession对象
	 * @return SqlSessionFactory
	 
	public static SqlSessionFactory getSqlSessionFactory(){
		if(sqlSessionFactory == null){
			InputStream inputStream; 
	        try{
	        		inputStream = Resources.getResourceAsStream("mybatis-config.xml"); 
	                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 
	            }catch (IOException e){ 
	                throw new RuntimeException(e.getCause()); 
	      	  } 
	    } 
	    return sqlSessionFactory; 
	}*/
	
	@Override
	public User selectUser(HashMap<String, Object> map) {
		User user = new User();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			userMapper mapper = sqlSession.getMapper(userMapper.class);
			if(mapper.selectUser(map) != null) {
				user = mapper.selectUser(map);
				System.out.println(""+user.getUserName());
				return user;
			}
			else 
				return null;
		}finally {
			sqlSession.close();
		}
		
	}
	
}















