/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: GraduationProjectController
 * Author:   feiyi
 * Date:     2019/5/9 4:55 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.widgets.gp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/5/9
 * @since 1.0.0
 */

@Controller
@RequestMapping(value = "/gp")
public class GraduationProjectController {
    private static final Logger logger = LoggerFactory.getLogger(GraduationProjectController.class);
    /**
     * 生成图片验证码
     */
    @RequestMapping(value = "/getImgVerifyCode")
    public void getImgVerify(String clientId, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            BufferedImage image = randomValidateCode.getRandcode(clientId);//输出验证码图片方法
            try {
                // 将内存中的图片通过流动形式输出到客户端
                ImageIO.write(image, "JPEG", response.getOutputStream());
            } catch (Exception e) {
                logger.error("将内存中的图片通过流动形式输出到客户端失败>>>>   ", e);
            }
        } catch (Exception e) {
            logger.error("获取验证码失败>>>>   ", e);
        }
    }

    /**
     * 校验图片验证码
     */
    @RequestMapping(value = "/checkImgVerify", method = RequestMethod.POST, headers = "Accept=application/json")
    public boolean checkImgVerify(@RequestParam String verifyInput, String clientId) {
        try{
            String inputStr = verifyInput;
            String code = RandomValidateCodeUtil.allCode.get(clientId);
            if (code == null || !code.equals(inputStr)) return false;
            return true;
        }catch (Exception e){
            logger.error("验证码校验失败", e);
            return false;
        }
    }

    /**
     * 生成图片验证码
     */
    @RequestMapping(value = "/getPhoneVerify")
    @ResponseBody
    public void getPhoneVerify(String phoneNum) {
        try {
            TelephoneValidateCodeUtil.getTelephoneValidateCode(phoneNum);
        } catch (Exception e) {
            logger.error("获取验证码失败>>>>   ", e);
        }
    }

    /**
     * 校验图片验证码
     */
    @RequestMapping(value = "/checkPhoneVerify", method = RequestMethod.POST, headers = "Accept=application/json")
    public boolean checkPhoneVerify(@RequestParam String verifyInput, String phoneNum) {
        try{
            String inputStr = verifyInput;
            String code = TelephoneValidateCodeUtil.allCode.get(phoneNum);
            if (code == null || !code.equals(inputStr)) return false;
            return true;
        }catch (Exception e){
            logger.error("验证码校验失败", e);
            return false;
        }
    }
}
