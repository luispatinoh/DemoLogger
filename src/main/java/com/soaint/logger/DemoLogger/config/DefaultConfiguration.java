package com.soaint.logger.DemoLogger.config;

public class DefaultConfiguration extends LoggerConfiguration {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getProperty(final String property) {
		String message = null;
		if (property.equals("logger.logFilePath")) {
			message = "./data/log.txt";
		} else if (property.equals("logger.bd.username")) {
			message = "admin";
		} else if (property.equals("logger.bd.password")) {
			message = "admin";
		} else if (property.equals("logger.bd.jdbcDriver")) {
			message = "org.h2.Driver";
		} else if (property.equals("logger.bd.dburl")) {
			message = "jdbc:h2:./data/acmeDB";
		}
		
		return message;
	}

}