package com.zhenya.test.service;

import java.util.Date;
import java.util.List;

import com.zhenya.test.db.entity.*;

public interface EmployeeService {

	public List<Employee> getAll();

	public Employee getById(long id);

	public long insert(Employee employee);

	public long update(Employee employee);

	public long delete(long id);

	public List<Employee> findOfBirth(Date birth);

}