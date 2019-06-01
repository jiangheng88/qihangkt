package cn.bzu.qihangkt.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class QihangKTTest {
	@Test
	public void test() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		DataSource dateResource =  (DataSource) applicationContext.getBean("dataSource");
		System.out.println(dateResource.getClass());
	}
}
