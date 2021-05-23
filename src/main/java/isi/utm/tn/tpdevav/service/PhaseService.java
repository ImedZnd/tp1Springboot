package isi.utm.tn.tpdevav.service;

import java.util.List;

import isi.utm.tn.tpdevav.model.Phase;

public interface PhaseService {

    Phase addPhase(Phase Phase);
    void deletePhaseByID(Long id);
    Phase updatePhase(Phase Phase);
    List<Phase> findAllPhase();
    Phase findPhaseByName(String namePhase);
    Phase findPhaseById(Long id);

}
