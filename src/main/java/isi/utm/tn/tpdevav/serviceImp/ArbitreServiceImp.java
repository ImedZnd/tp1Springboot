package isi.utm.tn.tpdevav.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.utm.tn.tpdevav.model.Arbitre;
import isi.utm.tn.tpdevav.repository.ArbitreRepository;
import isi.utm.tn.tpdevav.service.ArbitreService;

@Service
public class ArbitreServiceImp implements ArbitreService  {
	
	
	
	@Autowired
	private ArbitreRepository arbitreRepository;

	@Override
	public Arbitre addArbitre(Arbitre arbitre) {
		return arbitreRepository.save(arbitre);
	}

	@Override
	public void deleteArbitreByID(Long id) {
		arbitreRepository.deleteById(id);
		
	}

	@Override
	public Arbitre updateArbitre(Arbitre arbitre) {
		
		return arbitreRepository.saveAndFlush(arbitre);
	}

	@Override
	public List<Arbitre> findAllArbitre() {
		// TODO Auto-generated method stub
		return arbitreRepository.findAll();
	}

	@Override
	public Arbitre findArbitreByName(String nameArbitre) {
		// TODO Auto-generated method stub
		return arbitreRepository.findArbitreByName(nameArbitre);
	}

	@Override
	public Arbitre findArbitreById(Long id) {
		// TODO Auto-generated method stub
		return arbitreRepository.getOne(id);
	}
	
	

}
