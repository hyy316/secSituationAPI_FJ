package com.uway.mobile.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ControlEventService {

	void synchronizedMalwareControlFiles() throws Exception;
}
