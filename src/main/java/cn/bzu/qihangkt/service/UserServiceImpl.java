package cn.bzu.qihangkt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bzu.qihangkt.dao.BaseDao;
import cn.bzu.qihangkt.entity.User;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	@Autowired
	private BaseDao<User> baseDao;
	
	
	@Override
	public BaseDao<User> getBaseDao() {
		
		return baseDao;
	}

}
