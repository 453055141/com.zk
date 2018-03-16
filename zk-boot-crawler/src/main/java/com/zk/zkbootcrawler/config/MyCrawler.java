package com.zk.zkbootcrawler.config;

import com.sun.tools.corba.se.idl.StringGen;
import com.zk.zkbootcache.config.RedisClusterConfig;
import com.zk.zkbootcrawler.controller.UrlAndRedis;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Pattern;

/**
 * 自定义爬虫类需要继承WebCrawler类，决定哪些url可以被爬以及处理爬取的页面信息
 */
@Component
public class MyCrawler extends WebCrawler {

    //队列大小
    private final int QUEUE_LENGTH = 10000*10;

    public LinkedBlockingQueue<String> concurrentLinkedQueue = new LinkedBlockingQueue<String>(QUEUE_LENGTH);

//    @Autowired
//    private JedisCluster jedisCluster;



    /**
     * 正则匹配指定的后缀文件
     */
    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg"
            + "|png|mp3|mp3|zip|gz))$");


    /**
     * 这个方法主要是决定哪些url我们需要抓取，返回true表示是我们需要的，返回false表示不是我们需要的Url
     * 第一个参数referringPage封装了当前爬取的页面信息
     * 第二个参数url封装了当前爬取的页面url信息
     */
    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();  // 得到小写的url
        return !FILTERS.matcher(href).matches()   // 正则匹配，过滤掉我们不需要的后缀文件
                && href.startsWith("https://www.zhihu.com/question");  // url必须是http://www.java1234.com/开头，规定站点
    }

    /**
     * 当我们爬到我们需要的页面，这个方法会被调用，我们可以尽情的处理这个页面
     * page参数封装了所有页面信息
     */
    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();  // 获取url
        System.out.println("页面信息获取："+Thread.currentThread().getName());
        System.out.println("URL: " + url);


        JedisCluster jedisCluster = (JedisCluster) SpringApplicationContextHolder.getContext().getBean("jedisCluster");

        if(StringUtils.isNotBlank(url)){
            if(-1==("https://www.zhihu.com/question/".indexOf(url))){

                //存入队列
                try {
                    if(StringUtils.isNotBlank(url)){
                        //存入redis
                        jedisCluster.sadd("urlgather",url);
                    }
                    System.out.println("URL存入队列："+Thread.currentThread().getName());
                    concurrentLinkedQueue.put(url);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }



//        if (page.getParseData() instanceof HtmlParseData) {  // 判断是否是html数据
//            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData(); // 强制类型转换，获取html数据对象
//            String text = htmlParseData.getText();  // 获取页面纯文本（无html标签）
//            String html = htmlParseData.getHtml();  // 获取页面Html
//            Set<WebURL> links = htmlParseData.getOutgoingUrls();  // 获取页面输出链接
//
//            System.out.println("纯文本长度: " + text.length());
//            System.out.println("html长度: " + html.length());
//            System.out.println("输出链接个数: " + links.size());
//        }
    }

}
