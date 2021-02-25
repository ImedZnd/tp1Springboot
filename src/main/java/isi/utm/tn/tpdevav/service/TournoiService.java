package isi.utm.tn.tpdevav.service;

import java.util.List;
import java.util.Optional;

import isi.utm.tn.tpdevav.model.Tournoi;

public interface TournoiService {
    Tournoi addTournoi(Tournoi tournoi);
    Tournoi updateTournoi (Tournoi tournoi);
    void deleteById(Long id);
    Optional<Tournoi> getById(Long id);
    Tournoi getByNameTournoi(String nameTournoi);
    List<Tournoi> getAll();
}
