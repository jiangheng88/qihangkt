package cn.bzu.qihangkt.entity;

import org.springframework.stereotype.Component;

@Component
public class Resource {
	private Integer id;
	private String path;
	public Resource() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Resource(String path) {
		super();
		this.path = path;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "Resource [id=" + id + ", path=" + path + "]";
	}
	
}
