package cn.bzu.qihangkt.test;

import java.io.IOException;
import java.io.InputStream;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.bzu.qihangkt.dao.UserDao;
import cn.bzu.qihangkt.entity.User;


public class QihangKTTest {
	@Test
	public void test() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		DataSource dateResource =  (DataSource) applicationContext.getBean("dataSource");
		System.out.println(dateResource.getClass());
		
		InputStream in =null;
		try {
			in = Resources.getResourceAsStream("mybatis-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * SqlSessionFactory sqlSessionFactory = new
		 * SqlSessionFactoryBuilder().build(in); SqlSession session =
		 * sqlSessionFactory.openSession(); UserDao dao =
		 * session.getMapper(UserDao.class);
		 * 
		 * User user =dao.getUserAllInfo("jiangheng"); System.out.println(user);
		 */
		
		UserDao dao1 = applicationContext.getBean(UserDao.class);
		User user1 = dao1.getUserAllInfo("jiangheng");
		System.out.println(user1);
		
		
	}
}
