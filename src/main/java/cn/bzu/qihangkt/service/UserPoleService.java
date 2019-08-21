package cn.bzu.qihangkt.service;

import org.apache.ibatis.annotations.Param;

import cn.bzu.qihangkt.entity.User;
import cn.bzu.qihangkt.entity.UserRole;

public interface UserPoleService extends BaseService<UserRole> {
	// 根据用户id删除与用户有关的角色

	public void deleteByUserId(Integer userId);
	
	//批量删除的方法
	
	public void batchDeleteUserRole(Integer [] ids);

}
