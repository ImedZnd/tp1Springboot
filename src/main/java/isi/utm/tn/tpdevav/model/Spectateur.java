package isi.utm.tn.tpdevav.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "spectateur")
public class Spectateur {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long spectateur_id;
	
	private String age ;
	
	private String cin ;
	
	@OneToOne
    @JoinColumn(name = "billet_id", nullable = false)
    private Billet billet;
	
	
	public Spectateur() {}

	public Spectateur(Long spectateur_id, String age, String cin, Billet billet) {
		
		this.spectateur_id = spectateur_id;
		this.age = age;
		this.cin = cin;
		this.billet = billet;
	}

	public Long getSpectateur_id() {
		return spectateur_id;
	}

	public void setSpectateur_id(Long spectateur_id) {
		this.spectateur_id = spectateur_id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public Billet getBillet() {
		return billet;
	}

	public void setBillet(Billet billet) {
		this.billet = billet;
	}

	
	
}
