package com.soaint.logger.DemoLogger.impl;

import java.text.DateFormat;
import java.util.Date;

import org.apache.logging.log4j.util.Strings;

import com.soaint.logger.DemoLogger.config.LoggerConfiguration;
import com.soaint.logger.DemoLogger.domain.MessageType;
import com.soaint.logger.DemoLogger.exception.MessageException;
import com.soaint.logger.DemoLogger.interfaces.ILogger;
import com.soaint.logger.DemoLogger.manager.DatabaseManager;

public class DatabaseLogger implements ILogger {
	
	private DatabaseManager manager;
	
	public DatabaseLogger(LoggerConfiguration configuration) {
		this.manager = DatabaseManager.getInstance(configuration);
	}
	
	public void message(String message) throws MessageException {
		if (Strings.isBlank(message)) {
			throw new MessageException("Mensaje no valido");
		}
		String errorMessage = "message " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + message;
		this.manager.insertMessageBD(errorMessage, MessageType.MESSAGE.getId());
	}

	public void warning(String message) throws MessageException {
		if (Strings.isBlank(message)) {
			throw new MessageException("Mensaje no valido");
		}
		String errorMessage = "warning " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + message;
		this.manager.insertMessageBD(errorMessage, MessageType.WARNING.getId());
	}

	public void error(String message) throws MessageException {
		if (Strings.isBlank(message)) {
			throw new MessageException("Mensaje no valido");
		}
		String errorMessage = "error " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + message;
		this.manager.insertMessageBD(errorMessage, MessageType.ERROR.getId());
	}

}