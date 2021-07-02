package com.soaint.logger.DemoLogger.manager;

import java.io.Serializable;
import java.util.logging.ConsoleHandler;

import com.soaint.logger.DemoLogger.config.LoggerConfiguration;

public class ConsoleManager implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static ConsoleManager instance = null;
	
	private ConsoleManager(LoggerConfiguration configuration) {
		super();
	}
	
	public static synchronized ConsoleManager getInstance(LoggerConfiguration configuration) {
		if (instance == null) {
			instance = new ConsoleManager(configuration);
		}
		return instance;
	}
	
	public ConsoleHandler getConsoleHandler() {
		return new ConsoleHandler();
	}

}