package cn.bzu.qihangkt.dao;

import org.apache.ibatis.annotations.Param;

import cn.bzu.qihangkt.entity.Role;

public interface RoleDao extends BaseDao<Role>{
	public Role getOneRoleById(@Param("id") Integer id);
}
