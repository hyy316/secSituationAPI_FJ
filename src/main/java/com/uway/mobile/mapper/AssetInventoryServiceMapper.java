package com.uway.mobile.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.uway.mobile.domain.CRCassetInventory;
import com.uway.mobile.domain.CRCassetInventoryQuery;

public interface AssetInventoryServiceMapper {
	List<Map<String, Object>> getCrcAssetInventory(Map<String, Object> paraMap);

	public long countCrcAssetInventory(Map<String, Object> sqlMap);

	int countByExample(CRCassetInventoryQuery example);

	int deleteByExample(CRCassetInventoryQuery example);

	int deleteByPrimaryKey(Integer id);

	int insert(CRCassetInventory record);

	int insertSelective(CRCassetInventory record);

	List<CRCassetInventory> selectByExample(CRCassetInventoryQuery example);

	CRCassetInventory selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") CRCassetInventory record,
			@Param("example") CRCassetInventoryQuery example);

	int updateByExample(@Param("record") CRCassetInventory record, @Param("example") CRCassetInventoryQuery example);

	int updateByPrimaryKeySelective(CRCassetInventory record);

	int updateByPrimaryKey(CRCassetInventory record);

	List<Map<String, Object>> groupByParm(Map<String, Object> paraMap);

}
