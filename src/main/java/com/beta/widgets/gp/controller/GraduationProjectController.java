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

import com.beta.widgets.gp.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private IUserService userService;
    /**
     * 生成图片验证码
     */
    @RequestMapping(value = "/verify/getImg")
    public void getImgVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            BufferedImage image = randomValidateCode.getRandcode(request);//输出验证码图片方法
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
    @RequestMapping(value = "/verify/checkImg", method = RequestMethod.POST, headers = "Accept=application/json")
    public boolean checkImgVerify(@RequestParam String verifyInput, HttpServletRequest request) {
        try{
            String inputStr = verifyInput;
            String code = request.getSession().getAttribute(RandomValidateCodeUtil.RANDOMCODEKEY).toString();
            if (code == null || !code.equals(inputStr)) return false;
            return true;
        }catch (Exception e){
            logger.error("验证码校验失败", e);
            return false;
        }
    }

    /**
     * 生成手机验证码
     */
    @RequestMapping(value = "/verify/getPhone")
    @ResponseBody
    public void getPhoneVerify(String phoneNum, HttpServletRequest request) {
        try {
            TelephoneValidateCodeUtil.getTelephoneValidateCode(phoneNum, request);
        } catch (Exception e) {
            logger.error("获取验证码失败>>>>   ", e);
        }
    }

    /**
     * 校验手机验证码
     */
    @RequestMapping(value = "/verify/checkPhone", method = RequestMethod.POST, headers = "Accept=application/json")
    public boolean checkPhoneVerify(@RequestParam String verifyInput, String phoneNum, HttpServletRequest request) {
        try{
            String inputStr = verifyInput;
            String code = request.getSession().getAttribute(phoneNum).toString();
            if (code == null || !code.equals(inputStr)) return false;
            return true;
        }catch (Exception e){
            logger.error("验证码校验失败", e);
            return false;
        }
    }

    @RequestMapping(value = "/user/regist", method = RequestMethod.POST)
    public boolean regist(String username, String password, String realname, String groupCode){
        return userService.regist(username, password, realname, groupCode);
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public boolean login(String username, String password){
        return userService.login(username, password);
    }

}
