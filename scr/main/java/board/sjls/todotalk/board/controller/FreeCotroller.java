package sjls.todotalk.board.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sjls.todotalk.board.service.BoardService;

@Controller
public class FreeCotroller {
	
//	@Autowired
//	private BoardService boardService;
	
	@RequestMapping("/")
	public  String  home() {
		return "home";
	}
	
	@RequestMapping("/list")
	public String FreeList() {
		//ModelAndView mv = new ModelAndView();
		
		return "/board/free/list";	
	}
	
	
//	@RequestMapping("/WriteForm")
//	public ModelAndView writeForm() {
//		
//		ModelAndView mv = new ModelAndView();
//		
//		return mv;
//		
//	}
	@RequestMapping("/Write")
	public String Write() {
		
		ModelAndView mv = new ModelAndView();
		
		
		
		
		
		return  "/board/free/write"; // + menu_id;
		
	}
//	
//	@RequestMapping("/MBoard/Read")
//	public  ModelAndView Read() {
//
//		ModelAndView  mv  = new ModelAndView();
//	
//		return mv;
//	} 
//	
//	
//	@RequestMapping("/MBoard/UpdateForm")
//	public  ModelAndView  updateForm() {
//				
//		ModelAndView  mv  = new ModelAndView();
//		
//		return mv;
//	} 
//	
//	@RequestMapping("/MBoard/Update")
//	public  ModelAndView  update() {
//		
//		ModelAndView  mv  = new ModelAndView();			
//		
//		return mv;
//	} 
//	
//	@RequestMapping("/MBoard/Delete")
//	public  ModelAndView  delete( ) {
//		
//		
//		ModelAndView  mv  = new ModelAndView();			
//		
//		return mv;
//	} 
//	
//
//	
//	

}
