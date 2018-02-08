package po.patterns.interceptor.newversion;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Secure
public class SecurityInspector {
	
	public SecurityInspector() {
	}
	
	@AroundInvoke
	public Object doSecurityCheck(InvocationContext ctx) throws Exception {
		
		System.out.println("from securityCheck");
		
		Logger.getLogger("SecurityLog").info(ctx.getMethod().getName() + "  is accessed");
		
		String user = (String) ctx.getContextData().get("user");
		
		if (user == null) {
			user = (String) ctx.getParameters()[0];
			
			ctx.getContextData().put("user", user);
		}
		
		return null; //ctx.proceed();
	}
	
	@PostConstruct
	public void onStart() {
		System.out.println("from onStart");
		
		Logger.getLogger("SecurityLog").info("Activating");
	}
	
	@PreDestroy
	public void onShutdown() {
		System.out.println("from onShutdown");
		
		Logger.getLogger("SecurityLog").info("Deactivating");
	}

}
