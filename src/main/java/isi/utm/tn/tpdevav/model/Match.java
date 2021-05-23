package isi.utm.tn.tpdevav.model;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import isi.utm.tn.tpdevav.extras.MatchStatus;


@JsonIgnoreProperties({"hibernateLazyInitializer","handler","arbitres","equipes","billets"})
@Entity
@Table(name="matchs")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long match_id;

    private String name;

	private Date dateMatch;

	private Long winner_id;

	private String scoreEquipe1;

	private String scoreEquipe2;

	@Enumerated(EnumType.STRING)
	private MatchStatus status;


	@ManyToOne
    @JoinColumn(name = "phase_id", nullable = false)
    private Phase phase;

    @OneToMany(mappedBy = "match", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Arbitre>  arbitres;


    @OneToMany(mappedBy = "match", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Equipe>  equipes;
    
    @OneToMany(mappedBy = "match", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Billet> billets; 

    public Match() {}

	


	public Match(Long match_id, String name, Date dateMatch, Long winner_id, String scoreEquipe1, String scoreEquipe2,
			MatchStatus status, Phase phase, Set<Arbitre> arbitres, Set<Equipe> equipes, Set<Billet> billets) {
		this.match_id = match_id;
		this.name = name;
		this.dateMatch = dateMatch;
		this.winner_id = winner_id;
		this.scoreEquipe1 = scoreEquipe1;
		this.scoreEquipe2 = scoreEquipe2;
		this.status = status;
		this.phase = phase;
		this.arbitres = arbitres;
		this.equipes = equipes;
		this.billets = billets;
	}


	public Long getMatch_id() {
		return match_id;
	}

	public void setMatch_id(Long match_id) {
		this.match_id = match_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateMatch() {
		return dateMatch;
	}

	public void setDateMatch(Date dateMatch) {
		this.dateMatch = dateMatch;
	}

	public String getScoreEquipe1() {
		return scoreEquipe1;
	}

	public void setScoreEquipe1(String scoreEquipe1) {
		this.scoreEquipe1 = scoreEquipe1;
	}

	public String getScoreEquipe2() {
		return scoreEquipe2;
	}

	public void setScoreEquipe2(String scoreEquipe2) {
		this.scoreEquipe2 = scoreEquipe2;
	}

	public Phase getPhase() {
		return phase;
	}

	public void setPhase(Phase phase) {
		this.phase = phase;
	}

	public Set<Arbitre> getArbitres() {
		return arbitres;
	}

	public void setArbitres(Set<Arbitre> arbitres) {
		this.arbitres = arbitres;
	}

	public Set<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(Set<Equipe> equipes) {
		this.equipes = equipes;
	}

	public Set<Billet> getBillets() {
		return billets;
	}

	public void setBillets(Set<Billet> billets) {
		this.billets = billets;
	}



	public Long getWinner_id() {
		return winner_id;
	}



	public void setWinner_id(Long winner_id) {
		this.winner_id = winner_id;
	}



	public MatchStatus getStatus() {
		return status;
	}



	public void setStatus(MatchStatus status) {
		this.status = status;
	}
   
	
	
}
