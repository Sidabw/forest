/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: DES
 * Author:   feiyi
 * Date:     2020/12/5 4:57 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.security.symmetrical;

import com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory;
import kotlin.LateinitKt;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * 〈一句话功能简述〉:
 * 〈对称加密：DES〉
 *
 * @author feiyi
 * @create 2020/12/5
 * @since 1.0.0
 */
public class DES {

    private static final String originStr = "I'm sidalu";

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        //1⃣️初始化密钥
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        //2.固定密钥长度（56 or 64）
        keyGenerator.init(56);
        SecretKey keyGenSecretKey = keyGenerator.generateKey();
        byte[] encoded = keyGenSecretKey.getEncoded();
        String hexStr = Hex.encodeHexString(encoded);
        //只是输出看一下
        System.out.println("十六进制密钥：" + hexStr);

        //2⃣️密钥key转换
        DESKeySpec desKeySpec = new DESKeySpec(encoded);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
        SecretKey convertSecretKey = factory.generateSecret(desKeySpec);

        //3⃣️加密
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
        byte[] encryptedBytes = cipher.doFinal(originStr.getBytes());
        System.out.println("jdk DES encrypt: " + Hex.encodeHexString(encryptedBytes));

        //4⃣️解密
        cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        System.out.println("jdk DES decrypt: " + new String(decryptedBytes));
    }
}
