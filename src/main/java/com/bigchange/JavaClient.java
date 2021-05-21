package com.bigchange;/*
 * @Author: chaojiangyou
 * @CreatedDate: 2021/5/21
 * @Last Modified by: chaojiangyou
 * @Last Modified time: 2021/5/21
 */
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class JavaClient {


  private String url;

  public JavaClient(String url) {
    this.url = url;
  }

  /**
   * 获取客户端连接实例
   * @return
   */
  public WebSocketClient getClient(String token){

    try {

      Map httpHeaders = new HashMap<String, String>();

      httpHeaders.put("Authorization",  token);

      //创建客户端连接对象
      WebSocketClient client = new WebSocketClient(new URI(this.url), httpHeaders) {

        /**
         * 建立连接调用
         * @param serverHandshake
         */
        @Override
        public void onOpen(ServerHandshake serverHandshake) {
          System.out.println("建立连接");
        }

        /**
         * 收到服务端消息调用
         * @param s
         */
        @Override
        public void onMessage(String s) {

          System.out.println("收到来自服务端的消息:::" + s);
        }

        /**
         * 断开连接调用
         * @param i
         * @param s
         * @param b
         */
        @Override
        public void onClose(int i, String s, boolean b) {
          System.out.println("关闭连接:::" + "i = " + i + ":::s = " + s +":::b = " + b);
        }

        /**
         * 连接报错调用
         * @param e
         */
        @Override
        public void onError(Exception e) {
          System.out.println("报错了:::" + e.getMessage());
        }

      };

      //请求与服务端建立连接
      client.connect();

      //判断连接状态，0为请求中  1为已建立  其它值都是建立失败
      while(client.getReadyState().ordinal() == 0){

        try {

          Thread.sleep(200);

        }catch (Exception e){

          System.out.println("延迟操作出现问题，但并不影响功能");

        }

        System.out.println("连接中。。。");

      }

      //连接状态不再是0请求中，判断建立结果是不是1已建立
      if (client.getReadyState().ordinal() == 1){

        return client;

      }

    }catch (URISyntaxException e){

      System.out.println(e.getMessage());
    }

    return null;
  }
}