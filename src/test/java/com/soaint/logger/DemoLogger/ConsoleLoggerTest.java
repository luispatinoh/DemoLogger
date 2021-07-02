package com.soaint.logger.DemoLogger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.soaint.logger.DemoLogger.config.DefaultConfiguration;
import com.soaint.logger.DemoLogger.domain.LoggerType;
import com.soaint.logger.DemoLogger.exception.HandlerException;
import com.soaint.logger.DemoLogger.exception.LogFileException;
import com.soaint.logger.DemoLogger.exception.LoggerTypeException;
import com.soaint.logger.DemoLogger.exception.MessageException;
import com.soaint.logger.DemoLogger.factory.LoggerFactory;
import com.soaint.logger.DemoLogger.interfaces.ILogger;
import com.soaint.logger.DemoLogger.manager.ConsoleManager;
import com.soaint.logger.DemoLogger.impl.ConsoleLogger;

public class ConsoleLoggerTest {
	
	@Before
	public final void baseSetUp() {}
	
	@After
	public final void baseTearDown() {}
	
	@Test
    public void testLoggerFactory_ConsoleType() {
		ILogger logger;
		try {
			logger = LoggerFactory.getLogger(LoggerType.CONSOLE.getType());
			assertEquals(true, logger instanceof ConsoleLogger);
		} catch (SecurityException e) {
			fail("Exception " + e);
		} catch (HandlerException e) {
			fail("Exception " + e);
		} catch (LogFileException e) {
			fail("Exception " + e);
		} catch (LoggerTypeException e) {
			fail("Exception " + e);
		}
    }
	
	@Test
    public void testConsoleManager_HandlerValid() {
		ConsoleManager consoleManager = ConsoleManager.getInstance(new DefaultConfiguration());
		assertNotNull(consoleManager.getConsoleHandler());
    }
	
	@Test
    public void testLoggerConsole_addMessageInfo() {
		ILogger logger;
		try {
			logger = LoggerFactory.getLogger(LoggerType.CONSOLE.getType());
			logger.message("Prueba de mensaje en log");
	        assertEquals(true, logger instanceof ConsoleLogger);
		} catch (SecurityException e) {
			fail("Exception " + e);
		} catch (HandlerException e) {
			fail("Exception " + e);
		} catch (LogFileException e) {
			fail("Exception " + e);
		} catch (LoggerTypeException e) {
			fail("Exception " + e);
		} catch (MessageException e) {
			fail("Exception " + e);
		}
    }
	
	@Test
    public void testLoggerConsole_addMultipleMessage() {
		ILogger logger;
		try {
			logger = LoggerFactory.getLogger(LoggerType.CONSOLE.getType());
			logger.message("Prueba de mensaje en log");
			logger.warning("Prueba de warning en log");
			logger.error("Prueba de error en log");
	        assertEquals(true, logger instanceof ConsoleLogger);
		} catch (SecurityException e) {
			fail("Exception " + e);
		} catch (HandlerException e) {
			fail("Exception " + e);
		} catch (LogFileException e) {
			fail("Exception " + e);
		} catch (LoggerTypeException e) {
			fail("Exception " + e);
		} catch (MessageException e) {
			fail("Exception " + e);
		}
    }
	
}
