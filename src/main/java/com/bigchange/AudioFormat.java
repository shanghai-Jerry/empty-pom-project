package com.bigchange;/*
 * @Author: chaojiangyou
 * @CreatedDate: 2021/5/21
 * @Last Modified by: chaojiangyou
 * @Last Modified time: 2021/5/21
 */

import com.alibaba.fastjson.annotation.JSONField;

public class AudioFormat {
  private String type;

  @JSONField(name = "audio_channel")
  private int AudioChannel;
  @JSONField(name = "sample_rate")
  private int SampleRate;
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getAudioChannel() {
    return AudioChannel;
  }

  public void setAudioChannel(int audioChannel) {
    AudioChannel = audioChannel;
  }

  public int getSampleRate() {
    return SampleRate;
  }

  public void setSampleRate(int sampleRate) {
    SampleRate = sampleRate;
  }


}
