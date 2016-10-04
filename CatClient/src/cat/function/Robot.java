package cat.function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Robot {
	/**
	 * 使用图灵机器人接口获取回答
	 * 
	 * @param apikey API认证
	 * @param info 想要请求的问题
	 * @return 获取的回复
	 * */
	public static String getResponse(String info){
		String httpUrl;
		try {
			httpUrl = "http://www.tuling123.com/openapi/api?key=afb89bce91948f335f2b10f0c398afa4"   + "&info=" + URLEncoder.encode(info,"UTF-8");
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setReadTimeout(5000);
			connection.setConnectTimeout(5000);
			
			InputStream inputStream = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
			
			String line = "";
			String reg = "\"text\":\"(.*)?\"}";
			Pattern pattern = Pattern.compile(reg);
			Matcher matcher;
			while((line = reader.readLine()) != null){
				matcher = pattern.matcher(line);
				if(matcher.find()){
					connection.disconnect();
					return matcher.group(1);
				}
			}
			connection.disconnect();	
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
