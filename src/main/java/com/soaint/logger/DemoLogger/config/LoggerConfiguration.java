package com.soaint.logger.DemoLogger.config;

import java.io.Serializable;

public abstract class LoggerConfiguration implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public abstract String getProperty(final String property);

}