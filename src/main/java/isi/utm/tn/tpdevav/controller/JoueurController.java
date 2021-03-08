package isi.utm.tn.tpdevav.controller;

import isi.utm.tn.tpdevav.model.Joueur;
import isi.utm.tn.tpdevav.service.JoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/joueur")
public class JoueurController {
	
	@Autowired
	JoueurService joueurService;
	
	
	 @CrossOrigin(origins = "*")
	 @PreAuthorize("hasRole('ADMIN')")
	    @PostMapping("/add")
	    public ResponseEntity<Joueur> addJoueur(@Valid @RequestBody Joueur joueur)
	    {
		 Joueur _joueur = joueurService.addJoueur(joueur);
	        if(_joueur == null) new ResponseEntity<>(joueur,HttpStatus.CONFLICT);
	        return new ResponseEntity<>(_joueur, HttpStatus.OK);
	    }
	 
	 @CrossOrigin(origins = "*")
	 @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	    @GetMapping("/all")
	    public ResponseEntity<List<Joueur>> allJoueurs()
	    {
	        return new ResponseEntity<>(joueurService.findAllJoueur(),HttpStatus.OK);
	    }

	    @CrossOrigin(origins = "*")
		@PreAuthorize("hasRole('ADMIN')")
	    @PostMapping("/delete/{id}")
	    public ResponseEntity<Joueur> deleteJoueurById(@PathVariable("id") Long id)
	    {
	    	joueurService.deleteJoueurByID(id);
	        return new ResponseEntity<>( HttpStatus.OK);
	    }
	    

	    @CrossOrigin(origins = "*")
		@PreAuthorize("hasRole('ADMIN')")
	    @PostMapping("/update")
	    public ResponseEntity<Joueur> updateJoueur( @Valid @RequestBody Joueur joueur )
	    {
	    	Joueur _joueur  =joueurService.updateJoueur(joueur);
	        if(_joueur == null) new ResponseEntity<>(joueur,HttpStatus.CONFLICT);
			return new ResponseEntity<>(_joueur, HttpStatus.OK);
	    }  
	    

	    
}
