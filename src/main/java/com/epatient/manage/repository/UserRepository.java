package com.epatient.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.epatient.manage.model.User;


public interface UserRepository  extends JpaRepository<User, Integer>{

	@Query("SELECT s FROM User s WHERE s.email = :email")
	public User findByEmail(@Param("email") String email);
}
