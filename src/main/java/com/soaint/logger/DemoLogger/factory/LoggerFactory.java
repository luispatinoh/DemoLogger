package com.soaint.logger.DemoLogger.factory;

import com.soaint.logger.DemoLogger.impl.ConsoleLogger;
import com.soaint.logger.DemoLogger.impl.DatabaseLogger;
import com.soaint.logger.DemoLogger.impl.FileLogger;
import com.soaint.logger.DemoLogger.config.LoggerConfiguration;
import com.soaint.logger.DemoLogger.config.DefaultConfiguration;
import com.soaint.logger.DemoLogger.domain.LoggerType;
import com.soaint.logger.DemoLogger.exception.HandlerException;
import com.soaint.logger.DemoLogger.exception.LogFileException;
import com.soaint.logger.DemoLogger.exception.LoggerTypeException;
import com.soaint.logger.DemoLogger.interfaces.ILogger;

public class LoggerFactory {
	
	private LoggerFactory() {
		super();
	}
	
	public static ILogger getLogger(String type) throws SecurityException, HandlerException, LogFileException, LoggerTypeException {
		if (LoggerType.FILE.getType().equals(type)) {
			return new FileLogger(new DefaultConfiguration());
		} else if (LoggerType.CONSOLE.getType().equals(type)) {
			return new ConsoleLogger(new DefaultConfiguration());
		} else if (LoggerType.DATABASE.getType().equals(type)) {
			return new DatabaseLogger(new DefaultConfiguration());
		} else {
			throw new LoggerTypeException("Tipo no valido");
		}
	}
	
	public static ILogger getLogger(String type, LoggerConfiguration configuration) throws SecurityException, HandlerException, LogFileException, LoggerTypeException {
		if (LoggerType.FILE.getType().equals(type)) {
			return new FileLogger(configuration);
		} else if (LoggerType.CONSOLE.getType().equals(type)) {
			return new ConsoleLogger(configuration);
		} else if (LoggerType.DATABASE.getType().equals(type)) {
			return new DatabaseLogger(configuration);
		} else {
			throw new LoggerTypeException("Tipo no valido");
		}
	}

}