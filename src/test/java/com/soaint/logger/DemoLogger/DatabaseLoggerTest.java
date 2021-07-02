package com.soaint.logger.DemoLogger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.soaint.logger.DemoLogger.config.DefaultConfiguration;
import com.soaint.logger.DemoLogger.domain.LoggerType;
import com.soaint.logger.DemoLogger.domain.MessageType;
import com.soaint.logger.DemoLogger.exception.HandlerException;
import com.soaint.logger.DemoLogger.exception.LogFileException;
import com.soaint.logger.DemoLogger.exception.LoggerTypeException;
import com.soaint.logger.DemoLogger.exception.MessageException;
import com.soaint.logger.DemoLogger.factory.LoggerFactory;
import com.soaint.logger.DemoLogger.interfaces.ILogger;
import com.soaint.logger.DemoLogger.manager.DatabaseManager;
import com.soaint.logger.DemoLogger.impl.DatabaseLogger;

public class DatabaseLoggerTest {
	
	@Before
	public final void baseSetUp() {}
	
	@After
	public final void baseTearDown() {}
	
	@Test
    public void testLoggerFactory_DatabaseType() {
		ILogger logger;
		try {
			logger = LoggerFactory.getLogger(LoggerType.DATABASE.getType());
			assertEquals(true, logger instanceof DatabaseLogger);
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
    public void testDatabaseManager_BDConnectionValid() {
		DatabaseManager bdManager = DatabaseManager.getInstance(new DefaultConfiguration());
		try {
			assertTrue(bdManager.getConnection().isValid(0));
		} catch (SQLException e) {
			assertTrue(false);
		}
    }
	
	@Test
    public void testDatabaseManager_insertMessage() {
		try {
			DatabaseManager bdManager = DatabaseManager.getInstance(new DefaultConfiguration());
			bdManager.createLogTable();
			bdManager.insertMessageBD("Prueba de insercion en log", MessageType.MESSAGE.getId());
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
    }
	
	@Test
    public void testLoggerDatabase_addLog() {
		try {
			ILogger logger = LoggerFactory.getLogger(LoggerType.DATABASE.getType());
			logger.message("Prueba de mensaje en log");
			logger.warning("Prueba de warning en log");
			logger.error("Prueba de error en log");
	        assertTrue(true);
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
