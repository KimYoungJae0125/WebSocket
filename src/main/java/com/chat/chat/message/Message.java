package com.chat.chat.message;

public class Message {
    private String receiverId;
    private String message;

    public String getReceiverId() {
        return this.receiverId;
    }
    public String getMessage() {
        return this.message;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}
