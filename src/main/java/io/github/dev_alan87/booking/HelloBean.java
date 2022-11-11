package io.github.dev_alan87.booking;

import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ViewScoped
public class HelloBean {

	@Autowired
	private MsgService msgService;
	
	public String getMsg() {
		return msgService.getMsg();
	}
	
}
