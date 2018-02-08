/*
 * File : ReduceRange.java
 * Description : todo
 * 
 * Author :
 * Created :
 * 
 * Modified :
 * Modified by:
 * 
 * Last modification : 
 */

package po.patterns.interceptor;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.stream.Stream;

import javax.enterprise.context.Dependent;

@Dependent
@Profiled
public class ReduceRange implements Executor {

	@Override
	public double execute(int range) throws NoSuchAlgorithmException {
		
		SecureRandom algorithm = SecureRandom.getInstanceStrong();
		
		return Stream.generate(algorithm::nextDouble).limit(range).reduce(0d, (x, y) -> x+y);
		
	}

}
