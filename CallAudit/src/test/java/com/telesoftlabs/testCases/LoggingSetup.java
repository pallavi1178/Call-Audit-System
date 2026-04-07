package com.telesoftlabs.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggingSetup {
	private static FileHandler fileHandler;

	static {
		try (FileInputStream fis = new FileInputStream("./Configurations/logging.properties")) {
			LogManager.getLogManager().readConfiguration(fis);
		} catch (IOException e) {
			System.err.println("Could not load logging.properties file from Configurations folder");
			e.printStackTrace();
		}
		configureLogger();
	}

	/**
	 * Configures the logger with a console handler and a file handler.
	 * It ensures the existence of the "logs" directory and manages log file handling.
	 * 
	 * 1. Creates the "logs" directory if it doesn't exist.
	 * 2. Deletes an empty log file if it already exists.
	 * 3. Configures the logger to log messages with INFO level or higher.
	 * 4. Adds a custom formatter for both the console and file handlers.
	 * 5. Sets a file handler with a size limit of 5MB per log file, appending to the existing file.
	 * 
	 * This method is intended to set up the logging configuration for the application.
	 */
	public static void configureLogger() {
		if (fileHandler == null) {
			try {
				// Create logs directory if it doesn't exist
				String logDir = "logs";
				File dir = new File(logDir);
				if (!dir.exists()) {
					dir.mkdirs();
				}

				/*
				LocalDateTime local = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
				 String dateTime=local.format(formatter);
				File baseLogFile = new File(logDir, dateTime+".log");
				 */
				File baseLogFile = new File(logDir, "TelesuiteLoggerTestResult.log");
				if (baseLogFile.exists() && baseLogFile.length() == 0) {
					baseLogFile.delete();
				}

				// Define the log directory and file pattern
				//String logFilePattern = logDir + "/"+dateTime+".log.%g";
				String logFilePattern = logDir + "/TelesuiteLoggerTestResult.log.%g";

				// Remove existing handlers (if any)
				Logger rootLogger = Logger.getLogger("");
				Handler[] handlers = rootLogger.getHandlers();
				for (Handler handler : handlers) {
					rootLogger.removeHandler(handler);
				}

				// Set log level globally
				rootLogger.setLevel(Level.INFO);
				// Create and configure console handler
				ConsoleHandler consoleHandler = new ConsoleHandler();
				consoleHandler.setLevel(Level.INFO);
				consoleHandler.setFormatter(new CustomFormatter());
				rootLogger.addHandler(consoleHandler);

				// Create and configure file handler
				fileHandler = new FileHandler(logFilePattern, 5 * 1024 * 1024, 5, true); // Append to existing log
				fileHandler.setLevel(Level.INFO);
				fileHandler.setFormatter(new CustomFormatter());
				rootLogger.addHandler(fileHandler);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// Optional: Delete existing log files
	private static void deleteExistingLogFiles(String logDir) {
		File dir = new File(logDir);
		if (dir.exists() && dir.isDirectory()) {
			for (File file : dir.listFiles()) {
				if (file.isFile() && file.getName().startsWith("app.log")) {
					file.delete();
				}
			}
		}
	}
}
