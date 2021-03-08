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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
	public String generateToken(@RequestBody User user) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("inavalid username/password");
		}
		return jwtUtil.generateToken(user.getUsername());
	}

	@CrossOrigin(origins = "*")
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		User userCheck = userService.getByUsername(user.getUsername());
		if(userCheck != null)
			return new ResponseEntity<>(user, HttpStatus.CONFLICT);
		User user1 = userService.addOne(user);
		if (user1 == null)
			return new ResponseEntity<>(user, HttpStatus.CONFLICT);
		return new ResponseEntity<>(user1, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/all")
	public ResponseEntity<List> allUsers() {
		return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/delete/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
		userService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user,@PathVariable long id) {
		
        Optional<User> userOptional = userService.getById(id);
        if (!userOptional.isPresent())
            return ResponseEntity.notFound().build();
		User userCheck = userService.getByUsername(user.getUsername());
		if(userCheck != null)
			return new ResponseEntity<>(user, HttpStatus.CONFLICT);
        user.setUser_id(id);
        User user1 = userService.updateUser(user);
        if (user1==null) new ResponseEntity<>(user, HttpStatus.CONFLICT);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

}
