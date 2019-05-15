package com.Java.bak.middle.DWR.src.com.dwr.service;

import java.util.Collection;

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

public void sendMsg(String msg){

	WebContext contex=WebContextFactory.get();

	//获取client.jsp页面的ScriptSession集合，注意："/dwrpush/client.jsp"

	Collection<ScriptSession> sessions=contex.getScriptSessionsByPage("/DWR/Client.jsp");

	Util util=new Util(sessions);

	ScriptBuffer sb=new ScriptBuffer();

	sb.appendScript("show(");

	sb.appendData(msg); 

	sb.appendScript(")");

	util.addScript(sb);

}

}
