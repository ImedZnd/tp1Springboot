package isi.utm.tn.tpdevav.service;

import isi.utm.tn.tpdevav.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User addOne(User user);
    void deleteById(Long id);
    Optional<User> getById(Long id);
    User getByUsername(String username);
    User getByEmail(String username);
    List<User> getAll();
}
