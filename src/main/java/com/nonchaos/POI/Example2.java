package com.nonchaos.POI;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Example2 {
  public static void main(String[] args) {
    String date = new Date().toString();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    System.out.println(dateFormat.format(new Date()));
  }
}
