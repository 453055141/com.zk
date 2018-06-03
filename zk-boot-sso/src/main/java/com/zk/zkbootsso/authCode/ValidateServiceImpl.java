package com.zk.zkbootsso.authCode;

import com.zk.zkbootexception.config.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@Service
@PropertySource("classpath:resource.properties")
public class ValidateServiceImpl implements ValidateService {

    Logger logger = LoggerFactory.getLogger(ValidateServiceImpl.class);

    @Autowired
    private JedisCluster jedisCluster;

    /**
     * 干扰线数量
     */
    private static final int count = 200;
    /**
     * 定义图形大小
     */
    private static final int width = 105;
    /**
     * 定义图形大小
     */
    private static final int height = 35;
    /**
     * 干扰线的长度=1.414*lineWidth
     */
    private static final int lineWidth = 2;

    /**
     * 图片验证码在redis中保存的key
     */
    @Value("${REDIS_USER_RANDCODE_KEY}")
    private String REDIS_USER_RANDCODE_KEY;

    /**
     * 验证码长度
     */
    @Value("${RANDCODE_LENGTH}")
    private Integer RANDCODE_LENGTH;

    /**
     * 验证码类型 1数字 2小写字母 3大写字符 4字符 5混合字符串
     */
    @Value("${RANDCODE_TYPE}")
    private Integer RANDCODE_TYPE;

    /**
     * 用户输错密码的次数在redis中保存的key
     */
    @Value("${REDIS_USER_PASSWORD_WRONG_NUM_KEY}")
    private String REDIS_USER_PASSWORD_WRONG_NUM_KEY;

    /**
     * 验证码过期时间
     */
    @Value("${RANDCODE_EXPIRE}")
    private Integer RANDCODE_EXPIRE;

    /**
     * 用户输错密码多少次开始弹验证码
     */
    @Value("${REDIS_USER_PASSWORD_MAX_WRONG_NUM}")
    private Integer REDIS_USER_PASSWORD_MAX_WRONG_NUM;

    @Override
    public Boolean isRandCodeImage(String username) {
        return null;
    }

    @Override
    public void generateRandCodeImage(HttpServletRequest request, HttpServletResponse response) {
        // 设置页面不缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        // response.setContentType("image/png");

        // 在内存中创建图象
        final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 获取图形上下文
        final Graphics2D graphics = (Graphics2D) image.getGraphics();

        // 设定背景颜色
        graphics.setColor(Color.WHITE); // ---1
        graphics.fillRect(0, 0, width, height);
        // 设定边框颜色
        // graphics.setColor(getRandColor(100, 200)); // ---2
        graphics.drawRect(0, 0, width - 1, height - 1);

        final Random random = new Random();
        // 随机产生干扰线，使图象中的认证码不易被其它程序探测到
        for (int i = 0; i < count; i++) {
            graphics.setColor(getRandColor(150, 200)); // ---3

            final int x = random.nextInt(width - lineWidth - 1) + 1; // 保证画在边框之内
            final int y = random.nextInt(height - lineWidth - 1) + 1;
            final int xl = random.nextInt(lineWidth);
            final int yl = random.nextInt(lineWidth);
            graphics.drawLine(x, y, x + xl, y + yl);
        }

        // 取随机产生的认证码(4位数字)
        final String resultCode = createRandCode();
        for (int i = 0; i < resultCode.length(); i++) {
            // 将认证码显示到图象中,调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
            // graphics.setColor(new Color(20 + random.nextInt(130), 20 + random
            // .nextInt(130), 20 + random.nextInt(130)));

            // 设置字体颜色
            graphics.setColor(Color.BLACK);
            // 设置字体样式
            // graphics.setFont(new Font("Arial Black", Font.ITALIC, 18));
            graphics.setFont(new Font("Times New Roman", Font.BOLD, 24));
            // 设置字符，字符间距，上边距
            graphics.drawString(String.valueOf(resultCode.charAt(i)), (23 * i) + 8, 26);
        }

        // 将认证码存入SESSION
        // request.getSession().setAttribute(SESSION_USER_RANDCODE_KEY,
        // resultCode);
        String r = request.getParameter("r");
        // 如果r不为空 则保存到redis中.
        if (!StringUtils.isBlank(r) && r.length() == 32) {
            // 将认证码存入Redis中
            jedisCluster.set(REDIS_USER_RANDCODE_KEY + ":" + r, resultCode);
            // 设置图片验证码过期时间
            jedisCluster.expire(REDIS_USER_RANDCODE_KEY + ":" + r, RANDCODE_EXPIRE);
        }
        // 图象生效
        graphics.dispose();

        // 输出图象到页面
        try {
            ImageIO.write(image, "JPEG", response.getOutputStream());
        } catch (IOException e) {
            throw new BusinessException("failure.randcode");
        }
    }

    /**
     * 创建验证码
     * @return
     */
    private String createRandCode() {
        switch (RANDCODE_TYPE) {
            case 1:// 数字
                return RandCodeImageEnum.NUMBER_CHAR.generateStr(RANDCODE_LENGTH);
            case 2:// 小写字母
                return RandCodeImageEnum.LOWER_CHAR.generateStr(RANDCODE_LENGTH);
            case 3:// 大写字符
                return RandCodeImageEnum.UPPER_CHAR.generateStr(RANDCODE_LENGTH);
            case 4:// 字符
                return RandCodeImageEnum.LETTER_CHAR.generateStr(RANDCODE_LENGTH);
            case 5:// 混合字符串
                return RandCodeImageEnum.ALL_CHAR.generateStr(RANDCODE_LENGTH);
            default:
                return RandCodeImageEnum.NUMBER_CHAR.generateStr(RANDCODE_LENGTH);
        }
    }

    /**
     * 取得给定范围随机颜色
     * @param fc
     * @param bc
     * @return
     */
    private Color getRandColor(int fc, int bc) {
        final Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }

        final int r = fc + random.nextInt(bc - fc);
        final int g = fc + random.nextInt(bc - fc);
        final int b = fc + random.nextInt(bc - fc);

        return new Color(r, g, b);
    }

    @Override
    public boolean isVerifyRandCode(String randcode, String r) {
        return false;
    }
}
