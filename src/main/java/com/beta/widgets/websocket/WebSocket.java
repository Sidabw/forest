/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: WebSocket
 * Author:   feiyi
 * Date:     2019/1/16 下午3:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.widgets.websocket;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/1/16
 * @since 1.0.0
 */
/*@ServerEndpoint(value = "/websocket")
@Component
public class WebSocket {

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    //用户管理所有的websocket 对象。remove、群发
    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<WebSocket>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    private int i = 1000;

    *//**
     * 连接建立成功调用的方法*//*
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("in on open");
        this.session = session;
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
        try {
            while (i-- > 0) {
                sendMessage(String.valueOf(new Random().nextInt(10)));
                Thread.sleep(500);
            }
            System.out.println("没了...");
        } catch (IOException e) {
            System.out.println("IO异常");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    *//**
     * 连接关闭调用的方法
     *//*
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    *//**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*//*
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的消息:" + message);

        //群发消息
        for (WebSocket item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    *//**
     * 发生错误时调用*//*
     @OnError
     public void onError(Session session, Throwable error) {
     System.out.println("发生错误");
     error.printStackTrace();
     }


     public void sendMessage(String message) throws IOException {
     this.session.getBasicRemote().sendText(message);
     //this.session.getAsyncRemote().sendText(message);
     }


     *//**
      * 群发自定义消息
      * *//*
    public static void sendInfo(String message) throws IOException {
        for (WebSocket item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                continue;
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocket.onlineCount--;
    }
}*/
