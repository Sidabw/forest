package com.Java.bak.middle.AutoSendMessage.src.com.zpark.ausm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zpark.util.SendMessage;

/**
 * Servlet implementation class ServletTest
 */
public class ServletTest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object send = SendMessage.send();
		resp.getWriter().print(send);
	}
}
