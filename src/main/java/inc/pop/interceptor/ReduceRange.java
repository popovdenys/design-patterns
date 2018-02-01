package inc.pop.interceptor;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
//import java.util.stream.Stream;

import javax.enterprise.context.Dependent;

@Dependent
@Profiled
public class ReduceRange implements Executor {

	@Override
	public int execute(int range) {
		
//		SecureRandom algorithm = SecureRandom.getInstanceStrong();
		
//		return Stream.generate(algorithm::nextDouble).limit(range).reduce(0d, (x, y) -> x+y);
		
		return 1;
		
	}

}
