package hub.vo;

public class UserKeyword {
/*
 * user_no int not null,
    keyword_no int not null,
 */
	protected int userNo;
	protected int keywordNo;
	
	public int getUserNo() {
		return userNo;
	}
	public UserKeyword setUser_no(int userNo) {
		this.userNo = userNo;
		return this;
	}
	public int getKeywordNo() {
		return keywordNo;
	}
	public UserKeyword setKeywordNo(int keywordNo) {
		this.keywordNo = keywordNo;
		return this;
	}
}
