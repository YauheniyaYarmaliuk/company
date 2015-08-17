package com.zhenya.test.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zhenya.test.db.mybatis.MyBatisConnectionFactory;
import com.zhenya.test.db.dao.DepartmentDAO;
import com.zhenya.test.db.entity.Department;
import com.zhenya.test.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Override
	public List<Department> getAll() {
		DepartmentDAO departmentDAO = new DepartmentDAO(MyBatisConnectionFactory.getSqlSessionFactory());
		return departmentDAO.getAll();
	}

	@Override
	public Department getById(long id) {
		DepartmentDAO departmentDAO = new DepartmentDAO(MyBatisConnectionFactory.getSqlSessionFactory());
		return departmentDAO.selectById(id);
	}

	@Override
	public long insert(Department department) {
		DepartmentDAO departmentDAO = new DepartmentDAO(MyBatisConnectionFactory.getSqlSessionFactory());
		return departmentDAO.insert(department);

	}

	@Override
	public long update(Department department) {
		DepartmentDAO departmentDAO = new DepartmentDAO(MyBatisConnectionFactory.getSqlSessionFactory());
		return departmentDAO.update(department);
	}

	@Override
	public long delete(long id) {
		DepartmentDAO departmentDAO = new DepartmentDAO(MyBatisConnectionFactory.getSqlSessionFactory());
		return departmentDAO.delete(id);

	}

}
