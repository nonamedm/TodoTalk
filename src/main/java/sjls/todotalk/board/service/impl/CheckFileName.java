package sjls.todotalk.board.service.impl;

import java.io.File;

public class CheckFileName {
    // filePath     :  c:\\upload\\ 
	// orgFileName  :  파일이름
	// fileExt      :  .jpg 
	public String getCheckFileName(
			String filePath, String orgFileName, String fileExt) {
		
		boolean  isCheck         =  true;
		String   returnFileName  =  null;
		
		String   fullFilePath    =  null;
		File     file            =  null;
		
		int i = 0;
		while( isCheck ) {   // 무한루프
			fullFilePath = filePath + orgFileName + fileExt;
			file         = new File( fullFilePath );
			if( file.exists() ) {
				i +=  1;
				orgFileName = orgFileName + String.valueOf(i);
			} else {
				isCheck = false;
			}
		}
		
		returnFileName = orgFileName + fileExt;
		
		return returnFileName;
	}

}







