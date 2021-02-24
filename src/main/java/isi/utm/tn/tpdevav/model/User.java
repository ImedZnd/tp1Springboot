package isi.utm.tn.tpdevav.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;


    private String surname;

    private Date birthdate;


    private String address;

    private String cin ;

    private  String role;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    @NotBlank
    private  String username;

    @NotBlank
    private String  email;
    
    
    public User() {}
    

	public User(Long user_id, String surname, Date birthdate, String address, String cin, String role,
			@NotBlank String name, @NotBlank String password, @NotBlank String username, @NotBlank String email) {
		
		this.user_id = user_id;
		this.surname = surname;
		this.birthdate = birthdate;
		this.address = address;
		this.cin = cin;
		this.role = role;
		this.name = name;
		this.password = password;
		this.username = username;
		this.email = email;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
    
    
}
