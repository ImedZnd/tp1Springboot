package isi.utm.tn.tpdevav.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "equipes")
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

}
