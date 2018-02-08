package po.patterns.interceptor.newversion;

import java.util.logging.Logger;

import javax.enterprise.context.Dependent;

@Dependent
@Secure
//@Interceptors(SecurityInspector.class)
//@Stateless
//@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class BusinessService {

	public void startService() {
		System.out.println("Call startService");
//		Logger.getLogger("Applog").info("done...");
		
	}
	
	public void startAnotherService() {
		
		Logger.getLogger("Applog").info("done agian ...");
		
	}
}
