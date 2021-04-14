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


@Controller
public class FreeCotroller {
	
	@Autowired
	private FreeBoardService boardService;
	
	@RequestMapping("/freeList")
	public String FreeList(Model model) {
		//ModelAndView mv = new ModelAndView();
		
		List<FreeBoardVo> list = boardService.getBoardList();
		model.addAttribute("list",list);
		
		return "/board/free/list";	
	}
	
	
	@RequestMapping("/writeForm")
	public  String  writeForm( ) {
		return "/board/free/write";     
	} 
	
	@RequestMapping("/write")
	public String Write(FreeBoardVo vo) {
		//글제목, 본문 db에 저장 
		boardService.insertBoard(vo);
		
		
		return  "redirect:/list"; 
	}
	
	
	@RequestMapping("/read")
	public  String Read(HttpServletRequest request, Model model) {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		FreeBoardVo vo = boardService.getBoardCont(idx);

		model.addAttribute("board",vo);
		return "/board/free/read";
	} 
	
	@RequestMapping("/delete")
	public  String  delete(HttpServletRequest request, Model model ) {
		int idx = Integer.parseInt(request.getParameter("idx"));
		boardService.deleteBoard(idx);	
		
		return "redirect:/list";
	} 
	
	
	@RequestMapping("/updateForm")
	public  String  updateForm(HttpServletRequest request, Model model ) {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		FreeBoardVo vo = boardService.getBoardCont(idx);

		model.addAttribute("upBoard",vo);
		return "/board/free/update";
	} 
	
	
	@RequestMapping("/update")
	public  String  update(FreeBoardVo vo) {
		boardService.updateBoard(vo);
		return "redirect:/list";
	} 
	


}
