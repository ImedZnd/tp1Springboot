package isi.utm.tn.tpdevav.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;


    private String surname;

    private Date birthdate;


    private String address;

    private String cin ;

    private  String role;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    @NotBlank
    private  String username;

    @NotBlank
    private String  email;
}
