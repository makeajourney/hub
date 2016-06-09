package hub.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import hub.dao.HubDao;
import hub.vo.User;

public class LoginController implements Controller {
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		if (model.get("loginInfo") == null) { // 입력폼을 요청할 때
			return "/auth/LogInForm.jsp";
		
		} else {
			HubDao hubDao = (HubDao)model.get("hubDao"); 
			User loginInfo = (User)model.get("loginInfo");
			
			// login 
			if (model.get("password2") == null) {
				User user = hubDao.exist(
						loginInfo.getId(), 
						loginInfo.getPassword());
				
				if (user != null) {
					HttpSession session = (HttpSession)model.get("session");
					session.setAttribute("user", user);
					return "redirect:../main.do";
				} else {
					return "/auth/LogInFail.jsp";
				}
			} else {
				hubDao.signUp(loginInfo.getId(), loginInfo.getPassword());
				
				return "redirect:../auth/login.do";
			}
		}
	}
}
