package com.soaint.logger.DemoLogger.impl;

import java.util.logging.Level;

import org.apache.logging.log4j.util.Strings;

import com.soaint.logger.DemoLogger.config.LoggerConfiguration;
import com.soaint.logger.DemoLogger.exception.MessageException;
import com.soaint.logger.DemoLogger.interfaces.ILogger;
import com.soaint.logger.DemoLogger.manager.ConsoleManager;

public class ConsoleLogger implements ILogger {
	
	private ConsoleManager manager;
	
	public ConsoleLogger(LoggerConfiguration configuration) {
		this.manager = ConsoleManager.getInstance(configuration);
		logger.addHandler(this.manager.getConsoleHandler());
	}
	
	public void message(String message) throws MessageException {
		if (Strings.isBlank(message)) {
			throw new MessageException("Mensaje no valido");
		}
		logger.log(Level.INFO, message);
	}

	public void warning(String message) throws MessageException {
		if (Strings.isBlank(message)) {
			throw new MessageException("Mensaje no valido");
		}
		logger.log(Level.WARNING, message);
	}

	public void error(String message) throws MessageException {
		if (Strings.isBlank(message)) {
			throw new MessageException("Mensaje no valido");
		}
		logger.log(Level.SEVERE, message);
	}

}