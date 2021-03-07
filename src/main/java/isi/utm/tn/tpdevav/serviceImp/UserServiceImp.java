package isi.utm.tn.tpdevav.serviceImp;

import isi.utm.tn.tpdevav.model.User;
import isi.utm.tn.tpdevav.repository.UserRepository;
import isi.utm.tn.tpdevav.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService,UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addOne(User user){
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
    public  User getByEmail(String username){
        return userRepository.findPersonByEmail(username);
    }

    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }
	@Override
	public User updateUser(User user) {
		
		return userRepository.saveAndFlush(user);
	}
	
	

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
	@Override
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
