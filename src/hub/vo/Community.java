package hub.vo;

public class Community {
/*
 * no int primary key not null auto_increment,
    name varchar(50) not null,
    url varchar(100) not null
 */
	protected int no;
	protected String name;
	protected String url;
	
	public int getNo() {
		return no;
	}
	public Community setNo(int no) {
		this.no = no;
		return this;
	}
	public String getName() {
		return name;
	}
	public Community setName(String name) {
		this.name = name;
		return this;
	}
	public String getUrl() {
		return url;
	}
	public Community setUrl(String url) {
		this.url = url;
		return this;
	}
}
