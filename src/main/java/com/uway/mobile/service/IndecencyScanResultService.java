package com.uway.mobile.service;

import java.util.Map;

public interface IndecencyScanResultService {

	void download_indecencyScanResultFile() throws Exception;

	public Map<String, Object> getIndecencyScanResult(Map<String, Object> paraMap) throws Exception;

	public long countScanResult(Map<String, Object> sqlMap) throws Exception;

	public Map<String, Object> groupByParm(Map<String, Object> paraMap);

	public Map<String, Object> groupByTime(Map<String, Object> paraMap);

	public Map<String, Object> groupByAsset(Map<String, Object> paraMap);
}
