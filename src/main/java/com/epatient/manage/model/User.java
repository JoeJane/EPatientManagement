package com.epatient.manage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

		@Id
	    @Column(name = "userid")
	    private int userid;
	    @NotBlank(message = "Email is mandatory")
	    @Email(message = "Invalid Email Address")
	    private String email;
	    @Size(min = 3, max = 15, message = "Invalid Password length")
	    private String password;
	    @NotBlank(message = "First Name is mandatory")
	    private String firstname;
	    @NotBlank(message = "Last Name is mandatory")
	    private String lastname;
	    @NotBlank(message = "Address is mandatory")
	    private String address;
	    @NotBlank(message = "City is mandatory")
	    private String city;
	    @NotBlank(message = "Postal Code is mandatory")
	    private String postalcode;
	    
	    @NotBlank(message = "Country is mandatory")
	    private String country;
	    @NotBlank(message = "Phone Number is mandatory")
	    private String phonenumber;
	    
	    private String role;
	    
	    
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
	
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getPostalcode() {
			return postalcode;
		}
		public void setPostalcode(String postalcode) {
			this.postalcode = postalcode;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getPhonenumber() {
			return phonenumber;
		}
		public void setPhonenumber(String phonenumber) {
			this.phonenumber = phonenumber;
		}
	
	    
	    
	    
	    
}
