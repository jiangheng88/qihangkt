package cn.bzu.qihangkt.entity;

public class User {
	private Integer id;
	private String username;
	private String userpass;
	private String email;
	private String phone;
	private Integer enable;
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
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", userpass=" + userpass + ", email=" + email + ", phone="
				+ phone + ", enable=" + enable + "]";
	}
	public User(Integer id, String username, String userpass, String email, String phone, int enable) {
		super();
		this.id = id;
		this.username = username;
		this.userpass = userpass;
		this.email = email;
		this.phone = phone;
		this.enable = enable;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
