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
         * didiyic��һ�η�����ʾ���
         * 
         * ��¼����ʱ�����cookie ����д�������
         * 
         * ������ǵ�һ��
         * 
         * ��cookie�л�ȡ�ϴ�ʱ�䣬��ʾ��ҳ��
         * 
         */
		
		Cookie  [] cookies = request.getCookies();
		
		Cookie cookie=cookieutils.findcookie(cookies, "lastvisit");
		
		if(cookie==null)
		{
			//��һ�η���
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print("<h1>���ã���ӭ��������վ��</h1>");
			
		}
		else {
			//���ǵ�һ�η���
			response.setContentType("text/html;charset=UTF-8");
			String lasttime=cookie.getValue();
			response.getWriter().print("<h1>����ϴη���ʱ����"+lasttime +"</h1>");
			
		}
		
		Date date=new Date(0);
		Cookie cookie2 = new Cookie("lastvisit", date.toLocaleString());
		//������Чʱ����·��
		cookie2.setPath("/webcookie");
		cookie2.setMaxAge(60 * 60 * 24 );
		//
		
		response.addCookie(cookie2);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
