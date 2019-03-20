
package com.widget.oss.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

import com.aliyun.oss.OSSClient;

public class Demo {
	public static void main(String[] args) throws FileNotFoundException{
		String endpoint = "http://oss-cn-beijing.aliyuncs.com";
	    // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
	    String accessKeyId = "LTAIW5ue9luAhTwz";
	    String accessKeySecret = "TM88OEekXdrIFCqOoOa8YOXYA3ZQXK";
	    // 创建OSSClient实例。
	    OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
	    
	    //这两行代码是上传文件
	    // 上传文件流。
	    InputStream inputStream = new FileInputStream("C:\\Users\\think\\Desktop\\111.png");
	    ossClient.putObject("wechatdc", "111.png", inputStream);
	    // 设置URL过期时间为10年  3600l* 1000*24*365*10
	    Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
	    // 生成URL
	    URL url = ossClient.generatePresignedUrl("wechatdc", "111.png", expiration);
	    System.out.println(url.toString());
	    
	    // 关闭Client。
	    ossClient.shutdown();
	}
}
