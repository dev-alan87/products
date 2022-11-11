package io.github.dev_alan87.booking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.springframework.stereotype.Service;


public interface MsgService {

	String getMsg();
	
	@Service
	public static class DefaultMsgService implements MsgService {

		@Override
		public String getMsg() {
			return String.format("Hi there, it's %s here", 
					LocalDateTime.now()
						.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
		}
	}
}
