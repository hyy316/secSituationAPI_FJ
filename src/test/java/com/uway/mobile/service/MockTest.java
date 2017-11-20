package com.uway.mobile.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.uway.mobile.Application;
import com.uway.mobile.mapper.IndecencyScanResultMapper;
import com.uway.mobile.service.impl.IndecencyScanResultServiceImp;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class) // 指定SpringBoot-Application启动类
public class MockTest {

	//标注测试类中@Autowired的对象
	@Mock
	private IndecencyScanResultMapper indecencyScanResultMapper;
	
	//测试类中需要使用mock对象
	@InjectMocks
	private IndecencyScanResultServiceImp service;
	
	@Test
	  public void testCheckLineItem() throws Exception {
		  Map<String, Object> paraMap1= new HashMap<String, Object>();
		  paraMap1.put("xxx", "ccc");
		  Map<String, Object> paraMap2= new HashMap<String, Object>();
		  paraMap2.put("xxx", "cccdd");
		  //对mock类进行模拟方法,第一次返回100，第二次返回222，第三次返回333
	        when(indecencyScanResultMapper.countindecencyScanResults(paraMap1)).thenReturn(100L,222L,333L);
	        when(indecencyScanResultMapper.countindecencyScanResults(paraMap2)).thenReturn(999L);
	        //断言
	        assertNotNull(service.countScanResult(paraMap2));
	        assertTrue(service.countScanResult(paraMap2) ==999L);
	        
//	        verify(indecencyScanResultMapper).countindecencyScanResults(paraMap2);
	        //验证方法执行了2次  
	        //且执行时间小于10毫秒
	        verify(indecencyScanResultMapper, timeout(10).times(2)).countindecencyScanResults(paraMap2);
	        verify(indecencyScanResultMapper, timeout(10).atLeastOnce()).countindecencyScanResults(paraMap2);
//	        verify(indecencyScanResultMapper, atLeast(2)).countindecencyScanResults(paraMap2);
//	        verify(indecencyScanResultMapper, atMost(5)).countindecencyScanResults(paraMap2);
//	        verify(indecencyScanResultMapper, never()).countindecencyScanResults(paraMap2);
	    }
}
