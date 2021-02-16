package isi.utm.tn.tpdevav.controller;

import isi.utm.tn.tpdevav.model.User;
import isi.utm.tn.tpdevav.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    UserService userService;

    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user)
    {
        User user1 = userService.addOne(user);
        if(user1 == null) new ResponseEntity<>(user,HttpStatus.CONFLICT);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/all")
    public ResponseEntity<List> allUsers(@Valid @RequestBody User user)
    {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }
}
