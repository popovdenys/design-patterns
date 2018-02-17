package po.patterns.injection;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

@ManagedBean
public class JsfModel {
	
	@Inject
	User user;
	
	public String getUser() {
		return user.getName();
	}
}
