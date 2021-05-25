package isi.utm.tn.tpdevav.serviceImp;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.utm.tn.tpdevav.model.Equipe;
import isi.utm.tn.tpdevav.model.Joueur;
import isi.utm.tn.tpdevav.repository.EquipeRepository;
import isi.utm.tn.tpdevav.service.EquipeService;

@Service
public class EquipeServiceImp implements EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;

    @Override
    public Equipe addEquipe(Equipe equipe) {
            return equipeRepository.save(equipe);
    }

    @Override
    public Equipe updateEquipe(Equipe equipe) {
        return equipeRepository.saveAndFlush(equipe);
    }

    @Override
    public void deleteById(Long id) {
        equipeRepository.deleteById(id);

    }

    @Override
    public Equipe getById(Long id) {
            return equipeRepository.findById(id).get();
    }

    @Override
    public Equipe getByName(String name) {
            return equipeRepository.findEquipeByName(name);
    }

    @Override
    public List<Equipe> getAll() {
        return equipeRepository.findAll();
    }

    @Override
    public Set<Joueur> getJoueursByEquipeId(Long id) {
        Equipe equipe = getById(id);
        return equipe.getJoueurs();
    }
    
}
