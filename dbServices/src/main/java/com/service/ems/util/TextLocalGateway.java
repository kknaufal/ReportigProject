package com.service.ems.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TextLocalGateway implements SMSUtil {
	
	private static final String API_KEY = "jwViB+0pfWI-PCFvC3r51SWZUZikvCYGIBVvwf9XFO";
	private static final String BASE_URL = "https://api.textlocal.in/send/?"; 
	private static final String SENDER="TXTLCL";
	private static final boolean TEST_MODE=true;
	
	@Override
	public String sendSMS(String no, String msg) {
		List<String> nos = new ArrayList<>();
		nos.add(no);
		return sendSMS(nos, msg);
			
		}

	@Override
	public String sendSMS(List<String> numbers, String msg) {
		String smsStatus="";
		try { 
			
			String smsURL=buildSMSURL(numbers,msg);
			URL url = new URL(smsURL);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			
			// Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			
			while ((line = rd.readLine()) != null) {
			// Process line...
				smsStatus=smsStatus+line+" ";
			}
			rd.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return smsStatus;
	}
	private String buildSMSURL(List<String> numbers, String msg){
		StringBuffer smsUrl=new StringBuffer(BASE_URL);
		StringBuffer numberBuffer = new StringBuffer();
		boolean commaRequired = false;
		for(String number : numbers) {
			if(commaRequired) {
				numberBuffer.append(',').append(number);
				
			}else {
				numberBuffer.append(number);
			}
			commaRequired = true;
		}
		try{
		String apiKey = "apikey=" + URLEncoder.encode(API_KEY, "UTF-8");
		String message = "&message=" + URLEncoder.encode(msg, "UTF-8");
		String sender = "&sender=" + URLEncoder.encode(SENDER, "UTF-8");
		String phoneNumbers = "&numbers=" + URLEncoder.encode(numberBuffer.toString(), "UTF-8");
		
		String test = "&test=true";
		// Send data
		//String data = "https://api.textlocal.in/send/?" + apiKey + phoneNumbers + message + sender + test;
		smsUrl.append(apiKey).append(phoneNumbers).append(message).append(sender);
		if(TEST_MODE){
			smsUrl.append(test);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return smsUrl.toString();
	}
		
	}
