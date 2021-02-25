package isi.utm.tn.tpdevav.serviceImp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import isi.utm.tn.tpdevav.model.Spectateur;
import isi.utm.tn.tpdevav.repository.SpectateurRepository;
import isi.utm.tn.tpdevav.service.SpectateurService;
@Service
public class SpectateurServiceImp implements SpectateurService {
	
	@Autowired
	private SpectateurRepository spectateurRepository;

	@Override
	public Spectateur addSpectateur(Spectateur spectateur) {

		return spectateurRepository.save(spectateur);
	}

	@Override
	public void deleteSpectateurByID(Long id) {
		
		spectateurRepository.deleteById(id);
		
	}

	@Override
	public Spectateur updateSpectateur(Spectateur spectateur) {
		
		return spectateurRepository.saveAndFlush(spectateur);
	}

	@Override
	public List<Spectateur> findAllSpectateur() {
		
		return spectateurRepository.findAll();
	}

	@Override
	public Spectateur findSpectateurByBillet(Long id_Billet) {
		// TODO Auto-generated method stub
		return spectateurRepository.findSpectateurByBillet(id_Billet);
	}

	@Override
	public Spectateur findSpectateurById(Long id) {
		// TODO Auto-generated method stub
		return spectateurRepository.getOne(id);
	}

}
