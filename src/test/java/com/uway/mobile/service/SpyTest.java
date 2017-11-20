package com.uway.mobile.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.uway.mobile.Application;
import com.uway.mobile.service.impl.IndecencyScanResultServiceImp;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class) // 指定SpringBoot-Application启动类
public class SpyTest {

	//spy标注的，可以是抽象类，具体方法可以并未实现，在测试中模拟执行结果
	@Spy
	private IndecencyScanResultServiceImp service;
	
	@Test
	  public void testCheckLineItem() throws Exception {
		
		Map<String, Object> paraMap2= new HashMap<String, Object>();
		  paraMap2.put("xxx", "cccdd");
		doReturn(100L).when(service).countScanResult(paraMap2);
		
		
		assertTrue(service.countScanResult(paraMap2) ==100L);
		//使用spy区别于mock，类方法并未实际执行，可以未实现。
        verify(service, times(1)).countScanResult(paraMap2);

	}
}
