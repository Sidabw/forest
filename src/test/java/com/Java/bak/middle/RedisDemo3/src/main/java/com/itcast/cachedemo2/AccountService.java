package com.Java.bak.middle.RedisDemo3.src.main.java.com.itcast.cachedemo2;

import org.springframework.cache.annotation.CacheEvict; 
import org.springframework.cache.annotation.Cacheable; 

import com.itcast.cachedemo.Account;
public class AccountService {
	@Cacheable(value="accountCache")// 使用了一个缓存名叫 accountCache 
	  public Account getAccountByName(String userName) { 
	    // 方法内部实现不考虑缓存逻辑，直接实现业务
	    System.out.println("real query account."+userName); 
	    return getFromDB(userName); 
	  } 
	  /*key使用的是SPEL(SpringEL)
	   *如果该方法接受的是String username：这里还可以加入condition="#username.length()<4"以表示只有...情况下才参与缓存。
	   *@CachePut(value...,key...)注解可以保证方法执行而且会存储缓存。
	   *@CacheEvict是在方法执行完成后才会执行，当方法抛出异常时该注解就不执行了，可以使用 beforeInvocation=true
	 */
	@CacheEvict(value="accountCache",key="#account.getName()")// 清空 accountCache 缓存
	public void updateAccount(Account account) {
		updateDB(account); 
	} 
  
	@CacheEvict(value="accountCache",allEntries=true)// 清空 accountCache 缓存
	public void reload() { 
	} 
  
	private Account getFromDB(String acctName) { 
    System.out.println("real querying db..."+acctName); 
    return new Account(acctName); 
	} 
  
	private void updateDB(Account account) { 
    System.out.println("real update db..."+account.getName()); 
	} 
}
