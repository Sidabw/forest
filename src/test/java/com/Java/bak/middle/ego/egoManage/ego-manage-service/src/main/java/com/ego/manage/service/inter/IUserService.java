package com.ego.manage.service.inter;

import org.springframework.web.multipart.MultipartFile;

import com.ego.pojo.PictrueResult;
import com.ego.pojo.TbUser;

public interface IUserService {
	public boolean login(TbUser user);

	public PictrueResult uploadPic(MultipartFile uploadFile);
}
