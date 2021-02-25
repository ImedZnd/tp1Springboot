package isi.utm.tn.tpdevav.service;

import java.util.List;

import isi.utm.tn.tpdevav.model.Match;
import isi.utm.tn.tpdevav.model.Spectateur;

public interface SpectateurService {
	
	Spectateur addSpectateur(Spectateur spectateur);
	void deleteSpectateurByID(Long id);
	Spectateur updateSpectateur(Spectateur spectateur);
    List<Spectateur> findAllSpectateur();
    Spectateur findSpectateurByBillet(Long id_Billet);
    Spectateur findSpectateurById(Long id);

}
