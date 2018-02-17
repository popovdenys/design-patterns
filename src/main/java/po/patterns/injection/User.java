package po.patterns.injection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

// enough for model definition 
@Named
@RequestScoped

/** needed for annotation
 * 
@Stereotype
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
*
*/
public class User {
	private String id;
	private String name = "Popov Denys";
	
	public String getName() {
		return name;
	}
}
