package isi.utm.tn.tpdevav.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.utm.tn.tpdevav.model.Arbitre;

@Repository
public interface ArbitreRepository extends JpaRepository<Arbitre, Long> {
	Arbitre findArbitreByName(String name);
	

}
