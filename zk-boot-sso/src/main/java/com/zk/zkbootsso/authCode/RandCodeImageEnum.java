package com.zk.zkbootsso.authCode;

import java.util.Random;

/**
 * 验证码辅助类
 */
public enum RandCodeImageEnum {

    /**
     * 混合字符串
     */
    ALL_CHAR("0123456789abcdefghijkmnpqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"), // 去除小写的l和o这个两个不容易区分的字符；
    /**
     * 字符
     */
    LETTER_CHAR("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"),
    /**
     * 小写字母
     */
    LOWER_CHAR("abcdefghijklmnopqrstuvwxyz"),
    /**
     * 数字
     */
    NUMBER_CHAR("0123456789"),
    /**
     * 大写字符
     */
    UPPER_CHAR("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
    /**
     * 待生成的字符串
     */
    private String charStr;

    private RandCodeImageEnum(final String charStr) {
        this.charStr = charStr;
    }

    /**
     * 生产随机验证码
     */
    public String generateStr(final int codeLength) {
        final StringBuffer sb = new StringBuffer();
        final Random random = new Random();
        final String sourseStr = getCharStr();

        for (int i = 0; i < codeLength; i++) {
            sb.append(sourseStr.charAt(random.nextInt(sourseStr.length())));
        }

        return sb.toString();
    }

    public String getCharStr() {
        return charStr;
    }

}
