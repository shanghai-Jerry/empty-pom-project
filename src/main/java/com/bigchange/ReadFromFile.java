package com.bigchange;
/*
 * @Author: chaojiangyou
 * @CreatedDate: 2021/5/21
 * @Last Modified by: chaojiangyou
 * @Last Modified time: 2021/5/21
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFromFile {
  /**
   * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
   */
  public static byte[] readFileByBytes(String fileName) {
    InputStream in = null;
    try {
      in = new FileInputStream(fileName);
      byte[] buffer=new byte[in.available()];
      ReadFromFile.showAvailableBytes(in);
      // 读入多个字节到字节数组中，byteread为一次读入的字节数
      while (in.read(buffer) != -1) {
      }
      return buffer;
    } catch (Exception e1) {
      e1.printStackTrace();
    } finally {
      if (in != null) {
        try {
          in.close();
        } catch (IOException e1) {
        }
      }
    }
    return null;
  }

  /**
   * 显示输入流中还剩的字节数
   */
  private static void showAvailableBytes(InputStream in) {
    try {
      System.out.println("当前字节输入流中的字节数为:" + in.available());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}