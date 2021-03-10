package com.beta.basic.controller;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSONObject;
import com.beta.basic.util.IoUtils;
import com.beta.basic.util.JacksonUtils;
import com.beta.basic.util.pojo.BusinessRegisterContent;
import com.beta.basic.util.pojo.BusinessRegisterRequest;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.beta.basic.dao.mapper.TbUser;
import com.beta.basic.util.pojo.LoginUser;
import com.beta.basic.service.AsyncTest;
import com.beta.basic.service.IUserService;


//import com.redshield.licence.feign.Secsrv;
@RestController
@RequestMapping("/test")
public class MyController {
	
	private Logger logger = Logger.getLogger(MyController.class);
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private AsyncTest asyncTest;

//	@Autowired
//	private Secsrv secsrv;

    @RequestMapping(value="/reqTest",method=RequestMethod.GET)
    @ResponseBody
    public String reqTest() throws Exception {
        logger.debug("req come in!");
        Thread.sleep(new Random().nextInt(50));
        logger.debug("req finished");
        return "When grace is lost from life, come with a burst of song.\n" +
                "If the day is done, if birds sing no more, if the wind has flagged tired, then draw the veil of darkness thick upon me, even as thou hast wrapt the earth with the coverlet of sleep and tenderly closed the petals of the drooping lotus at dusk.From the traveller, whose sack of provisions is empty before the voyage is ended, whose garment is torn and dustladen, whose strength is exhausted, remove shame and poverty, and renew his life like a flower under the cover of thy kindly night.";
    }

	@RequestMapping(value="/asynctest",method=RequestMethod.GET)
	@ResponseBody
	public String asyncTest() throws Exception {
		asyncTest.testt();
		logger.info("/asynctest请求到达");
		System.out.println("/asynctest请求到达");
		return "hello world async";
	}

	@RequestMapping(value="/dataList",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView dataList() {

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
        System.out.println("in...");
        String originalFilename = uploadFile[0].getOriginalFilename();
        String originalFilename2 = uploadFile[1].getOriginalFilename();
        System.out.println(originalFilename);
        System.out.println(originalFilename2);
        InputStream inputStream = uploadFile[0].getInputStream();

        return "11";
    }



    @RequestMapping(value = "/upload2", method = RequestMethod.POST)
    @ResponseBody
    public Object upload2(@RequestParam(value = "file") MultipartFile file) throws IOException {
//        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
//        Iterator<String> fileNames = uploadFile.getFileNames();
//        ServletInputStream inputStream = uploadFile.getInputStream();
//        List<MultipartFile> files = uploadFile.getFiles("uploadFile");
//        for(MultipartFile file : files) {
        InputStream inputStream = file.getInputStream();
        System.out.println(inputStream.available());
//        String fileMd5 = DigestUtils.md5Hex(inputStream);
//        InputStream inputStream1 = uploadFile.getInputStream();
//        System.out.println(inputStream == inputStream1);
//        System.out.println(fileMd5);
//        System.out.println(userIdtime);
//            CloseableHttpClient httpClient = HttpClients.createDefault();
//            HttpPost httpPost = new HttpPost("http://weedfs-filer.zenki.cn/a/b");
//            httpPost.setHeader(new BasicHeader("Accept-Language", "zh-cn"));
//            HttpEntity reqEntity = MultipartEntityBuilder.create()
//                    .setCharset(Charset.forName("UTF-8"))
//                    .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
//                    .addBinaryBody("b", inputStream)
//                    .build();
////
            // 发起请求并返回请求的响应
//            httpPost.setEntity(reqEntity);
//            CloseableHttpResponse response = httpClient.execute(httpPost);
//            System.out.println(response.getStatusLine());
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

    @RequestMapping(value = "/reqTestParams", method = RequestMethod.POST)
    @ResponseBody
    public String reqTest(@RequestBody HashMap params) {
        System.out.println(params.size());
        for (Object key : params.keySet()) {
            System.out.println(params.get(key));
        }
        return "200aa";
    }


    @RequestMapping(value = "/saTes", method = RequestMethod.POST)
    public String saTest(@RequestBody BusinessRegisterRequest request, HttpServletRequest httpReq) throws IOException {
        System.out.println(JacksonUtils.convertToJsonStr(request.getContent()));
        return "ssa";
    }

    @RequestMapping(value = "/saTes2", method = RequestMethod.POST)
    public String saTest2(@RequestBody JSONObject jsonReq) {
        //这个就相当于原始message_content字符串，拿这个去验签
        String messageContentStr = jsonReq.getJSONObject("message_content").toJSONString();
        //如果你后边还要用这个对象的话，就这么处理下。但是验签要拿上边那个原始的
        BusinessRegisterContent messageContent = jsonReq.getJSONObject("message_content").toJavaObject(BusinessRegisterContent.class);
        return "ssa";
    }

    @Value("${docker.test}")
    private String dockerTest;

    @RequestMapping(value = "getDt", method = RequestMethod.GET)
    public String getDt(){
        return dockerTest;
    }


    @RequestMapping(value = "rrtt", method = RequestMethod.POST)
    public String rrtt(@RequestBody Header header){
//        System.out.println(header.getC1().toJSONString());
        System.out.println(header.getC1());
        return "ss";
    }



    @RequestMapping(value = "/reqTestTest", method = RequestMethod.POST)
    public String reqTestTest(@RequestBody String abc){
        System.out.println(abc);
        return "ss";
    }

    @RequestMapping(value = "/jmeter", method = RequestMethod.POST)
    public Object jmeterTest(@RequestBody String abc, HttpServletRequest request){
        System.out.println(abc);
        System.out.println(request.getCookies()[0].getComment());
        HashMap<String, Object> res = new HashMap<>();
        res.put("statusCode", 200);
        res.put("message", "成功不成功，你猜猜!");
        try {
            int sleepSec = new Random().nextInt(50)  +250;
            if (sleepSec> 260) {
                res.put("statusCode", 508);
            }
//            int sleepSec = new Random().nextInt(100);
            System.out.println("开始睡：    " + sleepSec);
            System.out.println("当前线程：   " + Thread.currentThread().getName());
            //假设一个请求占用50～100毫秒
            Thread.sleep(sleepSec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

}
