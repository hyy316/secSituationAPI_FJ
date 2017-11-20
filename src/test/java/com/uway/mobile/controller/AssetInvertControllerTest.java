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
public class AssetInvertControllerTest extends BaseApplicationTest {

	@Autowired
	MockMvc mvc;

	/**
	 * 铁通资产信息
	 * 
	 * @throws Exception
	 */
	@Test
	public void testlistCRCAsset() throws Exception {
		String uri = "/CRCassetInventory/listCRCAsset";
		String requestJson = "{\"page_size\":\"10\",\"page_num\":\"10\",\"timeRange\":\"\"}";
		RequestBuilder request = null;
		request = MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(requestJson);
		MvcResult mvcResult = mvc.perform(request).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print())
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println(status + "," + content);
	}

	/**
	 * 统计铁通资产量
	 * 
	 * @throws Exception
	 */
	@Test
	public void testgetCountAssert() throws Exception {
		String uri = "/CRCassetInventory/getCountAssert";
		String requestJson = "{\"topn\":\"10\",\"page_num\":\"10\",\"timeRange\":\"\",\"size\":\"6\"}";
		RequestBuilder request = null;
		request = MockMvcRequestBuilders.post(uri).header("sid", "xxxx").contentType(MediaType.APPLICATION_JSON)
				.content(requestJson);
		@SuppressWarnings("unused")
		MvcResult mvcResult = mvc.perform(request).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print())
				.andReturn();

	}

	/**
	 * 铁通资产： 按字段分组统计数据量
	 * 
	 * @throws Exception
	 */
	@Test
	public void testgroupByParm() throws Exception {
		String uri = "/CRCassetInventory/groupByParm";
		String requestJson = "{\"topn\":\"10\",\"timeRange\":\"6 MONTH\",\"groupfields\":\"port\"}";
		RequestBuilder request = null;
		request = MockMvcRequestBuilders.post(uri).header("sid", "xxxx").contentType(MediaType.APPLICATION_JSON);
		request = MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(requestJson);
		MvcResult mvcResult = mvc.perform(request).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print())
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println(status + "," + content);
	}

}
