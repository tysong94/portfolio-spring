package kr.ac.kopo.board.web.resort;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionController {
	
	private static final Logger logger = LoggerFactory.getLogger(Controller_d.class);
	
	@RequestMapping(value = "/setSession")
	public String setSession(Model model, HttpSession session) {
		logger.info("setSession.");
		
		session.setAttribute("userId", 123);
		
		return "resort/setSession";
	}
	
	@RequestMapping(value = "/getSession")
	public String getSession(Model model, HttpSession session) {
		logger.info("getSession.");
		
		int userId = (int) session.getAttribute("userId");
		System.out.println("userId : " + userId);
		
		model.addAttribute("userId", userId);
		
		return "resort/getSession";
	}
}
