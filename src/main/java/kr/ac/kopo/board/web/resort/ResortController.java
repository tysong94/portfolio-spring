package kr.ac.kopo.board.web.resort;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.kopo.board.domain.Reservation;
import kr.ac.kopo.board.domain.Room;
import kr.ac.kopo.board.domain.User;
import kr.ac.kopo.board.service.ReservationService;
import kr.ac.kopo.board.service.RoomService;
import kr.ac.kopo.board.service.UserService;
import kr.ac.kopo.board.vo.ReservationVO;

@Controller
public class ResortController {
	
	private static final Logger logger = LoggerFactory.getLogger(ResortController.class);
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private UserService userService;
	
	//-----a--------------------------------------------------------	
	// 메인 페이지
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "resort/main";
	}
	
	
	// 메인 페이지
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(Locale locale, Model model) {
		
		return "resort/main";
	}
	
	// VIP룸
	@RequestMapping(value = "/vip", method = RequestMethod.GET)
	public String vip(Locale locale, Model model) {
		
		return "resort/a1_vip";
	}
	
	// 일반룸
	@RequestMapping(value = "/common", method = RequestMethod.GET)
	public String common(Locale locale, Model model) {
		
		return "resort/a2_common";
	}

	// 합리적인룸
	@RequestMapping(value = "/reasonable", method = RequestMethod.GET)
	public String reasonable(Locale locale, Model model) {
		
		return "resort/a3_reasonable";
	}

	//-----b--------------------------------------------------------
	// 찾아오는길
	@RequestMapping(value = "/way", method = RequestMethod.GET)
	public String way(Locale locale, Model model) {
		
		return "resort/b1_way";
	}
	// 대중교통
	@RequestMapping(value = "/publicc", method = RequestMethod.GET)
	public String publicc(Locale locale, Model model) {
		
		return "resort/b2_public";
	}
	// 자가용
	@RequestMapping(value = "/own", method = RequestMethod.GET)
	public String own(Locale locale, Model model) {
		
		return "resort/b3_own";
	}
	
	//-----관광명소--------------------------------------------------------
	// 찾아오는길
	@RequestMapping(value = "/attractions1", method = RequestMethod.GET)
	public String attractions1(Locale locale, Model model) {
		
		return "resort/c1_attractions";
	}
	// 대중교통
	@RequestMapping(value = "/attractions2", method = RequestMethod.GET)
	public String attractions2(Locale locale, Model model) {
		
		return "resort/c2_attractions";
	}
	// 자가용
	@RequestMapping(value = "/attractions3", method = RequestMethod.GET)
	public String attractions3(Locale locale, Model model) {
		
		return "resort/c3_attractions";
	}
	
	//-----동적--------------------------------------------------------
	// 예약 리스트
	@RequestMapping(value = "/reservationList", method = RequestMethod.GET)
	public String reservationList(Locale locale, @RequestParam Map<String, String> param, Model model) {
		
		List<ReservationVO> reservationVOs = reservationService.setReservations();
		model.addAttribute("reservationVOs", reservationVOs);

		return "resort/d1_reservationList";
	}
	
	// 예약 화면
	@RequestMapping(value = "/reservationForm", method = RequestMethod.GET)
	public String reservationForm(Locale locale, @RequestParam Map<String, String> param, Model model) throws ParseException {
		// 전체 리스트 가져오기(사용자, 날짜, 예약실)
		List<User> all_users = userService.selectAll();
		List<String> all_dates = reservationService.dates();
		List<Room> all_rooms = roomService.selectAll();
		
		// 날짜, 방 파라미터 받기
		String reserve_date = param.get("date");
		int reserve_room = Integer.parseInt(param.get("room"));
		
		model.addAttribute("all_users", all_users);
		model.addAttribute("all_dates", all_dates);
		model.addAttribute("reserve_date", reserve_date);
		model.addAttribute("all_rooms", all_rooms);
		model.addAttribute("reserve_room", reserve_room);
		
		return "resort/d2_reservationForm";
	}
	
	// 예약 동작
	@RequestMapping(value = "/reservation", method = RequestMethod.POST)
	public String reservation(Locale locale, @RequestParam Map<String, String> param, Model model) throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
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
	
}
