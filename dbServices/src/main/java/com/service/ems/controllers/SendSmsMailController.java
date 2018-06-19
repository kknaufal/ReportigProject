package com.service.ems.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.ems.util.SendEmailUtil;
import com.service.ems.util.SMSUtil;
/*
 * This controller is only for testing purpose.
 * It can be deleted
 */
@RestController
@RequestMapping(value = "/send")
public class SendSmsMailController {

	@Autowired
	SMSUtil sendSmsUtil;
	
	@Autowired
	SendEmailUtil sendEmailUtil;

	@GetMapping("sms/{no}/{msg}")
	ResponseEntity sendSms(@PathVariable(value = "no") final String no, @PathVariable(value = "msg") final String msg) {
		return ResponseEntity.ok(sendSmsUtil.sendSMS(no, msg));
	}
	@GetMapping("email/{to}/{sub}/{msg}")
	ResponseEntity sendmail(@PathVariable(value = "to") final String to, @PathVariable(value = "msg") final String msg,@PathVariable(value = "sub") final String sub) {
		
		//Creating cc 
		List<String> ccListString = new ArrayList<>();
		ccListString.add("tom.francis@nestgroup.net");
		ccListString.add("nimmy.mol@nestgroup.net");
		Optional<List<String>> cc = Optional.of(ccListString);
		
		//Creating bcc 
				List<String> bccListString = new ArrayList<>();
				ccListString.add("anil.nair@nestgroup.net");
				Optional<List<String>> bcc = Optional.of(ccListString);
				
		//Creating meeting request dates
		String date_s = "2018-03-01 18:00:00"; 
		String date_s2 = "2018-03-01 18:30:00";
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
		Date[] meetingTime = new Date[2];
		try {
			meetingTime[0] = dt.parse(date_s);
			meetingTime[1] = dt.parse(date_s2); 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Optional<Date[]> meeting = Optional.of(meetingTime);
		//To remove cc, bcc and meeting request:
		//Optional<List<String>> cc = Optional.ofNullable(ccListString);
		//Optional<Date[]> meeting = Optional.ofNullable(meetingTime);
		//Optional<Date[]> bcc = Optional.ofNullable(bccListString);

		String organizer = new String("EMA Application");
		String location = new String("Healthcare, Infopark");
		
		sendEmailUtil.send(to, sub, msg, cc, bcc, meeting, organizer, location);
		return ResponseEntity.ok().build();
	}
}
