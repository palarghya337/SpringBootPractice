package com.practice.springboot.utils;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.logging.Logger;

import com.practice.springboot.exceptions.InvalidOperationException;

public final class Log {

	private static final Logger LOGGER = Logger.getLogger(Log.class.getSimpleName());
	static {
		System.setProperty("java.util.logging.SimpleFormatter.format", "%4$s: %5$s %n");
	}
	private Log() {
		throw new InvalidOperationException("Object creation is not allowed.");
	}
	public static void logInfo(String pattern, Object...arguments) {

		MessageFormat format = new MessageFormat(pattern);
		String message = format.format(arguments);
		LOGGER.info(message);
	}

  public static <T> void logInfo(T object) {
    String message = Objects.toString(object, "null");
    LOGGER.info(message);
  }
}
