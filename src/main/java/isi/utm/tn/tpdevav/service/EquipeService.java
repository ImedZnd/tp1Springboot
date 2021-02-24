package isi.utm.tn.tpdevav.service;

import java.util.List;
import java.util.Optional;


import isi.utm.tn.tpdevav.model.Equipe;

public interface EquipeService {
    Equipe addEquipe(Equipe equipe);
    Equipe updateEquipe (Equipe equipe);
    void deleteById(Long id);
    Optional<Equipe> getById(Long id);
    Equipe getByName(String name);
    List<Equipe> getAll();
}
