package kr.ac.kopo.board.web.resort;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.board.domain.User;
import kr.ac.kopo.board.service.ReservationService;
import kr.ac.kopo.board.service.RoomService;
import kr.ac.kopo.board.service.UserService;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(Controller_d.class);
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private UserService userService;
	
	// 메인 페이지
	@RequestMapping(value = "/")
	public String home(Locale locale, @RequestParam Map<String, String> param, Model model) {
		return "redirect:/main";
	}
	
	// 로그인 작성 화면
	@RequestMapping(value = "/loginForm")
	public String login(Model model, HttpServletRequest request, HttpSession session) {
		if(session.getAttribute("sessionUser") == null) {
			// 이전 페이지 기억하기
			String referer = request.getHeader("Referer");
			request.getSession().setAttribute("prevPage", referer);
			
			return "resort/loginForm";
		} else {
			logger.info("userid : " + session.getAttribute("userid"));
			model.addAttribute("msg", "이미 로그인 되어있습니다.");
			return "resort/alert";
		}
	}
	
	// 로그인 동작
	@RequestMapping(value = "/login")
	public String login(Model model, @RequestParam Map<String, String> param, HttpSession session, HttpServletRequest request) {
		String userid = param.get("userid");
		String password = param.get("password");
		User user = userService.selectOne(userid);
		
		//로그인 성공 
		if(user != null && user.getPassword().equals(password)) {
			session.setAttribute("sessionUser", user);
			//이전 페이지, 점프 페이지 가져오기
			String prevPage = (String) request.getSession().getAttribute("prevPage");
			String jumpPage = (String) request.getSession().getAttribute("jumpPage");
			logger.info("prevPage : " + prevPage);
			logger.info("jumpPage : " + jumpPage);
			
			if(jumpPage == null)return "redirect:" + prevPage;
			else 				return "redirect:" + jumpPage;
		// 로그인 실패
		} else {
			model.addAttribute("msg", "아이디 또는 비밀번호가 맞지 않습니다.");
			return "resort/alert";
		}
	}
	
	// 로그아웃 동작
	@RequestMapping(value = "/logout")
	public String logout(Model model, @RequestParam Map<String, String> param, HttpSession session) {
		session.invalidate();
		model.addAttribute("msg", "로그아웃 되었습니다.");
		return "redirect:/main";
	}
}
