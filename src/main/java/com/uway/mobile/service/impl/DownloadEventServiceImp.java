package com.uway.mobile.service.impl;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uway.mobile.common.StaticFtp;
import com.uway.mobile.domain.ECity;
import com.uway.mobile.domain.MalwareDownload;
import com.uway.mobile.mapper.MalwareDownloadMapper;
import com.uway.mobile.service.DownloadEventService;
import com.uway.mobile.util.FTPClientHandler;
import com.uway.mobile.util.StreamConvertUtil;


@Transactional
@Service
public class DownloadEventServiceImp implements DownloadEventService {
	
	
	@Autowired
	private MalwareDownloadMapper malwareDownloadMapper;

	public void synchronizedMalwareDownloadFiles() throws Exception {
		try {
			FTPFile[] listFiles = FTPClientHandler.listFiles(StaticFtp.sourceFilePath);
			for (FTPFile ftpFile : listFiles) {
				if (ftpFile.getName().startsWith("I_EYXZ")) {
					OutputStream outputStream = FTPClientHandler.downloadStream(StaticFtp.sourceFilePath, ftpFile.getName());
					if (outputStream==null) {
						continue;
					}
					ByteArrayInputStream inputStream = StreamConvertUtil.parse(outputStream);
					BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
					List<MalwareDownload> list=new ArrayList<>();
					String line="";
					try {
						while ((line=reader.readLine())!=null) {
							if (line.trim()!="") {
								String[] split = line.split(",");
								String phone=split[0].trim();
								String number=split[1].trim();
								String E_name=split[2].trim();
								String type=split[3].trim();
								String attribute=split[4].trim();
								String url=split[5].trim();
								String md5=split[6].trim();
								String gtime = split[7].trim();
								String Z_name=E_name;
								
								SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
								Date gettime =null;
								if (gtime != null && gtime.length() > 8) {
									try {
										gettime = df.parse(gtime);
									} catch (ParseException e) {
										gettime = new Date();
									}
								} else {
									gettime = new Date();
								}
								Map<String, String> map = ECity.getCity();
								String city = map.get(number);
								if (city!=null) {
									MalwareDownload download=new MalwareDownload(phone, city, E_name, 
											type, attribute, url, md5, gettime,Z_name,0);
									list.add(download);
								}
							}
						}
					} finally {
						if (reader!=null) {
							reader.close();
						}
						if (inputStream!=null) {
							inputStream.close();
						}
						if (outputStream!=null) {
							outputStream.close();
						}
					}
					if (list!=null&&list.size()>0) {
						malwareDownloadMapper.insert(list);
						String sourceFilePath=StaticFtp.sourceFilePath+ftpFile.getName();
						String destFilePath=StaticFtp.destFilePath+ftpFile.getName();
						FTPClientHandler.renameFile(sourceFilePath, destFilePath);
					}
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}



}
