package isi.utm.tn.tpdevav.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.utm.tn.tpdevav.model.Match;
import isi.utm.tn.tpdevav.model.Spectateur;

@Repository
public interface SpectateurRepository extends JpaRepository<Spectateur, Long>{
	Spectateur findSpectateurByBillet(Long id_Billet);
	
}
