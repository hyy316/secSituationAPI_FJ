package com.uway.mobile.service;

import java.util.Map;

public interface TerminalSecurityService {

	Map<String, Object> groupByParm(Map<String, Object> paraMap);

	Map<String, Object> getCrcAssetInventory(Map<String, Object> paraMap);

	Map<String, Object> groupByMulParm(Map<String, Object> paraMap);
}
