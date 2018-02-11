package po.patterns.singleton;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Startup
@Singleton
public class LoggingBean {
	
	private Logger logger;
	
	@PostConstruct
	public void start() {
		logger = LogManager.getLogger("GlobalLogger");
		logger.info("Logger started first");
	}
	
	public void logInfo(String msg) {
		logger.info(msg);
	}
	
}
