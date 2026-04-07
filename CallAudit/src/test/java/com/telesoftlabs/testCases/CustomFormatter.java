package com.telesoftlabs.testCases;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {
	/**
	 * Formats the given log record into a custom log string with detailed information.
	 * The format includes the timestamp, source class name, source method name, log level, 
	 * and the log message, all enclosed in square brackets.
	 * 
	 * @param record The log record to be formatted.
	 * @return A formatted string representation of the log record.
	 */
	@Override
	public String format(LogRecord record) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		builder.append(new Date(record.getMillis())); // Date inside braces
		builder.append("] ");
		builder.append("[");
		builder.append(record.getSourceClassName()); // Class name inside braces
		builder.append("] ");
		builder.append("[");
		builder.append(record.getSourceMethodName()); // Method name inside braces
		builder.append("] ");
		builder.append("[");
		builder.append(record.getLevel()); // Levels inside braces
		builder.append("] ");
		builder.append(record.getMessage());
		builder.append("\n");
		return builder.toString();
	}
}
