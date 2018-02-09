package com.zk.zkbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @RequestMapping("/home")
    public String home() {
        System.out.println("hello");
        return "upload";
    }

    @RequestMapping("/upload")
    public void upload(@RequestPart("photo") MultipartFile photo, Object object, HttpServletResponse response, HttpServletRequest request) throws IOException {
        // 判断文件是否为空
        if (!photo.isEmpty()) {
            try {
                // 取原始文件名
//				String oldName = photo.getOriginalFilename();
//				// 生成新文件名
//				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//				System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
//				long time = System.currentTimeMillis();
//				String newName = df.format(new Date()).toString() + oldName.substring(oldName.lastIndexOf("."));

                // 文件保存路径

                String filePath = "D:\\image\\"
                        + photo.getOriginalFilename();
                // 转存文件
                photo.transferTo(new File(filePath));

                System.out.println("存放图片文件的路径:"+filePath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("文件上传成功");
    }
}
