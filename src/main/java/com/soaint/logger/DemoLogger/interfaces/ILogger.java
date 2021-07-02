package com.soaint.logger.DemoLogger.interfaces;

import java.util.logging.Logger;

import com.soaint.logger.DemoLogger.exception.MessageException;

public interface ILogger {
	
	public static final Logger logger = Logger.getLogger("ILogger");
	
	public void message(String message) throws MessageException;
	public void warning(String message) throws MessageException;
	public void error(String message) throws MessageException;

}