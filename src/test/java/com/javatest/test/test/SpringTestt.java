package com.javatest.test.test;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.beta.security.dao.*;
import com.elasticsearch.Demo1;
import com.elasticsearch.PinYin;
import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.beta.basic.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringTestt {

	public static final int i = 1;
	@Autowired
	private IUserService userService;

	@Autowired
	private CompanyInfoMapper mapper;

	@Autowired
	private ModelMapper modelMapper;


	@Test
	public void testt() throws UnknownHostException {
		/*List<TbUser> queryList = userService.queryList();
		System.out.println(queryList.get(0).getUsername());*/
		String index = "company_info";
//		String index = "company_info";
		String type = "company";
//		String type = "text";
		CompanyInfoExample companyInfoExample = new CompanyInfoExample();
		List<CompanyInfo> companyInfos = mapper.selectByExample(companyInfoExample);
		System.out.println(companyInfos.size());
		//全文 公司名称
		//全文 公司名称简称
		//全文 股票代码
		//全文 pinyin 公司名称
		//全文 pinyin 公司简称
		//全文 pinyin 公司全名简称
		TransportClient client = Demo1.getClient("10.10.1.6","zk_es_data");
		int i = 0;
		ArrayList<String > ids = new ArrayList<>();
		ArrayList<String> datas = new ArrayList<>();
		for(CompanyInfo companyInfo : companyInfos){
			HashMap<String, String> each = new HashMap<>();
			each.put("company_name", shortCompanyName(companyInfo.getCompanyName()));
			each.put("stock_name", companyInfo.getStockName());
			each.put("used_name", companyInfo.getUsedName());
			each.put("company_full_name", companyInfo.getCompanyName());
			each.put("stock_code", removeStockcodeStr(companyInfo.getStockCode()));
			String jsonEach = JSONObject.toJSONString(each);
			String id = UUID.randomUUID().toString().replaceAll("-","");
			System.out.println(i++);
			ids.add(id);
			datas.add(jsonEach);
		}
		Demo1.bulkIndexNewRecoreds(client, index, type, ids, datas);

	}

	private String shortCompanyName(String companyName) {
		if(!StringUtils.isEmpty(companyName)){
			//remove 股份有限公司
			companyName = companyName.replaceAll("股份有限公司","");
		}
		return companyName;
	}

	@Test
	public void testInsertOne() throws UnknownHostException {
		String index = "medcl4";
		String type = "folks";
		TransportClient client = Demo1.getClient();
		HashMap<String, String> each = new HashMap<>();
		each.put("company_name", "北京灵矶互联科技有限公司");
//		each.put("company_name_py2", "灵矶互联");
//		each.put("company_name_hz", "灵矶互联");
		each.put("code", "000123");
//		each.put("company_name", "刘德华");
		String jsonEach = JSONObject.toJSONString(each);
		String id = UUID.randomUUID().toString().replaceAll("-","");
		Demo1.indexNewRecored(client, index, type, id, jsonEach);
	}

	@Test
	public void testQuery() throws UnknownHostException {
		String index = "company_info";
//		String index = "company_info";
		TransportClient client = Demo1.getClient("10.10.1.6","zk_es_data");
		//公司名称
//		SearchResponse searchResponse = Demo1.simpleMatchQuery(client, index, "company_name_fc", "神州高铁");
//		Demo1.getResponseResult(searchResponse, "company_name_fc");
		//公司名称简称
//		SearchResponse searchResponse = Demo1.simpleMatchQuery(client, index, "stock_name_fc", "神州");
//		Demo1.getResponseResult(searchResponse, "company_name_fc");
		//股票代码	???
//		SearchResponse searchResponse = Demo1.simpleMatchQuery(client, index, "stock_code_fc", "00000");
//		Demo1.getResponseResult(searchResponse, "company_name_fc");
		//pinyin
//		SearchResponse searchResponse = Demo1.simpleMultiMatch(client, index, "szsm",
//				"company_name_pinyin", "stock_name_pinyin", "simplified_company_name_pinyin");
//		Demo1.getResponseResult(searchResponse, "company_name_fc");
//		SearchResponse searchResponse = Demo1.simpleMatchPhraseQuery(client, index, "company_name.ik", "富士 ");
		SearchResponse searchResponse = Demo1.simpleMatchPhraseQuery(client, index, "company_name.full_pinyin", "fsk");
//		SearchResponse searchResponse = Demo1.simpleMatchQuery(client, index, "company_name.full_pinyin", "fushikang");
//		SearchResponse searchResponse = Demo1.simpleWildcardQuery(client, index, "code", "*0001*");
		Demo1.getResponseResult(searchResponse, "company_name");
	}


	@Test
	public void testMongoEs() throws UnknownHostException {
		//select all model info
		ModelExample modelExample = new ModelExample();
		List<Model> models = modelMapper.selectByExample(modelExample);
		//insert into es
		String index = "model_info";
		String type = "model";
		TransportClient client = Demo1.getClient("10.10.1.6","zk_es_data");
		int i = 0;
		ArrayList<String > ids = new ArrayList<>();
		ArrayList<String> datas = new ArrayList<>();
		for(Model model : models){
			HashMap<String, String> each = new HashMap<>();
			each.put("model_name", model.getComment());
			String jsonEach = JSONObject.toJSONString(each);
			ids.add(model.getPinyinMongoId());
			datas.add(jsonEach);
			System.out.println(i++);
		}
		Demo1.bulkIndexNewRecoreds(client, index, type, ids, datas);
	}
	public static void main(String[] args) {
		//i++;
		for(int i =0  ; i < 500; i++){
			System.out.println(UUID.randomUUID());
		}
	}
	@Test
	public void testStockCode(){
        String s = removeStockcodeStr("000026.SZ");
        System.out.println(s);
    }
	private String removeStockcodeStr(String stockCode){
        if (StringUtils.isEmpty(stockCode))
            return "";
        char[] chars = stockCode.toCharArray();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < chars.length ; i ++){
            if(isNum(chars[i]))
                result.append(chars[i]);
        }
        return result.toString();
    }
    private boolean isNum(char a){
	    // 47 58
	    if( a > 47 && a < 58){
	        //是数字
	        return true;
        }
        return false;
    }
}
