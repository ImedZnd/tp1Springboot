package isi.utm.tn.tpdevav.model;




import javax.persistence.*;



@Entity
@Table(name="arbitre")
public class Arbitre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long arbitre_id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;
    
    public Arbitre() {}
    

	public Arbitre(Long arbitre_id, String name, Match match) {
	
		this.arbitre_id = arbitre_id;
		this.name = name;
		this.match = match;
	}

	public Long getArbitre_id() {
		return arbitre_id;
	}

	public void setArbitre_id(Long arbitre_id) {
		this.arbitre_id = arbitre_id;
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
    
    
    

}
