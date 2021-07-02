package com.soaint.logger.DemoLogger.domain;

public enum LoggerType {
	
	CONSOLE ("console"), 
	DATABASE ("database"), 
	FILE ("file");
	
	private String type;
	
	private LoggerType(final String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
}