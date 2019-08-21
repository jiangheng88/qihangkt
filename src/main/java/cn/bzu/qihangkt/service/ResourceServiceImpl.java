package cn.bzu.qihangkt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bzu.qihangkt.dao.BaseDao;
import cn.bzu.qihangkt.dao.ResourceDao;
import cn.bzu.qihangkt.entity.Resource;
import cn.bzu.qihangkt.web.AuthClass;

@Service("resourceService")
public class ResourceServiceImpl extends BaseServiceImpl<Resource> implements ResourceService {

	@Autowired
	private ResourceDao resourceDao;

	// 通过名字查询该路径的条数
	@Override
	public int selectCount(String path) {

		return resourceDao.selectCount(path);
	}

	@Override
	public BaseDao<Resource> getBaseDao() {
		// TODO Auto-generated method stub
		return resourceDao;
	}

	@Override
	public void addPath(List<String> resources) {

		for (String res : resources) {
			int count = 0;
			count = this.selectCount(res);
			if (count == 0) {
				this.add(new Resource(res));
			}

		}

	}

}
