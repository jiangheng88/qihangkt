package cn.bzu.qihangkt.service;

import java.util.List;

import cn.bzu.qihangkt.entity.Resource;

public interface ResourceService extends BaseService<Resource>{
	
	
	//根据路径名查询该路径的数量
	public int selectCount(String path);

	
	// 将路径添加到数据库中
	public void addPath(List<String> resources); 	
	
}
