package com.soaint.logger.DemoLogger.domain;

public enum MessageType {
	
	MESSAGE (1, "message"), 
	WARNING (2, "warning"),
	ERROR (3, "error");
	
	private int id;
	private String name;
	
	private MessageType(final int id, final String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

}