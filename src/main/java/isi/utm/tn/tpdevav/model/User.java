package isi.utm.tn.tpdevav.model;

import javax.validation.constraints.NotBlank;
import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;

    @NotBlank
    private  String username;

	@NotBlank
    private String password;
	
    @NotBlank
    private String  email;

    @NotBlank
    private String name;
	
    private Date birthdate;

    private String address;

    private  String role;


	public User() {}
    

	
	public User(@NotBlank String username, @NotBlank String password, @NotBlank String email, @NotBlank String name,
			Date birthdate, String address, String role) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.birthdate = birthdate;
		this.address = address;
		this.role = role;
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



	public Long getUser_id() {
		return user_id;
	}



	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}    
    
    
    
}
