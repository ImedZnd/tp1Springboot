package isi.utm.tn.tpdevav.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isi.utm.tn.tpdevav.model.Equipe;
import isi.utm.tn.tpdevav.model.Match;
import isi.utm.tn.tpdevav.service.MatchService;

@RestController
@RequestMapping("/api/match")
public class MatchController {
	
	@Autowired
	MatchService matchService;
	
	 @CrossOrigin(origins = "*")
	 //@PreAuthorize("hasRole('ADMIN')")
	 @PostMapping("/add")
	 public ResponseEntity<Match> addMatch(@Valid @RequestBody Match match)
	 {
	    Match match1 = matchService.addMatch(match);
	    if(match1 == null) new ResponseEntity<>(match,HttpStatus.CONFLICT);
	    return new ResponseEntity<>(match1, HttpStatus.OK);
	  }
	 
	 @CrossOrigin(origins = "*")
	 @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	 @GetMapping("/all")
	 public ResponseEntity<List<Match>> allMatch()
	 {
		return new ResponseEntity<>(matchService.findAllMatch(), HttpStatus.OK);
	 }
	 
	 @CrossOrigin(origins = "*")
	 //@PreAuthorize("hasRole('ADMIN')")
	 @DeleteMapping("/delete/{id}")
	 public ResponseEntity<Equipe> deleteMatch(@PathVariable("id") Long id)
	 {
		matchService.deleteMatchByID(id);
	    return new ResponseEntity<>(HttpStatus.OK);
	 }
	 
	 @CrossOrigin(origins = "*")
	 //@PreAuthorize("hasRole('ADMIN')")
	 @PutMapping("/update")
	 public ResponseEntity<Match> updateMatch(@Valid @RequestBody Match match)
	 {
		Match match1 = matchService.updateMatch(match);
	    if(match1 == null) new ResponseEntity<>(match,HttpStatus.CONFLICT);
	    return new ResponseEntity<>(match1, HttpStatus.OK);
	    }  
}
