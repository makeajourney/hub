package hub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

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
					"SELECT ID FROM USER" +
					" WHERE ID=? AND PASSWORD=?");
			stmt.setString(1, id);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if (rs.next()) {
				User user = new User().setId(rs.getString("ID"));
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
	
	// 사용자가 추가한 단어들을 가져옴.
	public List<Keyword> getUserKeyword(String id) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			connection = ds.getConnection();
			stmt = connection.prepareStatement(
					"SELECT WORD FROM KEYWORD K,USER_KEYWORD UK" +
					" WHERE K.NO = UK.NO AND UK.NO = (SELECT NO FROM USER WHERE ID=?)");
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			
			ArrayList<Keyword> keywords = new ArrayList<Keyword>();
			
			while (rs.next()) {
				keywords.add(new Keyword()
						.setWord(rs.getString("KEYWORD")));
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
}
