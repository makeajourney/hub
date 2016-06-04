package hub.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import hub.vo.User;

public class MainController implements Controller {

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = (HttpSession) model.get("session");
		User user = (User) session.getAttribute("user");
		
		if (user == null) {
			return "redirect:./auth/login.do";
		} else {			
			return "main.jsp";
		}
	}

}
