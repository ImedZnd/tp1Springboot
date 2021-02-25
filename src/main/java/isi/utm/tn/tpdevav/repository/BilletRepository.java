package isi.utm.tn.tpdevav.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.utm.tn.tpdevav.model.Billet;

@Repository
public interface BilletRepository extends JpaRepository<Billet, Long>{
    Billet findBilletByCategorie(String categorie);
}
