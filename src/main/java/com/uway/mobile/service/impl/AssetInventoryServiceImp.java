package com.uway.mobile.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uway.mobile.mapper.AssetInventoryServiceMapper;
import com.uway.mobile.service.AssetInventoryService;

@Transactional
@Service
public class AssetInventoryServiceImp implements AssetInventoryService {

	@Autowired
	private AssetInventoryServiceMapper assetInventoryMapper;

	@Override
	public Map<String, Object> getCrcAssetInventory(Map<String, Object> paraMap) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		long pageSize = Long.parseLong(paraMap.get("page_size").toString());
		List<Map<String, Object>> details = assetInventoryMapper.getCrcAssetInventory(paraMap);
		if (details != null) {
			resultMap.put("details", details);
			long totalNum = assetInventoryMapper.countCrcAssetInventory(paraMap);
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
		List<Map<String, Object>> details = assetInventoryMapper.groupByParm(paraMap);
		if (details != null) {
			resultMap.put("details", details);
			resultMap.put("total_num", details.size());
		}
		return resultMap;
	}

	@Override
	public long countAssertInventory(Map<String, Object> paraMap) {
		return assetInventoryMapper.countCrcAssetInventory(paraMap);
	}

}
