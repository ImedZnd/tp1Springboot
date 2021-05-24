package isi.utm.tn.tpdevav.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler","matches","joueurs"})
@Entity
@Table(name = "equipe")
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipe_id;

    private String name;

	@Column(columnDefinition = "integer default 0")
	private Integer points;

    @ManyToMany
	@JoinTable(name="match_equipes", joinColumns = @JoinColumn(name="equipe_id"), inverseJoinColumns = @JoinColumn(name="match_id"))
    private Collection<Match> matches = new ArrayList<>();

    @OneToMany(mappedBy = "equipe", fetch = FetchType.LAZY)
    private Set<Joueur> joueurs;

    
    public Equipe() {}


	public Equipe(Long equipe_id, String name, Integer points, Collection<Match> matches, Set<Joueur> joueurs) {
		this.equipe_id = equipe_id;
		this.name = name;
		this.points = points;
		this.matches = matches;
		this.joueurs = joueurs;
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


	public Integer getPoints() {
		return points;
	}


	public void setPoints(Integer points) {
		this.points = points;
	}


	public Collection<Match> getMatches() {
		return matches;
	}


	public void setMatches(Collection<Match> matches) {
		this.matches = matches;
	}


	public Set<Joueur> getJoueurs() {
		return joueurs;
	}


	public void setJoueurs(Set<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	
}
