package sjls.todotalk.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sjls.todotalk.board.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="/noticeFm", method=RequestMethod.GET)
	public ModelAndView noticeFm() {
		ModelAndView mav = new ModelAndView();
		
		List<Map<String, Object>> getNoticeList = noticeService.getNoticeList();
		
		mav.addObject("getNoticeList", getNoticeList);
		mav.setViewName("/board/notice/noticeList");
		return mav;
	}
}
