package com.zk.zkbootsso.authCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("validate")
public class ValidateController {
    @Autowired
    private ValidateService validateService;

    @RequestMapping("reg")
    public String regView() {
        int a = 9;
        return "reg";
    }

    /**
     * 是否开启验证码 登录是否异常
     */
    @RequestMapping(value = "/randcode/visible")
    @ResponseBody
    public boolean isImageRandCode(String userName,HttpServletRequest request, HttpServletResponse response) {
        boolean result = validateService.isRandCodeImage(userName);
        return result;
    }

    /**
     * 获取验证码图片
     * <p>
     * Description:
     * </p>
     *
     * @author 王子维
     * @data 2017年1月5日下午7:01:04
     * @param request
     * @param response
     */
    @RequestMapping(value = "/randcodeimg")
    public void getImageRandCode(HttpServletRequest request, HttpServletResponse response) {
        validateService.generateRandCodeImage(request, response);
    }

    /**
     * 验证图片验证码
     * <p>Description: </p>
     * @author 王子维
     * @data 2017年11月22日下午3:21:29
     * @param randcode
     * @param rf
     * @return
     */
    @RequestMapping(value = "/randcodeimg/verify", method = RequestMethod.POST)
    @ResponseBody
    public boolean verifyImageRandCode(String randcode, String rf) {
        validateService.isVerifyRandCode(randcode, rf);
        return true;
    }
}
