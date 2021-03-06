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
public class SrvResourceControllerTest extends BaseApplicationTest{

	@Autowired
	MockMvc mvc;
	
	@Test
	public void testgroupByTime() throws Exception{
		String url="/srvResource/groupByTime";
		String requestJson="{\"timeRange\":\"1 DAY\"}";
		RequestBuilder requestBuilder=null;
		requestBuilder=MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON)
				.content(requestJson);
		MvcResult mvcResult=mvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(jsonPath("$.data.total_num").value(6))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		int status=mvcResult.getResponse().getStatus();
		String content=mvcResult.getResponse().getContentAsString();
		System.out.println(status+","+content);
	}
	
	@Test
	public void testgroupByParm() throws Exception{
		String url="/srvResource/groupByParm";
		String requestJson="{\"groupfields\":\"service\"}";
		RequestBuilder requestBuilder=null;
		requestBuilder=MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON)
				.content(requestJson);
		MvcResult mvcResult=mvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(jsonPath("$.data.total_num").value(5))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		int status=mvcResult.getResponse().getStatus();
		String content=mvcResult.getResponse().getContentAsString();
		System.out.println(status+","+content);
	}
	
	@Test
	public void testcountSrvResources() throws Exception{
		String url="/srvResource/countSrvResources";
		String requestJson="{\"port\":\"80\"}";
		RequestBuilder requestBuilder=null;
		requestBuilder=MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON)
				.content(requestJson);
		
		MvcResult mvcResult=mvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(jsonPath("$.msg").value("查询成功！"))
				.andDo(MockMvcResultHandlers.print()).andReturn();
		int status=mvcResult.getResponse().getStatus();
		String content=mvcResult.getResponse().getContentAsString();
		System.out.println(status+","+content);
	}
	
}
