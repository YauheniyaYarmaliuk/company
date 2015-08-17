package com.zhenya.test.service;

import java.util.List;

import com.zhenya.test.db.entity.*;

public interface DepartmentService {

	public List<Department> getAll();

	public Department getById(long id);

	public long insert(Department department);

	public long update(Department department);

	public long delete(long id);

}
