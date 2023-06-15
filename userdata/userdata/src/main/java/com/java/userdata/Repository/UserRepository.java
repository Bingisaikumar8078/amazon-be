package com.java.userdata.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.userdata.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	@SuppressWarnings("unchecked")
	User save(User user);

	User getUserByUsername(String username);
	
	
	
}
