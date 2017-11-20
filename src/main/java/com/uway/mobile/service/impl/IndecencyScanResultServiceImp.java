package com.uway.mobile.service.impl;

import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uway.mobile.common.StaticFtp;
import com.uway.mobile.domain.IndecencyScanResult;
import com.uway.mobile.mapper.IndecencyScanResultMapper;
import com.uway.mobile.service.IndecencyScanResultService;
import com.uway.mobile.util.FTPClientHandler;
import com.uway.mobile.util.POIUtil;
import com.uway.mobile.util.StreamConvertUtil;
import com.uway.mobile.util.ZipStrUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Transactional
@Service
public class IndecencyScanResultServiceImp implements IndecencyScanResultService {

	private static final Logger log = Logger.getLogger(IndecencyScanResultServiceImp.class);
	@Autowired
	private IndecencyScanResultMapper indecencyScanResultMapper;

	@Override
	public Map<String, Object> getIndecencyScanResult(Map<String, Object> paraMap) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		long pageSize = Long.parseLong(paraMap.get("page_size").toString());
		List<Map<String, Object>> details = indecencyScanResultMapper.getIndecencyScanResult(paraMap);
		if (details != null) {
			
			//处理html页面源码，解压缩
			for(Map<String, Object> map :details){
				try{
				String hc =  (String) map.get("htmlContent");
				hc = ZipStrUtil.unCompress(hc);
				 map.put("htmlContent",hc);
				}catch(Exception e ){
					e.printStackTrace();
				}
			}
			
			resultMap.put("details", details);
			// int totalNum = details.size();
			long totalNum = indecencyScanResultMapper.countindecencyScanResults(paraMap);
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
	public long countScanResult(Map<String, Object> sqlMap) throws Exception {
		// TODO Auto-generated method stub
		return indecencyScanResultMapper.countindecencyScanResults(sqlMap);
	}

	@Override
	public Map<String, Object> groupByParm(Map<String, Object> paraMap) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Map<String, Object>> details = indecencyScanResultMapper.groupByParm(paraMap);
		if (details != null) {
			resultMap.put("details", details);
			resultMap.put("total_num", details.size());
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> groupByTime(Map<String, Object> paraMap) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Map<String, Object>> details = indecencyScanResultMapper.groupByTime(paraMap);
		if (details != null) {
			resultMap.put("details", details);
			resultMap.put("total_num", details.size());
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> groupByAsset(Map<String, Object> paraMap) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Map<String, Object>> details = indecencyScanResultMapper.groupByAsset(paraMap);
		if (details != null) {
			resultMap.put("details", details);
			resultMap.put("total_num", details.size());
		}
		return resultMap;
	}

	@Override
	public void download_indecencyScanResultFile() throws Exception {
		
		FTPFile[] ftpFiles = null;
		log.debug("开始扫描ftp服务器目录待处理不良信息文件。");
		try {
			ftpFiles = FTPClientHandler.listFiles(StaticFtp.indecencyScan);
		} catch (Exception e) {
			log.error("扫描ftp服务器目录待处理文件异常！"+e.toString());
			e.printStackTrace();
		}
		if (ftpFiles != null) {

			log.debug("扫描ftp服务器目录待处理文件："+ftpFiles.length);
			for (FTPFile ftpFile : ftpFiles) {
				if (ftpFile.getName().startsWith(StaticFtp.file_indecencyScanResult)) {
					List<IndecencyScanResult> list = new ArrayList<IndecencyScanResult>();
					OutputStream outputStream = null;
					InputStream inputStream = null;
					try {
						log.debug("开始下载文件："+ftpFile.getName()+",文件大小："+ftpFile.getSize());
						outputStream = FTPClientHandler.downloadStream(StaticFtp.indecencyScan, ftpFile.getName());
						log.debug("完成下载文件："+ftpFile.getName()+",文件大小："+ftpFile.getSize());
						if (outputStream == null) {
							continue;
						}
						inputStream = StreamConvertUtil.parse(outputStream);
						JSONArray jsonArray = POIUtil.getJsonFile(inputStream);
						int size = jsonArray.size();
						log.debug("文件数据行数："+size);
						for (int i = 0; i < size; i++) {

							JSONObject jsonObject = jsonArray.getJSONObject(i);
							Integer assertinfoid = (Integer) jsonObject.get("assertInfoId");
							Integer notify=(Integer)jsonObject.get("notify");
							if (notify == null) {
								notify = 0;
							}
							String port = jsonObject.getString("port");
							if (StringUtils.isEmpty(port)) {
								port = "-";
							}
							
							String ip = jsonObject.getString("ip");
							if (StringUtils.isEmpty(ip)) {
								ip = "-";
							}
							String department = jsonObject.getString("department");
							if (StringUtils.isEmpty(department)) {
								department = "-";
							}
							String oriurl = jsonObject.getString("oriurl");
							if (StringUtils.isEmpty(oriurl)) {
								oriurl = "-";
							}
							String url = jsonObject.getString("url");
							if (StringUtils.isEmpty(url)) {
								url = "-";
							}
							Date scantime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
									.parse(jsonObject.getString("scantime"));
							String title = jsonObject.getString("title");
							if (StringUtils.isEmpty(title)) {
								title = "-";
							}
							String sensitype = jsonObject.getString("sensitype");
							if (StringUtils.isEmpty(sensitype)) {
								sensitype = "-";
							}
							String occurence = jsonObject.getString("occurence");
							if (StringUtils.isEmpty(occurence)) {
								occurence = "-";
							}
							String esid = jsonObject.getString("esid");
							if (StringUtils.isEmpty(esid)) {
								esid = "-";
							}
							String htmlcontent = jsonObject.getString("htmlContent");
							if (StringUtils.isEmpty(htmlcontent)) {
								htmlcontent = "-";
							}
							IndecencyScanResult indecencyScanResult = new IndecencyScanResult(notify,assertinfoid, ip, port,
									department, oriurl, url, scantime, title, sensitype, occurence, esid, htmlcontent);
							list.add(indecencyScanResult);
						}
						if (list != null && list.size() > 0) {
							indecencyScanResultMapper.insert(list);
							log.debug("不良信息入库记录数："+list.size());
						}

						String sourceFileName = StaticFtp.indecencyScan + ftpFile.getName();
						String movFileName = StaticFtp.indecencySacn_his + ftpFile.getName();

						FTPClientHandler.renameFile(sourceFileName, movFileName);
						log.debug("不良信息文件归档成功。");

					} catch (Exception e) {
						log.error("不良信息同步出错:"+ftpFile.getName()+"."+e.toString());
						e.printStackTrace();
					} finally {
						if (outputStream != null) {
							outputStream.close();
						}
						if (inputStream != null) {
							inputStream.close();
						}
					}
				}
			}
		}
	}

}
