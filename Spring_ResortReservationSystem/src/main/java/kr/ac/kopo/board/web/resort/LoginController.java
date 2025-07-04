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
	
	// ���� ������
	@RequestMapping(value = "/")
	public String home(Locale locale, @RequestParam Map<String, String> param, Model model) {
		return "redirect:/main";
	}
	
	// �α��� �ۼ� ȭ��
	@RequestMapping(value = "/loginForm")
	public String login(Model model, HttpServletRequest request, HttpSession session) {
		if(session.getAttribute("sessionUser") == null) {
			// ���� ������ ����ϱ�
			String referer = request.getHeader("Referer");
			request.getSession().setAttribute("prevPage", referer);
			
			return "resort/loginForm";
		} else {
			logger.info("userid : " + session.getAttribute("userid"));
			model.addAttribute("msg", "�̹� �α��� �Ǿ��ֽ��ϴ�.");
			return "resort/alert";
		}
	}
	
	// �α��� ����
	@RequestMapping(value = "/login")
	public String login(Model model, @RequestParam Map<String, String> param, HttpSession session, HttpServletRequest request) {
		String userid = param.get("userid");
		String password = param.get("password");
		User user = userService.selectOne(userid);
		
		//�α��� ���� 
		if(user != null && user.getPassword().equals(password)) {
			session.setAttribute("sessionUser", user);
			//���� ������, ���� ������ ��������
			String prevPage = (String) request.getSession().getAttribute("prevPage");
			String jumpPage = (String) request.getSession().getAttribute("jumpPage");
			logger.info("prevPage : " + prevPage);
			logger.info("jumpPage : " + jumpPage);
			
			if(jumpPage == null)return "redirect:" + prevPage;
			else 				return "redirect:" + jumpPage;
		// �α��� ����
		} else {
			model.addAttribute("msg", "���̵� �Ǵ� ��й�ȣ�� ���� �ʽ��ϴ�.");
			return "resort/alert";
		}
	}
	
	// �α׾ƿ� ����
	@RequestMapping(value = "/logout")
	public String logout(Model model, @RequestParam Map<String, String> param, HttpSession session) {
		session.invalidate();
		model.addAttribute("msg", "�α׾ƿ� �Ǿ����ϴ�.");
		return "redirect:/main";
	}
}
