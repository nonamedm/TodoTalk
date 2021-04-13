package sjls.todotalk.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sjls.todotalk.util.GetApiPapago;
import sjls.todotalk.util.GetSrcLangText;


@Controller
public class translatorController {
	
	//번역할 텍스트 언어감지
	@RequestMapping(value="/srcLangText", method=RequestMethod.POST)
	public ModelAndView srcLangText(HttpServletRequest req) {
		ModelAndView mav = new  ModelAndView();
		String srcLangText = req.getParameter("srcLangText");
		
		GetSrcLangText srcLanguage = new GetSrcLangText();
		String data = srcLanguage.translator(srcLangText);
		
		
		mav.addObject("resultData2", data);
		mav.setViewName("jsonView");
		return mav;
	}
	
	
	 //번역한텍스트 반환
	@RequestMapping(value="/translatorText", method=RequestMethod.POST)
	public ModelAndView translatorText(HttpServletRequest req) {
		
		ModelAndView mav = new ModelAndView();
		 
		String getText     = req.getParameter("getText");
		String tarLanguage = req.getParameter("tarLanguage");
		String srcLanguage = req.getParameter("srcLanguage");
		
		GetApiPapago translatorTxt = new GetApiPapago();
		String data = translatorTxt.translator(getText, tarLanguage, srcLanguage);
		
		mav.addObject("resultData", data);
		mav.setViewName("jsonView");
		return mav;
	}
	
}
