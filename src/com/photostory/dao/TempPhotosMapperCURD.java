package com.photostory.dao;

import java.util.ArrayList;
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.photostory.entity.Tphotos;

/**
 * @author zuo
 * @2018��9��14��08:13:24
 * @vision 1.0
 * ��Ӧӳ��ӿڣ�TempPhotosMapper��ʵ����
 */

public class TempPhotosMapperCURD implements TempPhotosMapper{
	/*����ע��SqlSessionFactory�Ķ�����Ϊ�������*/
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
			/*ͨ��sqlSession��ȡ��Ӧ�ӿڵĶ���*/
			TempPhotosMapper mapper = sqlSession.getMapper(TempPhotosMapper.class);  
			if(mapper.getAllTempPhotos() != null) {
				/*ͨ���ӿڷ���ӳ���SQL���ִ�ж�ӦCURD��������̬����ԭ��*/
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
			/*ͨ��sqlSession��ȡ��Ӧ�ӿڵĶ���*/
			TempPhotosMapper mapper = sqlSession.getMapper(TempPhotosMapper.class);
			if(mapper.getAllTempPhotos() != null) {
				/*ͨ���ӿڷ���ӳ���SQL���ִ�ж�ӦCURD��������̬����ԭ��*/
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
