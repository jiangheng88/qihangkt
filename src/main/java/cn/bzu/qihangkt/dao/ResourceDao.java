package cn.bzu.qihangkt.dao;

import org.apache.ibatis.annotations.Param;

import cn.bzu.qihangkt.entity.Resource;

public interface ResourceDao extends BaseDao<Resource>{
	
	public int selectCount(@Param("path") String path);
}
