package com.uway.mobile.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DownloadEventService {

	void synchronizedMalwareDownloadFiles() throws Exception;
}
