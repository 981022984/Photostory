package com.photostory.dao;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.photostory.entity.Admin;

/**
 * 管理员CURD实现类
 * @author Administrator
 * @time 2018年9月16日20:46:32
 * @vision 1.0
 */
public class AdminMapperCURD implements AdminMapper{

	@Resource(name="sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;
	/* (non-Javadoc)
	 * @see com.photostory.dao.AdminMapper#getAdmin(java.util.HashMap)
	 */
	@Override
	public Admin getAdmin(HashMap<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			/*动态绑定调用实际CURD操作语句*/
			AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
			Admin admin = mapper.getAdmin(map);
			return admin;
		}finally {
			sqlSession.close();
		}
	}

}
