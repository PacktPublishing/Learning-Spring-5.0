package com.packt.ch10.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;

import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.packt.ch10.model.MyBook;
import com.packt.ch10.model.Result;

@Controller("/webS")
public class WebSocketController {

	@RequestMapping("/bookPage")
	public String bookPage() {
		System.out.println("hello");
		return "book";
	}

	@MessageMapping("/book")
	@SendTo("/topic/showOffer")
	public Result showOffer(MyBook myBook) throws Exception {
		System.out.println(myBook.getBookName());
	
		Result result = new Result();
		result.getOffer(myBook.getBookName());
		return result;
	}

}
