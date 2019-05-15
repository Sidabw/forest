package com.enumtest;

public class AccessControl {
	public static void main(String[] args)
	{
		//将字符串转变成枚举中的实例
		AccessRight right=AccessRight.valueOf("MANAGER");
		System.out.println(checkRight(right));
	}
	public static boolean checkRight(AccessRight accessRight)
	{
		if(accessRight==AccessRight.MANAGER)
		{
			return true;
		}
		if(accessRight==AccessRight.DEPATMENT)
		{
			return true;
		}
		return false;
	}
}
enum AccessRight
{
	MANAGER,DEPATMENT;
}
