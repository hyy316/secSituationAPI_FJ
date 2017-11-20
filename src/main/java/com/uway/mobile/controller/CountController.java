package com.uway.mobile.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uway.mobile.common.Constance;
import com.uway.mobile.common.Result;
import com.uway.mobile.service.CountService;

@RestController
public class CountController {
	@Autowired
	private CountService countService;

	/**
	 * 统计各个地区占全省的比例
	 * 
	 * @param paraMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/countMap", method = RequestMethod.POST)
	public Result countMap(@RequestBody Map<String, Object> paraMap) throws Exception {
		Result result = new Result();
		/*
		 * try { if (paraMap.get("page_size") == null) {
		 * paraMap.put("page_size", Constance.PAGE_SIZE); } else {
		 * paraMap.put("page_size",
		 * Integer.parseInt(paraMap.get("page_size").toString())); } if
		 * (paraMap.get("page_num") == null) { paraMap.put("page_num", 0);
		 * result.setCode(Constance.RESPONSE_PARAM_EMPTY);
		 * result.setMsg("请传入页码！"); return result; } else {
		 * paraMap.put("page_num",
		 * (Integer.parseInt(paraMap.get("page_num").toString()) - 1)
		 * Integer.parseInt(paraMap.get("page_size").toString())); } Object
		 * timeRange = paraMap.get("timeRange"); if (timeRange == null ||
		 * "".equals(timeRange)) { paraMap.put("timeRange", ""); } else { if (!(
		 * "1 HOUR".equals(timeRange) || "6 HOUR".equals(timeRange) || "1 DAY"
		 * .equals(timeRange) || "6 MONTH".equals(timeRange) )) {
		 * paraMap.put("timeRange", "");
		 * result.setCode(Constance.RESPONSE_PARAM_ERROR);
		 * result.setMsg("不支持这种统计类型：" + timeRange); return result; } } if
		 * (Integer.parseInt(paraMap.get("page_num").toString()) < 0 ||
		 * Integer.parseInt(paraMap.get("page_size").toString()) <= 0) {
		 * result.setCode(Constance.RESPONSE_PARAM_ERROR);
		 * result.setMsg("参数格式不正确！"); return result; }
		 * 
		 * } catch (Exception e) {
		 * result.setCode(Constance.RESPONSE_INNER_ERROR);
		 * result.setMsg("内部错误"); e.printStackTrace(); }
		 */
		result.setCode(Constance.RESPONSE_SUCCESS);
		result.setData(countService.getProportion(paraMap));
		result.setMsg("查询成功！");

		return result;

	}

}
