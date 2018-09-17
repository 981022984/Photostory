package com.photostory.dao;

import java.util.ArrayList;
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.photostory.entity.Tphotos;

/**
 * @author zuo
 * @2018年9月14日08:13:24
 * @vision 1.0
 * 对应映射接口（TempPhotosMapper）实现类
 */

public class TempPhotosMapperCURD implements TempPhotosMapper{
	/*依赖注入SqlSessionFactory的对象作为类的属性*/
	@Resource(name="sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;

	/* (non-Javadoc)
	 * @see com.photostory.dao.TempPhotosMapper#getAllTempPhotos()
	 */
	@Override
	public ArrayList<Tphotos> getAllTempPhotos() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ArrayList<Tphotos> tphotos = new ArrayList<Tphotos>();
		try {
			/*通过sqlSession获取对应接口的对象*/
			TempPhotosMapper mapper = sqlSession.getMapper(TempPhotosMapper.class);  
			if(mapper.getAllTempPhotos() != null) {
				/*通过接口方法映射的SQL语句执行对应CURD操作，动态代理原理*/
				tphotos = mapper.getAllTempPhotos();
				return tphotos;
			}
			else 
				return null;
			
		}finally {
			sqlSession.close();
		}
		
	}

	/* (non-Javadoc)
	 * @see com.photostory.dao.TempPhotosMapper#getAllTempPhotos2()
	 */
	@Override
	public ArrayList<Tphotos> getAllTempPhotos2() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ArrayList<Tphotos> tphotos = new ArrayList<Tphotos>();
		try {
			/*通过sqlSession获取对应接口的对象*/
			TempPhotosMapper mapper = sqlSession.getMapper(TempPhotosMapper.class);
			if(mapper.getAllTempPhotos() != null) {
				/*通过接口方法映射的SQL语句执行对应CURD操作，动态代理原理*/
				tphotos = mapper.getAllTempPhotos();
				return tphotos;
			}
			else 
				return null;
		}finally {
			sqlSession.close();
		}
		
	}
}
