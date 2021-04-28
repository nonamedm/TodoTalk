package sjls.todotalk.board.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sjls.todotalk.board.service.NoticeService;
import sjls.todotalk.board.vo.NoticeBoard;
import sjls.todotalk.util.Criteria;
import sjls.todotalk.util.PageMaker;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="/noticeFm", method=RequestMethod.GET)
	public ModelAndView noticeFm(@RequestParam HashMap<String, Object> map,Criteria cri) {
		
		ModelAndView mav = new ModelAndView();
		//Criteria cri = new Criteria();
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(noticeService.getNoticeListCount());
		
		List<NoticeBoard> getNoticeList = noticeService.getNoticeList(cri);
		
		mav.addObject("getNoticeList", getNoticeList);
		mav.addObject("pageMaker", pageMaker);
		
		mav.setViewName("/board/notice/noticeList");
		return mav;
	}
	
	@RequestMapping(value="/noticeWriteFm", method=RequestMethod.GET)
	public ModelAndView noticeWriteFm() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/board/notice/noticeWriteFm");
		return mav;
	}
	
	@RequestMapping(value="/noticeWrite", method=RequestMethod.POST)
	public ModelAndView noticeWrite(@RequestParam HashMap<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		String notice_cont2 = (String)map.get("notice_cont");
		notice_cont2.replace("<", "&lt;");
		notice_cont2.replace(">", "&gt;");
		map.put("notice_cont", notice_cont2);
		
		System.out.println(map);
		
		noticeService.noticeWrite(map);
		
		mav.setViewName("redirect:/noticeFm");
		return mav;
	}
	
	@RequestMapping(value="/noticeRead", method=RequestMethod.GET)
	public ModelAndView noticeRead(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		
		int idx = Integer.parseInt(req.getParameter("idx"));
		
		noticeService.updateReadCount(idx);
		HashMap<String, Object> getViewRead = noticeService.getNoticeRead(idx);
		
		mav.addObject("getViewRead", getViewRead);
		mav.setViewName("/board/notice/noticeReadFm");
		return mav;
	}
	
	@RequestMapping(value="/noticeUpdateFm", method=RequestMethod.GET)
	public ModelAndView noticeUpdateFm(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		
		int idx = Integer.parseInt(req.getParameter("idx"));
		
		
		HashMap<String, Object> getViewRead = noticeService.getNoticeRead(idx);
		
		mav.addObject("getViewRead", getViewRead);
		mav.setViewName("/board/notice/noticeUpdateFm");
		return mav;
	}
	
	@RequestMapping(value="/noticeUpdate", method=RequestMethod.POST)
	public ModelAndView noticeUpdate(@RequestParam HashMap<String, Object> map){
		ModelAndView mav = new ModelAndView();
		
		Object idx = map.get("notice_idx");
		
		noticeService.noticeUpdate(map);
		
		mav.setViewName("redirect:/noticeRead?idx="+idx);
		return mav;
	}
	
	@RequestMapping(value="/noticeDelete", method=RequestMethod.GET)
	public ModelAndView noticeDelete(HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		
		int idx = Integer.parseInt(req.getParameter("idx"));
		
		noticeService.noticeDelete(idx);
		
		mav.setViewName("redirect:/noticeFm");
		return mav;
	}
	
}
