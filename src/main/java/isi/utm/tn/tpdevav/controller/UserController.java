package isi.utm.tn.tpdevav.controller;

import isi.utm.tn.tpdevav.Util.JwtUtil;
import isi.utm.tn.tpdevav.model.AuthRequest;
import isi.utm.tn.tpdevav.model.Spectateur;
import isi.utm.tn.tpdevav.model.User;
import isi.utm.tn.tpdevav.service.UserService;
import isi.utm.tn.tpdevav.serviceImp.UserServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserServiceImp userServiceImp;
	
	@Autowired
	JwtUtil jwtUtil;
	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception ex) {
			throw new Exception("inavalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getUserName());
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		User user1 = userServiceImp.save(user);
		if (user1 == null)
			new ResponseEntity<>(user, HttpStatus.CONFLICT);
		return new ResponseEntity<>(user1, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/all")
	public ResponseEntity<List> allUsers() {
		return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/delete/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
		userService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
		User user1 = userService.updateUser(user);
		if (user1 == null)
			new ResponseEntity<>(user, HttpStatus.CONFLICT);
		return new ResponseEntity<>(user1, HttpStatus.OK);
	}

}
