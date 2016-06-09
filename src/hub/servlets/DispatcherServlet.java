package hub.servlets;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hub.controls.AddUserKeywordAjaxController;
import hub.controls.Controller;
import hub.controls.DeleteUserKeywordAjaxController;
import hub.controls.LoginController;
import hub.controls.LogoutController;
import hub.controls.MainController;
import hub.vo.Keyword;
import hub.vo.User;


@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		String servletPath = request.getServletPath();
		
		try {
			ServletContext sc = this.getServletContext();
			
			HashMap<String, Object> model = new HashMap<String, Object>();
			model.put("hubDao", sc.getAttribute("hubDao"));
			model.put("session", request.getSession());
			
			String pageControllerPath = null;
			Controller pageController = null;
			
			//
			if ("/main.do".equals(servletPath)) {
				pageController = new MainController();
			} else if ("/addUserKeyword.do".equals(servletPath)) {
				pageController = new AddUserKeywordAjaxController();
				if(request.getParameter("keyword") != null) {
					model.put("keyword", new Keyword()
							.setWord(URLDecoder.decode(request.getParameter("keyword"))));
				}
			} else if ("/deleteUserKeyword.do".equals(servletPath)) {
				pageController = new DeleteUserKeywordAjaxController();
				if(request.getParameter("keyword") != null) {
					model.put("keyword", new Keyword()
							.setWord(URLDecoder.decode(request.getParameter("keyword"))));
				}
			}
			else if ("/auth/login.do".equals(servletPath)) {
				pageController = new LoginController();
				if (request.getParameter("id") != null) {
					model.put("loginInfo", new User()
						.setId(request.getParameter("id"))
						.setPassword(request.getParameter("password")));
					model.put("password2", request.getParameter("password2"));
				}
			} else if ("/auth/logout.do".equals(servletPath)) {
				pageController = new LogoutController();
			}
			
			String viewUrl = pageController.execute(model);
			
			for (String key : model.keySet()) {
				request.setAttribute(key, model.get(key));
			}
			if (viewUrl.startsWith("redirect:")) {
				response.sendRedirect(viewUrl.substring(9));
				return;
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
				rd.include(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}
}
