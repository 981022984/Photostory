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

@RunWith(SpringJUnit4ClassRunner.class) //ָ������������������ ������ָ����Junit4
@ContextConfiguration(locations = {"classpath*:application-Ioc.xml"})//װ��Spring
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
			ͨ��sqlSession��ȡ��Ӧ�ӿڵĶ���
			TempPhotosMapper mapper = sqlSession.getMapper(TempPhotosMapper.class);  
			if(mapper.getAllTempPhotos() != null) {
				ͨ���ӿڷ���ӳ���SQL���ִ�ж�ӦCURD��������̬����ԭ��
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
