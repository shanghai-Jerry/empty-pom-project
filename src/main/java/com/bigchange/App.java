package com.bigchange;

import org.java_websocket.client.WebSocketClient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        JavaClient javaClient = new JavaClient();
        WebSocketClient webSocketClient = javaClient.getClient("wss://xxx/ielts_speaking/stream");
        if (webSocketClient != null) {
            System.out.println("getWebSocketClient succeed");
        }
    }
}
