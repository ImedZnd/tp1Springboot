package isi.utm.tn.tpdevav.service;

import java.util.List;
import java.util.Optional;

import isi.utm.tn.tpdevav.model.Billet;

public interface BilletService {
    Billet addBillet(Billet billet);
    Billet updateBillet (Billet billet);
    void deleteById(Long id);
    Optional<Billet> getById(Long id);
    Billet getByCategorie(String categorie);
    List<Billet> getAll();
}
