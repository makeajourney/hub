package hub.vo;

public class ArticleKeyword {
/*
 * article_no int not null,
    keyword_no int not null,
 */
	protected int articleNo;
	protected int keywordNo;
	
	public int getArticleNo() {
		return articleNo;
	}
	public ArticleKeyword  setArticleNo(int articleNo) {
		this.articleNo = articleNo;
		return this;
	}
	public int getKeywordNo() {
		return keywordNo;
	}
	public ArticleKeyword setKeywordNo(int keywordNo) {
		this.keywordNo = keywordNo;
		return this;
	}
}
