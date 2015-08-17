package com.zhenya.test.db.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.zhenya.test.db.entity.AVGSalary;

public class AVGSalaryDao {

	private SqlSessionFactory sqlSessionFactory = null;

	public AVGSalaryDao(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<AVGSalary> getAll() {
		List<AVGSalary> list = null;
		SqlSession session = sqlSessionFactory.openSession();

		try {
			list = session.selectList("AVGSalary.getAll");
		} finally {

			session.close();
		}

		return list;
	}
}
