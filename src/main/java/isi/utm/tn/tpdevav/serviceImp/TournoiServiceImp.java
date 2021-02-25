package isi.utm.tn.tpdevav.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.utm.tn.tpdevav.model.Tournoi;
import isi.utm.tn.tpdevav.repository.TournoiRepository;
import isi.utm.tn.tpdevav.service.TournoiService;

@Service
public class TournoiServiceImp implements TournoiService {

    @Autowired
    TournoiRepository tournoiRepository;

    @Override
    public Tournoi addTournoi(Tournoi tournoi) {
       
        return tournoiRepository.save(tournoi);
    }

    @Override
    public Tournoi updateTournoi(Tournoi tournoi) {
       
        return tournoiRepository.saveAndFlush(tournoi);
    }

    @Override
    public void deleteById(Long id) {
        
        tournoiRepository.deleteById(id);
    }

    @Override
    public Optional<Tournoi> getById(Long id) {
    
        return tournoiRepository.findById(id);
    }

    @Override
    public Tournoi getByNameTournoi(String nameTournoi) {
        
        return tournoiRepository.findTournoiByNameTournoi(nameTournoi);
    }

    @Override
    public List<Tournoi> getAll() {
        
        return tournoiRepository.findAll();
    }

    
}
