/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: DH
 * Author:   feiyi
 * Date:     2020/12/6 2:54 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.security.asymmetric;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Objects;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/12/6
 * @since 1.0.0
 */
public class DH {

    private static final String originStr = "I'm sidalu";

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidAlgorithmParameterException, InvalidKeyException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        //1.初始化发送方密钥
        KeyPairGenerator senderKeyPairGenerator = KeyPairGenerator.getInstance("DH");
        senderKeyPairGenerator.initialize(512);
        KeyPair senderKeyPair = senderKeyPairGenerator.generateKeyPair();
        byte[] senderPublicKeyEnc = senderKeyPair.getPublic().getEncoded();//发送方公钥，发送给接收方
        System.out.println("publicKey: " + Hex.encodeHexString(senderPublicKeyEnc));

        //2.初始化接收方密钥
        KeyFactory receiverKeyFactory = KeyFactory.getInstance("DH");
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(senderPublicKeyEnc);
        PublicKey receiverPublicKey = receiverKeyFactory.generatePublic(x509EncodedKeySpec);
        DHParameterSpec dhParameterSpec = ((DHPublicKey)receiverPublicKey).getParams();
        KeyPairGenerator receiverKeyPairGenerator = KeyPairGenerator.getInstance("DH");
        receiverKeyPairGenerator.initialize(dhParameterSpec);
        KeyPair receiverKeypair = receiverKeyPairGenerator.generateKeyPair();
        PrivateKey receiverPrivateKey = receiverKeypair.getPrivate();
        byte[] receiverPublicKeyEnc = receiverKeypair.getPublic().getEncoded();

        //3.密钥构建
        KeyAgreement receiverKeyAgreement = KeyAgreement.getInstance("DH");
        receiverKeyAgreement.init(receiverPrivateKey);
        receiverKeyAgreement.doPhase(receiverPublicKey,true);
        SecretKey receiverDesKey = receiverKeyAgreement.generateSecret("DES");

        KeyFactory senderKeyFactory = KeyFactory.getInstance("DH");
        x509EncodedKeySpec = new X509EncodedKeySpec(receiverPublicKeyEnc);
        PublicKey senderPublicKey = senderKeyFactory.generatePublic(x509EncodedKeySpec);
        KeyAgreement senderKeyAgreement =  KeyAgreement.getInstance("DH");
        senderKeyAgreement.init(senderKeyPair.getPrivate());
        senderKeyAgreement.doPhase(senderPublicKey, true);
        SecretKey senderDesKey = senderKeyAgreement.generateSecret("DES");
        if(Objects.equals(receiverDesKey, senderDesKey)) {
            System.out.println("双方密钥相同");
        }

        //4.加密
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, senderDesKey);
        byte[] result = cipher.doFinal(originStr.getBytes());
        System.out.println("jdk dh eccrypt :" + Base64.encodeBase64String(result));

        //5.解密
        cipher.init(Cipher.DECRYPT_MODE, senderDesKey);
        result = cipher.doFinal(result);
        System.out.println("jdk dh decrypt : " + new String(result));
    }
}
