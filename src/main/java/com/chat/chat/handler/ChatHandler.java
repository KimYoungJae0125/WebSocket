package com.chat.chat.handler;


import com.chat.chat.message.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

@Component
@ServerEndpoint(value = "/websocket")
public class ChatHandler extends Socket {
    private static final List<Session> session = new ArrayList<>();

    private ObjectMapper objectMapper;
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("connected");
        this.session.add(session);
        System.out.println(session.getId());
    }

    @OnMessage
    public void onMessage(Session session, String msg) {
        objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        Message message = new Message();
        try {
            message = objectMapper.readValue(msg, Message.class);
        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
            System.out.println(msg);
            System.out.println("session X");
            throw new RuntimeException(e);
        }

        for (int i=0, len=this.session.size(); i<len; i++) {
            message.setSender(session.getId().equals(this.session.get(i).getId()) ? "나" : "상대");
            try {
                this.session.get(i).getBasicRemote().sendText(objectMapper.writeValueAsString(message));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("connection close");
        this.session.remove(session);
    }

}
