package com.zhenya.test.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zhenya.test.db.mybatis.MyBatisConnectionFactory;
import com.zhenya.test.db.dao.EmployeeDAO;
import com.zhenya.test.db.entity.Employee;
import com.zhenya.test.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public List<Employee> getAll() {
		EmployeeDAO employeesDAO = new EmployeeDAO(MyBatisConnectionFactory.getSqlSessionFactory());
		return employeesDAO.getAll();
	}

	@Override
	public Employee getById(long id) {
		EmployeeDAO employeesDAO = new EmployeeDAO(MyBatisConnectionFactory.getSqlSessionFactory());
		return employeesDAO.getById(id);
	}

	@Override
	public long insert(Employee employee) {
		EmployeeDAO employeesDAO = new EmployeeDAO(MyBatisConnectionFactory.getSqlSessionFactory());
		return employeesDAO.insert(employee);

	}

	@Override
	public long update(Employee employee) {
		EmployeeDAO employeesDAO = new EmployeeDAO(MyBatisConnectionFactory.getSqlSessionFactory());
		return employeesDAO.update(employee);
	}

	@Override
	public long delete(long id) {
		EmployeeDAO employeesDAO = new EmployeeDAO(MyBatisConnectionFactory.getSqlSessionFactory());
		return employeesDAO.delete(id);

	}

	@Override
	public List<Employee> findOfBirth(Date birth) {
		EmployeeDAO employeesDAO = new EmployeeDAO(MyBatisConnectionFactory.getSqlSessionFactory());
		return employeesDAO.findOfBirth(birth);
	}

}