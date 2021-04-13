package sjls.todotalk.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GetSrcLangText {
	private String clientId = "Cam4wvptdeAunjXebAbE";//애플리케이션 클라이언트 아이디값";
	private String clientSecret = "YhRQLHJv7x";//애플리케이션 클라이언트 시크릿값";
	
	public String translator(String getText) {
		String text="";
		try {
			text = URLEncoder.encode(getText, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("인코딩 실패", e);
		}
		String apiURL = "https://openapi.naver.com/v1/papago/detectLangs";
		
		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		
		String responseBody = post(apiURL, requestHeaders, text);
		
		//api json형태 데이터 파싱
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject;
		String objLangCode = null;
		try {
			jsonObject = (JSONObject) jsonParser.parse(responseBody);
			objLangCode = (String) jsonObject.get("langCode");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return objLangCode;
	}
	
	private static String post(String apiUrl, Map<String, String> requestHeaders, String text){
        HttpURLConnection con = connect(apiUrl);
        String postParams =  "query="  + text; //원본언어: 한국어 (ko) -> 목적언어: 영어 (en)
        try {
            con.setRequestMethod("POST");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(postParams.getBytes());
                wr.flush();
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 응답
                return readBody(con.getInputStream());
            } else {  // 에러 응답
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
}
