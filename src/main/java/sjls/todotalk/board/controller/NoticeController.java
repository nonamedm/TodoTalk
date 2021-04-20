package sjls.todotalk.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sjls.todotalk.board.service.NoticeService;
import sjls.todotalk.util.Criteria;
import sjls.todotalk.util.PageMaker;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="/noticeFm", method=RequestMethod.GET)
	public ModelAndView noticeFm(Criteria cri) {
		ModelAndView mav = new ModelAndView();
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(noticeService.getNoticeListCount());
		
		List<Map<String, Object>> getNoticeList = noticeService.getNoticeList(cri);
		
		mav.addObject("getNoticeList", getNoticeList);
		mav.addObject("pageMaker", pageMaker);
		
		mav.setViewName("/board/notice/noticeList");
		return mav;
	}
}
