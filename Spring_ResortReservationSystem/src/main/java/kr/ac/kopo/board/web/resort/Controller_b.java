package kr.ac.kopo.board.web.resort;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Controller_b {
	
	private static final Logger logger = LoggerFactory.getLogger(Controller_b.class);

	//-----b--------------------------------------------------------
	// ã�ƿ��±�
	@RequestMapping(value = "/way", method = RequestMethod.GET)
	public String way(Locale locale, Model model) {
		
		return "resort/b1_way";
	}
	// ���߱���
	@RequestMapping(value = "/publicc", method = RequestMethod.GET)
	public String publicc(Locale locale, Model model) {
		
		return "resort/b2_public";
	}
	// �ڰ���
	@RequestMapping(value = "/own", method = RequestMethod.GET)
	public String own(Locale locale, Model model) {
		
		return "resort/b3_own";
	}
	
}
