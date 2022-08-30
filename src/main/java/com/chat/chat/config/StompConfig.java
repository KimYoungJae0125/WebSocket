package com.chat.chat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
@EnableWebSocketMessageBroker
@Profile("local")
public class StompConfig implements WebSocketMessageBrokerConfigurer {

    @Value("${websocket.portInfo}")
    private String portInfo;
    @Bean
    public String getPortInfo() {
        return portInfo;
    }
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        System.out.println(getPortInfo());
        registry.addEndpoint("/websocket").setAllowedOrigins(getPortInfo()).withSockJS();
    }

    //패키지 된 프로젝트는 내장 tomcat에 의존하지 않기 때문에 Springboot에 내장 된 tomcat의 일반 코드는 외부 컨테이너에서 실행 할 수 없다.
//    @Profile({"dev", "test"})
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
