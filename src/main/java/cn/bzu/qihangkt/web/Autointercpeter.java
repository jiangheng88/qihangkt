package cn.bzu.qihangkt.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.bzu.qihangkt.entity.User;
import cn.bzu.qihangkt.service.UserService;

public class Autointercpeter extends HandlerInterceptorAdapter{
	@Autowired
	private UserService userService;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("进入了preHandle方法！！！！");
		//先从session拿取用户
		
		HttpSession session = request.getSession();
		User user =(User) session.getAttribute("user");
		System.out.println("从自动登录的拦截器中获取的session"+user);
		// 1.只有未登录的用户才能自动登陆
		if(user==null) {
			// 2.只有带了自动登陆cookie的用户才能自动登陆
			//获取cookie
			Cookie[] cookies = request.getCookies();
			Cookie remPass = null;
			Cookie autoLogin= null;
			if(cookies!=null) {
				for(Cookie c: cookies) {
					if(c.getName().equals("remPass"))
						remPass=c;
					if(c.getName().equals("autologin")) {
						autoLogin=c;
					}
				}
				
			}
			
			
			if(remPass!=null && autoLogin!=null) {
				// 3.自动登录Cookie中保存的用户名密码都需要是正确的才能自动登陆				
				//从Cookie的值中取出用户名，利用String的截断函数		
				//从Cookie的值中取出用户名，利用String的截断函数
				String name = remPass.getValue().split(":")[0];
				System.out.println(name);
				//从Cookie的值中取出密码
				String pass = remPass.getValue().split(":")[1];
				System.out.println(pass);
				User userLogin= userService.login(name, pass);
				System.out.println(userLogin);
				if(userLogin!=null && autoLogin.getValue().equals("autologin")) {
					session.setAttribute("user", userLogin);
					response.sendRedirect(request.getContextPath()+"/admin/admin");
				}
			}	
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/admin");
		}
		
		return super.preHandle(request, response, handler);
	}
}
