package com.uway.mobile.mapper;

import java.util.List;
import java.util.Map;

import com.uway.mobile.domain.IndecencyScanResult;

public interface IndecencyScanResultMapper {

	public List<Map<String, Object>> getIndecencyScanResult(Map<String, Object> sqlMap);

	public List<Map<String, Object>> groupByParm(Map<String, Object> paraMap);

	public List<Map<String, Object>> groupByTime(Map<String, Object> paraMap);

	public long countindecencyScanResults(Map<String, Object> paraMap);

	public List<Map<String, Object>> groupByAsset(Map<String, Object> paraMap);

	void insert(List<IndecencyScanResult> list);
}