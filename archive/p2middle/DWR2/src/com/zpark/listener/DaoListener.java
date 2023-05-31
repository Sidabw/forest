package com.Java.bak.middle.DWR2.src.com.zpark.listener;

import java.util.List;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.dwr.service.SendMsg;
import com.zpark.service.IUserService;
import com.zpark.service.UserServiceImpl;

public class DaoListener implements HttpSessionListener{
	private IUserService us=new UserServiceImpl();
	List<String> telFirst=null;
	List<String> telCurrent=null;
	@Override
	public void sessionCreated( HttpSessionEvent httpsessionevent) {
		//对数据库数据进行监视
		new Thread(new Runnable(){
			@Override
			public void run() {
				//第一次查询数据库，记录原始信息（模拟，实际情况可以使用Date类，只显示3天内数据库的变动）
				telFirst= us.findTel();
				//定义遍历两个数据的变量
				int i=0;
				int j=0;
				System.out.println("telFirst：。。。。。。。。。。。。。。。。。。。。。。。。"+telFirst);
				while(true){
					try {
						//查询当前数据库信息
						telCurrent=us.findTel();
						System.out.println("telCurrent:................................"+telCurrent);
						for(String strTC:telCurrent){
							if(strTC.equals(telFirst.get(i))){
								i++;
							}else{
								//找到了不相符字段
								System.out.println("找到了。、。。。。。。。。。。。。。。。。。。。。。。。");
								//进行反向ajax弹窗
								new SendMsg().sendMsg(strTC);
								telFirst=telCurrent;
								break;
							}
						}
						i=0;
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}).start();
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpsessionevent) {
		// TODO Auto-generated method stub
		
	}

}
