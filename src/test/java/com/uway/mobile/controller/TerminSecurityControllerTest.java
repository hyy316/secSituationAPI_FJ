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
public class TerminSecurityControllerTest extends BaseApplicationTest{

	@Autowired
	MockMvc mvc;
	
	@Test
	public void testgetTerminalSecurity() throws Exception{
		String url="/terminalSecurity/listTerminalSecurity";
		String requestJson="{\"page_size\":\"1\",\"page_num\":\"10\",\"timeRange\":\"\"}";
		RequestBuilder requestBuilder=null;
		requestBuilder=MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON)
				.content(requestJson);
		MvcResult mvcResult=mvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(jsonPath("$.data.total_num").value(122))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		int status=mvcResult.getResponse().getStatus();
		String content=mvcResult.getResponse().getContentAsString();
		System.out.println(status+","+content);
	}
	
	
	@Test
	public void testgroupByParm() throws Exception{
		String url="/terminalSecurity/groupByParm";
		String requestJson="{\"groupfields\":\"logcategory\"}";
		RequestBuilder requestBuilder=null;
		requestBuilder=MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON)
				.content(requestJson);
		MvcResult mvcResult=mvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(jsonPath("$.data.total_num").value(4))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		int status=mvcResult.getResponse().getStatus();
		String content=mvcResult.getResponse().getContentAsString();
		System.out.println(status+","+content);
	}
	
	//@Test
	public void testgroupByMulParm() throws Exception{
		String url="/terminalSecurity/groupByMulParm";
		String requestJson="{}";
		RequestBuilder requestBuilder=null;
		requestBuilder=MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON)
				.content(requestJson);
		MvcResult mvcResult=mvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(jsonPath("$.data.total_num").value(6))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		int status=mvcResult.getResponse().getStatus();
		String content=mvcResult.getResponse().getContentAsString();
		System.out.println(status+","+content);
	}
	
}
