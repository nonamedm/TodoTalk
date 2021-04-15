package sjls.todotalk.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AttendanceCheckController {

	@RequestMapping(value = "/attendanceCheckFm", method = RequestMethod.GET)
	public ModelAndView attendanceCheckFm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("attendance/attendanceCheckFm");
		return mav;
	}

}
