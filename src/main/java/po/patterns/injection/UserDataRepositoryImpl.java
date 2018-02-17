package po.patterns.injection;

import javax.inject.Named;

@Database
@Named("UserDataRepositoryImpl")
public class UserDataRepositoryImpl implements UserDataRepository {

	@Override
	public void save(User user) {
		System.out.println("Save to database");
	}

}
