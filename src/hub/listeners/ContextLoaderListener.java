package hub.listeners;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import hub.dao.HubDao;

@WebListener
public class ContextLoaderListener implements ServletContextListener{

	// BasicDataSource ds;
	
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		// 웹애플리케이션이 시작될 때 실행
		try {
			ServletContext sc = event.getServletContext();
			
			InitialContext initialContext = new InitialContext();
			DataSource ds = (DataSource) initialContext.lookup("java:comp/env/jdbc/hub");
			
			HubDao hubDao = new HubDao();
			hubDao.setDataSource(ds);
			
			sc.setAttribute("hubDao", hubDao);
			
			System.out.println("ContextLoaderListener -> contextInitialized");
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// 웹애플리케이션이 종료될 때 실행
	}
}
