package po.patterns.singleton;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InitializationBean {
	private Logger logger;
	
	@PostConstruct
	public void start() {
		logger = LogManager.getLogger("Global initialization");
		logger.info("Initialization has been started with Logger service");
	}
	
	public void initializationInfo(String msg) {
		logger.info(msg);
	}
}
