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
        String token = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9" +
           ".eyJleHAiOjE2MjE1ODg3NTUsImlzcyI6ImJiay1qd3QifQ.LKnZerDFDHjI0D0LwrRqWKDxEzAffSD4-BDRB4LdE1CvRES10tExpzmRGh_9-Kpa_D6mAf0-ATJLAWCAsBCrW0PxDVrMxtpce193fPJlQvXbwza6g35PdIF3JThe7Nie9KoMcF5uIcRAUyvqxutu1U-VweUKZPfPz4wT5L6hN9QBgSBwN1G_sqAZDqqm--u7Pkum99GdEmVby_gKv8wIYkWMNJ_McglLzkj7TgtTesbqfCuia0g-cSp09c87Cxu6CUzlI3AwE3fmqX0eZOBgmQkUcW_xfcHVk0POkVtvEWCeKyfTWlWQNMlmP6E4bWg-OeQbk0Fec3a6pK4aFUQ6ZQ";

       JavaClient javaClient = new JavaClient("wss://algapi.llsapp.com/api/ielts_speaking/stream");
        WebSocketClient webSocketClient = javaClient.getClient(token);
        if (webSocketClient != null) {
            System.out.println("getWebSocketClient succeed");
            TelisMeta telisMeta = new TelisMeta ();
            AudioFormat audioFormat = new AudioFormat ();
            audioFormat.setType("WAV");
            audioFormat.setAudioChannel(1);
            audioFormat.setSampleRate(16000);
            telisMeta.setQuestion("question test");
            telisMeta.setAudioType(6);
            telisMeta.setAudioFormat(audioFormat);
            String jsonString = JSON.toJSONString(telisMeta);
            System.out.printf("send meta:%s\n", jsonString);
            // send meta
            webSocketClient.send(jsonString.getBytes());
            byte[] bytes = ReadFromFile.readFileByBytes("/Users/chaojiangyou/Desktop/question2.wav");
            // send audio
            webSocketClient.send(bytes);
            // send EOS flag
            webSocketClient.send(EOS);
        }
    }
}
