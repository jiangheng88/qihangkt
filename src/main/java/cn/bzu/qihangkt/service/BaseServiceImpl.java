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
	// 定义一个接收泛型的变量
	private Class<T> clazz;
	// 定义一个表名
	private String tableName = null;

	// 获得泛型的具体的类型
	public BaseServiceImpl() {
		// 获得父类的类型
		Type type = this.getClass().getGenericSuperclass();
		// 将Type类型的强转为他的实现类
		ParameterizedType pt = (ParameterizedType) type;
		// 得到的数组的第一个元素就是我们要得到的类的类型
		Type arr[] = pt.getActualTypeArguments();
		clazz = (Class<T>) arr[0];
		// 获取表名
		tableName = clazz.getSimpleName().toLowerCase();
	}

	// 提供一个抽象方法 当前类的子类需要提供具体实现类的 Dao
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
		// 将参数放入数组中
		for (Field field : t.getClass().getDeclaredFields()) {
			field.setAccessible(true);// 权限
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
			field.setAccessible(true);// 权限
			try {
				if (field.get(t) == null) {
					continue;
				}
				if (("id").equals(field.getName())) {
					id = (Integer) field.get(t);
					continue;
				}
				// 拼接成 ：变量名='值' 的形式
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

}
