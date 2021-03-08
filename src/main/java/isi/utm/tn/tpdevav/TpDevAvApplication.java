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
				new User("root","root","root@gmail.com","ahmed",null,null)
        ).collect(Collectors.toList());
        repo.saveAll(users);
    }

	public static void main(String[] args) {
		SpringApplication.run(TpDevAvApplication.class, args);
	}

}
