package com.Java.bak.middle.ssmBak.SSMProject.src.com.zpark.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zpark.dao.UserInfoMapper;
import com.zpark.pageutil.PageBean;
import com.zpark.pojo.DepartmentInfo;
import com.zpark.pojo.QueryVO;
import com.zpark.pojo.UserInfo;
import com.zpark.pojo.UserRole;

@Service("us")
//��������ǿ��ظ�����������������Ҫ�ģ�ֻ������Ϊtrue���ڷ�����������Ϊfalse
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class UserInfoServiceImpl implements IUserInfoService {
	@Autowired
	private UserInfoMapper um;
	@Override
	public UserInfo login(UserInfo u) {
		UserInfo userInfo = um.selectById(u);
		return userInfo;
	}
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public void empAdd(UserInfo user) {
		um.insertUser(user);
	}
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public void deptAdd(DepartmentInfo dept) {
		um.deptAdd(dept);
	}
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	@Override
	public void roleAdd(UserRole userRole) {
		um.roleAdd(userRole);
	}
	@Override
	public List<UserInfo> userList(QueryVO queryVO, PageBean pageBean) {
		String queryContent = queryVO.getQueryContent();
		String queryType = queryVO.getQueryType();
		if(queryType==null){
			pageBean.setRowCount(um.rouCount());
			List<UserInfo> list=um.userList(pageBean);
			return list;
		}else if(queryType.equals("1")){
			
		}else if(queryType.equals("2")){
			
		}else if(queryType.equals("3")){
			
		}else if(queryType.equals("4")){
			
		}
		return null;
	}
	
	@Override
	public void export(String[] titles, ServletOutputStream out) {
		try {
			//第一步：创建1个workbook 对应一个excel
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
			//第二步：添加1个sheet
			HSSFSheet hssfSheet = hssfWorkbook.createSheet("sheet1");
			//第三步，在sheet中添加表头第0行
			//注意老版本poi对excel行数列数有限制 short
			HSSFRow hssfRow = hssfSheet.createRow(0);
			//第四步，创建单元格，并设置值表头 设置表头居中
			HSSFCellStyle hssfCellStyle = hssfWorkbook.createCellStyle();
			hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			   HSSFCell hssfCell = null;
	            for (int i = 0; i < titles.length; i++) {
	                hssfCell = hssfRow.createCell((short) i);//列索引从0开始
	                hssfCell.setCellValue(titles[i]);//列名1
	                hssfCell.setCellStyle(hssfCellStyle);//列居中显示                
	            }
	           /* for(int j=1;j<150;j++){
	            	hssfRow=hssfSheet.createRow(j);
	            	hssfCell = hssfRow.createCell((short) j);//列索引从0开始
	            	hssfCell.setCellValue(j);//列名1
	            	hssfCell.setCellStyle(hssfCellStyle);//列居中显示                
	            }*/
	           // 第五步，写入实体数据 
	           List<UserInfo> users=um.userListAll();
	            //SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	            if(users != null && !users.isEmpty()){
	                for (int i = 1; i < users.size(); i++) {
	                	UserInfo userInfo = users.get(i);
	                	Integer userid = userInfo.getUserId();
	                	hssfCell = hssfRow.createCell((short) 0);
	                	int userId=0;
	                	if(userInfo.getUserId()==null){
	                		userId=0;
	                	}else{
	                		userId=userInfo.getUserId();
	                	}
	                   hssfRow = hssfSheet.createRow(i);                
	                    hssfCell.setCellValue(userId);
	                   // hssfCell.setCellStyle(hssfCellStyle);//列居中显示                
	            }
	           }   
	            // 第七步，将文件输出到客户端浏览器
	            try {
	            	hssfWorkbook.write(out);
	                out.flush();
	                out.close();

	            } catch (Exception e) {
	                e.printStackTrace();
	            }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
