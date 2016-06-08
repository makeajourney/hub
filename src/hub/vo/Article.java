package hub.vo;

import java.util.Date;

public class Article {
/*
 * no int primary key not null auto_increment,
    title varchar(200) not null,
    url varchar(150) not null,
    content text,
    post_time datetime not null,
    board_no int not null,
 */
	protected int no;
	protected String title;
	protected String url;
	protected String content;
	protected Date postTime;
	protected int boardNo;
	protected int keywordNo;
	
	public int getNo() {
		return no;
	}
	public Article setNo(int no) {
		this.no = no;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public Article setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getUrl() {
		return url;
	}
	public Article setUrl(String url) {
		this.url = url;
		return this;
	}
	public String getContent() {
		return content;
	}
	public Article setContent(String content) {
		this.content = content;
		return this;
	}
	public Date getPostTime() {
		return postTime;
	}
	public Article setPostTime(Date postTime) {
		this.postTime = postTime;
		return this;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public Article setBoardNo(int boardNo) {
		this.boardNo = boardNo;
		return this;
	}
	public int getKeywordNo() {
		return keywordNo;
	}
	public Article setKeywordNo(int keywordNo) {
		this.keywordNo = keywordNo;
		return this;
	}
}
