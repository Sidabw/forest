/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: AES
 * Author:   feiyi
 * Date:     2020/12/5 5:45 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.security.symmetrical;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/12/5
 * @since 1.0.0
 */
public class AES {

    private static final String originStr = "I'm sidalu";

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        //1⃣️初始化密钥
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        //128 or 192 or 256
        //256好像额外需要一个无政策限制权限文件... 不懂
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] keyBytes = secretKey.getEncoded();
        String hexStr = Hex.encodeHexString(keyBytes);
        //只是输出看一下
        System.out.println("十六进制密钥：" + hexStr);

        //2⃣️密钥key转换
        Key key = new SecretKeySpec(keyBytes,"AES");

        //3⃣️加密
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] result = cipher.doFinal(originStr.getBytes());
        System.out.println("jdk AES encrypt: " + Base64.encodeBase64String(result));

        //4⃣️解密
        cipher.init(Cipher.DECRYPT_MODE, key);
        result = cipher.doFinal(result);
        System.out.println("jdk aes decrypt: " + new String(result));

    }
}
