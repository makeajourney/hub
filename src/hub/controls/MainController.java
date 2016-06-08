package hub.controls;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import hub.dao.HubDao;
import hub.vo.Article;
import hub.vo.Keyword;
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
			HubDao hubDao = (HubDao) model.get("hubDao");
			ArrayList<Keyword> keywords = (ArrayList<Keyword>) hubDao.getUserKeyword(user.getId());
			
			model.put("keywords", keywords);
			
			ArrayList<Article> articles = new ArrayList<Article>();
			for (int i = 0; i < keywords.size(); i ++) {
				hubDao.getArticle(keywords.get(i), articles);
			}
			model.put("articles", articles);
			return "main.jsp";
		}
	}

}
