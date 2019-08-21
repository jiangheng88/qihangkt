package cn.bzu.qihangkt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.bzu.qihangkt.entity.Resource;
import cn.bzu.qihangkt.entity.Role;
import cn.bzu.qihangkt.entity.User;
import cn.bzu.qihangkt.service.UserService;

@Controller("loginController")
public class LoginController {

	@Autowired
	private UserService userService;

	// 加载login页面
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	// 实现登录
	@RequestMapping(value = "/dologin", method = RequestMethod.POST)
	public String doLogin(String userInfo, String userpass, HttpSession session,String remmber,
			String autoLogin,HttpServletRequest req,HttpServletResponse resp) {

		User user = userService.login(userInfo, userpass);
		System.out.println(user);
		if (user != null) {

			// 将登陆后的用户保存到session中
			session.setAttribute("user", user);
			
			//获取cookie
			if(remmber.equals("rem")) {
				Cookie cookieRem = new Cookie("remPass", user.getUsername() + ":" + user.getUserpass());
				cookieRem.setPath(req.getContextPath());
				cookieRem.setMaxAge(3600*24*7);
				resp.addCookie(cookieRem);
			}
			if(autoLogin.equals("auto")) {
				Cookie cookieauto = new Cookie("autologin","autologin");
				cookieauto.setPath(req.getContextPath());
				cookieauto.setMaxAge(3600*24*7);
				resp.addCookie(cookieauto);
			}
			boolean isAdmin = false;
			// 拿到登录成功的用户所有关联的所有角色信息
			List<Role> roles = user.getRole();
			List<Resource> resources = null; // 用来保存用户的权限路径
			List<String> loginUserPathes = new ArrayList<>();
			if (roles != null) {
				// 遍历角色，判断是不是超级管理员角色
				for (Role r : roles) {
					if (r.getRoleCode().equals("admin")) {
						isAdmin = true;
						break;
					}

					// 不是超级管理员的情况下，我们要把登录成功的用户，关联的所有权限标记，取出来

					resources = r.getResources();

					if (resources != null) {
						for (Resource res : resources) {
							// loginUserPathes:存放了当前登录用户所拥有的path路径
							loginUserPathes.add(res.getPath());
						}
					}

				}
			}

			// 循环完毕后，loginUserPathes：包括了登录成功的用户，所拥有的所有权限的标记
			session.setAttribute("isAdmin", isAdmin);
			// 循环完毕后，loginUserPathes：包括了登录成功的用户，所拥有的所有权限的标记
			session.setAttribute("loginUserPathes", loginUserPathes);

			return "redirect:admin/admin";
		} else {
			return "redirect:login";
		}

	}
}
