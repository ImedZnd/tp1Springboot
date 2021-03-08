package isi.utm.tn.tpdevav.serviceImp;

import isi.utm.tn.tpdevav.model.User;
import isi.utm.tn.tpdevav.repository.UserRepository;
import isi.utm.tn.tpdevav.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImp implements UserService,UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
	private PasswordEncoder bcryptEncoder;

    @Override
    public User addOne(User user){
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    @Override
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
    @Override
    public Optional<User> getById(Long id){
        return userRepository.findById(id);
    }
   
    

    @Override
    public  User getByEmail(String email){
        return userRepository.findPersonByEmail(email);
    }

    @Override
    public User getByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }
	@Override
	public User updateUser(User user) {
		if(user.getPassword() != null)
            user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.saveAndFlush(user);
	}
	
	

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

	
    private Set getAuthority(User user) {
        Set authorities = new HashSet<>();
		user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		});
		return authorities;
	}

}
