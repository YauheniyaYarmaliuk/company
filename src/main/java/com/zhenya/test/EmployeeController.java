package com.zhenya.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zhenya.test.db.entity.Employee;
import com.zhenya.test.service.impl.EmployeeServiceImpl;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Employee> getAll() {
		List<Employee> employees = new EmployeeServiceImpl().getAll();
		return employees;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Employee getEmployee(@PathVariable Integer id) {
		Employee employee = new EmployeeServiceImpl().getById(id);
		return employee;
	}

	@RequestMapping(value = "/update/{id}/{salary}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public long update(@PathVariable Integer salary, @PathVariable Integer id) {
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		Employee employee = service.getById(id);
		employee.setSalary(salary);
		return service.update(employee);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public long delete(@PathVariable Integer id) {
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		return service.delete(id);
	}

	@RequestMapping(value = "/insert/{deptId}/{name}/{surname}/{patronymic}/{birth}/{salary}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public long insert(@PathVariable Integer deptId, @PathVariable String name, @PathVariable String surname,
			@PathVariable String patronymic, @PathVariable String birth, @PathVariable Integer salary) {
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		Employee employee = new Employee();
		employee.setDeptId(deptId);
		employee.setName(name);
		employee.setSurname(surname);
		employee.setPatronymic(patronymic);

		Date dob = getDOB(birth);

		employee.setBirth(dob);
		employee.setSalary(salary);
		return service.insert(employee);
	}

	public static Date getDOB(String birth) {

		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			return formatter.parse(birth);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/findOfBirth/{birth}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Employee> findOfBirth(@PathVariable String birth) {
		Date dob = getDOB(birth);
		List<Employee> employees = new EmployeeServiceImpl().findOfBirth(dob);
		return employees;
	}

}
