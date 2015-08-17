package com.zhenya.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhenya.test.db.entity.AVGSalary;
import com.zhenya.test.db.entity.Department;
import com.zhenya.test.db.entity.Employee;
import com.zhenya.test.service.AVGSalaryService;
import com.zhenya.test.service.DepartmentService;
import com.zhenya.test.service.impl.AVGSalaryServiceImpl;
import com.zhenya.test.service.impl.DepartmentServiceImpl;
import com.zhenya.test.service.impl.EmployeeServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller(value = "HomeController")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/avgSalaries", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<AVGSalary> avgSalaries(Locale locale, Model model) {
		AVGSalaryService service = new AVGSalaryServiceImpl();
		return service.getAll();
	}

	@RequestMapping(value = "/avg", method = RequestMethod.GET)
	public String avg(Locale locale, Model model) {
		return "avgSalary";
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public String page(Locale locale, Model model) {
		return "employees";
	}
}
