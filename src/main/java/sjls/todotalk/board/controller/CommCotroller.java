package sjls.todotalk.board.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sjls.todotalk.board.service.CommService;
import sjls.todotalk.board.vo.CommBoardVo;
import sjls.todotalk.board.vo.CommFileVo;


@Controller
public class CommCotroller {
	@Autowired
	private CommService commService;
	
	@RequestMapping("/board/comm/commList")
	public ModelAndView commList(@RequestParam HashMap<String, Object> map) {
		
		//목록 불러오기 
		List<CommBoardVo> commList = commService.getCommList(map);
		
		CommBoardVo commBoardVo = (CommBoardVo) map.get("commBoardVo");
		CommFileVo commFileVo = (CommFileVo) map.get("commFileVo");
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("List",commList);
		mv.addObject("commFileVo",commFileVo);
		
		mv.setViewName("/board/comm/commList");
		
		return mv;
	}
	
	@RequestMapping("/board/comm/commRead")
	public ModelAndView read(@RequestParam HashMap<String , Object> map) {
		
		List<CommBoardVo> commList = commService.getCommList(map);
		CommBoardVo commBoardVo = commService.getCommRead(map);
		//CommBoardVo commBoardVo = (CommBoardVo) map.get("commBoardVo");
		
		List<CommFileVo> filesList = commService.getFileList(map);
				
		ModelAndView  mv = new ModelAndView();
		mv.addObject("List",commList);
		mv.addObject("commBoardVo",commBoardVo);
		mv.addObject("filesList",filesList);
		mv.setViewName("/board/comm/commRead");
		return mv;
		
	}
	
	@RequestMapping("/board/comm/WriteForm")
	public ModelAndView writeForm(@RequestParam HashMap<String, Object> map ) {
		
		// 페이지 이동 
		ModelAndView  mv = new ModelAndView();
		mv.addObject("map",  map);
		mv.setViewName("/board/comm/commWrite");
		return mv;
		
	}
	@RequestMapping("/board/comm/commWrite")
	public ModelAndView write(@RequestParam HashMap<String, Object> map
			,HttpServletRequest request ) {
		
		commService.getCommWrite(map,request);
		//파일값처리?
		
		ModelAndView  mv = new ModelAndView();		
		mv.addObject("map",  map);
		
		mv.setViewName("redirect:/board/comm/commList");
		return mv;
		
	}
	
	@RequestMapping("/board/comm/delete")
	public ModelAndView delete(@RequestParam  HashMap<String, Object> map) {
		commService.delete(map);
		
		ModelAndView  mv =  new ModelAndView();
		mv.setViewName( "redirect:/board/comm/commList" );
		return  mv;
		
	}
	
	@RequestMapping("/board/comm/commUpdateForm")
	public ModelAndView updateForm(@RequestParam HashMap<String, Object>map, HttpServletRequest requst) {
		
		List<CommBoardVo> commList = commService.getCommList(map);
		List<CommFileVo> fileList = commService.getFileList(map);
		CommBoardVo commBoardVo = commService.getCommRead(map);
		
		
		ModelAndView  mv = new ModelAndView();
		mv.addObject("commList",  commList);
		mv.addObject("fileList",  fileList);
		mv.addObject("commBoardVo",  commBoardVo);
		mv.addObject("map",  map);
		mv.setViewName("/board/comm/commUpdate");
		
		return mv;
		
	}
	
	@RequestMapping("/board/comm/commUpdate")
	public ModelAndView update(@RequestParam  HashMap<String, Object> map , HttpServletRequest request) {
		
		commService.update(map,request);
		
		ModelAndView  mv =  new ModelAndView();
		
		//mv.addObject("",map);
		mv.setViewName( "redirect:/board/comm/commList" );
		return  mv;
		
	}
	
	
	
	//파일 다운로드
	// {sfile}    :    .jpg 와 같은 . 포함 문자는 무시한다 
	// {sfile:.+} : 정규식문법 .문자가 한개이상(+) 있을때
	@RequestMapping(value="/download/{type}/{sfile_name:.+}", method = RequestMethod.GET )
	public void downloadFile(HttpServletResponse response,
		@PathVariable("type") String type,@PathVariable("sfile_name") String sfile_name) throws IOException {
		
		String  INTERNAL_FILE        = sfile_name;
		String  EXTERNAL_FILE_PATH   = "c:\\upload\\" + sfile_name;
		
		File    file   =  null;
		if( type.equalsIgnoreCase("internal") ) {
			ClassLoader   classLoader = 
				Thread.currentThread().getContextClassLoader();
			file = new File(classLoader.getResource(INTERNAL_FILE).getFile() );
		} else {
			file  =  new File( EXTERNAL_FILE_PATH );
		}
				
		if(!file.exists() ) {
			String errorMessage = "죄송합니다. 파일이 없습니다";
			System.out.println(errorMessage);
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
			outputStream.close();
			return;
		}
		
		String  mimeType = URLConnection.guessContentTypeFromName(file.getName());
		mimeType = "application/octet-stream"; // 무조건 다운로드
		
		response.setContentType(mimeType);
		response.setHeader("Content-Disposition", 
			String.format("inline; filename=\"" + file.getName() + "\"" ) );
		
		response.setContentLength( (int) file.length() );
		
		InputStream  inputStream = new BufferedInputStream(
			new FileInputStream(file) );
		
		FileCopyUtils.copy(inputStream, response.getOutputStream() );
		
		inputStream.close();
		
	}
	
	
	
	
	



}
