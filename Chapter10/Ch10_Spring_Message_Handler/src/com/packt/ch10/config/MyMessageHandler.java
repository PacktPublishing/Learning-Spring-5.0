package com.packt.ch10.config;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


public class MyMessageHandler extends TextWebSocketHandler {

	List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();


	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
		String country = message.getPayload();
		String reply="No data available";
		if(country.equals("India"))
		{
			reply="DELHI";
		}
		else if(country.equals("USA"))
		{
			reply="Washington,D.C";
		}
		System.out.println("handling message");
		
		for(WebSocketSession webSsession:sessions)
		{
			session.sendMessage(new TextMessage(reply));	
		}
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws IOException {
		// Handle new connection here
		
		System.out.println("connection establieshed:hello");
		sessions.add(session);
		session.sendMessage(new TextMessage("connection establieshed:hello"));
		}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws IOException {
		// Handle closing connection here
		System.out.println("connection closed : BYE");
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws IOException {
		session.sendMessage(new TextMessage("Error!!!!!!"));
		}
}