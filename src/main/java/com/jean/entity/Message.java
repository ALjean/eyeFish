package com.jean.entity;

import com.jean.enums.MessageKey;

public class Message {

    private int id;

    private MessageKey key;

    private String text;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public MessageKey getKey() {
	return key;
    }

    public void setKey(MessageKey key) {
	this.key = key;
    }

    public String getText() {
	return text;
    }

    public void setText(String text) {
	this.text = text;
    }

    public Message() {
	super();
    }

    public Message(int id, MessageKey key, String text) {
	super();
	this.id = id;
	this.key = key;
	this.text = text;
    }

}