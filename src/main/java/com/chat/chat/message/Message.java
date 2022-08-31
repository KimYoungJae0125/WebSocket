package com.chat.chat.message;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDateTime;

public class Message {
    private String receiverId;
    private String message;

    private String sender;

    private LocalDateTime time;

    public String getReceiverId() {
        return this.receiverId;
    }
    public String getMessage() {
        return this.message;
    }

    public String getSender() {
        return this.sender;
    }

    public LocalDateTime getTime() {
        return this.time;
    }
    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }


}
