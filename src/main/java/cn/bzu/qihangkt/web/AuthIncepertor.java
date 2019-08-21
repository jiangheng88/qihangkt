
package cn.bzu.qihangkt.web;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.bzu.qihangkt.entity.User;

public class AuthIncepertor extends HandlerInterceptorAdapter {

	@Override

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();

		String resouce = "";
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			// 获得到页面对应的处理方法
			Method method = handlerMethod.getMethod(); // 得到这个方法上的RequestMapping注解

			RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);

			// 得到注解里的值(即使访问的路径名)

			resouce = requestMapping.value()[0];
			
			System.out.println("RequestMap中的注解值是"+resouce);

		} else {
			throw new RuntimeException("您访问的页面不存在！");
		}

		// 拿到系统中所有要求进行权限控制的方法，对应的权限控制标记
		List<String> allPermissionPathes = (List<String>) request.getServletContext().getAttribute("permission");

		// 拿到目前登录的用户，他所拥有的所有的权限对应的权限控制标记
		List<String> loginUserPathes = (List<String>) session.getAttribute("loginUserPathes");

		// 拿到目前登录的用户，他所拥有的所有的权限对应的权限控制标记
		User loginUser = (User) session.getAttribute("user");
		
		System.out.println("拦截器中的Session"+loginUser);
		if (loginUser != null) {
			boolean isAdmin = (boolean) session.getAttribute("isAdmin");

			if (!isAdmin && allPermissionPathes.contains(resouce)) {
				// 进行权限控制的：对比两个东西，userAllpermRes包不包含resource

				if (!loginUserPathes.contains(resouce)) {
					throw new RuntimeException("您没有权限访问该功能！");
				}
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/login");
		}
		return super.preHandle(request, response, handler);
	}

}
