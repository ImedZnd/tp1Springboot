package isi.utm.tn.tpdevav.model;
import java.io.Serializable;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long match_id;

    private String name;

    @OneToMany(mappedBy = "match", fetch = FetchType.LAZY)
    private Set <Arbitre>  arbitres;

    @OneToMany(mappedBy = "match", fetch = FetchType.LAZY)
    private Set <Equipe>  Equipe;

}