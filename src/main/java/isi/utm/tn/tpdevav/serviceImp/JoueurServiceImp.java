package isi.utm.tn.tpdevav.serviceImp;
import isi.utm.tn.tpdevav.model.Joueur;
import isi.utm.tn.tpdevav.repository.JoueurRepository;
import isi.utm.tn.tpdevav.service.JoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoueurServiceImp implements JoueurService  {
	

	@Autowired
	private JoueurRepository joueurRepository;

	@Override
	public Joueur addJoueur(Joueur joueur) {
		return joueurRepository.save(joueur);
	}

	@Override
	public void deleteJoueurByID(Long id) {
		joueurRepository.deleteById(id);
		
	}

	@Override
	public Joueur updateJoueur(Joueur joueur) {
		
		return joueurRepository.saveAndFlush(joueur);
	}


	@Override
	public Joueur findJoueurByName(String name) {
		// TODO Auto-generated method stub
		return joueurRepository.findJoueurByName(name);
	}

	@Override
	public Joueur findJoueurById(Long id) {
		// TODO Auto-generated method stub
		return joueurRepository.getOne(id);
	}

	@Override
	public List<Joueur> findAllJoueur() {
		// TODO Auto-generated method stub
		return joueurRepository.findAll();
	}
	
	

}
