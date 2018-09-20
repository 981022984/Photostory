package com.photostory.test;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.photostory.dao.CommendDao;
import com.photostory.dao.TempPhotosDao;
import com.photostory.entity.Commend;
import com.photostory.entity.Tphotos;
import com.photostory.service.TempPhotosService;
import com.photostory.service.TempPhotosServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class) //指定测试用例的运行器 这里是指定了Junit4
@ContextConfiguration(locations = {"classpath*:application-Ioc.xml"})//装配Spring
public class TestGetCommend {
	@Resource(name="commendCURD")
	private CommendDao c;
	
	@Resource(name="sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private TempPhotosService tempPhotosService;      //注入Service接口对象
	
	@Resource(name="tempPhotosCURD")
	private TempPhotosDao tempPhotosCURD;
	
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
