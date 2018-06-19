package com.service.ems.util;

import java.util.List;

public interface SMSUtil {

	String sendSMS(List<String> no, String msg);
	String sendSMS(String no, String msg);
	
}
