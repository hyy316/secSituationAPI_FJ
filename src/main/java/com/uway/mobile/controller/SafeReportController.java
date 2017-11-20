package com.uway.mobile.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uway.mobile.common.Constance;
import com.uway.mobile.common.Result;
import com.uway.mobile.domain.SummaryReport;
import com.uway.mobile.service.CountService;

@RestController
@RequestMapping("safeReport")
public class SafeReportController {

	@Autowired
	private CountService countService;

	/**
	 * 报告统计
	 * 
	 * @param cityname
	 * @param timeRange
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/summary", method = RequestMethod.GET)
	public Result summaryCount(@RequestParam(value = "city", required = false) String cityname,
			@RequestParam(value = "timeRange", required = false) String timeRange) throws Exception {

		Result result = new Result();

		System.out.println(cityname);
		System.out.println(timeRange);

		// SummaryReport sum = new SummaryReport();
		//
		// sum.setCity("福建");
		// sum.setTimeRange("1 DAY");
		// sum.setIndecency(5);
		// sum.setMalware(36);
		// sum.setMalwareEvents(2302);
		// sum.setVulnerability(22);

		Map<String, Object> param = new HashMap<String, Object>();
		SummaryReport sum = countService.getReport(param);
		sum.setCity("福建");
		sum.setTimeRange("1 DAY");
		result.setData(sum);
		result.setCode(Constance.RESPONSE_SUCCESS);
		result.setMsg("查询成功！");
		return result;

	}
}
