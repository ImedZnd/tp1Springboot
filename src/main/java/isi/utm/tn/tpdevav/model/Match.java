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
<<<<<<< HEAD
@Table(name = "matchs")
=======
@Table(name="matche")
>>>>>>> refs/remotes/origin/main
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long match_id;

    private String name;

    @OneToMany(mappedBy = "match", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set <Arbitre>  arbitres;

<<<<<<< HEAD
    @OneToMany(mappedBy = "match", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set <Equipe>  Equipe;
   
=======
    @OneToMany(mappedBy = "match", fetch = FetchType.LAZY)
    private Set <Equipe>  equipes;
>>>>>>> refs/remotes/origin/main

}
