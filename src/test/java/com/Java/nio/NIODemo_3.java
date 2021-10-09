package com.Java.nio;

import org.jfree.util.Log;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author shaogz
 */
public class NIODemo_3 {

    @Test
    public void test() {
        System.out.println(fileMD5("/Users/feiyi/Downloads/movies-music/浮生梦.mkv"));
    }

    public static String fileMD5(String path) {
        File file = new File(path);
        try (FileInputStream in = new FileInputStream(file); FileChannel ch = in.getChannel()) {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            digest.update(byteBuffer);
            return toHexString(digest.digest());
        } catch (IOException | NoSuchAlgorithmException e) {
            Log.error("", e);
            return "";
        }
    }

    public static String toHexString(byte[] data) {
        char[] hexCode = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder r = new StringBuilder(data.length * 2);
        for (byte b : data) {
            r.append(hexCode[(b >> 4) & 0xF]);
            r.append(hexCode[(b & 0xF)]);
        }
        return r.toString();
    }
}