package com.ego.manage.service;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ego.commons.utils.FtpUtil;
import com.ego.commons.utils.IDUtils;
import com.ego.manage.service.inter.IUserService;
import com.ego.mapper.TbUserMapper;
import com.ego.pojo.PictrueResult;
import com.ego.pojo.TbUser;
@Service
public class UserServiceImpl implements IUserService{
	
	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;
	@Value("${FTP_USER_NAME}")
	private String FTP_USER_NAME;
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;
	
	@Autowired
	private TbUserMapper tum;

	@Override
	public boolean login(TbUser user) {
		TbUser tbuser = tum.selectByUnameAndPwd(user);
		System.out.println(tbuser);
		if(tbuser==null||tbuser.getUsername()==null){
			return false;
		}else{
			return true;
		}
	}
	@Override
	public PictrueResult uploadPic(MultipartFile uploadFile) {
		if(null==uploadFile||uploadFile.isEmpty()){
			return PictrueResult.error("上传图片为空");
		}
		//取文件扩展名
		String originalFilename = uploadFile.getOriginalFilename();
		String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
		//生成新文件名
		//可以使用uuid生成新文件名。
		//UUID.randomUUID()
		//可以是时间+随机数生成文件名
		String imageName = IDUtils.genImageName();
		//把图片上传到ftp服务器（图片服务器）
		//需要把ftp的参数配置到配置文件中
		//文件在服务器的存放路径，应该使用日期分隔的目录结构
		DateTime dateTime = new DateTime();
		/*
		System.out.println("===================================================");
		System.out.println("FTP_ADDRESS"+FTP_ADDRESS);
		System.out.println("FTP_PORT"+FTP_PORT);
		System.out.println("imageName"+imageName+ext);
		System.out.println(dateTime);*/
		String filePath = dateTime.toString("/yyyy/MM/dd");
		try {
			
			System.out.println(FTP_ADDRESS+" FTP_PORT:"+FTP_PORT);
			
			FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USER_NAME, FTP_PASSWORD, 
					FTP_BASE_PATH, filePath, imageName + ext, uploadFile.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回结果，生成一个可以访问到图片的url返回
		
		return PictrueResult.ok(IMAGE_BASE_URL + filePath + "/" + imageName + ext);
	}
}
