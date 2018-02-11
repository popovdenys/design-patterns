/*
 * File : ClientApp.java
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

package po.patterns.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.status.StatusConsoleListener;
import org.apache.logging.log4j.status.StatusLogger;


public class ClientApp {
	
	private static final Logger logger = LogManager.getLogger(ClientApp.class);
	
	public static void main(String[] args) {
		
		logger.error("some error");
		
		logger.trace("Entering application");
		
		int[] i = {0};
		
		List<Integer> dataParallel = Collections.synchronizedList(new ArrayList<>());
		List<Integer> dataParallelStream = Collections.synchronizedList(new ArrayList<>());
		
		Stream.generate(()->i[0] += 1).parallel()
				.limit(30)
				.map(x->{dataParallel.add(x); return x;})
				.forEachOrdered(x->System.out.print(x + " "));

		System.out.println();
		
		Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30).parallelStream()
				.map(x->{dataParallelStream.add(x); return x;})
				.forEachOrdered(x->System.out.print(x + " "));
		
		System.out.println();
		
		for(Integer e : dataParallel) {
			System.out.print(e + " ");
		}
		
		System.out.println();
		
		for(Integer e : dataParallelStream) {
			System.out.print(e + " ");
		}
		
/*
		Log4j2Test log4j = new Log4j2Test();
		
		log4j.testMethod();
*/		
		System.out.println();
		
		logger.trace("trace event");
		
	}

}
