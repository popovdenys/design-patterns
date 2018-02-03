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
