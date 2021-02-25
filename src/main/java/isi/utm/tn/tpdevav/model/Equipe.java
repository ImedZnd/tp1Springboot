package isi.utm.tn.tpdevav.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler","joueurs"})
@Entity
@Table(name = "equipe")
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipe_id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;

    @OneToMany(mappedBy = "equipe", fetch = FetchType.LAZY)
    private Set<Joueur> joueurs;
    
    @ManyToOne
    @JoinColumn(name = "tournoi_id", nullable = false)
    private Tournoi tournoi;
    
    public Equipe() {}    

	

	public Equipe(Long equipe_id, String name, Match match, Set<Joueur> joueurs, Tournoi tournoi) {
		super();
		this.equipe_id = equipe_id;
		this.name = name;
		this.match = match;
		this.joueurs = joueurs;
		this.tournoi = tournoi;
	}



	public Tournoi getTournoi() {
		return tournoi;
	}



	public void setTournoi(Tournoi tournoi) {
		this.tournoi = tournoi;
	}



	public Long getEquipe_id() {
		return equipe_id;
	}

	public void setEquipe_id(Long equipe_id) {
		this.equipe_id = equipe_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public Set<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(Set<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
    
    

}
