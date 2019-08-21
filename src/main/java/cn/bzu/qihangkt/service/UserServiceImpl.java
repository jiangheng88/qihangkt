package cn.bzu.qihangkt.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.bzu.qihangkt.dao.BaseDao;
import cn.bzu.qihangkt.dao.UserDao;
import cn.bzu.qihangkt.dao.UserRoleDao;
import cn.bzu.qihangkt.entity.User;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private BaseDao<User> baseDao;
	@Autowired
	private UserRoleDao userRoleDao;

	// 的到BaseDao的实例
	@Override
	public BaseDao<User> getBaseDao() {

		return baseDao;
	}

	// 通过名字查询用户
	@Override
	public User getUserByName(String username) {

		return userDao.getUserByName(username);
	}

	// 添加用户
	@Override
	public void addUser(User user, Integer[] roleIds) {

		user.setEnable(1);
		user.setDate(new Date());
		// 根据指定的列名添加用户信息
		this.addUserByColumn(new Object[] { "id", "username", "userpass", "email", "phone", "enable", "date" },
				new Object[] { user.getId(), user.getUsername(), user.getUserpass(), user.getEmail(), user.getPhone(),
						user.getEnable(), user.getDate() });
		// 根据名字查询刚刚添加的用户
		User userByName = userDao.getUserByName(user.getUsername());

		for (Integer arr : roleIds) {
			// 将用户的信息添加到用户角色的关联的表中
			userRoleDao.add("user_role_table", new Object[] { null, userByName.getId(), arr });
		}
	}

	// 关联查询所有的记录
	@Override
	public List<User> selectAllUsersByRelevance() {
		return userDao.selectAllUsersByRelevance();

	}

	@Override
	public PageInfo<User> selectByPager(int pageNum, int pageSize) {

		Page<User> page = PageHelper.startPage(pageNum, pageSize);
		List<User> users = userDao.selectAllUsersByRelevance();
		System.out.println(users);
		PageInfo<User> info = new PageInfo<>(users);
		return info;
	}

	// 根据id查询
	@Override
	public User selectOneById(Integer id) {

		return userDao.selectOneById(id);
	}

	// 修改用户并且实现关联表中的信息是修改
	@Override
	public void updateUser(User user, Integer[] roleIds) {

		System.out.println(Arrays.toString(roleIds));
		if (user.getUserpass().trim().equals(""))
			user.setUserpass(null);
		// 修该用户信息表中的信息
		this.update(user);
		// 删除id对应用户在用户角色关联表中的信息
		userRoleDao.deleteByUserId(user.getId());

		for (Integer arr : roleIds) {
			// 将修改后的用户信息添加到用户角色的关联的表中
			userRoleDao.add("user_role_table", new Object[] { null, user.getId(), arr });
		}

	}

	// 根据id删除用户的信息，同时还要删除关联中的信息
	@Override
	public void deleteUserById(Integer id) {
		// 第一步，删除关联表中的信息
		userRoleDao.deleteByUserId(id);
		// 第二步删除用户信息表中的信息
		userDao.delete("user", id);

	}

	// 批量删除用户的信息
	@Override
	public void batchDeleteUser(Integer[] ids) {
		userDao.batchDeleteUser(ids);

	}

	// 批量删除用户的信息和关联表中的信息
	@Override
	public void batchDelete(Integer[] adsArr) {

		// 第一步伤处关联表中信息
		userRoleDao.batchDeleteUserRole(adsArr);
		// 第二步删除用户表中的信息
		this.batchDeleteUser(adsArr);

	}

	@Override
	public PageInfo<User> fuzzySelectByInfo(String info, Integer pageNum, Integer pageSize) {
		Page<User> page = PageHelper.startPage(pageNum, pageSize);
		// 获得查询的信息
		List<User> users = userDao.fuzzySelectByInfo(info);
		System.out.println(users);
		PageInfo<User> pInfo = new PageInfo<User>(users);
		return pInfo;
	}

	@Override
	public User login(String userInfo, String userpass) {

		User user = userDao.getUserAllInfo(userInfo);

		System.out.println("===user=====" + user);
		if (user == null)
			throw new RuntimeException("用户名或密码有错误！"); // 有对应的用户的情况下，进一步的验证
		if (!userpass.equals(user.getUserpass()))
			throw new RuntimeException("用户名或密码有吴！");

		return user;
	}

}
