package isi.utm.tn.tpdevav.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isi.utm.tn.tpdevav.model.Arbitre;

import isi.utm.tn.tpdevav.service.ArbitreService;


@RestController
@RequestMapping("/api/arbitre")
public class ArbitreController {
	
	@Autowired
	ArbitreService arbitreService;
	
	
	 @CrossOrigin(origins = "*")
	    @PostMapping("/add")
	    public ResponseEntity<Arbitre> addArtitre(@Valid @RequestBody Arbitre arbitre)
	    {
		 Arbitre arbitre1 = arbitreService.addArbitre(arbitre);
	        if(arbitre1 == null) new ResponseEntity<>(arbitre,HttpStatus.CONFLICT);
	        return new ResponseEntity<>(arbitre1, HttpStatus.OK);
	    }
	 
	 @CrossOrigin(origins = "*")
	    @GetMapping("/all")
	    public ResponseEntity<List<Arbitre>> allArbitres()
	    {
	        return new ResponseEntity<>(arbitreService.findAllArbitre(),HttpStatus.OK);
	    }

	    @CrossOrigin(origins = "*")
	    @PostMapping("/delete/{id}")
	    public ResponseEntity<Arbitre> deleteArbitre(@PathVariable("id") Long id)
	    {
	    	arbitreService.deleteArbitreByID(id);;
	        return new ResponseEntity<>( HttpStatus.OK);
	    }
	    

	    @CrossOrigin(origins = "*")
	    @PostMapping("/update")
	    public ResponseEntity<Arbitre> updateArbitre( @Valid @RequestBody Arbitre arbitre )
	    {
	    	Arbitre arbitre1  =arbitreService.updateArbitre(arbitre);
	    	
	        if(arbitre1 == null) new ResponseEntity<>(arbitre,HttpStatus.CONFLICT);
	        
			return new ResponseEntity<>(arbitre1, HttpStatus.OK);
			
	    	
	    }  
	    
	    

	    
	    
	    
}
