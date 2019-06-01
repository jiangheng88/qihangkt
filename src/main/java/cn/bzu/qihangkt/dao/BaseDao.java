package cn.bzu.qihangkt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BaseDao<T> {
	// ��ѯһ����Ϣ�ļ�¼
	Map<Object, Object> selectOne(@Param("tableName") String tableName, @Param("id") Integer id);
	//��ѯ���еķ���
	List<Map<Object, Object>> selectAll(@Param("tableName")String tableName);
	
	//��ӵķ���
	
	int add(@Param("tableName")String tableName,@Param("objects")Object[] objects);
	
	//�޸ĵķ���
	
	int update(@Param("id") int id, @Param("tableName") String tableName ,@Param("objects") Object[] objects);
	
	//ɾ���ķ���
	
	int delete(@Param("tableName") String tableName, @Param("id") int id);
}
