package cn.bzu.qihangkt.service;

import org.apache.ibatis.annotations.Param;

import cn.bzu.qihangkt.entity.Role;
import cn.bzu.qihangkt.entity.UserRole;

public interface RoleService extends BaseService<Role>{
	public Role getOneRoleById( Integer id);
}
