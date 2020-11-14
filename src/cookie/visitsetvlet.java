package cookie;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.cookieutils;

/**
 * Servlet implementation class visitsetvlet
 */
public class visitsetvlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * didiyic第一次访问显示你好
         * 
         * 记录访问时间存入cookie ，会写到浏览器
         * 
         * 如果不是第一次
         * 
         * 从cookie中获取上次时间，显示到页面
         * 
         */
		
		Cookie  [] cookies = request.getCookies();
		
		Cookie cookie=cookieutils.findcookie(cookies, "lastvisit");
		
		if(cookie==null)
		{
			//第一次访问
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print("<h1>您好，欢迎来到本网站！</h1>");
			
		}
		else {
			//不是第一次访问
			response.setContentType("text/html;charset=UTF-8");
			String lasttime=cookie.getValue();
			response.getWriter().print("<h1>你的上次访问时间是"+lasttime +"</h1>");
			
		}
		
		Date date=new Date(0);
		Cookie cookie2 = new Cookie("lastvisit", date.toLocaleString());
		//设置有效时长和路径
		cookie2.setPath("/webcookie");
		cookie2.setMaxAge(60 * 60 * 24 );
		//
		
		response.addCookie(cookie2);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
