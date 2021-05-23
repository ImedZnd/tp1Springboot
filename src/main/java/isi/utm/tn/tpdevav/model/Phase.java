package isi.utm.tn.tpdevav.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import isi.utm.tn.tpdevav.extras.PhaseName;


@JsonIgnoreProperties({"hibernateLazyInitializer","handler","matches"})
@Entity
@Table(name = "phase")
public class Phase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long phase_id;

    @Enumerated(EnumType.STRING)
    private PhaseName name;

    @ManyToOne
    @JoinColumn(name = "tournoi_id", nullable = false)
    private Tournoi tournoi;

    @OneToMany(mappedBy = "phase", fetch = FetchType.LAZY)
    private Set<Match> matches;

    public Phase() {
    }

    public Phase(Long phase_id, PhaseName name, Tournoi tournoi, Set<Match> matches) {
        this.phase_id = phase_id;
        this.name = name;
        this.tournoi = tournoi;
        this.matches = matches;
    }

    public Long getPhase_id() {
        return phase_id;
    }

    public void setPhase_id(Long phase_id) {
        this.phase_id = phase_id;
    }

    public PhaseName getName() {
        return name;
    }

    public void setName(PhaseName name) {
        this.name = name;
    }

    public Tournoi getTournoi() {
        return tournoi;
    }

    public void setTournoi(Tournoi tournoi) {
        this.tournoi = tournoi;
    }

    public Set<Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<Match> matches) {
        this.matches = matches;
    }

}
