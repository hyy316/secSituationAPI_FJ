package com.uway.mobile.mapper;

import java.util.List;
import java.util.Map;

import com.uway.mobile.domain.SrvResource;

@Mapper
public interface SrvResourceMapper {

	public List<Map<String, Object>> getSrvResources(Map<String, Object> sqlMap);

	public List<Map<String, Object>> groupByParm(Map<String, Object> paraMap);

	public List<Map<String, Object>> groupByTime(Map<String, Object> paraMap);

	public List<Map<String, Object>> groupByMonth(Map<String, Object> paraMap);

	public List<Map<String, Object>> groupByDay(Map<String, Object> paraMap);

	public long countSrvResources(Map<String, Object> sqlMap);

	int deleteByPrimaryKey(Integer id);

	int insert(SrvResource record);

	int insertSelective(SrvResource record);

	SrvResource selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(SrvResource record);

	int updateByPrimaryKey(SrvResource record);

	public List<SrvResource> getAll();

	public void insertBath(List<SrvResource> list);

}