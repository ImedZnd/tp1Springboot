package isi.utm.tn.tpdevav.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.utm.tn.tpdevav.model.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long>{
    Equipe findEquipeByName(String name);
}
