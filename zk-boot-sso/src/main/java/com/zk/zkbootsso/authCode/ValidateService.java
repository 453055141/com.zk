package com.zk.zkbootsso.authCode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ValidateService {

    /**
     * 是否开启验证码
     * @param username
     * @return
     */
    Boolean isRandCodeImage(String username);

    /**
     * 生成验证码图片
     * @param request
     * @param response
     */
    void generateRandCodeImage(HttpServletRequest request, HttpServletResponse response);

    /**
     * 验证验证码图片
     * @param randcode
     * @param r
     * @return
     */
    boolean isVerifyRandCode(String randcode, String r);
}
