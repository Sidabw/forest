package com.Java.bak.middle.DWR2.src.com.dwr.service;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.directwebremoting.proxy.dwr.Util;

@SuppressWarnings("deprecation")

public class SendMsg {

/**
 * 消息发送方法
 * @param msg //要发送的消息
 */
	//将WebContext定义为静态的，只有1份。
static WebContext contex = null;
public void sendMsg(String msg){

	if(contex==null){
		contex=WebContextFactory.get();
	}
	
	//获取client.jsp页面的ScriptSession集合，注意："/dwrpush/client.jsp"
	//("/项目名/要访问的jsp")
	Collection<ScriptSession> sessions=contex.getScriptSessionsByPage("/DWR/Client.jsp");

	Util util=new Util(sessions);

	ScriptBuffer sb=new ScriptBuffer();

	sb.appendScript("show(");

	sb.appendData(msg); 

	sb.appendScript(")");

	util.addScript(sb);

}
public void initContext(){
	if(contex==null){
		contex=WebContextFactory.get();
	}
}
}
