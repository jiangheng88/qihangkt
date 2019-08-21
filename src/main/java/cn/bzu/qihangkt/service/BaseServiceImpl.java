package cn.bzu.qihangkt.service;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import cn.bzu.qihangkt.dao.BaseDao;
import cn.bzu.qihangkt.tools.MapToEntityTool;

@Service("baseService")
public abstract class BaseServiceImpl<T> implements BaseService<T> {
	
	private Class<T> clazz;
	
	private String tableName = null;


	public BaseServiceImpl() {
		
		Type type = this.getClass().getGenericSuperclass();
		
		ParameterizedType pt = (ParameterizedType) type;
		
		Type arr[] = pt.getActualTypeArguments();
		clazz = (Class<T>) arr[0];
		
		tableName = clazz.getSimpleName().toLowerCase();
	}

	
	public abstract BaseDao<T> getBaseDao();

	@Override
	public T selectOne(int id) {
		Map<Object, Object> map = getBaseDao().selectOne(tableName, id);
		T t = MapToEntityTool.map2entity(map, clazz);
		return t;
	}

	@Override
	public List<T> selectAll() {
		List<T> ts = new ArrayList<>();
		
		List<Map<Object, Object>> list = getBaseDao().selectAll(tableName);
		for (Map<Object, Object> hashMap : list) {
			ts.add(MapToEntityTool.map2entity(hashMap, clazz));
		}
		return ts;
	}

	@Override
	public int add(T t) {

		List<Object> list = new ArrayList<>();
		
		for (Field field : t.getClass().getDeclaredFields()) {
			field.setAccessible(true);// Ȩ��
			try {
				list.add(field.get(t));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return getBaseDao().add(tableName, list.toArray());
	}

	@Override
	public int update(T t) {
		int id = 0;

		List<Object> list = new ArrayList<>();
		for (Field field : t.getClass().getDeclaredFields()) {
			field.setAccessible(true);// Ȩ��
			try {
				if (field.get(t) == null) {
					continue;
				}
				if (("id").equals(field.getName())) {
					id = (Integer) field.get(t);
					continue;
				}
				// ƴ�ӳ� ��������='ֵ' ����ʽ
				list.add(field.getName() + "=" + "'" + field.get(t) + "'");
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		int count = getBaseDao().update(id, tableName, list.toArray());
		return count;
	}

	@Override
	public int delete(int id) {

		int count = getBaseDao().delete(tableName, id);
		return count;
	}
	
	@Override
	public int addUserByColumn(Object[] columnName, Object[] fliedName) {
		int count = getBaseDao().addUserByColumn(tableName, columnName, fliedName);
		return count;
	}
	

}
