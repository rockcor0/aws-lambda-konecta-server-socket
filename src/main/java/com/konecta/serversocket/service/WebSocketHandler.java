package com.konecta.serversocket.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * 
 * @author Ricardo Delgado
 *
 */
public class WebSocketHandler extends TextWebSocketHandler{

	private final List<WebSocketSession> webSocketSessions = new ArrayList<>();
	
	public WebSocketHandler() {
		// TODO Auto-generated constructor stub
	}
	
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//super.afterConnectionEstablished(session);
		webSocketSessions.add(session);
	}
	
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//super.handleTextMessage(session, message);
		for (WebSocketSession webSocketSession : webSocketSessions) {
			webSocketSession.sendMessage(message);
		}
	}
	
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//		super.afterConnectionClosed(session, status);
		webSocketSessions.remove(session);
	}
	
	
	
}
