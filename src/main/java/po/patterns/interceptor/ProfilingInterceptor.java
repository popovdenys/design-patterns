/*
 * File : ProfilingInterceptor.java
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

import java.time.Instant;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Profiled
public class ProfilingInterceptor {

	@AroundInvoke
	public Object interceptMethod(InvocationContext ctx) throws Exception {
		
		String className = ctx.getMethod().getDeclaringClass().getSimpleName();
		String methodName = ctx.getMethod().getName();
		
		System.out.println("Init profile of " + className + "." + methodName);
		
		long start = Instant.now().toEpochMilli();
		
		Object result = ctx.proceed();
		
		long finish = Instant.now().toEpochMilli();
		
		System.out.println("Executed in : " + (finish - start) + "(ms)");
		
		return result;
	}
}
