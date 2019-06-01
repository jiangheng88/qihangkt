package cn.bzu.qihangkt.service;

import java.util.List;

public interface BaseService<T> {
	T selectOne(int id);
	List<T> selectAll();
	int add(T t);
	int update(T t);	
	int delete(int id);
}
