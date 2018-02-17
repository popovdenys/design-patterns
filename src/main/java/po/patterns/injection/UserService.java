package po.patterns.injection;

import javax.inject.Inject;
import javax.inject.Named;

public class UserService {
	
	@Inject
	@Named // it should be added also to UserDataRepositoryImpl
	@Database
	private UserDataRepository repoDao;
	
	public void persistUser(User user) {
		repoDao.save(user);
	}
}
