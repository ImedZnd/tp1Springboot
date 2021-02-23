package isi.utm.tn.tpdevav.serviceImp;

import isi.utm.tn.tpdevav.model.User;
import isi.utm.tn.tpdevav.repository.UserRepository;
import isi.utm.tn.tpdevav.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

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
    public  User getByUsername(String username){
        return userRepository.findPersonByUsername(username);
    }

    @Override
    public  User getByEmail(String username){
        return userRepository.findPersonByEmail(username);
    }

    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }
}
