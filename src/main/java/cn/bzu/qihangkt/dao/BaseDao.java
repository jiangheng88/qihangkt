package cn.bzu.qihangkt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BaseDao<T> {
	// 查询一条信息的记录
	Map<Object, Object> selectOne(@Param("tableName") String tableName, @Param("id") Integer id);
	//查询所有的方法
	List<Map<Object, Object>> selectAll(@Param("tableName")String tableName);
	
	//添加的方法
	
	int add(@Param("tableName")String tableName,@Param("objects")Object[] objects);
	
	//修改的方法
	
	int update(@Param("id") int id, @Param("tableName") String tableName ,@Param("objects") Object[] objects);
	
	//删除的方法
	
	int delete(@Param("tableName") String tableName, @Param("id") int id);
}
