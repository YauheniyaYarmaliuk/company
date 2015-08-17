package com.zhenya.test.db.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.zhenya.test.db.entity.Employee;

public class EmployeeDAO {

	private SqlSessionFactory sqlSessionFactory = null;

	public EmployeeDAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAll() {
		List<Employee> list = null;
		SqlSession session = sqlSessionFactory.openSession();

		try {
			list = session.selectList("Employee.getAll");
		} finally {

			session.close();
		}

		return list;
	}

	public Employee getById(long id) {
		Employee employees = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			employees = session.selectOne("Employee.getById", id);
		} finally {
			session.close();
		}
		return employees;
	}

	public long delete(long id) {
		long res = 0;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			res = session.delete("Employee.delete", id);
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}

	public long update(Employee employee) {
		long res = 0;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			res = session.update("Employee.update", employee);
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}

	public long insert(Employee employee) {
		int id = -1;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			id = session.insert("Employee.insert", employee);
		} finally {
			session.commit();
			session.close();
		}
		System.out.println("insert(" + employee + ")");
		return id;
	}

	public List<Employee> findOfBirth(Date birth) {
		List<Employee> list = null;
		SqlSession session = sqlSessionFactory.openSession();

		try {
			list = session.selectList("Employee.findOfBirth");
		} finally {
			session.commit();
			session.close();
		}

		return list;
	}

}
