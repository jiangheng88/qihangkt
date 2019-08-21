package cn.bzu.qihangkt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bzu.qihangkt.dao.BaseDao;
import cn.bzu.qihangkt.dao.RoleDao;
import cn.bzu.qihangkt.entity.Role;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService{
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public BaseDao<Role> getBaseDao() {
		// TODO Auto-generated method stub
		return roleDao;
	}

	@Override
	public Role getOneRoleById(Integer id) {
		
		return roleDao.getOneRoleById(id);
	}

}
