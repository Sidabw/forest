package com.beta.basic.service;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.beta.widgets.gp.dao.BlobTestEntity;
import com.beta.widgets.gp.dao.BlobTestEntityExample;
import com.beta.widgets.gp.dao.BlobTestEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beta.basic.mybatis.mapper.TbUser;
import com.beta.basic.mybatis.mapper.TbUserExample;
import com.beta.basic.mybatis.mapper.TbUserMapper;

@Service
public class UserService implements IUserService{


    @Autowired
    private BlobTestEntityMapper blobTestEntityMapper;

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
}
