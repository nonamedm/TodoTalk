package sjls.todotalk.board.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sjls.todotalk.board.service.QnAService;
import sjls.todotalk.board.vo.QnABoardVo;

@Controller
public class QnAController {
	
	@Autowired
	private QnAService qnaService;
	
	//QnA 게시판
	@RequestMapping("/board/QnA/qnaList")
	public ModelAndView qnaList(@RequestParam HashMap<String, Object> map) {
		
		//게시물 목록 
		List<QnABoardVo> qnaList = qnaService.getQnAList(map);
		QnABoardVo qnaBoardVo = (QnABoardVo) map.get("qnaBoardVo");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",qnaList);
		mv.setViewName("/board/QnA/qnaList");
		
		return mv;
	}

	
	//게시글 조회 
	@RequestMapping("/board/QnA/qnaRead")
	public ModelAndView qnaRead(@RequestParam HashMap<String, Object> map) {
		
		//idx로 조회된 글 내용 불러오기 
		List<QnABoardVo> qnaList = qnaService.getQnAList(map);
		QnABoardVo qnaBoardVo = qnaService.getQnARead(map);

		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("qnaBoardVo",qnaBoardVo);
		mv.addObject("list",qnaList);
		mv.addObject("read",map);
		mv.setViewName("/board/QnA/qnaRead");
		
		return mv;
	}
	
	
	//게시글 삭제
	@RequestMapping("/board/QnA/delete")
	public ModelAndView delete(@RequestParam HashMap<String, Object> map) {
		
		qnaService.boardDelete(map);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/board/QnA/qnaList");
		return mv;
		
	}
	
	//글 쓰기 form
	@RequestMapping("/board/QnA/qnaWriteForm")
	public ModelAndView writeForm(@RequestParam HashMap<String, Object> map) {
		
		QnABoardVo qnaBoardVo = qnaService.getQnARead(map);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("qnaBoardVo",qnaBoardVo); //글 쓸 때 저장할 값
		mv.addObject("map",map);
		mv.setViewName("/board/QnA/qnaWrite");
		return mv;
	}
	
	//글 쓰기
	@RequestMapping("/board/QnA/qnaWrite")
	public ModelAndView qnaWrite(@RequestParam HashMap<String, Object> map
			,HttpServletRequest request) {
		
		//qnaWrite.jsp에서 받아온 값 인서트하러 가는 길
		qnaService.getQnAWrite(map,request);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/board/QnA/qnaList");
		return mv;
	}
	
	//글 수정 form
	@RequestMapping("/board/QnA/updateForm")
	public ModelAndView updateForm(@RequestParam HashMap<String, Object> map) {
		QnABoardVo qnaBoardVo = qnaService.getQnARead(map);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("qnaBoardVo",qnaBoardVo); //수정할 때 저장할 값
		mv.addObject("map",map);
		mv.setViewName("/board/QnA/qnaUpdate");
		return mv;
	}
	
	//글 수정
	@RequestMapping("/board/QnA/qnaUpdate")
	public ModelAndView qnaUpdate(@RequestParam HashMap<String, Object> map
			,HttpServletRequest request) {
		
		//.jsp 에서 받아온 값
		qnaService.getQnAUpdate(map,request);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/board/QnA/qnaList");
		return mv;
	}
	

}
