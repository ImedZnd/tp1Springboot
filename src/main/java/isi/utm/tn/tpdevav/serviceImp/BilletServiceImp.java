package isi.utm.tn.tpdevav.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.utm.tn.tpdevav.model.Billet;
import isi.utm.tn.tpdevav.repository.BilletRepository;
import isi.utm.tn.tpdevav.service.BilletService;

@Service
public class BilletServiceImp implements BilletService {

    @Autowired
	private BilletRepository billetRepository;

    @Override
    public Billet addBillet(Billet billet) {
        return billetRepository.save(billet);
    }

    @Override
    public Billet updateBillet(Billet billet) {
        return billetRepository.saveAndFlush(billet);
    }

    @Override
    public void deleteById(Long id) {
        billetRepository.deleteById(id);

    }

    @Override
    public Optional<Billet> getById(Long id) {
        return billetRepository.findById(id);
    }

    @Override
    public Billet getByCategorie(String categorie) {
        return billetRepository.findBilletByCategorie(categorie);
    }

    @Override
    public List<Billet> getAll() {
        return billetRepository.findAll();
    }
    
}
