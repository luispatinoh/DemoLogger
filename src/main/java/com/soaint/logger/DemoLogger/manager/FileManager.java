package com.soaint.logger.DemoLogger.manager;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.FileHandler;

import com.soaint.logger.DemoLogger.config.LoggerConfiguration;
import com.soaint.logger.DemoLogger.exception.HandlerException;
import com.soaint.logger.DemoLogger.exception.LogFileException;

public class FileManager implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private LoggerConfiguration config;
	
	public FileManager(LoggerConfiguration config) {
		super();
		this.config = config;
	}
	
	public File getLogFile() throws LogFileException {
		File logFile = new File(this.config.getProperty("logger.logFilePath"));
		if (!logFile.exists()) {
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				throw new LogFileException("Error de creacion de archivo ");
			}
		}
		return logFile;
	}
	
	public FileHandler getFileHandler() throws HandlerException, LogFileException {
		try {
			getLogFile();
			return new FileHandler(this.config.getProperty("logger.logFilePath"));
		} catch (SecurityException e) {
			throw new  HandlerException("Error de handler de archivo");
		} catch (IOException e) {
			throw new  HandlerException("Error de handler de archivo");
		}
	}

}