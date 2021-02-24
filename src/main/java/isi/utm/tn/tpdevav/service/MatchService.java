package isi.utm.tn.tpdevav.service;

import java.util.List;

import isi.utm.tn.tpdevav.model.Match;

public interface MatchService {
	Match addMatch(Match match);
	void deleteMatchByID(Long id);
	Match updateMatch(Match match);
    List<Match> findAllMatch();
    Match findMatchByName(String nameMatch);
    Match findMatchById(Long id);
}
