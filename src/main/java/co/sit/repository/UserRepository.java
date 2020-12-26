package co.sit.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import co.sit.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmailId(String emailId);

	User findByEmailIdAndPassword(String email, String pwd);
	

}
