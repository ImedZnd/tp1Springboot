package isi.utm.tn.tpdevav.repository;

import isi.utm.tn.tpdevav.model.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Long> {
	Joueur findJoueurByName(String name);
}
