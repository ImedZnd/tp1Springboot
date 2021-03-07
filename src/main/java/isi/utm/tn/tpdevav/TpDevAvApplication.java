package isi.utm.tn.tpdevav;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import isi.utm.tn.tpdevav.model.User;
import isi.utm.tn.tpdevav.repository.UserRepository;


@SpringBootApplication
public class TpDevAvApplication {
	@Autowired
	private UserRepository repo;

	@PostConstruct
	public void initUser() {
		
		List<User> users = Stream.of(
                new User((long)1,"bo7",null,"tunis","13013222","admin","ahmed","root","root","root@gmail.com")
        ).collect(Collectors.toList());
        repo.saveAll(users);
    }

	public static void main(String[] args) {
		SpringApplication.run(TpDevAvApplication.class, args);
	}

}
