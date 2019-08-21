package cn.bzu.qihangkt.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;

import cn.bzu.qihangkt.entity.Role;
import cn.bzu.qihangkt.entity.User;
import cn.bzu.qihangkt.service.RoleService;
import cn.bzu.qihangkt.service.UserService;
import cn.bzu.qihangkt.web.AuthClass;
import cn.bzu.qihangkt.web.AuthMethod;

@AuthClass
@Controller
public class AdminController {
	@Autowired
	private RoleService roleservice;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@AuthMethod
	@RequestMapping(value = "/admin/admin", method = RequestMethod.GET)
	public String admin(HttpServletRequest request) {
		System.out.println("根路径是********" + request.getContextPath());
		return "admin/admin";
	}

	@AuthMethod
	@RequestMapping(value = "/admin/resources", method = RequestMethod.GET)
	public String resources() {
		return "admin/resources";
	}

	@AuthMethod
	@RequestMapping(value = "/admin/roles", method = RequestMethod.GET)
	public String role() {
		return "admin/role";
	}

	@AuthMethod
	@RequestMapping("/admin/user")
	public String userManage(Model model, Integer pageNum, Integer pageSize) {
		if (pageNum == null || pageNum == 0)
			pageNum = 1;
		if (pageSize == null || pageSize == 0)
			pageSize = 6;
		List<Role> roles = roleservice.selectAll();
		model.addAttribute("role", roles);
		System.out.println(pageNum + "**********" + pageSize);
		PageInfo<User> users = userService.selectByPager(pageNum, pageSize);
		System.out.println("PageInfo中的users*************" + users);
		model.addAttribute("users", users);

		return "admin/user";
	}

	// 注销的功能
	
	@RequestMapping("/admin/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {

		if (request.getSession(false) != null) {
			request.getSession().invalidate();
			// 删除自动登录 cookie
			Cookie remPass = new Cookie("remPass", "");
			remPass.setPath(request.getContextPath());
			remPass.setMaxAge(0);
			response.addCookie(remPass);
			Cookie autologin = new Cookie("autologin", "");
			autologin.setPath(request.getContextPath());
			autologin.setMaxAge(0);
			response.addCookie(autologin);
		}
		return "redirect:login";
	}

}
