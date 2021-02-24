package isi.utm.tn.tpdevav.service;

import java.util.List;
import isi.utm.tn.tpdevav.model.Joueur;



public interface JoueurService {
	
	Joueur addJoueur(Joueur joueur);
	void deleteJoueurByID(Long id);
	Joueur updateJoueur(Joueur joueur);
    Joueur findJoueurByName(String name);
    Joueur findJoueurById(Long id);
    List<Joueur> findAllJoueur();
    
}
