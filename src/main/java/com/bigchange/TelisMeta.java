package com.bigchange;/*
 * @Author: chaojiangyou
 * @CreatedDate: 2021/5/21
 * @Last Modified by: chaojiangyou
 * @Last Modified time: 2021/5/21
 */

import com.alibaba.fastjson.annotation.JSONField;

public class TelisMeta {
  @JSONField(name = "audio_format")
  private AudioFormat audioFormat;
  private String question;
  @JSONField(name = "type")
  private int type;
  public AudioFormat getAudioFormat() {
    return audioFormat;
  }

  public void setAudioFormat(AudioFormat audioFormat) {
    this.audioFormat = audioFormat;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }
}
