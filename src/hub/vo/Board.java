package hub.vo;

public class Board {
/*
 * no int primary key not null auto_increment,
    name varchar(50) not null,
    url varchar(100) not null,
    community_no int not null,
 */
	protected int no;
	protected String name;
	protected String url;
	protected int communityNo;
	
	public int getNo() {
		return no;
	}
	public Board setNo(int no) {
		this.no = no;
		return this;
	}
	public String getName() {
		return name;
	}
	public Board setName(String name) {
		this.name = name;
		return this;
	}
	public String getUrl() {
		return url;
	}
	public Board setUrl(String url) {
		this.url = url;
		return this;
	}
	public int getCommunityNo() {
		return communityNo;
	}
	public Board setCommunityNo(int communityNo) {
		this.communityNo = communityNo;
		return this;
	}
}
