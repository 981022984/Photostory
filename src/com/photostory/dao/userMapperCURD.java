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
 * userMapperӳ���ļ���CURD����Ӧ�ӿڵ�ʵ����
 * @author zuo
 * @time 2018��9��11��21:12:50
 * @vision 1.0 
 * @time 2018��9��12��21:28:53
 * @vision 2.0
 * @�޸�	����Spring,ʹ������ע��
 */
public class userMapperCURD implements userMapper{
	
    //����ע��
	@Resource(name="sqlSessionFactory")     
	private SqlSessionFactory sqlSessionFactory;
	
	
	/*//û������Springʱ���ɵ���ģʽ����sqlSessionFactory�Ӷ��õ�sqlSession
	private static SqlSessionFactory sqlSessionFactory;
	
	 * ��������һ��SqlSessionFactory���󣬹���ȡSqlSession����
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















