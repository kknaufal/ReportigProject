package com.service.ems.util;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface SendEmailUtil {

	void send(String to, String subject, String message, Optional<List<String>> cc, Optional<List<String>> bcc,Optional<Date[]> meetingRequest, String organizer, String location);
	
}
