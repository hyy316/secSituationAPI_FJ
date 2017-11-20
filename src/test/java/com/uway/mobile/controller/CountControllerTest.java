package com.uway.mobile.controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@AutoConfigureMockMvc
public class CountControllerTest extends BaseApplicationTest {

	@Autowired
	MockMvc mvc;

	/**
	 * 统计城市对应的数据
	 * 
	 * @throws Exception
	 */
	@Test
	public void testcountMap() throws Exception {
		String uri = "/countMap";
		String requestJson = "{\"page_size\":\"10\",\"page_num\":\"10\",\"timeRange\":\"\"}";
		RequestBuilder request = null;
		request = MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(requestJson);
		@SuppressWarnings("unused")
		MvcResult mvcResult = mvc.perform(request).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print())
				.andReturn();

	}

	@Test
	public void testcount() throws Exception {
		String uri = "/countMap";
		@SuppressWarnings("rawtypes")
		Map map = new HashMap<>();
		/*
		 * map.put("page_size", 10); map.put("page_num", 1);
		 * map.put("timeRange", "");
		 */

		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
				.content(map.toString());
		@SuppressWarnings("unused")
		MvcResult mvcResult = mvc.perform(request).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print())
				.andReturn();

	}
}
