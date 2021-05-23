package isi.utm.tn.tpdevav.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.utm.tn.tpdevav.model.Phase;

@Repository
public interface PhaseRepository extends JpaRepository<Phase, Long>{
    Phase findPhaseByName(String name);
}
