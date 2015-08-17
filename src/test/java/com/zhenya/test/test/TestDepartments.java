package com.zhenya.test.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.zhenya.test.db.entity.Department;
import com.zhenya.test.service.DepartmentService;
import com.zhenya.test.service.impl.DepartmentServiceImpl;

import junit.framework.Assert;

public class TestDepartments {

	@Test
	public void testDepartmentsSize() {

		DepartmentService service = new DepartmentServiceImpl();

		List<Department> list = service.getAll();

		boolean var1 = list.size() > 0;
		Assert.assertEquals(true, var1);
	}

	@Test
	public void testDepartmentsById() {

		DepartmentService service = new DepartmentServiceImpl();
		Department department = service.getById(5);
		Assert.assertEquals(true, department != null);
	}

	@Test
	public void testDepartmentInsert() {
		Department tester = new Department();
		tester.setName("Testers");

		DepartmentService service = new DepartmentServiceImpl();
		List<Department> list = service.getAll();
		long var1 = list.size();

		service.insert(tester);
		List<Department> list2 = service.getAll();
		long var2 = list2.size();

		Assert.assertEquals(true, var2 > var1);

	}

	@Test
	public void testDepartmentsUpdate() {
		DepartmentService service = new DepartmentServiceImpl();

		Department insdept = service.getById(14);

		String newName = "New-new name" + Math.random();

		insdept.setName(newName);

		service.update(insdept);

		String var2 = service.getById(14).getName();

		Assert.assertEquals(newName, var2);

	}

	@Test
	public void testInsertId() {
		DepartmentService service = new DepartmentServiceImpl();
		Department dept = new Department();
		dept.setName("Testers");
		long id = service.insert(dept);
		System.out.println(dept.getId());
	}

	@Test
	public void testDelete() {

		DepartmentService service = new DepartmentServiceImpl();
		service.delete(28);
		Department department = service.getById(28);
		Assert.assertEquals(true, department == null);
	}
}
