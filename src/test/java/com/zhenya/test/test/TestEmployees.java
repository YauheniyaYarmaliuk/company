package com.zhenya.test.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.junit.Test;

import com.zhenya.test.EmployeeController;
import com.zhenya.test.db.entity.Department;
import com.zhenya.test.db.entity.Employee;
import com.zhenya.test.service.DepartmentService;
import com.zhenya.test.service.EmployeeService;
import com.zhenya.test.service.impl.DepartmentServiceImpl;
import com.zhenya.test.service.impl.EmployeeServiceImpl;

import junit.framework.Assert;

public class TestEmployees {

/*	@Test
	public void testByBirth() {
		EmployeeService service = new EmployeeServiceImpl();

		Date dob = EmployeeController.getDOB("1991-02-10");

		List<Employee> list = service.findOfBirth(dob);
		boolean var1 = list.size() > 0;

		Assert.assertEquals(true, var1);
	}
*/
	@Test
	public void testEmployeeSize() {

		EmployeeService service = new EmployeeServiceImpl();

		List<Employee> list = service.getAll();

		boolean var1 = list.size() > 0;
		Assert.assertEquals(true, var1);
	}

	@Test
	public void testEmployeeById() {

		EmployeeService service = new EmployeeServiceImpl();
		Employee employee = service.getById(9);
		Assert.assertEquals(true, employee != null);
	}

	@Test
	public void testEmployeeInsert() {
		Employee test = new Employee();
		test.setDeptId(1);
		test.setName("Yauheniya");
		test.setSurname("Yarmaliuk");
		test.setPatronymic("Dmitrievna");

		String str = "1991-02-10";
		Date dt = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		try {
			dt = formatter.parse(str);
		} catch (Exception e) {
		}

		JOptionPane.showMessageDialog(null, formatter.format(dt));

		test.setBirth(dt);
		test.setSalary(600);

		EmployeeService service = new EmployeeServiceImpl();
		List<Employee> list = service.getAll();
		long var1 = list.size();

		service.insert(test);
		List<Employee> list2 = service.getAll();
		long var2 = list2.size();

		Assert.assertEquals(true, var2 > var1);

	}

	@Test
	public void testEmployeeUpdate() {
		EmployeeService service = new EmployeeServiceImpl();

		Employee insempl = service.getById(12);

		int salary = 1000;

		insempl.setSalary(salary);

		service.update(insempl);

		int var2 = service.getById(12).getSalary();

		Assert.assertEquals(salary, var2);

	}

	@Test
	public void testDelete() {

		EmployeeService service = new EmployeeServiceImpl();
		service.delete(5);
		Employee employee = service.getById(5);
		Assert.assertEquals(true, employee == null);
	}

}
