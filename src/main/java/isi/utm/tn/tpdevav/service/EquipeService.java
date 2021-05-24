package isi.utm.tn.tpdevav.service;

import java.util.List;


import isi.utm.tn.tpdevav.model.Equipe;

public interface EquipeService {
    Equipe addEquipe(Equipe equipe);
    Equipe updateEquipe (Equipe equipe);
    void deleteById(Long id);
    Equipe getById(Long id);
    Equipe getByName(String name);
    List<Equipe> getAll();
}
