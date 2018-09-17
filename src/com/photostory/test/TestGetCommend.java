package com.photostory.test;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.photostory.dao.CommendMapperCURD;
import com.photostory.dao.TempPhotosMapper;
import com.photostory.entity.Commend;
import com.photostory.entity.Tphotos;

@RunWith(SpringJUnit4ClassRunner.class) //指定测试用例的运行器 这里是指定了Junit4
@ContextConfiguration(locations = {"classpath*:application-Ioc.xml"})//装配Spring
public class TestGetCommend {
	@Resource(name="commendCURD")
	private CommendMapperCURD c;
	
	@Test
	public void test1() {
		ArrayList<Commend> list = new ArrayList<Commend>();
		if(c.getCommends("10001") != null)
			list = c.getCommends("10001");
		for(Commend c : list) {
			System.out.println(c.getuName());
			System.out.println(c.getComm());
		}
	}
	/*@Test
	public void getAllTempPhotos() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ArrayList<Tphotos> tphotos = new ArrayList<Tphotos>();
		try {
			通过sqlSession获取对应接口的对象
			TempPhotosMapper mapper = sqlSession.getMapper(TempPhotosMapper.class);  
			if(mapper.getAllTempPhotos() != null) {
				通过接口方法映射的SQL语句执行对应CURD操作，动态代理原理
				tphotos = mapper.getAllTempPhotos();
				for(Tphotos c : tphotos) {
					System.out.println(c.getPno());
					System.out.println(c.getPname());
				}
			} 			
		}finally {
			sqlSession.close();
		}	
	}*/
}
