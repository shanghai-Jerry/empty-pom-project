package com.bigchange;

import com.alibaba.fastjson.JSON;

import org.java_websocket.client.WebSocketClient;

/**
 * Hello world!
 *
 */
public class App {
   public static void main(String[] args ) {

        byte[] EOS = new byte[] {0x45, 0x4f, 0x53};
        String token = "Bearer xxx";

       JavaClient javaClient = new JavaClient("wss://xx_speaking/stream");
        WebSocketClient webSocketClient = javaClient.getClient(token);
        if (webSocketClient != null) {
            System.out.println("getWebSocketClient succeed");
            TelisMeta telisMeta = new TelisMeta();
            AudioFormat audioFormat = new AudioFormat ();
            audioFormat.setType("WAV");
            audioFormat.setAudioChannel(1);
            audioFormat.setSampleRate(16000);
            telisMeta.setQuestion("question test");
            telisMeta.setType(6);
            telisMeta.setAudioFormat(audioFormat);
            String jsonString = JSON.toJSONString(telisMeta);
            System.out.printf("send meta:%s\n", jsonString);
            // send meta
            webSocketClient.send(jsonString.getBytes());
            byte[] bytes = ReadFromFile.readFileByBytes("question2.wav");
            System.out.printf("send audio bytes:%d", bytes.length);
            // send audio
            webSocketClient.send(bytes);
            // send EOS flag
            webSocketClient.send(EOS);
        }
    }
}
