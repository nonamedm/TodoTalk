package sjls.todotalk.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sjls.todotalk.user.service.UserService;

@Controller
public class AttendanceCheckController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/attendanceCheckFm", method = RequestMethod.GET)
	public ModelAndView attendanceCheckFm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("attendance/attendanceCheckFm");
		return mav;
	}
	
	@RequestMapping(value = "/attendanceCheck", method = RequestMethod.POST)
	public ModelAndView attendanceCheck(@RequestParam HashMap<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		
		//출석체크여부
		int result = userService.attendanceCheckYn(map);
		System.out.println("출석안했으면 0 이 나와야한다: "+result);
		
		//여부확인 결과값이 0 이면 = 출석체크해주고, 1이면 출석체크 막기
		if(result == 0){
			//출석체크하기
			userService.attendanceCheck(map);
			int result2 = userService.attendanceCheckYn(map);
			mav.addObject("attendanceCheckYn2", result2);
			mav.setViewName("jsonView");
			
		}else {
			mav.addObject("attendanceCheckYn", result);
			mav.setViewName("jsonView");
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/attendanceTag", method = RequestMethod.GET)
	public ModelAndView attendanceTag(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		String userid = req.getParameter("userid");
		System.out.println(userid);
		
		List<Map<String, Object>> attendanceList = userService.attendanceTag(userid);
		System.out.println(attendanceList);
		
		mav.addObject("attendanceList", attendanceList);
		mav.setViewName("jsonView");
		return mav;
	}

}
