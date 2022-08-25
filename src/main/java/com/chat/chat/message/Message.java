package com.chat.chat.message;

public class Message {
    private String receiverId;
    private String message;

    private String sender;

    public String getReceiverId() {
        return this.receiverId;
    }
    public String getMessage() {
        return this.message;
    }

    public String getSender() {
        return this.sender;
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


}
