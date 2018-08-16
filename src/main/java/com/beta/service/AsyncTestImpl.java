
package com.beta.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTestImpl implements AsyncTest{

	@Async
	@Override
	public void testt() throws Exception {
		int i = 100;
		while(i>0){
			System.out.println("--------------------------------------"+i);
			//毫秒
			Thread.sleep(1000);
		}
	}

}
