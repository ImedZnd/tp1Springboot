package isi.utm.tn.tpdevav.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import isi.utm.tn.tpdevav.model.Arbitre;

import isi.utm.tn.tpdevav.service.ArbitreService;


@RestController
@RequestMapping("/api/arbitre")
public class ArbitreController {
	
	@Autowired
	ArbitreService arbitreService;
	
	
	 @CrossOrigin(origins = "*")
	 @PreAuthorize("hasRole('ADMIN')")
	    @PostMapping("/add")
	    public ResponseEntity<Arbitre> addArtitre(@Valid @RequestBody Arbitre arbitre)
	    {
		 Arbitre arbitre1 = arbitreService.addArbitre(arbitre);
	        if(arbitre1 == null) new ResponseEntity<>(arbitre,HttpStatus.CONFLICT);
	        return new ResponseEntity<>(arbitre1, HttpStatus.OK);
	    }
	 
	 @CrossOrigin(origins = "*")
	 @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	    @GetMapping("/all")
	    public ResponseEntity<List<Arbitre>> allArbitres()
	    {
	        return new ResponseEntity<>(arbitreService.findAllArbitre(),HttpStatus.OK);
	    }

	    @CrossOrigin(origins = "*")
		@PreAuthorize("hasRole('ADMIN')")
	    @PostMapping("/delete/{id}")
	    public ResponseEntity<Arbitre> deleteArbitre(@PathVariable("id") Long id)
	    {
	    	arbitreService.deleteArbitreByID(id);;
	        return new ResponseEntity<>( HttpStatus.OK);
	    }
	    

	    @CrossOrigin(origins = "*")
		@PreAuthorize("hasRole('ADMIN')")
	    @PutMapping("/update")
	    public ResponseEntity<Arbitre> updateArbitre( @Valid @RequestBody Arbitre arbitre )
	    {
	    	Arbitre arbitre1  =arbitreService.updateArbitre(arbitre);
	    	
	        if(arbitre1 == null) new ResponseEntity<>(arbitre,HttpStatus.CONFLICT);
	        
			return new ResponseEntity<>(arbitre1, HttpStatus.OK);
			
	    	
	    }  
	    
	    

	    
	    
	    
}
