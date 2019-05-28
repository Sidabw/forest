package com.arraylist3;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * ArrayList equals 返回 true 的前提条件。
 * e1 alist的第1个元素；e2 newList的第1个元素
 * e1==null?e2==null;e1.equals(e2);
 * */
public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<Book> alist = new ArrayList<Book>();
		ArrayList<Book> newlist = new ArrayList<Book>();
		alist.add(new Book(9, "zhangsan"));
		alist.add(new Book(8, "zhangjian"));
		System.out.println(alist);
		Iterator<Book> it = alist.iterator();
		while (it.hasNext()) {
			Book b = it.next();
			if (!newlist.contains(b))
				newlist.add(b); // 传b的引用，还是相同的对象
		}
		System.out.println(alist.equals(newlist));
		System.out.println(newlist);
	}

}

class Book {
	public int a;
	public String b;

	Book(int a, String b) {

		this.a = a;
		this.b = b;
	}
	@Override
	public String toString() {
		return this.a+"   "+this.b;
	}
}
