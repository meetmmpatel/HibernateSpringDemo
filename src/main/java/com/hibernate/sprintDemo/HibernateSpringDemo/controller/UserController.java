package com.hibernate.sprintDemo.HibernateSpringDemo.controller;


import com.hibernate.sprintDemo.HibernateSpringDemo.exception.ResourceNotFoundException;
import com.hibernate.sprintDemo.HibernateSpringDemo.model.User;
import com.hibernate.sprintDemo.HibernateSpringDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
  
  //Update the existing row
  @PutMapping("user/{id}")
  public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
										 @Valid @RequestBody User userDetails)
		  throws ResourceNotFoundException {
	
	User user = userRepository.findById(userId)
			.orElseThrow(() ->
					new ResourceNotFoundException("User id not found" + userId));
	
	user.setEmail(userDetails.getEmail());
	user.setLastName(userDetails.getLastName());
	user.setFirstName(userDetails.getFirstName());
	user.setUpdatedAt(new Date());
	
	
	final User updatedUer = userRepository.save(user);
	return ResponseEntity.ok(updatedUer);
	
	
  }
  
  
  //Delete the user
  @DeleteMapping("/user/{id}")
  public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
		  throws Exception {
	
	User user = userRepository.findById(userId)
			.orElseThrow(() -> new ResourceNotFoundException("user not found" + userId));
	
	
	userRepository.delete(user);
	Map<String, Boolean> response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	return response;
	
  }
  
  
}
