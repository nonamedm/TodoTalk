package sjls.todotalk.user.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import sjls.todotalk.board.service.impl.CheckFileName;

public class ProFilePhoto {
	
	public static void savePhoto(HashMap<String, Object> map, HttpServletRequest request) {
//	    넘어온 파일저장(c:\\upload\\)처리 (중복파일처리)
			CheckFileName  checkFile =  new CheckFileName(); 
			
			// 자료실 파일 저장될 경로
			String   filePath  = "c:\\upload\\photo\\";
			
			MultipartHttpServletRequest  multipartHttpServletRequest
			 =  (MultipartHttpServletRequest) request;
			
			Iterator<String> iterator =
					multipartHttpServletRequest.getFileNames();
			
			MultipartFile  multipartFile = null; 
			
			//photo_name	photo_orgfilename	photo_fileext	photo_sfilename
			List<String>  photo_names      = new ArrayList<String>(); 
			List<String>  photo_fileexts   = new ArrayList<String>(); 
			List<String>  photo_sfilenames = new ArrayList<String>(); 
			
			
//			int            user_idx2   =  (int) map.get("user_idx");
//			String         user_id2    =  (String) map.get("user_idx");
//			System.out.println(user_idx2x);
//			map.remove("user_idx", map.get("user_idx"));
//			map.remove("user_id",  map.get("user_id"));
//			map.put("user_idx", user_idx2);
//			map.put("user_id", user_id2);
			
			
			
			String         photo_name          = null; 
			String         photo_orgfilename   = null; 
			String         photo_fileext       = null; 
			String         photo_sfilename     = null; 
			
			// upload 된 파일마다 반복하여 처리
			// 파일하나당 반복
			while( iterator.hasNext() ) {
				multipartFile = multipartHttpServletRequest.getFile(
						iterator.next());
				
				if( !multipartFile.isEmpty()  )
				{
					// 김연아.광고.jpg
					photo_name    = multipartFile.getOriginalFilename();              // 김연아.광고.jpg
					photo_orgfilename = photo_name.substring(
							0, photo_name.lastIndexOf(".")); // 김연아.광고
					photo_fileext     = photo_name.substring( 
							photo_name.lastIndexOf(".") );  // .jpg
					
					// filePath + orgFileName + fileExt 이 존재하면 
					//  중복되지 않는 새로운 파일명을 생성
					// 김연아.광고2.jpg
					photo_sfilename = checkFile.getCheckFileName(
							filePath, photo_orgfilename, photo_fileext );
//					
//					photo_names.add( photo_name );
//					photo_fileexts.add( photo_fileext );
//					photo_sfilenames.add( photo_sfilename );
//									
					map.put("photo_name",      photo_name);
					map.put("photo_fileext",   photo_fileext);
					map.put("photo_sfilename", photo_sfilename);
					
					// 파일 저장 : c:\\upload\\photo
					File file = new File(filePath + photo_sfilename);				
					try {
						multipartFile.transferTo(file);   // 실제파일 저장
					} catch( IllegalStateException e ) {
						e.printStackTrace();
					} catch( IOException e ) {
						e.printStackTrace();
					} // try end
				} // if end				
			} // while end
		
	
	}
}