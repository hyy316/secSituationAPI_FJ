package com.uway.mobile.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uway.mobile.mapper.TerminalSecurityMapper;
import com.uway.mobile.service.TerminalSecurityService;

@Transactional
@Service
public class TerminalSecurityServiceImp implements TerminalSecurityService {

	@Autowired
	private TerminalSecurityMapper terminalSecurityMapper;

	@Override
	public Map<String, Object> getCrcAssetInventory(Map<String, Object> paraMap) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		long pageSize = Long.parseLong(paraMap.get("page_size").toString());
		List<Map<String, Object>> details = terminalSecurityMapper.getTerminalSecurity(paraMap);
		if (details != null) {
			resultMap.put("details", details);
			long totalNum = terminalSecurityMapper.countTerminalSecurity(paraMap);
			resultMap.put("total_num", totalNum);
			if (totalNum % pageSize > 0) {
				resultMap.put("total_page", totalNum / pageSize + 1);
			} else {
				resultMap.put("total_page", totalNum / pageSize);
			}
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> groupByParm(Map<String, Object> paraMap) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Map<String, Object>> details = terminalSecurityMapper.groupByParm(paraMap);
		if (details != null) {
			resultMap.put("details", details);
			resultMap.put("total_num", details.size());
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> groupByMulParm(Map<String, Object> paraMap) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Map<String, Object>> details = terminalSecurityMapper.groupByMulParm(paraMap);
		if (details != null) {
			resultMap.put("details", details);
			resultMap.put("total_num", details.size());
		}
		return resultMap;
	}

}
