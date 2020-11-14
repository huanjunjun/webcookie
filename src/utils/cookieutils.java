package utils;

import javax.servlet.http.Cookie;

public class cookieutils {
	public static Cookie findcookie(Cookie[] cookies, String name) {
		if (cookies == null) {
			return null;
		} else {
			for (Cookie cookie : cookies) {
				// 判断数组中每个cookie的名称与给定的名称是否一致
				if (name.equals(cookie.getName()))
					return cookie;
			}
		}

		return null;

	}
}
