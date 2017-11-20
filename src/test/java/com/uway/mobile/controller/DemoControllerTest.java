package com.uway.mobile.controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@WebMvcTest(controllers = AssetInfoController.class)
@AutoConfigureMockMvc
public class DemoControllerTest extends BaseApplicationTest {

	@Autowired
	MockMvc mvc;

	String expectedJson;

	// @Autowired
	// WebApplicationContext webApplicationConnect;
	//
	// @Before
	// public void setUp() throws JsonProcessingException {
	// mvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();
	//
	//// mvc =MockMvcBuilders.standaloneSetup(new UserController()).build();
	//
	// }

	/**
	 * 安全总结报告
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	@Test
	public void testShow() throws Exception {
		String expectedResult = "hello world!";
		String uri = "/safeReport/summary";
		RequestBuilder request = null;
		Map map = new HashMap<String, String>();
		map.put("page_size", "10");
		map.put("page_num", "1");

		// SoftInfo softInfo = new SoftInfo();
		// //设置值
		// ObjectMapper mapper = new ObjectMapper();
		// ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		// java.lang.String requestJson = ow.writeValueAsString(softInfo);

		request = MockMvcRequestBuilders.get(uri).param("city", "");// .params((MultiValueMap<String,
																	// String>)
																	// map);

		// request =
		// MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content("");
		MvcResult mvcResult = mvc.perform(request).andExpect(status().isOk())
				.andExpect(jsonPath("$.data.vulnerability").value(0))
				// .andDo(print())
				// andExpect(content().string("[{\"id\":1,\"name\":\"林峰\",\"age\":20}]"));
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println(status + "," + content);

		Assert.assertTrue("正确，正确的返回值为200", status == 200);
		Assert.assertFalse("错误，正确的返回值为200", status != 200);
		// Assert.assertTrue("数据一致", expectedResult.equals(content));
		// Assert.assertFalse("数据不一致", !expectedResult.equals(content));
	}

	protected String Obj2Json(Object obj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}

}
