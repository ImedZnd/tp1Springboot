package isi.utm.tn.tpdevav.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.utm.tn.tpdevav.model.Tournoi;

@Repository
public interface TournoiRepository extends JpaRepository<Tournoi, Long>{
    Tournoi findTournoiByNameTournoi(String nameTournoi);
}
