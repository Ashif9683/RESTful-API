package com.in28minutes.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users=new ArrayList<>();
	
	private static int userCount=0;
	
	static {
		users.add(new User(++userCount,"Ashif",LocalDate.now().minusYears(22)));
		users.add(new User(++userCount,"Shahid",LocalDate.now().minusYears(25)));
		users.add(new User(++userCount,"Salim",LocalDate.now().minusYears(28)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}

	public User findOne(int id) {

		Predicate<? super User> predicate=user->user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate= user->user.getId().equals(id);
		users.removeIf(predicate);
	}
	
}
