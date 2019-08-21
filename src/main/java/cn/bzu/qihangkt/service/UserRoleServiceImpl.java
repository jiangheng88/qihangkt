package cn.bzu.qihangkt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bzu.qihangkt.dao.BaseDao;
import cn.bzu.qihangkt.dao.UserRoleDao;
import cn.bzu.qihangkt.entity.User;
import cn.bzu.qihangkt.entity.UserRole;

@Service("userRoleService")
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole>implements UserPoleService{

	@Autowired
	private BaseDao<UserRole> baseDao;
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Override
	public void deleteByUserId(Integer userId) {
		
		userRoleDao.deleteByUserId(userId);
	}

	@Override
	public BaseDao<UserRole> getBaseDao() {
		
		return baseDao;
	}

	//批量删除的方法
	public void batchDeleteUserRole(Integer[] ids) {
		userRoleDao.batchDeleteUserRole(ids);
		
	}

}
