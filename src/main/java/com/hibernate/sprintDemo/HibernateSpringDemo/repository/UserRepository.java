package com.hibernate.sprintDemo.HibernateSpringDemo.repository;

import com.hibernate.sprintDemo.HibernateSpringDemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
