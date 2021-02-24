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
@Table(name = "arbitres")
=======
@Table(name="arbitre")
>>>>>>> refs/remotes/origin/main
public class Arbitre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long arbitre_id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;

}
