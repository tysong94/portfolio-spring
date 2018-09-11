package kr.ac.kopo.board.web.resort;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller_c {
	
	private static final Logger logger = LoggerFactory.getLogger(Controller_c.class);

	//-----관광명소--------------------------------------------------------
	// 찾아오는길
	@RequestMapping(value = "/attractions1")
	public String attractions1(Locale locale, Model model) {
		
		return "resort/c1_attractions";
	}
	// 대중교통
	@RequestMapping(value = "/attractions2")
	public String attractions2(Locale locale, Model model) {
		
		return "resort/c2_attractions";
	}
	// 자가용
	@RequestMapping(value = "/attractions3")
	public String attractions3(Locale locale, Model model) {
		
		return "resort/c3_attractions";
	}
	
}
