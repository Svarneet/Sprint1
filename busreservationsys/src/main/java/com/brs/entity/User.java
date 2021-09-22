package com.brs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;




@Entity
@Table(name = "Users")
public class User {
	@Id
	@Column(name = "userLoginId", nullable = false, unique=true, length = 10)
	@Pattern(regexp = "[0-9] {10}", message = " userLoginId should be  numbers between 1 to 10 ")
	// Bean validation to check The Id.
	private int userLoginId;
	@Column(name = "userName", nullable = false, length = 10)
	@NotBlank(message = "username cannot be blank")
	@Pattern(regexp = "^[A-Za-z ]{3,10}$", message = "username must only be alphabets from 3 to 10 characters")
	// Bean validation to check The userName.
	private String userName;
	@Column(name = "password", nullable = false, length = 10)
	@NotBlank(message = "password cannot be blank")
	@Pattern(regexp = "^[A-Za-z ]{3,10}$", message = "password must only be alphabets from 3 to 10 characters")
	// Bean validation to check The password.
	private String password;
	@Column(name = "firstName", nullable = false, length = 10)
	@NotBlank(message = "firstname cannot be blank")
	@Pattern(regexp = "^[A-Za-z ]{3,10}$", message = "firstname must only be alphabets from 3 to 10 characters")
	// Bean validation to check The firstName.
	private String firstName;
	@Column(name = "lastName", nullable = false, length = 10)
	@NotBlank(message = "lastname cannot be blank")
	@Pattern(regexp = "^[A-Za-z ]{3,10}$", message = "lastname must only be alphabets from 3 to 10 characters")
	// Bean validation to check The lastName.
	private String lastName;
	@Column(name = "contact", nullable = false, length = 10)
	@NotBlank(message = "contact cannot be blank")
	@Pattern(regexp = "^[10]{1}$", message = "contact should be  10 ")
	// Bean validation to check The contact.
	private String contact;
	@Column(name = "email", nullable = false, length = 10)
	@NotBlank(message = "email cannot be blank")
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "email must only be alphabets and special characters")
	// Bean validation to check The email.
	private String email;
	

	
	
	@OneToOne
    private Reservation reservation;
	@OneToOne()
	private FeedBack feedback;
	
	
	public  int getUserLoginId() {
		return userLoginId;
	}
	public void setUserLoginId(int userLoginId) {
		this.userLoginId = userLoginId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (userLoginId ^ (userLoginId >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userLoginId != other.userLoginId)
			return false;
		return true;
	}
	public User(int userLoginId, String userName, String password, String firstName, String lastName, String contact,
			String email) {
		super();
		this.userLoginId = userLoginId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.email = email;
		
	}

}