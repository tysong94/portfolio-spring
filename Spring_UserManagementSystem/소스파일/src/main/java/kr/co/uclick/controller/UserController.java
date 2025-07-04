package kr.co.uclick.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	// 사용자 전체 조회 화면 ----------------------------------------------------------
	@RequestMapping(value = "/")
	public String home(Model model) {
		return "redirect:list";
	}

	// 사용자 전체 조회 화면 ----------------------------------------------------------
	@RequestMapping(value = "list")
	public String list(Model model) {
		List<User> users = userService.findAllByOrderByIdDesc();
		model.addAttribute("users",  users);
		
		return "list";
	}
	
	// 사용자 검색 동작
	@RequestMapping(value = "userSearch")
	public String userSearch(@RequestParam Map<String, String> param, Model model) {
		String name = param.get("name");

		List<User> users = userService.findByNameContaining(name);
		model.addAttribute("users",  users);
		
		return "list";
	}
	
	// 사용자 추가 화면
	@RequestMapping(value = "userNew")
	public String newForm(@RequestParam Map<String, String> param, Model model) {
		return "userNew";
	}
	
	// 사용자 수정 화면
	@RequestMapping(value = "userEdit")
	public String editForm(@RequestParam Map<String, String> param, Model model) {
		Long id = Long.parseLong(param.get("id"));
		
		User user = userService.findById(id);
		model.addAttribute("user",  user);
		
		return "userEdit";
	}
	
	// 사용자 추가, 수정 동작
	@RequestMapping(value = "save")
	public String save(@RequestParam Map<String, String> param, Model model) {
		// 파라미터 받기
		Long id = Long.parseLong(param.get("id"));
		String name = param.get("name");
		Integer age = Integer.parseInt(param.get("age"));
		String sex = param.get("sex");
		String address = param.get("address");
		
		// 사용자 추가
		if(id == 0L) {
			User user = new User();
			user.setName(name);
			user.setSex(sex);
			user.setAge(age);
			user.setAddress(address);
			userService.save(user);
		// 사용자 수정
		} else {
			User user =  userService.findById(id);
			user.setName(name);
			user.setSex(sex);
			user.setAge(age);
			user.setAddress(address);
			userService.save(user);
		}
		
		return "redirect:list";
	}
	
	// 사용자 삭제 동작
	@RequestMapping(value = "userDelete")
	public String delete(@RequestParam Map<String, String> param, Model model) {
		Long id = Long.parseLong(param.get("id"));
		User user = userService.findById(id);

		if(user.getPhoneList().isEmpty()) {
			userService.delete(user);
			return "redirect:list";
		} else {
			model.addAttribute("msg", "등록된 전화가 있습니다. 사용자를 삭제하려면 등록된 전화를 모두 삭제하여야 합니다.");
			return "alert";
		}
	}
	
}
