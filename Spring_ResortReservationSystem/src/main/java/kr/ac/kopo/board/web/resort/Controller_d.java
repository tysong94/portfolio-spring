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
	
	// 예약 리스트
	@RequestMapping(value = "/reservationList")
	public String reservationList(Locale locale, @RequestParam Map<String, String> param, Model model) {
		
		List<ReservationVO> reservationVOs = reservationService.setReservationVOs();
		model.addAttribute("reservationVOs", reservationVOs);

		return "resort/d1_reservationList";
	}
	
	// 예약 추가 화면
	@RequestMapping(value = "/reservationNew")
	public String reservationNew(Locale locale, @RequestParam Map<String, String> param, Model model, HttpSession session, HttpServletRequest request, RedirectAttributes attributes) throws ParseException {
		//
		if(session.getAttribute("sessionUser") == null) {
			session.setAttribute("jumpPage", "/reservationNew");
			return "redirect:/loginForm";
		} else {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");

			// 예약 리스트 가져오기
			List<ReservationVO> rVOs = reservationService.setReservationVOs();
			
			// 전체 리스트 가져오기(사용자, 날짜, 예약실)
			List<User> users = userService.selectAll();
			
			// 예약 날짜, 예약 방 파라미터(없으면 기본값)
			String reserve_date = sdf.format(cal.getTime());
			int reserve_room = 1;
			if(param.get("date") != null) reserve_date = param.get("date");
			if(param.get("room") != null) reserve_room = Integer.parseInt(param.get("room"));
			
			// 모델 생성
			model.addAttribute("rVOs", rVOs);
			model.addAttribute("users", users);
			model.addAttribute("reserve_date", reserve_date);
			model.addAttribute("reserve_room", reserve_room);
			
			return "resort/d2_reservationNew";
		}
	}
	
	// 예약 추가 동작
	@RequestMapping(value = "/reservationCreate", method = RequestMethod.POST)
	public String reservationCreate(Locale locale, @RequestParam Map<String, String> param, Model model) throws ParseException {
		// 예약자, 예약날짜, 예약실, 남길 말 파라미터 받기
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
			model.addAttribute("msg", "예약이 찼습니다.");
			return "resort/alert";
		}
		
		return "redirect:/reservationList";
	}
	
	// 예약 수정 화면
	@RequestMapping(value = "/reservationEdit")
	public String reservationEdit(Locale locale, @RequestParam Map<String, String> param, Model model) throws ParseException {
		// 전체 리스트 가져오기(사용자, 날짜, 예약실)
		List<User> users = userService.selectAll();
		List<String> dates = reservationService.dates();
		List<Room> rooms = roomService.selectAll();
		
		// 수정할 예약 받아오기
		Reservation rsvn = reservationService.selectOne(Long.parseLong(param.get("rid")));
		
		// 모델 생성
		model.addAttribute("users", users);
		model.addAttribute("dates", dates);
		model.addAttribute("rooms", rooms);
		model.addAttribute("rsvn", rsvn);
		
		return "resort/d3_reservationEdit";
	}
	
	// 예약 수정 동작
	@RequestMapping(value = "/reservationUpdate", method = RequestMethod.POST)
	public String reservationUpdate(Locale locale, @RequestParam Map<String, String> param, Model model) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");
	
		User user = userService.selectOne(Long.parseLong(param.get("user")));
		Date date = sdf.parse(param.get("date"));
		Room room = roomService.selectOne(Long.parseLong(param.get("room")));
		String comment = param.get("comment");

		Reservation old_reserve = reservationService.selectOne(Long.parseLong(param.get("id")));
		Reservation check_reserve = reservationService.selectOneByDateRoom(date, Integer.parseInt(param.get("room")));
		
		// 중복이 없을 때 or 자기 자신과 중복될 때(유저만 바뀜)
		if(check_reserve == null || check_reserve.getId() == old_reserve.getId())  {
			old_reserve.setUser(user);
			old_reserve.setDate(date);
			old_reserve.setRoom(room);
			old_reserve.setComment(comment);
			reservationService.updateOne(old_reserve);
		} else {
			model.addAttribute("msg", "기존 예약이 있습니다.");
			return "resort/alert";
		}
		
		return "redirect:/reservationList";
	}
	
	// 예약 삭제 동작
	@RequestMapping(value = "/reservationDelete")
	public String reservationDelete(@RequestParam Map<String, String> param) {
		Reservation rsvn = reservationService.selectOne(Long.parseLong(param.get("rid")));
		reservationService.deleteOne(rsvn);

		return "redirect:/reservationList";
	}
	
	// 관리자페이지
	@RequestMapping(value = "/admin")
	public String admin(Model model, HttpSession session) {
		String auth = (String) session.getAttribute("auth");
		
		// 권한이 없을 때, 관리자가 아닐 때
		if(auth == null || !auth.equals("admin")) {
			model.addAttribute("msg", "관리자가 아닙니다.");
			return "resort/alert";
			// 관리자일 때
		} else {
			List<ReservationVO> reservationVOs = reservationService.setReservationVOs();
			model.addAttribute("reservationVOs", reservationVOs);
			model.addAttribute("auth", auth);
			return "resort/d4_admin";
		}
	}
}
