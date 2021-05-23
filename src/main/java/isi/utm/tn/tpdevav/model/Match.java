package isi.utm.tn.tpdevav.model;
import java.util.Set;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties({"hibernateLazyInitializer","handler","arbitres"})
@Entity
@Table(name="matchs")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long match_id;

    private String name;

    @OneToMany(mappedBy = "match", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set <Arbitre>  arbitres;


    @OneToMany(mappedBy = "match", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set <Equipe>  equipes;
    
    @OneToMany(mappedBy = "match", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Billet> billets; 

    public Match() {}
   
	


	public Match(Long match_id, String name, Set<Arbitre> arbitres, Set<Equipe> equipes, Set<Billet> billets) {
		super();
		this.match_id = match_id;
		this.name = name;
		this.arbitres = arbitres;
		this.equipes = equipes;
		this.billets = billets;
	}




	public Set<Billet> getBillets() {
		return billets;
	}




	public void setBillets(Set<Billet> billets) {
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
   


}
