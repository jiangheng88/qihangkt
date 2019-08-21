package cn.bzu.qihangkt.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;

import cn.bzu.qihangkt.entity.User;

public interface UserService extends BaseService<User>{
	
	//根据你名字查询
	public User getUserByName(@Param("username") String username);
	//关联添加用户
	public void addUser(User user, Integer[] roleIds);
	//关联查询
	public List<User> selectAllUsersByRelevance();
	
	//利用分页插件分页
	
	public PageInfo<User> selectByPager(int pageNum,int pageSize);
	
	//根据id查询
	
	public User selectOneById(Integer id);
	//修改用户
	public void updateUser(User user, Integer[] roleIds);
	//根据id删除用户的信息
	public void deleteUserById(Integer id);
	
	//批量删除的方法
	public void batchDeleteUser(Integer [] ids);
	public void batchDelete(Integer[] adsArr);
	//模糊查询
	public PageInfo<User> fuzzySelectByInfo(String info, Integer pageNum, Integer pageSize);
	//登录的方法
	public User login(String userInfo, String userpass);
	
}
