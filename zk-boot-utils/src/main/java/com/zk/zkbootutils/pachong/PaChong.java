package com.zk.zkbootutils.pachong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaChong {
    public static String sendGet(String url){
        //定义一个字符串存储网页内容
        String result = "";
        //定义缓冲字符输入流
        BufferedReader in = null;
        try {
            //转成URL对象
            URL realUrl = new URL(url);
            //初始化链接
            URLConnection connection = realUrl.openConnection();
            //开始链接
            connection.connect();
            //初始化输入流，读取URL响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            //临时存储抓到的每一行数据
            String line;
            while (null != (line = in.readLine())) {
                result += line + "\n";
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    //正则模板
    public static String RegexString(String targerStr,String patternStr){
        //定义一个正则样式模板，括号中是要抓取的内容
        Pattern pattern = Pattern.compile(patternStr);
        //定义一个正则表达式来匹配
        Matcher matcher = pattern.matcher(targerStr);
        if (matcher.find()){
            return matcher.group(1);
        }else{
            return "";
        }
    }

    public static void main(String[] args) {
        // 定义即将访问的链接
        String url = "http://www.baidu.com/link?url=ohMRN0H4F23uEgcFgwflGSP7rEz1lSxGdiy8VmVDmOK";
        // 访问链接并获取页面内容
        String result = sendGet(url);
        //正则表达式匹配
        String imgSrc = RegexString(result,"src=//(.+?) ");
        System.out.println(result);
        System.out.println(imgSrc);
    }
}
