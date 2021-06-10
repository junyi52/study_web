package com.stu.url;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlDown {
    public static void main(String[] args) throws Exception {
        //1.下载地址
        URL url = new URL("http://mp3.63007.com:82/00xx/%E9%A3%9E%E5%90%91%E5%88%AB%E4%BA%BA%E7%9A%84%E5%BA%8A.mp3");
        //2.连接到这个资源 HTTP
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        InputStream is = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream("8A.mp3");
        byte[] bytes = new byte[1024];
        int len;
        while ((len=is.read(bytes))!=-1){
            fos.write(bytes,0,len);//写出这个数据
        }
        fos.close();
        is.close();
        urlConnection.disconnect();//断开连接
    }
}
