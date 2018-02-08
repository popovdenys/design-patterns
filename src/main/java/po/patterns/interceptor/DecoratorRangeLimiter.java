package po.patterns.interceptor;

import java.security.NoSuchAlgorithmException;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public abstract class DecoratorRangeLimiter implements Executor {

	@Inject
	@Delegate
	private Executor executor;
	
	@Override
	public double execute(int range) throws NoSuchAlgorithmException {
		
		if(range > 8000) {
			throw new RuntimeException("Range cannot exceed 8000");
		}
		
		return executor.execute(range);
	}

}
