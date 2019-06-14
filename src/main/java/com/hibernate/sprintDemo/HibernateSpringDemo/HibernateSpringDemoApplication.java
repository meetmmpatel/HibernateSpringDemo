package com.hibernate.sprintDemo.HibernateSpringDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HibernateSpringDemoApplication {
  
  public static void main(String[] args) {
	SpringApplication.run(HibernateSpringDemoApplication.class, args);
  }
  
}
