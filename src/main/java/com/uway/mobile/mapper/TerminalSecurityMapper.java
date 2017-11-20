package com.uway.mobile.mapper;

import java.util.List;
import java.util.Map;

public interface TerminalSecurityMapper {
	List<Map<String, Object>> groupByParm(Map<String, Object> paraMap);

	List<Map<String, Object>> getTerminalSecurity(Map<String, Object> paraMap);

	public long countTerminalSecurity(Map<String, Object> sqlMap);

	int deleteByPrimaryKey(Integer id);

	List<Map<String, Object>> groupByMulParm(Map<String, Object> paraMap);
}
