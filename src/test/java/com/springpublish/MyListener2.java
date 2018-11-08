package com.springpublish;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class MyListener2 implements ApplicationListener<ApplicationEvent>{

	public void onApplicationEvent(ApplicationEvent event) {
		if(event instanceof MyEvent){
	            System.out.println("into My Listener2");
	            MyEvent myEvent=(MyEvent)event;
	            myEvent.print();
	     }
	}

}
