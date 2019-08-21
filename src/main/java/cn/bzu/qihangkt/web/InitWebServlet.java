package cn.bzu.qihangkt.web;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.bzu.qihangkt.dao.ResourceDao;
import cn.bzu.qihangkt.service.ResourceService;

/**
 * Servlet implementation class InitWebServlet
 */

public class InitWebServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; // spring的ico容器的引用初始化到InitWebServlet类的一个静态方法 private
	static ApplicationContext applicationContext;

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@Override
	public void init() throws ServletException {
		// 第一初始化一个spring容器
		// 获得整个容器中最大的全局属性
		ServletContext setvletContext = getServletContext();
		applicationContext = WebApplicationContextUtils.getWebApplicationContext(setvletContext);

		// 第二初始化权限

		try {
			// packageName实施权限控制的包全名
			String packageName = "cn.bzu.qihangkt.controller"; // 将所有的点换成斜线
			String packageNamePath = packageName.replace(".", "/"); // 拿到packgeNamePath,进一步获得队应服务器上磁盘上的绝对路径
			System.out.println(packageNamePath);
			String packageNameRealPath = this.getClass().getClassLoader().getResource(packageNamePath).getPath();
			System.out.println("在磁盘上的绝对路径是" + packageNameRealPath);
			// 创建文件
			File file = new File(packageNameRealPath);
			// file就是controller在磁盘的这个文件夹 //遍历这个文件夹中的文件
			String[] files = file.list(new FilenameFilter() {

				@Override
				public boolean accept(File dir, String name) {

					if (name.endsWith(".class")) {
						return true;
					}
					return false;
				}
			});

			List<String> resources = new ArrayList<String>();

			for (String classFilename : files) {
				// 删除.class后缀
				classFilename = classFilename.substring(0, classFilename.indexOf(".class"));
				// 拿到真正的类全名
				String classAllpackageName = packageName + "." + classFilename;
				// 得到类的对象
				Class clazz = Class.forName(classAllpackageName);

				// 拿到controller的对象，获得上面的注解

				if (!clazz.isAnnotationPresent(AuthClass.class))
					continue;
				// 剩下的类都是都是由AuthClass注解的类，这些类都需要权限控制 //拿到这些类的方法

				Method[] methods = clazz.getDeclaredMethods();
				for (Method m : methods) {
					if (!m.isAnnotationPresent(AuthMethod.class))
						continue;
					// 都是有@AuthMethod的方法,拿到要保存到permission表里resource字段的值 //剩下的都是有AuthMethod注解的方法

					RequestMapping requestMapping = m.getAnnotation(RequestMapping.class);
					// 将这个注解的第一个值保存到集合中
					resources.add(requestMapping.value()[0]);
				}

			}

			// List<String> resources ： 包含了controller包里，所有被@AuthClass和@AuthMethod共同作用的
			// 方法上面的@RequestMapping的value值，都在里面！

			ResourceService resourceService = applicationContext.getBean(ResourceService.class);

			// 将resource中内容添加到数据库中

			resourceService.addPath(resources);

			// 系统中所有的需要权限控制的方法的权限控制标记
			setvletContext.setAttribute("permission", resources);

		} catch (Exception e) {

		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
