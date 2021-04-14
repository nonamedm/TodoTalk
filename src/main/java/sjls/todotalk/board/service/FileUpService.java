package sjls.todotalk.board.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public interface FileUpService {

	void setWrite(HashMap<String, Object> map, HttpServletRequest request);

}
