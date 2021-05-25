package isi.utm.tn.tpdevav.service;

import java.util.List;
import java.util.Set;

import isi.utm.tn.tpdevav.model.Equipe;
import isi.utm.tn.tpdevav.model.Joueur;

public interface EquipeService {
    Equipe addEquipe(Equipe equipe);
    Equipe updateEquipe (Equipe equipe);
    void deleteById(Long id);
    Equipe getById(Long id);
    Equipe getByName(String name);
    List<Equipe> getAll();
    Set<Joueur> getJoueursByEquipeId(Long id);
}
