package inc.pop.interceptor;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("/rest")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {

		Set<Class<?>> resources = new HashSet<>();
		addRestRecourceClasses(resources);
		return resources;
	}

	private void addRestRecourceClasses(Set<Class<?>> resources) {
		resources.add(inc.pop.interceptor.StreamExecutor.class);
	}
}
