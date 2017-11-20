package com.uway.mobile.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
@AutoConfigureMockMvc
public class SafeReportControllerTest extends BaseApplicationTest{
	
	@Autowired
	MockMvc mvc;
	
	@Test
	public void testsummaryCount() throws Exception{
		String url="/safeReport/summary";
		String request="";
		RequestBuilder requestBuilder=null;
		requestBuilder=MockMvcRequestBuilders.get(url).content(request);
		MvcResult mvcResult=mvc.perform(requestBuilder).andExpect(status().isOk())
				.andExpect(jsonPath("$.code").value(200))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		int status=mvcResult.getResponse().getStatus();
		String content=mvcResult.getResponse().getContentAsString();
		System.out.println(status+","+content);
		
	}
	
}
