package cn.bzu.qihangkt.entity;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.junit.runners.Parameterized.Parameter;
import org.springframework.stereotype.Component;

import net.sf.ehcache.search.expression.Not;
@Component
public class User {
	
	private Integer id;
	@NotEmpty(message = "用户名不能为空")
	private String username;
	
	@Size(min =6,max = 10)
	private String userpass;
	@Email(message = "email格式不正确")
	private String email;
	@NotEmpty(message = "手机号不能为空")
	private String phone;
	private Integer enable;
	
	private Date date;
	private List<Role> role;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getEnable() {
		return enable;
	}
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	public List<Role> getRole() {
		return role;
	}
	public void setRole(List<Role> role) {
		this.role = role;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", userpass=" + userpass + ", email=" + email + ", phone="
				+ phone + ", enable=" + enable + ", date=" + date + ", role=" + role + "]";
	}
	
	
	
}
