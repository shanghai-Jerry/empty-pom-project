package com.bigchange;
/*
 * @Author: chaojiangyou
 * @CreatedDate: 2021/5/21
 * @Last Modified by: chaojiangyou
 * @Last Modified time: 2021/5/21
 */

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;

public class ReadFromFile {
  /**
   * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
   */
  public static byte[] readFileByBytes(String fileName) {
    InputStream in = null;
    ByteArrayOutputStream bos=new ByteArrayOutputStream();
    try {
      System.out.println("以字节为单位读取文件内容，一次读多个字节：");
      // 一次读多个字节
      byte[] tempbytes = new byte[100];
      int byteread = 0;
      in = new FileInputStream(fileName);
      byte[] buffer=new byte[in.available()];
      ReadFromFile.showAvailableBytes(in);
      // 读入多个字节到字节数组中，byteread为一次读入的字节数
      while ((byteread = in.read(tempbytes)) != -1) {
        bos.write(buffer, 0, byteread);
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