package com.designmode;

public class User {
	private String name;
	private int age;
	private boolean isMarried;
	private User(Builder builder){
		System.out.println("-----"+name);
		name=builder.name;
		age=builder.age;
		isMarried=builder.isMarried;
	}
	public static class Builder{
		private String name;
		private int age;
		private boolean isMarried;
		public Builder name(String name){
			//ʹ��this�Ǹ��ڲ��ำֵ�������ǿ��Եġ�ֻ����ʹ��val������ʹ������׶���
			this.name=name;
			return this;
		}
		public Builder age(int val){
			age=val;
			return this;
		}
		public Builder isMarried(boolean val){
			isMarried=val;
			return this;
		}
		public User build(){
			return new User(this);
		}
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public boolean isMarried() {
		return isMarried;
	}
	
}
