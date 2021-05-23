package isi.utm.tn.tpdevav.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler","phases"})
@Entity
@Table(name = "tournoi")
public class Tournoi {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tournoi_id;
	
	private String nameTournoi;
		
	
	@OneToMany(mappedBy = "tournoi", fetch = FetchType.LAZY)
	private Set<Phase> phases;
	
	public Tournoi() {}


	public Tournoi(Long tournoi_id, String nameTournoi, Set<Phase> phases) {
		this.tournoi_id = tournoi_id;
		this.nameTournoi = nameTournoi;
		this.phases = phases;
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

	public Set<Phase> getPhases() {
		return phases;
	}

	public void setPhases(Set<Phase> phases) {
		this.phases = phases;
	}
	

	
}
