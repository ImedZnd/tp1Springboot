package isi.utm.tn.tpdevav.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.utm.tn.tpdevav.model.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long>{
    Match findMatchByName(String matchName);
}
