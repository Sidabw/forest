package com.beta.basic.controller.swagger;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.beta.basic.mybatis.mapper.TbUser;
import com.beta.basic.pojo.LoginUser;
import com.beta.basic.service.AsyncTest;
import com.beta.basic.service.IUserService;


@Controller
@RequestMapping("/user")
public class ControllerMy {
	
	private Logger logger = Logger.getLogger(ControllerMy.class);  
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private AsyncTest asyncTest;

	@RequestMapping(value="/asynctest",method=RequestMethod.GET)
	@ResponseBody
	public String asyncTest() throws Exception{
		asyncTest.testt();
		logger.info("/asynctest请求到达");
		System.out.println("/asynctest请求到达");
		return "hello world async";
	}

	@RequestMapping(value="/dataList",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView dataList(){

		long start = System.currentTimeMillis();
		List<TbUser> queryList = userService.queryList();
		logger.error("消耗时间" + (System.currentTimeMillis() - start));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("arrayList",queryList);
		modelAndView.setViewName("/index");
		return modelAndView;
	}

	@RequestMapping(value="/loginTest")
	@ResponseBody
	public Map<String,?> loginTest(String username, String password, String _csrf, HttpServletRequest request){
		logger.info("loginTest...INFO...LEVEL...Test");
		logger.warn("loginTest...WARN...LEVEL...Test");
		logger.error("loginTest...ERROR...LEVEL...Test");
		Map<String,Object> map =new HashMap<>();
        if(!username.equals("") && password!=""){
            LoginUser user =new LoginUser(username,password);
            request.getSession().setAttribute("user",username);
            map.put("result","1");
        }else{
            map.put("result","0");
        }
        return map;
	}

    @RequestMapping(value="/logintest2")
    @ResponseBody
    public Map<String,?> loginTest2(String username, String password, String _csrf,
                                    HttpServletRequest request, HttpServletResponse response){
        logger.error("loginTest...ERROR...LEVEL...Test");
        Map<String,Object> map =new HashMap<>();
        map.put("result","1");
        response.setStatus(401);
        return map;
    }

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
	public Object logout(){
	    return "logout success";
    }

	@RequestMapping(value="/formtest",method=RequestMethod.POST)
	public String codingtest(HttpServletRequest request,String username,String password) throws UnsupportedEncodingException{
		//request.setCharacterEncoding("utf-8");
		System.out.println("username"+username);
		System.out.println("password"+password);
		return "hello";
	}


	//测试基本的多文件上传
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Object upload(MultipartFile[] uploadFile) throws IOException {
        String originalFilename = uploadFile[0].getOriginalFilename();
        String originalFilename2 = uploadFile[1].getOriginalFilename();
        System.out.println(originalFilename);
        System.out.println(originalFilename2);
        InputStream inputStream = uploadFile[0].getInputStream();

        return "11";
    }



    @RequestMapping(value = "/upload2", method = RequestMethod.POST)
    @ResponseBody
    public Object upload2(MultipartFile uploadFile, String userIdtime) throws IOException {
//        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
//        Iterator<String> fileNames = uploadFile.getFileNames();
//        ServletInputStream inputStream = uploadFile.getInputStream();
//        List<MultipartFile> files = uploadFile.getFiles("uploadFile");
//        for(MultipartFile file : files) {
        InputStream inputStream = uploadFile.getInputStream();
//        String fileMd5 = DigestUtils.md5Hex(inputStream);
//        InputStream inputStream1 = uploadFile.getInputStream();
//        System.out.println(inputStream == inputStream1);
//        System.out.println(fileMd5);
//        System.out.println(userIdtime);
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("http://weedfs-filer.zenki.cn/a/b");
            httpPost.setHeader(new BasicHeader("Accept-Language", "zh-cn"));
            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .setCharset(Charset.forName("UTF-8"))
                    .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                    .addBinaryBody("b", inputStream)
                    .build();
//
            // 发起请求并返回请求的响应
            httpPost.setEntity(reqEntity);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            System.out.println(response.getStatusLine());
//            File fileUpload = new File("/Users/feiyi/Documents/feiyiGitProject/" + "upload_test/" +  new Random().nextInt(10) +uploadFile.getOriginalFilename());
//
//        uploadFile.transferTo(fileUpload);
//        }
//        System.out.println(files.size());
//        while (fileNames.hasNext()) {
//            System.out.println(fileNames.next());
//        }
        return "11";
    }


    @RequestMapping(value = "/uploadStatus", method = RequestMethod.GET)
    @ResponseBody
    public Object getStatus(HttpServletRequest request){
	    return request.getSession().getAttribute("uploadStatus");
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

    @RequestMapping(value="/iptest",method=RequestMethod.GET)
    @ResponseBody
    public String testIp(HttpServletRequest request){
        String xforwardedfor = request.getHeader("x-forwarded-for");
        String remoteAddr = request.getRemoteAddr();
        return "xforwardedfor:"+xforwardedfor+"----"+"remoteAddr:"+remoteAddr;
    }

    //在mysql中使用blob存储二进制图片数据
    @RequestMapping(value = "/binaryImageDbStorage", method = RequestMethod.POST)
    @ResponseBody
    public boolean binaryImageDbStorage(MultipartFile multipartFile) throws IOException {
        String filename = multipartFile.getOriginalFilename();
        InputStream fileInputStream = multipartFile.getInputStream();
        return userService.binaryImageDbStorage(filename, fileInputStream);
    }

    //在mysql中使用blob存储二进制图片数据
    @RequestMapping(value = "/binaryImageDbRead", method = RequestMethod.GET)
    @ResponseBody
    public boolean binaryImageDbRead(String id) {
        return userService.binaryImageDbRead(id);
    }

    //在mysql中测试使用事务
    @RequestMapping(value = "/transactionalTest", method = RequestMethod.GET)
    @ResponseBody
    public String transactionalTest() {
	    return userService.transactionalTest();
    }

    @RequestMapping(value = "/restfulTest", method = RequestMethod.GET)
    @ResponseBody
    public String restfulTest() {
        return "get";
    }

    @RequestMapping(value = "/restfulTest", method = RequestMethod.POST)
    @ResponseBody
    public String restfulTest2() {
        return "post";
    }

    @RequestMapping(value = "/restfulTest", method = RequestMethod.PUT)
    @ResponseBody
    public String restfulTest3() {
        return "put";
    }

    @RequestMapping(value = "/restfulTest", method = RequestMethod.DELETE)
    @ResponseBody
    public String restfulTest4() {
        return "delete";
    }
}
