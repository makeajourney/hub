package hub.vo;

public class Keyword {
/*8
 * no int primary key not null auto_increment,
    word varchar(50) not null,
 */
	
	protected int no;
	protected String word;
	
	public int getNo() {
		return no;
	}
	public Keyword setNo(int no) {
		this.no = no;
		return this;
	}
	public String getWord() {
		return word;
	}
	public Keyword setWord(String word) {
		this.word = word;
		return this;
	}
}
