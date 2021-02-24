package isi.utm.tn.tpdevav.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.utm.tn.tpdevav.model.Match;
import isi.utm.tn.tpdevav.repository.MatchRepository;
import isi.utm.tn.tpdevav.service.MatchService;

@Service
public class MatchServiceImpl implements MatchService{

	@Autowired
	private MatchRepository matchRepository;
	
	@Override
	public Match addMatch(Match match) {
		return matchRepository.save(match);
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
