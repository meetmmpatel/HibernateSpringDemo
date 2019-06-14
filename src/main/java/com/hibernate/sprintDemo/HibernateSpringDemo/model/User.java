package com.hibernate.sprintDemo.HibernateSpringDemo.model;


import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  
  @Column(name = "first_name", nullable = false)
  private String firstName;
  
  @Column(name = "last_name", nullable = false)
  private String lastName;
  
  @Column(name = "email_address", nullable = false)
  private String email;
  
  @Column(name = "created_At", nullable = false)
  @CreatedDate
  private Date createdAt;
  
  @Column(name = "created_by", nullable = false)
  @CreatedBy
  private String createdBy;
  
  @Column(name = "updated_at", nullable = false)
  @LastModifiedDate
  private Date updatedAt;
  
  @Column(name = "updated_by", nullable = false)
  @LastModifiedBy
  private String updatedBy;
  
  
  public User() {
	
  }
  
  public User(String firstName, String lastName, String email, Date createdAt, String createdBy, Date updatedAt, String updatedBy) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.createdAt = createdAt;
	this.createdBy = createdBy;
	this.updatedAt = updatedAt;
	this.updatedBy = updatedBy;
  }
  
  public long getId() {
	return id;
  }
  
  public void setId(long id) {
	this.id = id;
  }
  
  public String getFirstName() {
	return firstName;
  }
  
  public void setFirstName(String firstName) {
	this.firstName = firstName;
  }
  
  public String getLastName() {
	return lastName;
  }
  
  public void setLastName(String lastName) {
	this.lastName = lastName;
  }
  
  public String getEmail() {
	return email;
  }
  
  public void setEmail(String email) {
	this.email = email;
  }
  
  public Date getCreatedAt() {
	return createdAt;
  }
  
  public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
  }
  
  public String getCreatedBy() {
	return createdBy;
  }
  
  public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
  }
  
  public Date getUpdatedAt() {
	return updatedAt;
  }
  
  public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
  }
  
  public String getUpdatedBy() {
	return updatedBy;
  }
  
  public void setUpdatedBy(String updatedBy) {
	this.updatedBy = updatedBy;
  }
  
  @Override
  public String toString() {
	return "User{" +
			"id=" + id +
			", firstName='" + firstName + '\'' +
			", lastName='" + lastName + '\'' +
			", email='" + email + '\'' +
			", createdAt=" + createdAt +
			", createdBy='" + createdBy + '\'' +
			", updatedAt=" + updatedAt +
			", updatedBy='" + updatedBy + '\'' +
			'}';
  }
}
