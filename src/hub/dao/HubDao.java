package hub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

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
}
