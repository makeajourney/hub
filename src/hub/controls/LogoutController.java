package hub.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

public class LogoutController implements Controller {
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = (HttpSession) model.get("session");
		session.invalidate();	// session object  무효화

		return "redirect:login.do";
	}
}