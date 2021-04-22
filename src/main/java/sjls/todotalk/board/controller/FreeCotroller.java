package sjls.todotalk.board.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sjls.todotalk.board.service.FreeBoardService;
import sjls.todotalk.board.vo.FreeBoardVo;
import sjls.todotalk.board.vo.FreeFileVo;
import sjls.todotalk.board.vo.NoticeBoard;
import sjls.todotalk.util.Criteria;
import sjls.todotalk.util.PageMaker;

//자유 커뮤니티 게시판 
@Controller
public class FreeCotroller {
	
	@Autowired
	private FreeBoardService boardService;
	
	//게시판 목록(페이징 됨)
	@RequestMapping("/board/free/freeList")
	public ModelAndView noticeFm(@RequestParam HashMap<String, Object> map,Criteria cri){
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);   
		
		pageMaker.setTotalCount(boardService.getListCount()); //총 게시글 수 
		
		//게시글 목록 
		List<FreeBoardVo> getFreeList = boardService.getFreeList(cri);
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("getFreeList", getFreeList);
		mv.addObject("pageMaker", pageMaker);
		mv.setViewName("/board/free/freeList");
		return mv;	
	}
	
	//게시글 조회 글 읽기
	@RequestMapping("/board/free/freeRead")
	public ModelAndView freeRead(@RequestParam HashMap<String, Object> map) {
		
		//idx로 조회된 글 내용 불러오기
		FreeBoardVo freeBoardVo =  boardService.getFreeRead(map);
		//파일 목록 
		List<FreeFileVo> filesList = boardService.getFileList(map);
		//조회수
		boardService.readcount(map);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("freeBoardVo",freeBoardVo);
		mv.addObject("filesList",filesList);
		mv.addObject("map",map);
		mv.setViewName("/board/free/freeRead");
		return mv;
	}
	
	//게시글 삭제 
	@RequestMapping("/board/free/delete")
	public ModelAndView delete(@RequestParam HashMap<String, Object> map) {
		
		//게시판 테이블 삭제 
		boardService.boardDelete(map);
		
		//파일 댓글 다 같이 삭제는 serviceimpl에 코딩
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/board/free/freeList");
		return mv;
	}
	
	//글 쓰기 form
	@RequestMapping("/board/free/freeWriteForm")
	public ModelAndView writeForm(@RequestParam HashMap<String, Object> map) {
		
		FreeBoardVo freeBoardVo = boardService.getFreeRead(map);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("freeBoardVo",freeBoardVo);
		mv.addObject("map",map);
		mv.setViewName("/board/free/freeWrite");
		return mv;
	}
	
	//글 쓰기
	@RequestMapping("/board/free/freeWrite")
	public ModelAndView freeWrite(@RequestParam HashMap<String, Object> map,HttpServletRequest request) {
		
		//Write.jsp에서 받아온 값 인서트하러 가는 길
		boardService.getFreeWrite(map,request);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/board/free/freeList");
		return mv;
	}
	
	//글 수정 form
	@RequestMapping("/board/free/freeUpdateForm")
	public ModelAndView updateForm(@RequestParam HashMap<String, Object> map) {
		
		FreeBoardVo freeBoardVo = boardService.getFreeRead(map);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("freeBoardVo",freeBoardVo);
		mv.addObject("map",map);
		mv.setViewName("/board/free/freeUpdate");
		return mv;
	}
	
	//글 수정
	@RequestMapping("/board/free/freeUpdate")
	public ModelAndView freeUpdate(@RequestParam HashMap<String, Object> map,HttpServletRequest request) {
		
		//Write.jsp에서 받아온 값 인서트하러 가는 길
		boardService.getFreeUpdate(map,request);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/board/free/freeList");
		return mv;
	}

}

