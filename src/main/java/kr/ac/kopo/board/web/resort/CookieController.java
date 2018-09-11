package kr.ac.kopo.board.web.resort;

import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {
	
	private static final Logger logger = LoggerFactory.getLogger(Controller_d.class);
	
	// jsp_setCookie
	@RequestMapping(value = "/jsp_setCookie")
	public String jsp_setCookie(Locale locale, Model model) {
		return "resort/jsp_setCookie";
	}
	// jsp_getCookie
	@RequestMapping(value = "/jsp_getCookie")
	public String jsp_getCookie(Locale locale, Model model) {
		return "resort/jsp_getCookie";
	}
	// jsp_delCookie
	@RequestMapping(value = "/jsp_delCookie")
	public String jsp_delCookie(Locale locale, Model model) {
		return "resort/jsp_delCookie";
	}
	
	// spring_setCookie
	@RequestMapping(value = "/spring_setCookie")
	public String spring_setCookie(Locale locale, Model model, HttpServletResponse response) {
		logger.info("set_Cookie");
		
		Cookie userIdCookie = new Cookie("userIdCookie", "777");
		userIdCookie.setPath("/");
		userIdCookie.setMaxAge(60 * 60 * 24 * 30);	//한 달 지속
		response.addCookie(userIdCookie);
		
		return "resort/spring_setCookie";
	}
	// spring_getCookie
	@RequestMapping(value = "/spring_getCookie")
	public String spring_getCookie(Locale locale, Model model,  @CookieValue(value="userIdCookie", required = false) Cookie userIdCookie) {
		logger.info("get_Cookie");
		
		if(userIdCookie != null) {
			System.out.println("userIdCookie : " + userIdCookie.getValue());
		}

		model.addAttribute("userIdCookie", userIdCookie.getValue());
		
		return "resort/spring_getCookie";
	}
	
	
}
