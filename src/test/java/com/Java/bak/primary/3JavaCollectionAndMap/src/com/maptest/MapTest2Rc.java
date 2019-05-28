package com.maptest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MapTest2 {
	public static void main(String[] args) {
		HashMap<Person, String> hash=new HashMap<Person,String>();
		hash.put(new Person("zhangsan", 3), "3");
		hash.put(new Person("wangwu", 2), "5");
		hash.put(new Person("wangwu", 2), "7");
		//System.out.println(hash);
		/*
	 	Collection<String> values = map.values();
		Iterator<String> its = values.iterator();
		while (its.hasNext()) {
			System.out.println(its.next());
		}
		System.out.println
		*/
		Set<Person> set=hash.keySet();
		Iterator<Person> iterator=set.iterator();
				while(iterator.hasNext())
				{
					Person key=iterator.next();
					String value=hash.get(key);
					System.out.println("键是："+key+"      "+"值是："+value);
				}
	}
}
class Person {
	private String name;
	private int salary;

	public Person(String name, int salary) {

		this.name = name;
		this.salary = salary;
	}
	

	@Override
	public String toString() {
		return "Person [name=" + name + ", salary=" + salary + "]";
	}

	@Override
	public int hashCode() {			//如果hashCode值相同， 还需判断equals方法

		return this.name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {	//复写Object的equals方法，   hashCode返回0时才会调用equals
		Person other = (Person) obj;
		Integer integer=other.salary;
		Integer integer1=this.salary;
		return this.name.equals(other.name)&&integer1.equals(integer);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}

