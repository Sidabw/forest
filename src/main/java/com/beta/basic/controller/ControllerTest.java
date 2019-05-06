
package com.beta.basic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.URLEncoder;


@Controller
@RequestMapping("/sida")
public class ControllerTest {
	
	@Value("")
	String path;

	@RequestMapping(value="/brew",method=RequestMethod.POST)
	@ResponseBody
	public String testt(@RequestParam(name="username") String username,String password,String tel){
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		System.out.println("tel:"+tel);
		return "------------------------------------------------------------\r\n"+
				"username:"+username+"password:"+password+"tel:"+tel+
				"\r\n------------------------------------------------------------";
	}

	@RequestMapping(value="/iptest",method=RequestMethod.GET)
	@ResponseBody
	public String testIp(HttpServletRequest request){
		String xforwardedfor = request.getHeader("x-forwarded-for");
		String remoteAddr = request.getRemoteAddr();
		return "xforwardedfor:"+xforwardedfor+"----"+"remoteAddr:"+remoteAddr;
	}


    @RequestMapping(value="/sida",method=RequestMethod.POST)
    @ResponseBody
    public String sida(@RequestBody ClassOut request){
        return null;
    }


    @RequestMapping(value = "/download", method = RequestMethod.GET)
    @ResponseBody
    public String download(HttpServletResponse response){
	    //用这种方式下载的docx会多120字节...  暂时不清楚哪里的原因。可以用下面的download2接口
        response.setContentType("application/force-download");// 设置强制下载不打开
        response.addHeader("Content-Disposition", "attachment;fileName=" + "11.docx");// 设置文件名
        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream("/Users/feiyi/Documents/feiyiGitProject/forest/organName.docx");
            bis = new BufferedInputStream(fis);
            OutputStream os = response.getOutputStream();
            int i =0;
            while (i != -1) {
                i = bis.read(buffer);
                os.write(buffer, 0, i);
                System.out.println(i);
            }
            return "下载成功";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	    return "下载失败";
    }



    @RequestMapping("/download2")
    public ResponseEntity<FileSystemResource> download2()throws UnsupportedEncodingException {

        File file = new File("/Users/feiyi/Documents/feiyiGitProject/forest/organName.docx");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", "attachment; filename=" +  URLEncoder.encode("11.docx", "UTF-8"));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new FileSystemResource(file));

    }

}
