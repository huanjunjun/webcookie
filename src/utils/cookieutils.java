package utils;

import javax.servlet.http.Cookie;

public class cookieutils {
	public static Cookie findcookie(Cookie[] cookies, String name) {
		if (cookies == null) {
			return null;
		} else {
			for (Cookie cookie : cookies) {
				// �ж�������ÿ��cookie������������������Ƿ�һ��
				if (name.equals(cookie.getName()))
					return cookie;
			}
		}

		return null;

	}
}
