package com.zhenya.test.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zhenya.test.db.dao.AVGSalaryDao;
import com.zhenya.test.db.entity.AVGSalary;
import com.zhenya.test.db.mybatis.MyBatisConnectionFactory;
import com.zhenya.test.service.AVGSalaryService;

@Service("avgSalaryService")
public class AVGSalaryServiceImpl implements AVGSalaryService {

	public List<AVGSalary> getAll() {
		AVGSalaryDao avgSalaryDAO = new AVGSalaryDao(MyBatisConnectionFactory.getSqlSessionFactory());
		return avgSalaryDAO.getAll();
	}

}
