package hub.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import hub.dao.HubDao;
import hub.vo.Keyword;
import hub.vo.User;

public class AddUserKeywordAjaxController implements Controller {
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		HubDao hubDao = (HubDao) model.get("hubDao");
		
		HttpSession session = (HttpSession) model.get("session");
		User user = (User) session.getAttribute("user");
		
		Keyword keyword = (Keyword) model.get("keyword");
		
		hubDao.addUserKeyword(user, keyword);
		
		return "";
	}
}
