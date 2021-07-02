package com.soaint.logger.DemoLogger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

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
import com.soaint.logger.DemoLogger.manager.FileManager;
import com.soaint.logger.DemoLogger.impl.FileLogger;

public class FileLoggerTest {
	
	@Before
	public final void baseSetUp() {}
	
	@After
	public final void baseTearDown() {}
	
	@Test
    public void testLoggerFactory_FileType() {
		ILogger logger;
		try {
			logger = LoggerFactory.getLogger(LoggerType.FILE.getType());
			assertEquals(true, logger instanceof FileLogger);
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
    public void testLoggerFactory_TypeNoValid() {
		ILogger logger;
		try {
			logger = LoggerFactory.getLogger("noValid");
			assertEquals(true, logger instanceof FileLogger);
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
    public void testFileManager_HandlerValid() {
		try {
			FileManager fileManager = new FileManager(new DefaultConfiguration());
			assertNotNull(fileManager.getFileHandler());
		} catch (HandlerException e) {
			fail("Exception " + e);
		} catch (LogFileException e) {
			fail("Exception " + e);
		}
    }
	
	@Test
    public void testLoggerFile_addMessageInfo() {
		ILogger logger;
		try {
			logger = LoggerFactory.getLogger(LoggerType.FILE.getType());
			logger.message("Prueba de mensaje en log");
			assertEquals(true, logger instanceof FileLogger);
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
    public void testLoggerFile_addMultipleMessage() {
		ILogger logger;
		try {
			logger = LoggerFactory.getLogger(LoggerType.FILE.getType());
			logger.message("Prueba de mensaje en log");
			logger.warning("Prueba de warning en log");
			logger.error("Prueba de error en log");
	        assertEquals(true, logger instanceof FileLogger);
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
