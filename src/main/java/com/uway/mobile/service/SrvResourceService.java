package com.uway.mobile.service;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SrvResourceService {

	public Map<String, Object> getSrvResources(Map<String, Object> paraMap) throws Exception;

	public Map<String, Object> countSrvResources(Map<String, Object> sqlMap) throws Exception;

	public Map<String, Object> groupByParm(Map<String, Object> paraMap);

	public Map<String, Object> groupByTime(Map<String, Object> paraMap);

	public Map<String, Object> groupByMonth(Map<String, Object> paraMap);

	public Map<String, Object> groupByDay(Map<String, Object> paraMap);

	public void synchronizedSrvResourceFile() throws Exception;
}
