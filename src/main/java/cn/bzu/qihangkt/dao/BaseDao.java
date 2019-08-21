package cn.bzu.qihangkt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BaseDao<T> {
	//根据id得到一个用户
	Map<Object, Object> selectOne(@Param("tableName") String tableName, @Param("id") Integer id);
	//得到所用的用户
	List<Map<Object, Object>> selectAll(@Param("tableName")String tableName);
	
	//添加用户
	
	int add(@Param("tableName")String tableName,@Param("objects")Object[] objects);
	
	//根据id修改用户信息
	
	int update(@Param("id") int id, @Param("tableName") String tableName ,@Param("objects") Object[] objects);
	
	//根据id 删除信息
	
	int delete(@Param("tableName") String tableName, @Param("id") int id);
	
	//通过给定的数据库列名添加用户信息
	
	public int addUserByColumn(@Param("tableName")String tableName,@Param("columnName") Object[] columnName,@Param("fliedName") Object[] fliedName) ;
}
