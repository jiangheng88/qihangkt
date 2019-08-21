package cn.bzu.qihangkt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.bzu.qihangkt.entity.Role;
import cn.bzu.qihangkt.entity.User;
import cn.bzu.qihangkt.service.RoleService;
import cn.bzu.qihangkt.service.UserService;
import cn.bzu.qihangkt.web.AuthClass;
import cn.bzu.qihangkt.web.AuthMethod;

@Controller
@AuthClass
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	

	// 添加用户，关联添加
	@AuthMethod
	@RequestMapping("/admin/addUser.html")
	public String addUser(User user, Integer[] roleIds) {
		userService.addUser(user, roleIds);

		return "redirect:/admin/user";
	}

	// 得到修改用户的页面，并且携带要修改用户的信息。
	
	@ResponseBody
	@RequestMapping(value = "admin/updateUser", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String updateUser(Integer id,HttpServletRequest request) {
		System.out.println("id*********" + id);
		User user = userService.selectOneById(id);
		List<Role> roles =  user.getRole();
		List<Role> allRoles = roleService.selectAll();
		String optStr = "";
		for(Role r:allRoles) {
			if(roles.contains(r)) {
				optStr = optStr + "<option selected value=\"" + r.getId() + "\">" + r.getRoleName() + "</option>\r\n";
			}else {
				optStr = optStr + "<option value=\"" + r.getId() + "\">" + r.getRoleName() + "</option>\r\n";
			}
		}
		String path = request.getContextPath();
		return "<div class=\"modal-header\">\r\n"
				+ "					<button type=\"button\" class=\"close\" data-dismiss=\"modal\">\r\n"
				+ "						<span>&times;</span>\r\n" + "					</button>\r\n"
				+ "					<h4 class=\"modal-title\" id=\"myModalLabel\">编辑用户</h4>\r\n"
				+ "				</div>\r\n" + "				<div class=\"modal-body\">\r\n"
				+ "					<form id=\"updateUserForm\" action=\"" + path
				+ "/admin/updateUser\" method=\"post\">\r\n"
				+ "                       <input type='hidden' name='id' value='" + user.getId() + "'/>"
				+ "						<div class=\"form-group\">\r\n"
				+ "							<label>用户名：</label> <input type=\"text\" disabled name=\"username\" class=\"form-control\" value=\""
				+ user.getUsername() + "\">\r\n" + "						</div>\r\n"
				+ "						<div class=\"form-group\">\r\n"
				+ "							<label>密码（留空表示不修改密码）：</label> <input type=\"password\" name=\"userpass\" class=\"form-control\" value=\"\">\r\n"
				+ "						</div>\r\n" + "						<div class=\"form-group\">\r\n"
				+ "							<label>关联的角色：</label> \r\n"
				+ "							<select name=\"roleIds\" class=\"selectpicker form-control\" multiple>\r\n"
				+ optStr + "							</select>\r\n" + "						</div>\r\n"
				+ "						<div class=\"form-group\">\r\n"
				+ "							<label>手机号：</label> <input type=\"text\" name=\"phone\" class=\"form-control\" value=\""
				+ user.getPhone() + "\">\r\n" + "						</div>\r\n"
				+ "						<div class=\"form-group\">\r\n"
				+ "							<label>邮箱：</label> <input type=\"text\" name=\"email\" class=\"form-control\" value=\""
				+ user.getEmail() + "\">\r\n" + "						</div>\r\n" + "					</form>\r\n"
				+ "				</div>\r\n" + "				<div class=\"modal-footer\">\r\n"
				+ "					<button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">关闭</button>\r\n"
				+ "					<button onclick=\"updateUserFormSubmint()\" type=\"button\" class=\"btn btn-primary\">编辑用户</button>\r\n"
				+ "				</div>";
	}
	
	//提交修改用户的信息
	@AuthMethod
	@RequestMapping(value="/admin/updateUser",method = RequestMethod.POST)
	public String updateUserInfo(User user, Integer[] roleIds) {
		userService.updateUser(user,roleIds);
		return "redirect:/admin/user";
	}
	
	//根据id删除用户
	@AuthMethod
	@RequestMapping(value="/admin/deleteUser")
	public String deleteUserId(Integer id) {
		userService.deleteUserById(id);
		
		return "redirect:/admin/user";
	}
	
	//批量删除的方法
	@AuthMethod
	@ResponseBody
	@RequestMapping(value="/admin/batchDelete")
	public String batchDelete(String uid) {
		
		System.out.println("uid******"+uid);
		//将这个字符串的死一个字符和最后一个字符去掉
		uid=uid.substring(1,uid.length()-1);
		//去掉字符串的双引号
		uid = uid.replaceAll("\"", "");
		//将字符串截取成字符串数组
		String idsStr [] = uid.split(",");
		Integer adsArr [] = new Integer[idsStr.length];
		//遍历字符串将其转化成Integer类型的数组中
		for(int i=0;i<idsStr.length;i++) {
			adsArr[i] = Integer.parseInt(idsStr[i]);
			System.out.println("****************"+adsArr[i]);
		}
		//调用批量删除的方法
		userService.batchDelete(adsArr);
		//跳转页面，这里需要借助user.js
		return "success";
	}
	
	//查询的方法
	@AuthMethod
	@RequestMapping(value="/admin/userSearch",method = RequestMethod.POST)
	public String fuzzySelect(Model model ,String userInfo) {
		
		System.out.println(userInfo+"**********");
		List<Role> roles = roleService.selectAll();
		model.addAttribute("role", roles);
		 int pageNum=1; 
		 int pageSize=6;
		PageInfo<User> fuzzyUsers = userService.fuzzySelectByInfo(userInfo,pageNum, pageSize);
		System.out.println("PageInfo中的users*************"+fuzzyUsers);
		model.addAttribute("users",fuzzyUsers );
		return "admin/user";
	}
}
