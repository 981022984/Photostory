package com.photostory.test;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.photostory.dao.CommendMapperCURD;
import com.photostory.dao.TempPhotosMapper;
import com.photostory.dao.TempPhotosMapperCURD;
import com.photostory.entity.Commend;
import com.photostory.entity.Tphotos;
import com.photostory.service.TempPhotosService;
import com.photostory.service.TempPhotosServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class) //ָ������������������ ������ָ����Junit4
@ContextConfiguration(locations = {"classpath*:application-Ioc.xml"})//װ��Spring
public class TestGetCommend {
	@Resource(name="commendCURD")
	private CommendMapperCURD c;
	
	@Resource(name="sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private TempPhotosService tempPhotosService;      //ע��Service�ӿڶ���
	
	@Resource(name="tempPhotosCURD")
	private TempPhotosMapperCURD tempPhotosCURD;
	
	/**
	 * �������������Ϣ��ȡ
	 */
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
	/**
	 *  ������ʱ�ļ���ȡ
	 */
	@Test
	public void getAllTempPhotos2() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ArrayList<Tphotos> tphotos = new ArrayList<Tphotos>();
		try {
			/*ͨ��sqlSession��ȡ��Ӧ�ӿڵĶ���*/
			TempPhotosMapper mapper = sqlSession.getMapper(TempPhotosMapper.class);
			if(mapper.getAllTempPhotos2() != null) {
				/*ͨ���ӿڷ���ӳ���SQL���ִ�ж�ӦCURD��������̬����ԭ��*/
				tphotos = mapper.getAllTempPhotos2();
				System.out.println("--------"+tphotos.size());
			}
			
		}finally {
			sqlSession.close();
		}
	}
	
	
	@Test
	public void testTempPhotosService() {
		ArrayList<Tphotos> list1 = tempPhotosCURD.getAllTempPhotos2();
		for(Tphotos tp:list1) {
			System.out.println(tp.getPath());
			/*�û��ϴ�ͼƬ�洢λ�ã���ԣ�*/
			String src = TempPhotosServiceImpl.class.getClassLoader().getResource("").getPath(); 
			System.out.println(src);
		}
	}
}
