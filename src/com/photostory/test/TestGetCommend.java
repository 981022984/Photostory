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

@RunWith(SpringJUnit4ClassRunner.class) //指定测试用例的运行器 这里是指定了Junit4
@ContextConfiguration(locations = {"classpath*:application-Ioc.xml"})//装配Spring
public class TestGetCommend {
	@Resource(name="commendCURD")
	private CommendMapperCURD c;
	
	@Resource(name="sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private TempPhotosService tempPhotosService;      //注入Service接口对象
	
	@Resource(name="tempPhotosCURD")
	private TempPhotosMapperCURD tempPhotosCURD;
	
	/**
	 * 测试评论相关信息获取
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
	 *  测试临时文件获取
	 */
	@Test
	public void getAllTempPhotos2() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ArrayList<Tphotos> tphotos = new ArrayList<Tphotos>();
		try {
			/*通过sqlSession获取对应接口的对象*/
			TempPhotosMapper mapper = sqlSession.getMapper(TempPhotosMapper.class);
			if(mapper.getAllTempPhotos2() != null) {
				/*通过接口方法映射的SQL语句执行对应CURD操作，动态代理原理*/
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
			/*用户上传图片存储位置（相对）*/
			String src = TempPhotosServiceImpl.class.getClassLoader().getResource("").getPath(); 
			System.out.println(src);
		}
	}
}
