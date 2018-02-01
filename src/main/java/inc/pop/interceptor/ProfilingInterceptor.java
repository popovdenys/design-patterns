package inc.pop.interceptor;

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
		
		//long start = Instant.now().toEpochMilli();
		long start = 0;
		Object result = ctx.proceed();
		//long finish = Instant.now().toEpochMilli();
		long finish = 5;
		
		System.out.println("Executed in : " + (finish - start));
		return result;
	}
}
