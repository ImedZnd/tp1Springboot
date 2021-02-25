package isi.utm.tn.tpdevav.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import isi.utm.tn.tpdevav.extras.Phase;

@Entity
@Table(name = "tournoi")
public class Tournoi {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tournoi_id;
	
	private String nameTournoi;
		
	@Enumerated(EnumType.STRING)
	private Phase phase;
	
	@OneToMany(mappedBy = "tournoi", fetch = FetchType.LAZY)
	private Set<Equipe> equipes;
	
	public Tournoi() {}
	

	public Tournoi(Long tournoi_id, String nameTournoi, Phase phase, Set<Equipe> equipes) {
		
		this.tournoi_id = tournoi_id;
		this.nameTournoi = nameTournoi;
		this.phase = phase;
		this.equipes = equipes;
	}


	

	public Phase getPhase() {
		return phase;
	}

	public Long getTournoi_id() {
		return tournoi_id;
	}

	public void setTournoi_id(Long tournoi_id) {
		this.tournoi_id = tournoi_id;
	}

	public String getNameTournoi() {
		return nameTournoi;
	}

	public void setNameTournoi(String nameTournoi) {
		this.nameTournoi = nameTournoi;
	}

	public Set<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(Set<Equipe> equipes) {
		this.equipes = equipes;
	}
	
	

	
}
