package com.zhenya.test;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenya.test.db.entity.Department;
import com.zhenya.test.service.impl.DepartmentServiceImpl;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Department> getAll() {
		List<Department> departments = new DepartmentServiceImpl().getAll();
		return departments;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Department getDepartment(@PathVariable Integer id) {
		Department department = new DepartmentServiceImpl().getById(id);
		return department;
	}

	@RequestMapping(value = "/update/{id}/{name}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public long update(@PathVariable Integer id, @PathVariable String name) {
		DepartmentServiceImpl service = new DepartmentServiceImpl();
		Department department = service.getById(id);
		department.setName(name);
		return service.update(department);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public long delete(@PathVariable Integer id) {
		DepartmentServiceImpl service = new DepartmentServiceImpl();
		return service.delete(id);
	}

	@RequestMapping(value = "/insert/{name}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public long insert(@PathVariable String name) {
		DepartmentServiceImpl service = new DepartmentServiceImpl();
		Department department = new Department();
		department.setName(name);

		return service.insert(department);
	}

}
