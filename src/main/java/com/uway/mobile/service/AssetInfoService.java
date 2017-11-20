package com.uway.mobile.service;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AssetInfoService {

	public Map<String, Object> getAssetInfos(Map<String, Object> paraMap) throws Exception;

	Map<String, Object> groupByTime(Map<String, Object> paraMap);

	Map<String, Object> groupByParm(Map<String, Object> paraMap);
}
