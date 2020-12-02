package com.konecta.serversocket.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer{

	private final static String ENDPOINT = "/v1";
	
	public WebSocketConfiguration() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		
		registry.addHandler(getWebSocketHandler(), ENDPOINT).setAllowedOrigins("*");
	}
	
	@Bean
	public WebSocketHandler getWebSocketHandler() {
		return new com.konecta.serversocket.service.WebSocketHandler();
	}

}
