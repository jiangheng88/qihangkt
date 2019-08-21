package cn.bzu.qihangkt.dao;

import org.apache.ibatis.annotations.Param;

import cn.bzu.qihangkt.entity.UserRole;

public interface UserRoleDao extends BaseDao<UserRole>{
	
	
	//根据用户id删除与用户有关的角色
	
	public void deleteByUserId(@Param("userId") Integer userId);
	
	//批量删除
	 public void batchDeleteUserRole(@Param("uids") Integer [] uids);
}
