package isi.utm.tn.tpdevav.model;

import javax.persistence.*;


@Entity
@Table(name="joueur")
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long joueur_id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "equipe_id", nullable = false)
    private Equipe equipe;
    
    public Joueur() {}    
    

	public Joueur(Long joueur_id, String name, Equipe equipe) {
		
		this.joueur_id = joueur_id;
		this.name = name;
		this.equipe = equipe;
	}

	public Long getJoueur_id() {
		return joueur_id;
	}

	public void setJoueur_id(Long joueur_id) {
		this.joueur_id = joueur_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
    
    
    
    
    
}
