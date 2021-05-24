package isi.utm.tn.tpdevav.serviceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.utm.tn.tpdevav.model.Equipe;
import isi.utm.tn.tpdevav.model.Match;
import isi.utm.tn.tpdevav.model.Phase;
import isi.utm.tn.tpdevav.repository.MatchRepository;
import isi.utm.tn.tpdevav.service.EquipeService;
import isi.utm.tn.tpdevav.service.MatchService;
import isi.utm.tn.tpdevav.service.PhaseService;

@Service
public class MatchServiceImpl implements MatchService{

	@Autowired
	private MatchRepository matchRepository;

	@Autowired
	private EquipeService equipeService;

	@Autowired
	private PhaseService phaseService;
	
	@Override
	public Match addMatch(Match match) {
		Match mt = new Match();
        Phase phase = phaseService.findPhaseById(match.getPhase().getPhase_id());
		mt.setPhase(phase);
		mt.setDateMatch(match.getDateMatch());
		mt.setArbitres(match.getArbitres());
		mt.setBillets(match.getBillets());
		mt.setScoreEquipe1(match.getScoreEquipe1());
		mt.setScoreEquipe2(match.getScoreEquipe2());
		mt.setWinner_id(match.getWinner_id());
		mt.setStatus(match.getStatus());
        mt.getEquipes().addAll(match.getEquipes()
        .stream()
        .map(eq -> {
            Equipe equipe = equipeService.getById(eq.getEquipe_id());
            equipe.getMatches().add(mt);
            return equipe;
        }).collect(Collectors.toList()));
		mt.setName(mt.getName());
		return matchRepository.save(mt);
	}

	@Override
	public void deleteMatchByID(Long id) {
		matchRepository.deleteById(id);
	}

	@Override
	public Match updateMatch(Match match) {
		return matchRepository.saveAndFlush(match);
	}

	@Override
	public List<Match> findAllMatch() {
		return matchRepository.findAll();
	}

	@Override
	public Match findMatchByName(String nameMatch) {
		return matchRepository.findMatchByName(nameMatch);
	}

	@Override
	public Match findMatchById(Long id) {
		return matchRepository.getOne(id);
	}

}
