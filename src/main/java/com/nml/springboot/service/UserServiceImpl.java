package com.nml.springboot.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.nml.springboot.model.User;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements UserService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<User> users;
	
	static{
		users= populateDummyUsers();
	}

	public List<User> findAllUsers() {
		return users;
	}
	
	public User findById(long id) {
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public User findByName(String name) {
		for(User user : users){
			if(user.getName().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	public void saveUser(User user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	public void updateUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(long id) {

		for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
		    User user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	//I should check for email's user, not for name.
	public boolean isUserExist(User user) {
		return findByName(user.getName())!=null;
	}
	
	public void deleteAllUsers(){
		users.clear();
	}

	private static List<User> populateDummyUsers(){
		List<User> users = new ArrayList<User>();
		users.add(new User(counter.incrementAndGet(),"Jon",24, 50000));
		users.add(new User(counter.incrementAndGet(),"Robb",31, 65000));
		users.add(new User(counter.incrementAndGet(),"Sansa",20, 54000));
		users.add(new User(counter.incrementAndGet(),"Tyrion",35, 402000));
		users.add(new User(counter.incrementAndGet(),"Deanerys",26, 10000));
		users.add(new User(counter.incrementAndGet(),"Eddard",45, 510000));
		users.add(new User(counter.incrementAndGet(),"Tormund",37, 30000));
		users.add(new User(counter.incrementAndGet(),"Mance",50, 45000));
		return users;
	}

}
