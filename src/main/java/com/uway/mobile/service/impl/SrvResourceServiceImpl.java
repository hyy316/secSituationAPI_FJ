package com.uway.mobile.service.impl;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.net.ftp.FTPFile;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uway.mobile.common.StaticFtp;
import com.uway.mobile.domain.SrvResource;
import com.uway.mobile.mapper.SrvResourceMapper;
import com.uway.mobile.service.SrvResourceService;
import com.uway.mobile.util.FTPClientHandler;
import com.uway.mobile.util.POIUtil;
import com.uway.mobile.util.ParseCityUtil;
import com.uway.mobile.util.StreamConvertUtil;

@Service("srvResourceService")
public class SrvResourceServiceImpl implements SrvResourceService {

	private static final Logger log = Logger.getLogger(SrvResourceServiceImpl.class);
	@Autowired
	private SrvResourceMapper srvResourceMapper;

	@Override
	public Map<String, Object> getSrvResources(Map<String, Object> paraMap) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		long pageSize = Long.parseLong(paraMap.get("page_size").toString());
		List<Map<String, Object>> details = srvResourceMapper.getSrvResources(paraMap);
		if (details != null) {
			resultMap.put("details", details);
			long totalNum = srvResourceMapper.countSrvResources(paraMap);
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
	public Map<String, Object> countSrvResources(Map<String, Object> sqlMap) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		long totalNum = srvResourceMapper.countSrvResources(sqlMap);
		resultMap.put("SUM", totalNum);

		return resultMap;
	}

	@Override
	public Map<String, Object> groupByParm(Map<String, Object> paraMap) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Map<String, Object>> details = srvResourceMapper.groupByParm(paraMap);
		if (details != null) {
			resultMap.put("details", details);
			resultMap.put("total_num", details.size());
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> groupByTime(Map<String, Object> paraMap) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Map<String, Object>> details = srvResourceMapper.groupByTime(paraMap);
		if (details != null) {
			resultMap.put("details", details);
			resultMap.put("total_num", details.size());
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> groupByMonth(Map<String, Object> paraMap) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Map<String, Object>> details = srvResourceMapper.groupByMonth(paraMap);
		if (details != null) {
			resultMap.put("details", details);
			resultMap.put("total_num", details.size());
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> groupByDay(Map<String, Object> paraMap) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Map<String, Object>> details = srvResourceMapper.groupByDay(paraMap);
		if (details != null) {
			resultMap.put("details", details);
			resultMap.put("total_num", details.size());
		}
		return resultMap;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void synchronizedSrvResourceFile() throws Exception {
		FTPFile[] listFiles = null;
		log.debug("开始扫描ftp服务器目录待处理资产列表文件。");
		try {
			listFiles = FTPClientHandler.listFiles(StaticFtp.srvResource);
		} catch (Exception e) {
			log.error("扫描ftp服务器目录待处理文件异常！"+e.toString());
			e.printStackTrace();
		}
		if (listFiles != null) {
			log.debug("扫描ftp服务器目录待处理文件："+listFiles.length);
			for (FTPFile ftpFile : listFiles) {
				if (ftpFile.getName().startsWith(StaticFtp.srvResource_file)) {
					OutputStream outputStream = null;
					InputStream inputStream = null;
					try {
						log.debug("开始下载文件："+ftpFile.getName()+",文件大小："+ftpFile.getSize());
						outputStream = FTPClientHandler.downloadStream(StaticFtp.srvResource,
								ftpFile.getName());
						log.debug("完成下载文件："+ftpFile.getName()+",文件大小："+ftpFile.getSize());
						if (outputStream == null) {
							continue;
						}
						inputStream = StreamConvertUtil.parse(outputStream);
						Sheet sheet = POIUtil.getExcelFile(ftpFile.getName(), inputStream);
						List<SrvResource> list = new ArrayList<SrvResource>();
						log.debug("文件数据行数："+sheet.getLastRowNum());
						for (Row row : sheet) {
							int rowNum = row.getRowNum();
							if (rowNum == 0) {
								continue;
							}
							String city = row.getCell(0).toString();
							String ip = row.getCell(1).toString();
							row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
							String port = row.getCell(2).toString();
							String service = row.getCell(3).toString();
							String info = row.getCell(4).toString();
							Date createtime = POIUtil.buildDate(row.getCell(5),"yyyy/M/d H:mm:ss");
							
							if(createtime == null){
								continue;
							}
							
							city = ParseCityUtil.getLongCityName(city);

							if(city == null){
								continue;
							}
							
							SrvResource srvResource = new SrvResource(city, ip, port, service, info, createtime, null,
									null);
							list.add(srvResource);
						}
						if (list != null && list.size() > 0) {
							srvResourceMapper.insertBath(list);
							log.debug("资产标入库记录数："+list.size());
						}
						String sourceFilePath = StaticFtp.srvResource + ftpFile.getName();
						String destFilePath = StaticFtp.srvResource_his + ftpFile.getName();
						FTPClientHandler.renameFile(sourceFilePath, destFilePath);
						log.debug("资产表文件归档成功。");
					} catch (Exception e) {
						log.error("资产表同步出错:"+ftpFile.getName()+"."+e.toString());
						e.printStackTrace();
					}finally{
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
