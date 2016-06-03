package hub.vo;

import java.util.Date;

public class User {
/*
 * no int primary key not null auto_increment,
    id varchar(50) not null,
    password varchar(50) not null,
    create_time datetime default now()
 */
	protected int no;
	protected String id;
	protected String password;
	protected Date createTime;
	
	public int getNo() {
		return no;
	}
	
	public User setNo(int no) {
		this.no = no;
		return this;
	}
	
	public String getId() {
		return id;
	}
	
	public User setId(String id) {
		this.id = id;
		return this;
	}
	
	public String getPassword() {
		return password;
	}
	
	public User setPassword(String password) {
		this.password = password;
		return this;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public User setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}
}
