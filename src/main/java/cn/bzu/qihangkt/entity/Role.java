package cn.bzu.qihangkt.entity;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class Role {
	private Integer id;
	private String roleName;
	private String roleCode;
	
	private List<Resource> resources;
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	
	
	public List<Resource> getResources() {
		return resources;
	}
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
	
	
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", roleCode=" + roleCode + ", resources=" + resources
				+ "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
            return true;
        }
        if (obj instanceof Role) {
        	Role anotherRole = (Role)obj;
            
            if (this.id.equals(anotherRole.id)) {
            	 return true;
                }
        }
        return false;
		
	}
	
}
