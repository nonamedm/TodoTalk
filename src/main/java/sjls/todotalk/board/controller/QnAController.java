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
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sjls.todotalk.board.service.QnAService;
import sjls.todotalk.board.service.RepService;
import sjls.todotalk.board.vo.PdsVo;
import sjls.todotalk.board.vo.QnABoardVo;
import sjls.todotalk.board.vo.QnAFileVo;
import sjls.todotalk.board.vo.QnAReplyVo;
import sjls.todotalk.util.Criteria;
import sjls.todotalk.util.PageMaker;

@Controller
public class QnAController {
	
	@Autowired
	private QnAService qnaService;
	@Autowired
	private RepService repService;
	
	//QnA 게시판
	@RequestMapping("/board/QnA/qnaList")
	public ModelAndView qnaList(@RequestParam HashMap<String, Object> map,Criteria cri) {
		
		//게시물 목록 
		//List<QnABoardVo> qnaList = qnaService.getQnAList(map);
		List<PdsVo>  pdsList    = qnaService.getQnAList( map );
		QnABoardVo qnaBoardVo = (QnABoardVo) map.get("qnaBoardVo");
		
		//파일 목록 
		List<QnAFileVo> fileList = qnaService.getFileList(map);
		QnAFileVo qnafileVo = (QnAFileVo) map.get("qnafileVo");
		
		//페이징
		// qnaService.getQnAList(map)명령 실행후 map("pagePdsVo") 에 돌아온 결과 처리
		//PdsVo pagePdsVo  = (PdsVo) map.get("pagePdsVo");

	
		//addObject
		ModelAndView mv = new ModelAndView();
		//mv.addObject("list",qnaList);
		mv.addObject("fileList",fileList);
		mv.addObject("list",pdsList);
		//mv.addObject("pagePdsVo",  pagePdsVo );
		mv.addObject("map",  map );
		mv.setViewName("/board/QnA/qnaList");
		
		return mv;
	}

	
	//게시글 조회 글 읽기 
	@RequestMapping("/board/QnA/qnaRead")
	public ModelAndView qnaRead(@RequestParam HashMap<String, Object> map) {
		
		//idx로 조회된 글 내용 불러오기 
		//List<QnABoardVo> qnaList = qnaService.getQnAList(map);
		List<PdsVo>  pdsList    = qnaService.getQnAList( map );
		QnABoardVo qnaBoardVo = qnaService.getQnARead(map);
		
		//파일 목록 
		List<QnAFileVo> filesList = qnaService.getFileList(map);
		QnAFileVo qnafileVo = (QnAFileVo) map.get("qnafileVo");
		
		//조회수
		qnaService.readcount(map);
		
		//댓글 목록 조회
		List<QnAReplyVo> repList = repService.getRepList(map);
		QnAReplyVo qnaReplyVo = (QnAReplyVo) map.get("qnaReplyVo");
		

		//addObject
		ModelAndView mv = new ModelAndView();
		mv.addObject("qnaBoardVo",qnaBoardVo);
		mv.addObject("qnafileVo",qnafileVo);
		mv.addObject("filesList",filesList);
		mv.addObject("list",pdsList);
		mv.addObject("repList",repList);
		mv.addObject("qnaReplyVo",qnaReplyVo);
		mv.addObject("map",map);
		mv.setViewName("/board/QnA/qnaRead");
		
		return mv;
	}
	
	//댓글 쓰기
	@RequestMapping("/board/QnA/repWrite")
	public ModelAndView repWrite(@RequestParam HashMap<String, Object> map
			,HttpServletRequest request) {
		
		//qnaRead.jsp 안에 댓글쓰기에서 받아온 정보 insert 
		repService.repWrite(map,request);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/board/QnA/qnaList");
		return mv;
	}
	
	
	//댓글 하나하나 삭제
	@RequestMapping("/board/QnA/repDelete")
	public ModelAndView repDelete(@RequestParam HashMap<String, Object> map) {
		
		repService.repDelete(map);
		ModelAndView mv = new ModelAndView();
//		mv.setViewName("redirect:/board/QnA/qnaRead?qna_idx=${list.qna_idx}");
		mv.setViewName("redirect:/board/QnA/qnaList");
		return mv;
	}
	
	
	//게시글 삭제
	@RequestMapping("/board/QnA/delete")
	public ModelAndView delete(@RequestParam HashMap<String, Object> map) {
		
		//게시판 테이블 데이터 삭제
		qnaService.boardDelete(map);
		//파일,댓글 다 같이 삭제는 service impl에 있음 
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/board/QnA/qnaList");
		return mv;
	}
	
	//글 쓰기 form
	@RequestMapping("/board/QnA/qnaWriteForm")
	public ModelAndView writeForm(@RequestParam HashMap<String, Object> map) {
		
		QnABoardVo qnaBoardVo = qnaService.getQnARead(map);
		QnAFileVo qnaFileVo = (QnAFileVo) map.get("qnafileVo");
		
		//addObject
		ModelAndView mv = new ModelAndView();
		mv.addObject("qnaBoardVo",qnaBoardVo); //글 쓸 때 저장할 값
		mv.addObject("qnaFileVo",qnaFileVo); 
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

		//addObject
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
