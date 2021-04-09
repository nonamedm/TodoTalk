package sjls.todotalk.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "home";		
	}
	
	@RequestMapping(value="/AllSearch", method=RequestMethod.GET)
	public ModelAndView allSearch(String query) {
		String searchText = query;
		System.out.println(query);
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/allSearch");
		return mav;		
	}
	
}
