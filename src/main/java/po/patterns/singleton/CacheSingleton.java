package po.patterns.singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.DependsOn;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.apache.logging.log4j.LogManager;

@Startup
@DependsOn({"LoggingBean", "InitializationBean"})
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Singleton
@AccessTimeout(value=100000) // in milliseconds
public class CacheSingleton {
	private Map<Integer, String> cache;
	
	@PostConstruct
	public void start() {
		LogManager.getLogger(CacheSingleton.class).info("Singleton started");
		cache = new HashMap<>();
	}
	
	// can generate ConcurrentAccessTimeoutException
	@AccessTimeout(value=30, unit=TimeUnit.SECONDS)
	@Lock(LockType.WRITE)
	public void addUser(Integer id, String name) {
		cache.put(id, name);
	}
	
	@Lock(LockType.READ)
	public String getName(Integer id) {
		return cache.get(id);
	}
}
