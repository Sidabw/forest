package com.Java.bak.middle.sshBak.SSHProject.src.com.zpark.web.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zpark.pageutil.PageBean;
import com.zpark.service.IUserService;
import com.zpark.web.pojo.User;
import com.zpark.web.querybean.QueryVO;
@Controller("userActionSpring")
@Scope("prototype")
public class Demo extends ActionSupport implements ModelDriven<User>{
	@Resource(name="userService")
	private IUserService userService;
	private User user = new User();
	//使用模型驱动进行登陆操作
	public String login(){
		User u=userService.login(user);
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("user", user);
		System.out.println(session);
		if(u==null){
			return "tologin";
		}else{
			return "success";
		}
	}
	//查询所有员工信息，将list送到页面
	private QueryVO queryVO=new QueryVO();
	private PageBean pageBean=new PageBean();
	public String findAllUser(){
		/**
		 * 利用对象模型将pageBean对象传到action中，再通过service dao 更改pageBean中的内容，全程只有1个pageBean
		 * */
		Map<String, Object> session = ActionContext.getContext().getSession();
		//System.out.println("-------------------------------------"+(session1==session));
		if(session.get("user")==null){
			return "tologin";
		}
		List<User> list=userService.findAllUser(queryVO,pageBean);
		pageBean.setList(list);
		System.out.println(pageBean);
		if(list==null){
			return "tologin";
		}else{
			//通过Struts中的ActionContext将数据放到request域中(....getSession 。。。 put  放到session域中)
			ActionContext.getContext().put("pageBean", pageBean);
			//ActionContext.getContext().put("list", list);
			return "findAllSuccess";
		}
	}
	//编辑员工信息传递
	public String empEdit(){
		User u = findById(user.getUser_id());
		System.out.println(u);
		ActionContext.getContext().put("user", u);
		/**
		 * 对于checkbox或者option中的默认checked/selected，可以通过这种后台判断传值的方式动态设置默认值，
		 * 也可通过jstl中的c:if在页面做判断
		 * */
	/*	if("男".equals(u.getUser_sex())){
			System.out.println("nan");
			ActionContext.getContext().put("man", "checked");
		}else if("女".equals(u.getUser_sex())){
			System.out.println("nv");
			ActionContext.getContext().put("women","checked");
		}else{
			ActionContext.getContext().put("man", "checked");
		}*/
		return "empEditSuccess";
	}
	//根据ID获取单个用户
	public User findById(Integer user_id){
		User u=userService.findById(user_id);
		return u;
	}
	//编辑员工信息,编辑成功重新显示所有员工信息。
	public String userInfoUpdate(){
	/**
	 * 在有表关联的情况下，user内需要放置对应关联表的对象
	 * */
		boolean flag=userService.userInfoUpdate(user);
		if(flag){
	/**
	 * 1次请求做1件事情，结果重定向到action，调用findAllUser
	 * 重定向中的actionName不可以加.action结尾
	 * */
			return "updateSuccess";
		}else{
		}
		return "updateSuccess";
	}
	//获取用户ID(方法放弃)
	public Integer getUserId(User user){
		Integer id=userService.getUserId(user);
		return id;
	}
	//查看员工信息详细
	public String userInfoDetail(){
		User u = findById(user.getUser_id());
		ActionContext.getContext().put("user", u);
		return "detailSuccess";
	}
	//删除员工
	public String userInfoDelete(){
		boolean flag=userService.userInfoDelete(user);
		if(flag){
			return "deleteSuccess";
		}
		return "deleteSuccess";
	}
	//条件查询（员工信息中的） 方法放弃
	public String queryLimited(){
		System.out.println(queryVO);
		List<User> list=userService.queryLimited(queryVO);
		ActionContext.getContext().put("list", list);
		System.out.println(list);
		return "findAllSuccess";
	}
	//添加员工
	public String addEmployee(){
		boolean flag=userService.addEmployee();
		return "addEmployeeSuccess";
	}
	public String test(){
		System.out.println("ok...."+this.hashCode());
		return SUCCESS;
	}
	public String sava(){
	//	userService.sava(new User(null,"luoboluobotou","679546789"));
		return SUCCESS;
	}
	public String findByName(){
		userService.findByName();
		return SUCCESS;
	}
	@Override
	public User getModel() {
		return user;
	}
	public QueryVO getQueryVO() {
		return queryVO;
	}
	public void setQueryVO(QueryVO queryVO) {
		this.queryVO = queryVO;
	}
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
}
