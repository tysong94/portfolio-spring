package kr.ac.kopo.board.web.resort;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.ac.kopo.board.domain.Reservation;
import kr.ac.kopo.board.domain.Room;
import kr.ac.kopo.board.domain.User;
import kr.ac.kopo.board.service.ReservationService;
import kr.ac.kopo.board.service.RoomService;
import kr.ac.kopo.board.service.UserService;
import kr.ac.kopo.board.vo.ReservationVO;

@Controller
public class Controller_d {
	
	private static final Logger logger = LoggerFactory.getLogger(Controller_d.class);
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private UserService userService;
	
	// ���� ����Ʈ
	@RequestMapping(value = "/reservationList")
	public String reservationList(Locale locale, @RequestParam Map<String, String> param, Model model) {
		
		List<ReservationVO> reservationVOs = reservationService.setReservationVOs();
		model.addAttribute("reservationVOs", reservationVOs);

		return "resort/d1_reservationList";
	}
	
	// ���� �߰� ȭ��
	@RequestMapping(value = "/reservationNew")
	public String reservationNew(Locale locale, @RequestParam Map<String, String> param, Model model, HttpSession session, HttpServletRequest request, RedirectAttributes attributes) throws ParseException {
		//
		if(session.getAttribute("sessionUser") == null) {
			session.setAttribute("jumpPage", "/reservationNew");
			return "redirect:/loginForm";
		} else {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");

			// ���� ����Ʈ ��������
			List<ReservationVO> rVOs = reservationService.setReservationVOs();
			
			// ��ü ����Ʈ ��������(�����, ��¥, �����)
			List<User> users = userService.selectAll();
			
			// ���� ��¥, ���� �� �Ķ����(������ �⺻��)
			String reserve_date = sdf.format(cal.getTime());
			int reserve_room = 1;
			if(param.get("date") != null) reserve_date = param.get("date");
			if(param.get("room") != null) reserve_room = Integer.parseInt(param.get("room"));
			
			// �� ����
			model.addAttribute("rVOs", rVOs);
			model.addAttribute("users", users);
			model.addAttribute("reserve_date", reserve_date);
			model.addAttribute("reserve_room", reserve_room);
			
			return "resort/d2_reservationNew";
		}
	}
	
	// ���� �߰� ����
	@RequestMapping(value = "/reservationCreate", method = RequestMethod.POST)
	public String reservationCreate(Locale locale, @RequestParam Map<String, String> param, Model model) throws ParseException {
		// ������, ���೯¥, �����, ���� �� �Ķ���� �ޱ�
		User user = userService.selectOne(Long.parseLong(param.get("user")));
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(param.get("date"));
		Room room = roomService.selectOne(Integer.parseInt(param.get("room")));
		String comment = param.get("comment");
		
		if(reservationService.selectOneByDateRoom(date, Integer.parseInt(param.get("room"))) == null) {
			Reservation reservation = new Reservation();
			reservation.setUser(user);
			reservation.setDate(date);
			reservation.setRoom(room);
			reservation.setComment(comment);
			reservationService.createOne(reservation);
		} else {
			model.addAttribute("msg", "������ á���ϴ�.");
			return "resort/alert";
		}
		
		return "redirect:/reservationList";
	}
	
	// ���� ���� ȭ��
	@RequestMapping(value = "/reservationEdit")
	public String reservationEdit(Locale locale, @RequestParam Map<String, String> param, Model model) throws ParseException {
		// ��ü ����Ʈ ��������(�����, ��¥, �����)
		List<User> users = userService.selectAll();
		List<String> dates = reservationService.dates();
		List<Room> rooms = roomService.selectAll();
		
		// ������ ���� �޾ƿ���
		Reservation rsvn = reservationService.selectOne(Long.parseLong(param.get("rid")));
		
		// �� ����
		model.addAttribute("users", users);
		model.addAttribute("dates", dates);
		model.addAttribute("rooms", rooms);
		model.addAttribute("rsvn", rsvn);
		
		return "resort/d3_reservationEdit";
	}
	
	// ���� ���� ����
	@RequestMapping(value = "/reservationUpdate", method = RequestMethod.POST)
	public String reservationUpdate(Locale locale, @RequestParam Map<String, String> param, Model model) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");
	
		User user = userService.selectOne(Long.parseLong(param.get("user")));
		Date date = sdf.parse(param.get("date"));
		Room room = roomService.selectOne(Long.parseLong(param.get("room")));
		String comment = param.get("comment");

		Reservation old_reserve = reservationService.selectOne(Long.parseLong(param.get("id")));
		Reservation check_reserve = reservationService.selectOneByDateRoom(date, Integer.parseInt(param.get("room")));
		
		// �ߺ��� ���� �� or �ڱ� �ڽŰ� �ߺ��� ��(������ �ٲ�)
		if(check_reserve == null || check_reserve.getId() == old_reserve.getId())  {
			old_reserve.setUser(user);
			old_reserve.setDate(date);
			old_reserve.setRoom(room);
			old_reserve.setComment(comment);
			reservationService.updateOne(old_reserve);
		} else {
			model.addAttribute("msg", "���� ������ �ֽ��ϴ�.");
			return "resort/alert";
		}
		
		return "redirect:/reservationList";
	}
	
	// ���� ���� ����
	@RequestMapping(value = "/reservationDelete")
	public String reservationDelete(@RequestParam Map<String, String> param) {
		Reservation rsvn = reservationService.selectOne(Long.parseLong(param.get("rid")));
		reservationService.deleteOne(rsvn);

		return "redirect:/reservationList";
	}
	
	// ������������
	@RequestMapping(value = "/admin")
	public String admin(Model model, HttpSession session) {
		String auth = (String) session.getAttribute("auth");
		
		// ������ ���� ��, �����ڰ� �ƴ� ��
		if(auth == null || !auth.equals("admin")) {
			model.addAttribute("msg", "�����ڰ� �ƴմϴ�.");
			return "resort/alert";
			// �������� ��
		} else {
			List<ReservationVO> reservationVOs = reservationService.setReservationVOs();
			model.addAttribute("reservationVOs", reservationVOs);
			model.addAttribute("auth", auth);
			return "resort/d4_admin";
		}
	}
}
