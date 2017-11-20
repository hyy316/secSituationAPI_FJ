package com.uway.mobile.mapper;

import java.util.List;
import java.util.Map;

public interface CountMapper {

	public List<Map<String, Object>> getCountName(Map<String, Object> sqlMap);

	public List<Map<String, Object>> getCountIndecency(Map<String, Object> sqlMap);

	public List<Map<String, Object>> getCountsrvResource(Map<String, Object> sqlMap);

	public List<Map<String, Object>> getCountVulnerability(Map<String, Object> sqlMap);
}
