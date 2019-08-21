package cn.bzu.qihangkt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bzu.qihangkt.entity.User;

public interface UserDao extends BaseDao<User>{
	 
	//根据名字查询
	public User getUserByName(@Param("username") String username);
	//关联查询
	public List<User> selectAllUsersByRelevance();
	
	// 根据id查询一条记录
	
	public User selectOneById(@Param("id") Integer id);
	//批量删除
	public void batchDeleteUser(@Param("ids")Integer [] ids);
	
	//模糊查询
	public List<User> fuzzySelectByInfo(@Param("info") String info);
	//登录
	public User login(@Param("userInfo")String userInfo, @Param("userpass") String userpass);
	
	public User getUserAllInfo(@Param("userInfo") String userInfo);
	
	
}
