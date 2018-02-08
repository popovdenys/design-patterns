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

public class ClientApp {

	public static void main(String[] args) {
		int[] i = {0};
		
		List<Integer> data = Collections.synchronizedList(new ArrayList<>());
/*		
		Stream.generate(()->i[0] += 1).parallel()
				.limit(1000)
				.peek(System.out::print)
				.map(x->{data.add(x); return x;})
				.forEachOrdered(x->System.out.print(x + " "));

*/
		Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30).parallelStream()
				.map(x->{data.add(x); return x;})
				.forEachOrdered(x->System.out.print(x + " "));
				
				
		System.out.println();
		for(Integer e : data) {
			System.out.print(e + " ");
		}
		
	}

}
