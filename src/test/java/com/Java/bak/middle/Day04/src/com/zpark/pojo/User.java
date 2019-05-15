package com.Java.bak.middle.Day04.src.com.zpark.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("singleton")
@Component("u1")
/*@Service [service层] 	@Controller [web层]	@Responsitory [dao层]
 * */
public class User {
	@Value("1")
	private Integer id;
	private String name;
	/*@Autowired	
	 * 
	 * */
	private Rose rose;
	private List list;
	private Object[] obj;
	private Properties prop;
	private Map map;
	public User(Integer id, String name, Rose rose, List list, Object[] obj, Properties prop, Map map) {
		super();
		this.id = id;
		this.name = name;
		this.rose = rose;
		this.list = list;
		this.obj = obj;
		this.prop = prop;
		this.map = map;
	}
	public Properties getProp() {
		return prop;
	}
	public void setProp(Properties prop) {
		this.prop = prop;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Object[] getObj() {
		return obj;
	}
	public void setObj(Object[] obj) {
		this.obj = obj;
	}
	public User(Integer id, String name, Rose rose, List list, Object[] obj) {
		super();
		this.id = id;
		this.name = name;
		this.rose = rose;
		this.list = list;
		this.obj = obj;
	}
	public Rose getRose() {
		return rose;
	}
	public void setRose(Rose rose) {
		this.rose = rose;
	}
	public User(Integer id, String name, Rose rose) {
		super();
		this.id = id;
		this.name = name;
		this.rose = rose;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", rose=" + rose + ", list=" + list + ", obj="
				+ Arrays.toString(obj) + ", prop=" + prop + ", map=" + map + "]";
	}
	public User(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public User() {
		super();
	}
	public void initM(){
		System.out.println("初始化方法执行");
	}
	public void destoryM(){
		System.out.println("Objedct destoried!");
	}
	
}
