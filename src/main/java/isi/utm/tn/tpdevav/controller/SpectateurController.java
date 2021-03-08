package isi.utm.tn.tpdevav.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import isi.utm.tn.tpdevav.model.Spectateur;
import isi.utm.tn.tpdevav.service.SpectateurService;

@RestController
@RequestMapping("/api/spectateur")
public class SpectateurController {
	
	@Autowired
	SpectateurService spectateurService;
	
	 @CrossOrigin(origins = "*")
	 @PreAuthorize("hasRole('ADMIN')")
	 @PostMapping("/add")
	 public ResponseEntity<Spectateur> addSpectateur(@Valid @RequestBody Spectateur spectateur)
	 {
		 Spectateur spectateur1 = spectateurService.addSpectateur(spectateur);
	    if(spectateur1 == null) new ResponseEntity<>(spectateur,HttpStatus.CONFLICT);
	    return new ResponseEntity<>(spectateur1, HttpStatus.OK);
	  }
	 
	 @CrossOrigin(origins = "*")
	 @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	 @GetMapping("/all")
	 public ResponseEntity<List> allSpectateur()
	 {
		return new ResponseEntity<>(spectateurService.findAllSpectateur(), HttpStatus.OK);
	 }
	 
	 @CrossOrigin(origins = "*")
	 @PreAuthorize("hasRole('ADMIN')")
	 @PostMapping("/delete/{id}")
	 public ResponseEntity<Spectateur> deleteSpectateur(@PathVariable("id") Long id)
	 {
		 spectateurService.deleteSpectateurByID(id);
	    return new ResponseEntity<>(HttpStatus.OK);
	 }
	 
	 @CrossOrigin(origins = "*")
	 @PreAuthorize("hasRole('ADMIN')")
	 @PutMapping("/update")
	 public ResponseEntity<Spectateur> updateSpectateur(@Valid @RequestBody Spectateur spectateur)
	 {
		Spectateur spectateur1 = spectateurService.updateSpectateur(spectateur);
	    if(spectateur1 == null) new ResponseEntity<>(spectateur,HttpStatus.CONFLICT);
	    return new ResponseEntity<>(spectateur1, HttpStatus.OK);
	    }  

}
