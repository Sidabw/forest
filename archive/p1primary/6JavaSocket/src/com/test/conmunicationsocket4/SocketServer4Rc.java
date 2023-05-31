package com.test.conmunicationsocket4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer4 {
	public static void main(String[] args) {
		ServerSocket ss =null;
		Socket s =null;
		try {
			ss= new ServerSocket(2300);
			try {
				s=ss.accept();
				System.out.println("连接成功");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("error:   连接失败"+e);
			}
			BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
			String line= br.readLine();
			
			BufferedReader br2= new BufferedReader( new InputStreamReader(s.getInputStream()));
			
			PrintWriter pw =new PrintWriter(s.getOutputStream());
			
			while(!line.equals("bye"))
			{
				pw.println(line);
				pw.flush();
				
				System.out.println("Server..."+line);
				
				System.out.println("Client...."+br2.readLine());
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception:"+e);
		}
		finally {
			try {
				ss.close();
				s.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
