package example;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;

public class LoggerExample {
	
	org.apache.logging.log4j.Logger log = LogManager.getLogger(LoggerExample.class.getName());
	
	
	
	void Test() {
		log.info("info Log");
		log.debug("Debug Log");
		log.fatal("Fatal Log");
		log.error("Error Log");
		log.warn("Warn Log");
	}
	

}
