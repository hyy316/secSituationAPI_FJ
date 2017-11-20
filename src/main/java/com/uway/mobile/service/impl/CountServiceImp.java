package com.uway.mobile.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uway.mobile.domain.CityReport;
import com.uway.mobile.domain.SummaryReport;
import com.uway.mobile.mapper.IndecencyScanResultMapper;
import com.uway.mobile.mapper.MalwareMapper;
import com.uway.mobile.mapper.SrvResourceMapper;
import com.uway.mobile.mapper.VulnerabilityMapper;
import com.uway.mobile.service.CountService;
import com.uway.mobile.util.ParseCityUtil;

@Transactional
@Service
public class CountServiceImp implements CountService {

	@Autowired
	private IndecencyScanResultMapper indecencyScanResultMapper;
	@Autowired
	private MalwareMapper malwareMapper;
	@Autowired
	private SrvResourceMapper srvResourceMapper;
	@SuppressWarnings("unused")
	@Autowired
	private VulnerabilityMapper vulnerabilityMapper;

	@Override
	public Map<String, CityReport> getProportion(Map<String, Object> paraMap) {

		Map<String, CityReport> resultMap = new HashMap<String, CityReport>();

		paraMap.put("timeRange", "6 MONTH");
		paraMap.put("groupfields", "department");
		paraMap.put("topn", 50);

		paraMap.put("vulnerable", "true");
		long vulnerCount = srvResourceMapper.countSrvResources(paraMap);
		List<Map<String, Object>> vulerablesRes = srvResourceMapper.groupByParm(paraMap);

		paraMap.put("isRegisted", "true");
		List<Map<String, Object>> registVulerables = srvResourceMapper.groupByParm(paraMap);
		long registVulCount = srvResourceMapper.countSrvResources(paraMap);
		long unregistVulCount = vulnerCount - registVulCount;
		// paraMap.put("timeRange", "1 DAY");
		List<Map<String, Object>> ScanResultes = indecencyScanResultMapper.groupByParm(paraMap);

		paraMap.put("groupfields", "city");
		List<Map<String, Object>> malwares = malwareMapper.groupByParm(paraMap);

		// 城市集合
		List<String> citys = ParseCityUtil.CITYLIST;
		// 获取城市列表
		for (String city : citys) {
			// 初始化对象
			CityReport cobj = null;
			// 遍历查询结果集
			for (Map<String, Object> detail : ScanResultes) {
				@SuppressWarnings("unused")
				Object object = detail.get("department");
				String incity = ParseCityUtil.getCityName(detail.get("department").toString());
				if (incity.equals(city)) {
					String sumStr = detail.get("sum").toString();
					// 如果取出的城市為null
					if (resultMap.get(city) == null) {
						// 创建对象，进行赋值
						cobj = new CityReport();
						cobj.setCity(city);
						cobj.setIndecencyWebSit(sumStr);
						resultMap.put(city, cobj);
					} else {
						cobj = resultMap.get(city);
						cobj.setIndecencyWebSit(sumStr);
						resultMap.put(city, cobj);
					}
				}
			}
			for (Map<String, Object> detail4 : malwares) {
				String incity = ParseCityUtil.getCityName(detail4.get("city").toString());
				if (incity.equals(city)) {
					String sumstr = detail4.get("sum").toString();
					if (resultMap.get(city) == null) {
						cobj = new CityReport();
						cobj.setCity(city);
						cobj.setMalware(sumstr);
						resultMap.put(city, cobj);
					} else {
						cobj = resultMap.get(city);
						cobj.setMalware(sumstr);
						resultMap.put(city, cobj);
					}
				}
			}
			for (Map<String, Object> detail : vulerablesRes) {
				String incity = ParseCityUtil.getCityName(detail.get("department").toString());
				if (incity.equals(city)) {
					String sumStr = detail.get("sum").toString();

					if (resultMap.get(city) == null) {
						cobj = new CityReport();
						cobj.setCity(city);
						cobj.setVulnerable(sumStr);
						cobj.setUnRegistVulner(String.valueOf(unregistVulCount));
						resultMap.put(city, cobj);
					} else {
						cobj = resultMap.get(city);
						cobj.setVulnerable(sumStr);
						cobj.setUnRegistVulner(String.valueOf(unregistVulCount));
						resultMap.put(city, cobj);
					}
				}
			}
			for (Map<String, Object> detail3 : registVulerables) {
				String incity = ParseCityUtil.getCityName(detail3.get("department").toString());
				if (incity.equals(city)) {

					String sumStr = detail3.get("sum").toString();
					if (resultMap.get(city) == null) {
						cobj = new CityReport();
						cobj.setCity(city);
						cobj.setUnRegistVulner(sumStr);
						cobj.setUnRegistVulner(String.valueOf(unregistVulCount));
						resultMap.put(city, cobj);
					} else {
						cobj = resultMap.get(city);
						cobj.setUnRegistVulner(sumStr);
						cobj.setUnRegistVulner(String.valueOf(unregistVulCount));
						resultMap.put(city, cobj);
					}
				}
			}

			//
			// cobj = new CityReport();
			// cobj.setCity(city);
			// resultMap.put(city,cobj);
		}

		return resultMap;
	}

	@Override
	public SummaryReport getReport(Map<String, Object> paraMap) {
		SummaryReport sresult = new SummaryReport();

		paraMap.put("page_size", "1");
		paraMap.put("page_num", "1");

		paraMap.put("timeRange", "1 DAY");
		long scanParmCount = indecencyScanResultMapper.countindecencyScanResults(paraMap);
		long malNameCount = malwareMapper.countMalware(paraMap);

		long malEvntCount = malwareMapper.countMalwareEvent(paraMap);

		paraMap.put("timeRange", "6 MONTH");
		paraMap.put("vulnerable", "true");
		long vulnerCount = srvResourceMapper.countSrvResources(paraMap);

		sresult.setIndecency(scanParmCount);
		sresult.setMalware(malNameCount);
		sresult.setMalwareEvents(malEvntCount);
		sresult.setVulnerability(vulnerCount);

		return sresult;
	}

}
