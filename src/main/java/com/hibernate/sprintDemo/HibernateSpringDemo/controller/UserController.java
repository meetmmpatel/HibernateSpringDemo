package com.hibernate.sprintDemo.HibernateSpringDemo.controller;


import com.hibernate.sprintDemo.HibernateSpringDemo.exception.ResourceNotFoundException;
import com.hibernate.sprintDemo.HibernateSpringDemo.model.User;
import com.hibernate.sprintDemo.HibernateSpringDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {
  
  @Autowired
  private UserRepository userRepository;
  
  
  //Read the entire table
  @GetMapping("/users")
  public List<User> getallUser() {
	return userRepository.findAll();
  }
  
  //read by Id
  @GetMapping("users/{id}")
  public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userid)
		  throws ResourceNotFoundException {
	User user = userRepository.findById(userid)
			.orElseThrow(() ->
					new ResourceNotFoundException("User id not found" + userid));
	return ResponseEntity.ok().body(user);
  }
  
  //Insert Row
  @PostMapping("/users")
  public User createUser(@Valid @RequestBody User user) {
	return userRepository.save(user);
  }
  
  
}
