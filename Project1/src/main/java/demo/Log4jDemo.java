package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;
public class Log4jDemo {
	
	private static Logger logger = LogManager.getLogger(Log4jDemo.class);
	
	public static void main(String[] args) {
		logger.info("Info logger");
		logger.warn("warn logger");
		logger.debug("debug logger");
	}
}
