package com.Java.bak.middle.Day04.src.com.zpark.proxy;

public class UserServiceImpl implements UserServiceIntf{
	private UserDao userDao;
	@Override
	public void find() {
		System.out.println("find..................");
	}

	@Override
	public void delete() {
		System.out.println("delete..................");
	}

	@Override
	public void update() {
		System.out.println("update..................");
	}

	@Override
	public void add() {
		System.out.println("add..................");
	}

}
