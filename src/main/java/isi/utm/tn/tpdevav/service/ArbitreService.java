package isi.utm.tn.tpdevav.service;



import java.util.List;

import isi.utm.tn.tpdevav.model.Arbitre;

public interface ArbitreService {
	
	Arbitre addArbitre(Arbitre arbitre);
	void deleteArbitreByID(Long id);
	Arbitre updateArbitre(Arbitre arbitre);
    List<Arbitre> findAllArbitre();
    Arbitre findArbitrebyname(String nameArbitre);
    Arbitre findArbitrebyid(Long id);
    
}
