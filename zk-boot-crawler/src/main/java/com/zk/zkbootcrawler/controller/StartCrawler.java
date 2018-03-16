package com.zk.zkbootcrawler.controller;

import com.zk.zkbootcrawler.config.MyCrawler;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import io.micrometer.core.instrument.Statistic;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;

//import javax.inject.Singleton;

/**
 * 启动器
 */
@Component
public class StartCrawler {

    @Autowired
    private MyCrawler myCrawler;

//    @Bean
    public void startCrawler(){
        // 定义爬虫数据存储位置
        // 得到工程的路径 System.getProperty("user.dir")
        String crawlStorageFolder = System.getProperty("user.dir")+"/crawler";
        //定义爬虫线程7个
        int numberOfCrawlers=1;
        //定义爬虫配置
        CrawlConfig config=new CrawlConfig();
        //设置爬虫文件存储位置
        config.setCrawlStorageFolder(crawlStorageFolder);
        //实例化页面获取器
        PageFetcher pageFetcher=new PageFetcher(config);
        //实例化爬虫机器人配置,比如可以设置user-agent
        RobotstxtConfig robotstxtconfig=new RobotstxtConfig();
        //实例化爬虫机器人对目标服务器的配置，每个网站都有一个robots.txt文件
        //规定了该网站哪些页面可以爬，哪些页面禁止爬，该类是对robots.txt规范的实现
        RobotstxtServer robotstxtServer=new RobotstxtServer(robotstxtconfig,pageFetcher);
        //实例化爬虫控制器
        CrawlController controller= null;
        try {
            controller = new CrawlController(config,pageFetcher,robotstxtServer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //配置爬取种子页面，就是规定从哪里开始爬，可以配置多个种子页面
        controller.addSeed("https://www.zhihu.com/explore#daily-hot");  //日最热
        controller.addSeed("https://www.zhihu.com/explore#monthly-hot");    //月最热

        /**
         * 启动爬虫，爬虫从此刻开始执行爬虫任务，根据以上配置
         */
        controller.start(myCrawler.getClass(),numberOfCrawlers);
    }

//    public static void main(String[] args) {
//        StartCrawler c = new StartCrawler();
//        c.startCrawler();
//    }
}
