package com.grammer.test;
import java.io.File;
import java.io.FileFilter;

public class Demo9 {
	public static void main(String[] args) {
		filterFile(new File("c:/aaa"));
	}
	/*
	 * 过滤器筛选将指定文件夹下的小于200K的小文件获取并打印
	 */
	public static void filterFile(File f){
		if(f.isFile()){
			System.out.println(f + "不是文件夹");
			return;
		}
		if(!f.exists()) return;
		// 获得文件数组
		File files[] = f.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				// 判断是否是文件夹，如果是则返回true
				if(pathname.isDirectory()) return true;
				// 判断是否是隐藏文件
				if(pathname.isHidden()) return false;
				// 获得文件大小
				long length = pathname.length();
				if(length / 1024 < 200) return true;
				return false;
			}
		});
		
		// 遍历数组
		for (File file : files) {
			if(file.isDirectory()) {
				filterFile(file);
				continue;
			}
			System.out.println(file);
		}
	}

}
