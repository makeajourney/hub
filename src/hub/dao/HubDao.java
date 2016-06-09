package hub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import hub.vo.Article;
import hub.vo.Keyword;
import hub.vo.User;


public class HubDao {
	DataSource ds;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	public User exist(String id, String password) throws Exception {
		/* 있으면  Member 객체 리턴, 없으면 null 리턴 */
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			connection = ds.getConnection();
			stmt = connection.prepareStatement(
					"SELECT ID, NO FROM USER" +
					" WHERE ID=? AND PASSWORD=?");
			stmt.setString(1, id);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if (rs.next()) {
				User user = new User()
						.setId(rs.getString("ID"))
						.setNo(Integer.parseInt(rs.getString("NO")));
				return user;
			}
			else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		} finally {
			try { if (rs != null) rs.close();} catch (Exception e){}
			try { if (stmt != null) stmt.close();} catch (Exception e){}
			try {if (connection != null) connection.close(); } catch(Exception e) {}
		}
	}
	
	public int signUp(String id, String password) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = ds.getConnection();
			stmt = connection.prepareStatement(
					"INSERT INTO USER(ID, PASSWORD)"
					+ " VALUES (?,?)");
			stmt.setString(1, id);
			stmt.setString(2, password);

			return stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			try {if (stmt != null) stmt.close();} catch(Exception e) {}
			try {if (connection != null) connection.close(); } catch(Exception e) {}
		}
	}
	
	// 사용자가 추가한 단어들을 가져옴.
	public List<Keyword> getUserKeyword(String id) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			connection = ds.getConnection();
			stmt = connection.prepareStatement(
					"SELECT K.NO, K.WORD FROM KEYWORD K,USER_KEYWORD UK" +
					" WHERE K.NO = UK.KEYWORD_NO AND UK.USER_NO = (SELECT NO FROM USER WHERE ID=?)");
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			
			ArrayList<Keyword> keywords = new ArrayList<Keyword>();
			
			while (rs.next()) {
				keywords.add(new Keyword()
						.setNo(Integer.parseInt(rs.getString("K.NO")))
						.setWord(rs.getString("K.WORD")));
			}
			return keywords;
		} catch (Exception e) {
			throw e;
		} finally {
			try { if (rs != null) rs.close();} catch(Exception e) {}
			try { if (stmt != null) stmt.close();} catch(Exception e) {}
			try { if (connection != null) connection.close(); } catch (Exception e) {}
		}
	}
	
	public int addUserKeyword(User user, Keyword keyword) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		
		Keyword temp = getKeywordNo(keyword);

		try {
			connection = ds.getConnection();
			stmt = connection.prepareStatement(
					"INSERT INTO USER_KEYWORD (USER_NO, KEYWORD_NO)"
					+ " VALUES (?,?)");
			stmt.setInt(1, user.getNo());
			stmt.setInt(2, temp.getNo());

			return stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			try {if (stmt != null) stmt.close();} catch(Exception e) {}
			try {if (connection != null) connection.close(); } catch(Exception e) {}
		}
	}
	
	public Keyword getKeywordNo(Keyword keyword) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			connection = ds.getConnection();
			stmt = connection.prepareStatement(
					"SELECT WORD, NO FROM KEYWORD WHERE WORD = ?");
			stmt.setString(1, keyword.getWord());
			
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				keyword.setNo(Integer.parseInt(rs.getString("NO")));
				System.out.println(rs.getString("NO"));
				return keyword;
			} else {				
				return null;
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			try { if (rs != null) rs.close();} catch(Exception e) {}
			try { if (stmt != null) stmt.close();} catch(Exception e) {}
			try { if (connection != null) connection.close(); } catch (Exception e) {}
		}
	}
	
	public int deleteUserKeyword(User user, Keyword keyword) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		
		Keyword temp = getKeywordNo(keyword);
		
		try {
			connection = ds.getConnection();
			stmt = connection.prepareStatement(
					"DELETE FROM USER_KEYWORD"+ 
					" WHERE USER_NO = ? AND KEYWORD_NO =?");
			stmt.setInt(1, user.getNo());
			stmt.setInt(2, temp.getNo());
					
			return stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			try { if (stmt != null) stmt.close();} catch(Exception e) {}
			try {if (connection != null) connection.close(); } catch(Exception e) {}
		}
	}
	
	public void getArticle(Keyword keyword, ArrayList<Article> articles) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		/*
		 * 	protected int no;
	protected String title;
	protected String url;
	protected String content;
	protected Date postTime;
		 */
		try {
			connection = ds.getConnection();
			stmt = connection.prepareStatement(
					"SELECT A.NO, A.TITLE, A.URL, A.POST_TIME FROM ARTICLE A, ARTICLE_KEYWORD AK" +
					" WHERE A.NO = AK.ARTICLE_NO AND A.POST_TIME AND AK.KEYWORD_NO = ?" +
					" ORDER BY A.POST_TIME DESC LIMIT 8");
			stmt.setInt(1, keyword.getNo());
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				articles.add(new Article()
						.setNo(Integer.parseInt(rs.getString("A.NO")))
						.setTitle(rs.getString("A.TITLE"))
						.setUrl(rs.getString("A.URL"))
						.setPostTime(rs.getDate("A.POST_TIME"))
						.setKeywordNo(keyword.getNo()));
				System.out.println(rs.toString());
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try { if (rs != null) rs.close();} catch(Exception e) {}
			try { if (stmt != null) stmt.close();} catch(Exception e) {}
			try { if (connection != null) connection.close(); } catch (Exception e) {}
		}
	}
	
	
}
