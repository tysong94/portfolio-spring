package kr.co.uclick.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.uclick.entity.Phone;
import kr.co.uclick.entity.User;
import kr.co.uclick.service.PhoneService;
import kr.co.uclick.service.UserService;

@Controller
public class PhoneController {

	private static final Logger logger = LoggerFactory.getLogger(PhoneController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private PhoneService phoneService;

	// 전화 검색 동작
	@RequestMapping(value = "phoneSearch")
	public String phoneSearch(@RequestParam Map<String, String> param, Model model) {
		// 전화번호 받기
		String number = param.get("number");
		
		List<Phone> phones = phoneService.findByNumberContaining(number);
		List<User> users = new ArrayList<User>();
		for (Phone phone : phones) {
			if(!users.contains(phone.getUser())) {
				users.add(phone.getUser());
			}
		}
	
		// 유저 모델
		model.addAttribute("users",  users);
		
		return "list";
	}
	
	// 전화 추가 화면
	@RequestMapping(value = "phoneNew")
	public String phoneNew(@RequestParam Map<String, String> param, Model model) {
		int userid = Integer.parseInt(param.get("id"));
		
		model.addAttribute("userid",  userid);
		return "phoneNew";
	}
	
	// 전화 수정 화면
	@RequestMapping(value = "phoneEdit")
	public String phoneEdit(@RequestParam Map<String, String> param, Model model) {
		Long id = Long.parseLong(param.get("id"));
		
		Phone phone = phoneService.findById(id);

		model.addAttribute("phone",  phone);
		return "phoneEdit";
	}
	
	// 전화 추가, 수정 동작
	@RequestMapping(value = "savePhone")
	public String savePhone(@RequestParam Map<String, String> param, HttpServletRequest request, Model model) {
		 String referer = request.getHeader("Referer");
		 // 사용자, 전화 정보 파라미터 받기
		 Long userid = Long.parseLong(param.get("userid"));
		 User user = userService.findById(userid);
		 Long phoneid = Long.parseLong(param.get("phoneid"));
		 String carrier = param.get("carrier");
		 String number = param.get("number");
		 
		// 전화 추가
		if(phoneid == 0) {
			// 중복 없을 때
			if(phoneService.findByNumber(number) == null) {
				// 전화 값 세팅하고 추가하기
				Phone phone = new Phone();
				phone.setUser(user);
				phone.setCarrier(carrier);
				phone.setNumber(number);
				phoneService.save(phone);
				
				return "redirect:list";
			// 중복일 때
			} else {
				model.addAttribute("msg", "전화 번호가 중복됩니다.");
				model.addAttribute("url", referer);
				
				return "alert";
			}
		// 전화 수정
		} else {
			Phone search_phone = phoneService.findByNumber(number);
			Phone self_phone = phoneService.findById(phoneid);
			// 중복 없을 때
			if(search_phone == null || search_phone.getId() == self_phone.getId()) {
				//전화 값 세팅하고 수정하기
				self_phone.setCarrier(carrier);
				self_phone.setNumber(number);
				phoneService.save(self_phone);
				
				return "redirect:list";
			// 중복일 때
			} else {
				model.addAttribute("msg", "전화 번호가 중복됩니다.");
				model.addAttribute("url", referer);
				
				return "alert";
			}
		}
	}
	
	// 전화 삭제 동작
	@RequestMapping(value = "deletePhone")
	public String delete(@RequestParam Map<String, String> param, Model model) {
		Long id = Long.parseLong(param.get("id"));
		Phone phone = phoneService.findById(id);
		phoneService.delete(phone);
		
		return "redirect:list";
	}
	
}
