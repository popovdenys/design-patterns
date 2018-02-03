/*
 * File : AppConfig.java
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

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("/rest")
public class AppConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {

		Set<Class<?>> resources = new HashSet<>();
		addRestRecourceClasses(resources);
		return resources;
	}

	private void addRestRecourceClasses(Set<Class<?>> resources) {
		resources.add(po.patterns.interceptor.StreamExecutor.class);
	}
}
