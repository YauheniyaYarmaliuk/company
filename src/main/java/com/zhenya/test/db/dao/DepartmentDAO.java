package com.zhenya.test.db.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.zhenya.test.db.entity.Department;

public class DepartmentDAO {

	private SqlSessionFactory sqlSessionFactory = null;

	public DepartmentDAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	/**
	 * Returns the list of all Department instances from the database.
	 * 
	 * @return the list of all Department instances from the database.
	 */
	
	@SuppressWarnings("unchecked")
	public List<Department> getAll() {
		List<Department> list = null;
		SqlSession session = sqlSessionFactory.openSession();

		try {
			list = session.selectList("Department.getAll");
		} finally {
			session.close();
		}

		return list;
	}

	/**
	 * Select instance of Department from the database.
	 * 
	 * @param Department
	 *            the instance to be persisted.
	 */
	public Department selectById(long id) {
		Department department = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			department = session.selectOne("Department.selectById", id);
		} finally {
			session.close();
		}
		return department;
	}

	public long delete(long id) {
		long res = 0;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			res = session.delete("Department.delete", id);
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}

	public long update(Department department) {
		long res = 0;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			res = session.update("Department.update", department);
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}

	public long insert(Department department) {
		int id = -1;
		SqlSession session = sqlSessionFactory.openSession();

		try {
			id = session.insert("Department.insert", department);
		} finally {
			session.commit();
			session.close();
		}
		System.out.println("Inserted with id = " + id);
		System.out.println("insert(" + department + ")");
		return id;
	}

}
