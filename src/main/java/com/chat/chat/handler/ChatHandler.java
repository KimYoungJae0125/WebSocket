package com.chat.chat.handler;


import com.chat.chat.message.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

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
    private static final List<Session> session = new ArrayList<Session>();

    @OnOpen
    public void open(Session newUser) {
        System.out.println("connected");
        session.add(newUser);
        System.out.println(newUser.getId());
    }

    @OnMessage
    public void getMsg(Session recieveSession, String msg) {
        Message message = new Message();
        try {
            message = new ObjectMapper().readValue(msg, Message.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        for (int i=0; i<session.size(); i++) {
            if(!recieveSession.getId().equals(session.get(i).getId())) {
                try {
                    message.setSender("상대");
//                    session.get(i).getBasicRemote().sendText("상대(" + message.getReceiverId() + ") : " + message.getMessage());
                    session.get(i).getBasicRemote().sendText(new ObjectMapper().writeValueAsString(message));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    message.setSender("나");
//                    session.get(i).getBasicRemote().sendText("나(" + message.getReceiverId() + ") : " + message.getMessage());
                    session.get(i).getBasicRemote().sendText(new ObjectMapper().writeValueAsString(message));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
