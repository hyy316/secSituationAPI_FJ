package com.uway.mobile.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uway.mobile.common.Constance;
import com.uway.mobile.common.Result;
import com.uway.mobile.service.IndecencyScanResultService;

@RestController
@RequestMapping("IndecencyScanResult")
public class ScanResultController {

	@Autowired
	public IndecencyScanResultService ScanResultService;

	/**
	 * 获取扫描列表
	 * 
	 * @param paraMap
	 * @return
	 */
	@RequestMapping(value = "/listScanResults", method = RequestMethod.POST)
	public Result getScanResults(@RequestBody Map<String, Object> paraMap) {
		Result result = new Result();
		try {
			if (paraMap.get("page_size") == null) {
				paraMap.put("page_size", Constance.PAGE_SIZE);
			} else {
				paraMap.put("page_size", Integer.parseInt(paraMap.get("page_size").toString()));
			}
			if (paraMap.get("page_num") == null) {
				paraMap.put("page_num", 0);
				result.setCode(Constance.RESPONSE_PARAM_EMPTY);
				result.setMsg("请传入页码！");
				return result;
			} else {
				paraMap.put("page_num", (Integer.parseInt(paraMap.get("page_num").toString()) - 1)
						* Integer.parseInt(paraMap.get("page_size").toString()));
			}
			Object timeRange = paraMap.get("timeRange");
			if (timeRange == null || "".equals(timeRange)) {
				paraMap.put("timeRange", "");
			} else {
				if (!("1 HOUR".equals(timeRange) || "6 HOUR".equals(timeRange) || "1 DAY".equals(timeRange))) {
					paraMap.put("timeRange", "");
					result.setCode(Constance.RESPONSE_PARAM_ERROR);
					result.setMsg("不支持这种统计类型：" + timeRange);
					return result;
				}
			}
			if (Integer.parseInt(paraMap.get("page_num").toString()) < 0
					|| Integer.parseInt(paraMap.get("page_size").toString()) <= 0) {
				result.setCode(Constance.RESPONSE_PARAM_ERROR);
				result.setMsg("参数格式不正确！");
				return result;
			}
			result.setCode(Constance.RESPONSE_SUCCESS);
			result.setData(ScanResultService.getIndecencyScanResult(paraMap));
			result.setMsg("查询成功！");
		} catch (Exception e) {
			result.setCode(Constance.RESPONSE_INNER_ERROR);
			result.setMsg("内部错误");
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 按时间分组查询
	 * 
	 * @param paraMap
	 * @return
	 */
	@RequestMapping(value = "/groupByTime", method = RequestMethod.POST)
	public Result groupByTime(@RequestBody Map<String, Object> paraMap) {
		Result result = new Result();
		// 时间分组类型
		Object unit = paraMap.get("timeRange");
		// 分组条目数量
		Object size = paraMap.get("size");
		int sizei = 0;
		if (size == null) {
			sizei = Constance.GROUP_SIZE;
		} else {
			sizei = Integer.parseInt(size.toString());
		}
		paraMap.put("size", sizei);

		if (unit == null || "".equals(unit)) {
			paraMap.put("timeRange", "");
			result.setCode(Constance.RESPONSE_PARAM_EMPTY);
			result.setMsg("请传入统计类型字段！");
			return result;
		} else {
			// unit 区间数，hours周期按小时为单位
			// 需要目标表里的记录大于等于区间数，否则返回数据只有表里的记录数量，数据不全不能完成计算
			if ("1 HOUR".equals(unit)) {
				paraMap.put("hours", 1);
			} else if ("6 HOUR".equals(unit)) {
				paraMap.put("hours", 6);
			} else if ("1 DAY".equals(unit)) {
				paraMap.put("hours", 24);
			} else {
				paraMap.put("timeRange", "");
				result.setCode(Constance.RESPONSE_PARAM_ERROR);
				result.setMsg("不支持这种统计类型：" + unit);
				return result;
			}

		}
		result.setCode(Constance.RESPONSE_SUCCESS);
		result.setData(ScanResultService.groupByTime(paraMap));
		result.setMsg("查询成功！");

		return result;
	}

	/**
	 * 按字段组查询
	 * 
	 * @param paraMap
	 * @return
	 */
	@RequestMapping(value = "/groupByParm", method = RequestMethod.POST)
	public Result groupByParm(@RequestBody Map<String, Object> paraMap) {
		Result result = new Result();
		// 分组字段，可用逗号隔开多个分组字段
		Object countType = paraMap.get("groupfields");
		// 返回统计前几位的分组数据
		Object topn = paraMap.get("topn");

		Object timeRange = paraMap.get("timeRange");
		if (timeRange == null || "".equals(timeRange)) {
			paraMap.put("timeRange", "");
		} else {
			if (!("1 HOUR".equals(timeRange) || "6 HOUR".equals(timeRange) || "1 DAY".equals(timeRange))) {
				paraMap.put("timeRange", "");
				result.setCode(Constance.RESPONSE_PARAM_ERROR);
				result.setMsg("不支持这种统计类型：" + timeRange);
				return result;
			}
		}

		if (topn == null) {
			paraMap.put("topn", Constance.TOP_N);
		} else {
			paraMap.put("topn", Integer.parseInt(topn.toString()));
		}
		if (countType == null || "".equals(countType)) {
			paraMap.put("groupfields", "");
			result.setCode(Constance.RESPONSE_PARAM_EMPTY);
			result.setMsg("请传入统计字段！");
			return result;
		} else {
			// TODO 统计字段,需要做防注入
			paraMap.put("groupfields", countType.toString());
		}
		result.setCode(Constance.RESPONSE_SUCCESS);
		result.setData(ScanResultService.groupByParm(paraMap));
		result.setMsg("查询成功！");

		return result;
	}

	/**
	 * 按资产组查询
	 * 
	 * @param paraMap
	 * @return
	 */
	@RequestMapping(value = "/groupByAsset", method = RequestMethod.POST)
	public Result groupByAsset(@RequestBody Map<String, Object> paraMap) {
		Result result = new Result();
		// 分组字段，可用逗号隔开多个分组字段
		Object countType = paraMap.get("groupfields");
		// 返回统计前几位的分组数据
		Object topn = paraMap.get("topn");

		Object timeRange = paraMap.get("timeRange");
		if (timeRange == null || "".equals(timeRange)) {
			paraMap.put("timeRange", "");
		} else {
			if (!("1 HOUR".equals(timeRange) || "6 HOUR".equals(timeRange) || "1 DAY".equals(timeRange))) {
				paraMap.put("timeRange", "");
				result.setCode(Constance.RESPONSE_PARAM_ERROR);
				result.setMsg("不支持这种统计类型：" + timeRange);
				return result;
			}
		}

		if (topn == null) {
			paraMap.put("topn", Constance.TOP_N);
		} else {
			paraMap.put("topn", Integer.parseInt(topn.toString()));
		}
		if (countType == null || "".equals(countType)) {
			paraMap.put("groupfields", "");
			result.setCode(Constance.RESPONSE_PARAM_EMPTY);
			result.setMsg("请传入统计字段！");
			return result;
		} else {
			// TODO 统计字段,需要做防注入
			paraMap.put("groupfields", countType.toString());
		}
		result.setCode(Constance.RESPONSE_SUCCESS);
		result.setData(ScanResultService.groupByAsset(paraMap));
		result.setMsg("查询成功！");

		return result;
	}

}
