package com.service.ems.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SendEmailUtilImpl implements SendEmailUtil {

	@Autowired
	public JavaMailSender emailSender;

	@Override
	public void send(String to, String subject, String messageBody, Optional<List<String>> cc, Optional<List<String>> bcc,
			Optional<Date[]> meetingRequest, String organizer, String location) {
		try {

			MimeMessage message1 = emailSender.createMimeMessage();

			InternetAddress recipient = new InternetAddress(to);

			message1.addRecipient(Message.RecipientType.TO, recipient);
			message1.setSubject(subject);
			message1.setText(messageBody);
			//check for cc
			if (cc.isPresent()) {
				List<String> ccListString = cc.get();
				int i = 0;
				InternetAddress[] ccList = new InternetAddress[ccListString.size()];
				for (String ccString : ccListString) {
					ccList[i] = new InternetAddress(ccString);
					i++;
				}
				message1.addRecipients(Message.RecipientType.CC, ccList);
			}
			//check for bcc
			if (bcc.isPresent()) {
				List<String> bccListString = bcc.get();
				int i = 0;
				InternetAddress[] bccList = new InternetAddress[bccListString.size()];
				for (String bccString : bccListString) {
					bccList[i] = new InternetAddress(bccString);
					i++;
				}
				message1.addRecipients(Message.RecipientType.BCC, bccList);
			}
			//check for meeting request
			if(meetingRequest.isPresent()) {
				Date meetingTime[] = meetingRequest.get();
				SimpleDateFormat dtFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
				String dtStart = dtFormat.format(meetingTime[0]);
				String dtEnd = dtFormat.format(meetingTime[1]);
				StringBuffer sb = new StringBuffer();
				StringBuffer buffer = sb
						.append("BEGIN:VCALENDAR\n" + "PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN\n"
								+ "VERSION:2.0\n" + "METHOD:REQUEST\n" + "BEGIN:VEVENT\n" +

								"ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=TRUE:MAILTO:emy.baby@nestgroup.net\n" + // meeting
																											// attendees
								"ORGANIZER:MAILTO:" + organizer + "\n" + // organizer email
								"DTSTART:"+dtStart+"\n" + // meeting start date time
								"DTEND:"+dtEnd+"\n" + // meeting end date time
								"LOCATION:" + location + "\n" + // meeting room
								"TRANSP:OPAQUE\n" + "SEQUENCE:0\n"
								+ "UID:040000008200E00074C5B7101A82E00800000000002FF466CE3AC5010000000000000000100\n"
								+ " 000004377FE5C37984842BF9440448399EB02\n" + "DTSTAMP:20180109T192000Z\n"
								+ "CATEGORIES:Meeting\n" + "DESCRIPTION:" + messageBody + "\n\n" + "PRIORITY:5\n"
								+ "CLASS:PUBLIC\n" + "BEGIN:VALARM\n" + "TRIGGER:PT1440M\n" + "ACTION:DISPLAY\n"
								+ "DESCRIPTION:Reminder\n" + "END:VALARM\n" + "END:VEVENT\n" + "END:VCALENDAR");
				System.out.println("Message String_____\n"+buffer);
				message1.setHeader("Content-Class", "urn:content-  classes:calendarmessage");
				message1.setHeader("Content-ID", "calendar_message");
				message1.setDataHandler(new DataHandler(new ByteArrayDataSource(buffer.toString(), "text/calendar")));

				// Create the message part
				BodyPart messageBodyPart = new MimeBodyPart();

				// Fill the message
				messageBodyPart.setHeader("Content-Class", "urn:content-  classes:calendarmessage");
				messageBodyPart.setHeader("Content-ID", "calendar_message");
				messageBodyPart
						.setDataHandler(new DataHandler(new ByteArrayDataSource(buffer.toString(), "text/calendar")));// very
																														// important

				// Create a Multipart
				Multipart multipart = new MimeMultipart();

				// Add part one
				multipart.addBodyPart(messageBodyPart);

				// Put parts in message
				message1.setContent(multipart);
			}
			emailSender.send(message1);

		} catch (MessagingException me) {
			me.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
