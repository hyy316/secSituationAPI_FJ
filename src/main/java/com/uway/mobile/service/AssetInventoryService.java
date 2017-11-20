package com.uway.mobile.service;

import java.util.Map;

public interface AssetInventoryService {

	public Map<String, Object> getCrcAssetInventory(Map<String, Object> paraMap);

	public Map<String, Object> groupByParm(Map<String, Object> paraMap);

	long countAssertInventory(Map<String, Object> paraMap);
}
