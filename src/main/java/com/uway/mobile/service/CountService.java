package com.uway.mobile.service;

import java.util.Map;

import com.uway.mobile.domain.CityReport;
import com.uway.mobile.domain.SummaryReport;

public interface CountService {
	public Map<String, CityReport> getProportion(Map<String, Object> paraMap);

	public SummaryReport getReport(Map<String, Object> paraMap);

}
