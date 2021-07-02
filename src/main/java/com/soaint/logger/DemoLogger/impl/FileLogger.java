package com.soaint.logger.DemoLogger.impl;

import java.util.logging.Level;

import org.apache.logging.log4j.util.Strings;

import com.soaint.logger.DemoLogger.config.LoggerConfiguration;
import com.soaint.logger.DemoLogger.exception.HandlerException;
import com.soaint.logger.DemoLogger.exception.LogFileException;
import com.soaint.logger.DemoLogger.exception.MessageException;
import com.soaint.logger.DemoLogger.interfaces.ILogger;
import com.soaint.logger.DemoLogger.manager.FileManager;

public class FileLogger implements ILogger {
	
	private FileManager manager;
	
	public FileLogger(LoggerConfiguration configuration) throws SecurityException, HandlerException, LogFileException {
		this.manager = new FileManager(configuration);
		logger.addHandler(this.manager.getFileHandler());
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