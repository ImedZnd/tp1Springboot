package isi.utm.tn.tpdevav.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import isi.utm.tn.tpdevav.model.Equipe;
import isi.utm.tn.tpdevav.model.Joueur;
import isi.utm.tn.tpdevav.service.EquipeService;

@RestController
@RequestMapping("/api/equipe")
public class EquipeController {
    
    @Autowired
    EquipeService equipeService;

    @CrossOrigin(origins = "*")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Equipe> addEquipe(@Valid @RequestBody Equipe equipe)
    {
        Equipe equipe1 = equipeService.addEquipe(equipe);
        if(equipe1 == null) new ResponseEntity<>(equipe,HttpStatus.CONFLICT);
        return new ResponseEntity<>(equipe1, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<Equipe>> allEquipe()
    {
        return new ResponseEntity<>(equipeService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Equipe> deleteEquipe(@PathVariable("id") Long id)
    {
        equipeService.deleteById(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<Equipe> updateEquipe(@Valid @RequestBody Equipe equipe)
    {
        Equipe equipe1 = equipeService.updateEquipe(equipe);
        if(equipe1 == null) new ResponseEntity<>(equipe,HttpStatus.CONFLICT);
        return new ResponseEntity<>(equipe1, HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "*")
    //@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/{id}/joueurs")
    public ResponseEntity<Set<Joueur>> getJoueurs(@PathVariable("id") Long id)
    {
        return new ResponseEntity<>(equipeService.getJoueursByEquipeId(id), HttpStatus.OK);
    } 
}
