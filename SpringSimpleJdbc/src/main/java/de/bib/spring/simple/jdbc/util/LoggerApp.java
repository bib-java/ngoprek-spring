package de.bib.spring.simple.jdbc.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Capture all log in application
 * 
 * @author User
 *
 */

public class LoggerApp {

	/**
	 * Print log proses.
	 * 
	 * @param e : exception
	 * @return print error yg terjadi.
	 */
	public static String printLog(Exception e) {
		StringWriter stack = new StringWriter();
		e.printStackTrace(new PrintWriter(stack));
		return stack.toString();

	}
}
