package isi.utm.tn.tpdevav.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","spectateur"})
@Table(name="billet")
public class Billet {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billet_id;

    private String num_place;
    
    private String categorie;
    
    private String prix;
    
    @OneToOne(fetch = FetchType.LAZY,cascade =  CascadeType.ALL,mappedBy = "billet")
    private Spectateur spectateur;
	
    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;
    
    
    public Billet() {}
    

	public Billet(Long billet_id, String num_place, String categorie, String prix, Spectateur spectateur, Match match) {
		super();
		this.billet_id = billet_id;
		this.num_place = num_place;
		this.categorie = categorie;
		this.prix = prix;
		this.spectateur = spectateur;
		this.match = match;
	}

	public Long getBillet_id() {
		return billet_id;
	}

	public void setBillet_id(Long billet_id) {
		this.billet_id = billet_id;
	}

	public String getNum_place() {
		return num_place;
	}

	public void setNum_place(String num_place) {
		this.num_place = num_place;
	}

	

	public String getCategorie() {
		return categorie;
	}


	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}


	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public Spectateur getSpectateur() {
		return spectateur;
	}

	public void setSpectateur(Spectateur spectateur) {
		this.spectateur = spectateur;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

    
    
    
}
