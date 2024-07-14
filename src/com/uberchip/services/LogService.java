package com.uberchip.services;

/**
 * Refactored to provide a cleaner and more flexible logging mechanism.
 */
public class LogService {
	private StringBuilder logOutput = new StringBuilder();
	
	/**
	 * Logs a line of information. Each argument is logged in a new line.
	 * 
	 * @param msgObjs the objects to log
	 */
	public void logInfoLn(Object... msgObjs) {
        if (msgObjs == null || msgObjs.length == 0) {
            System.out.println();
            logOutput.append("\n");
        } else {
            for (Object msgObj : msgObjs) {
                System.out.println(msgObj.toString());
                logOutput.append(msgObj.toString()).append("\n");
            }
        }
    }
	
	/**
	 * Logs information without a newline. Arguments are logged in a single line.
	 * 
	 * @param msgObjs the objects to log
	 */
	public void logInfo(Object... msgObjs) {
        if (msgObjs != null) {
            for (Object msgObj : msgObjs) {
                System.out.print(msgObj.toString());
                logOutput.append(msgObj.toString());
            }
        }
    }

	/**
     * Clears the current log output.
     */
	public void clearOutput() {
        logOutput.setLength(0);
    }

	/**
     * Retrieves the current log output as a string.
     * 
     * @return the current log output
     */
	public String getLogOutput() {
        return logOutput.toString();
    }
}
