package sjls.todotalk.user.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sjls.todotalk.util.GetApiPapago;


@Controller
public class translatorController {
	 
	@RequestMapping(value="/translatorText", method=RequestMethod.POST)
	public ModelAndView translatorText(HttpServletRequest req) {
		
		ModelAndView mav = new ModelAndView();
		 
		String getText     = req.getParameter("getText");
		String tarLanguage = req.getParameter("tarLanguage");
		System.out.println(getText);
		System.out.println(tarLanguage);
		
		GetApiPapago translatorTxt = new GetApiPapago();
		String data = translatorTxt.translator(getText, tarLanguage);
		
		System.out.println("con : "+ data);
		
		mav.addObject("resultData", data);
		mav.setViewName("jsonView");
		return mav;
	}
	
}
