package com.zhenya.test.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.zhenya.test.db.entity.AVGSalary;
import com.zhenya.test.service.AVGSalaryService;
import com.zhenya.test.service.impl.AVGSalaryServiceImpl;

import junit.framework.Assert;

public class TestAVGSalary {

	@Test
	public void testAVGSalarySize() {

		AVGSalaryService service = new AVGSalaryServiceImpl();

		List<AVGSalary> list = service.getAll();

		boolean var1 = list.size() > 0;
		Assert.assertEquals(true, var1);
	}

}
