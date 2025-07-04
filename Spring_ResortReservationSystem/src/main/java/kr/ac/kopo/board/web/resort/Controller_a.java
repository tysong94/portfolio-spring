package kr.ac.kopo.board.web.resort;

import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controller_a {
	
	private static final Logger logger = LoggerFactory.getLogger(Controller_a.class);
	
	//-----a--------------------------------------------------------	
	// ∏ﬁ¿Œ ∆‰¿Ã¡ˆ
	@RequestMapping(value = "/main")
	public String main(Locale locale, Model model) {
		return "resort/a1_main";
	}
	// VIP∑Î
	@RequestMapping(value = "/vip", method = RequestMethod.GET)
	public String vip(Locale locale, Model model) {
		return "resort/a2_vip";
	}
	// ¿œπ›∑Î
	@RequestMapping(value = "/common", method = RequestMethod.GET)
	public String common(Locale locale, Model model) {
		return "resort/a3_common";
	}
	// «’∏Æ¿˚¿Œ∑Î
	@RequestMapping(value = "/reasonable", method = RequestMethod.GET)
	public String reasonable(Locale locale, Model model) {
		return "resort/a4_reasonable";
	}
}
