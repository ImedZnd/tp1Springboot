package isi.utm.tn.tpdevav.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.utm.tn.tpdevav.model.Phase;
import isi.utm.tn.tpdevav.repository.PhaseRepository;
import isi.utm.tn.tpdevav.service.PhaseService;

@Service
public class PhaseServiceImp implements PhaseService  {

    @Autowired
    private PhaseRepository phaseRepository;

    @Override
    public Phase addPhase(Phase phase) {
        return phaseRepository.save(phase);
    }

    @Override
    public void deletePhaseByID(Long id) {
        phaseRepository.deleteById(id);

    }

    @Override
    public Phase updatePhase(Phase phase) {
        return phaseRepository.saveAndFlush(phase);
    }

    @Override
    public List<Phase> findAllPhase() {
        return phaseRepository.findAll();
    }

    @Override
    public Phase findPhaseByName(String namePhase) {
        return phaseRepository.findPhaseByName(namePhase);
    }

    @Override
    public Phase findPhaseById(Long id) {
        return phaseRepository.getOne(id);
    }

}