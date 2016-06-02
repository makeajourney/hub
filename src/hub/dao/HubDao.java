package hub.dao;

import javax.sql.DataSource;

public class HubDao {
	DataSource ds;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
}
