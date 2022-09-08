package com.beta.basic.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.beta.widgets.gp.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beta.basic.dao.mapper.TbUser;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService{


    @Autowired
    private BlobTestEntityMapper blobTestEntityMapper;

    @Autowired
    private GpUserMapper gpUserMapper;

	@Override
	public List<TbUser> queryList() {
        List<BlobTestEntity> blobTestEntities = blobTestEntityMapper.selectByExample(new BlobTestEntityExample());
        System.out.println(JSONObject.toJSONString(blobTestEntities));
//        return Arrays.asList(new TbUser())
        return null;
	}

    @Override
    public boolean binaryImageDbStorage(String filename, InputStream fileInputStream) throws IOException {
        int available = fileInputStream.available();
        System.out.println(available);
        byte[] bytes = new byte[available];
        fileInputStream.read(bytes);
        BlobTestEntity blobTestEntity = new BlobTestEntity();
        blobTestEntity.setId(1);
        blobTestEntity.setImageName(filename);
        blobTestEntity.setImageBin(bytes);
        blobTestEntityMapper.insert(blobTestEntity);
        return false;
    }

    @Override
    public boolean binaryImageDbRead(String id) {
        BlobTestEntityExample example = new BlobTestEntityExample();
        example.createCriteria().andImageNameEqualTo("feiyi_test6.pdf");
        List<BlobTestEntity> blobTestEntities = blobTestEntityMapper.selectByExampleWithBLOBs(example);
        System.out.println(blobTestEntities.size());
        System.out.println(blobTestEntities.get(0).getImageBin().length);

//        BlobTestEntity blobTestEntity = blobTestEntityMapper.selectByPrimaryKey(1);
//        System.out.println(blobTestEntity.getImageBin().length);
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String transactionalTest() {
        GpUser user = createUser();
        gpUserMapper.insert(user);
        throw new NullPointerException("异常了...");   //这是抛出异常了，同时上面的insert语句也回滚了。哈哈哈.. 好开心
//        return "success";
    }

    private GpUser createUser() {
        GpUser gpUser = new GpUser();
        gpUser.setId(2);
        gpUser.setUsername("feiyi--2");
        gpUser.setGroupCode("feiyi--2");
        gpUser.setPassword("feiyi--2");
        gpUser.setRealname("feiyi--2");
        return gpUser;
    }
}
