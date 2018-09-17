package com.photostory.dao;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.photostory.entity.Commend;

/**
 * ����CURD�ӿڵ�ʵ����
 * @author Administrator
 * @time 2018��9��17��11:27:46
 * @vision 1.0
 */
public class CommendMapperCURD implements CommendMapper{
	/*����ע��SqlSessionFactory�Ķ�����Ϊ�������*/
	@Resource(name="sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;

	/* (non-Javadoc)
	 * @see com.photostory.dao.CommendMapper#getCommend(java.lang.String)
	 */
	@Override
	public ArrayList<Commend> getCommends(String pno) {
		ArrayList<Commend> list = new ArrayList<Commend>();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			CommendMapper mapper = sqlSession.getMapper(CommendMapper.class);
			if(mapper.getCommends(pno) != null) {
				list = mapper.getCommends(pno);
				return list;
			}
			else
				return null;
		}finally {
			sqlSession.close();
		}
	}	
}
