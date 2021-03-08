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

import isi.utm.tn.tpdevav.model.Tournoi;
import isi.utm.tn.tpdevav.service.TournoiService;

@RestController
@RequestMapping("/api/tournoi")
public class TournoiController {
    

    @Autowired
    TournoiService tournoiService;

    @CrossOrigin(origins = "*")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Tournoi> addTournoi(@Valid @RequestBody Tournoi tournoi)
    {
        Tournoi tournoi1 = tournoiService.addTournoi(tournoi);
        if(tournoi1 == null) new ResponseEntity<>(tournoi,HttpStatus.CONFLICT);
        return new ResponseEntity<>(tournoi1, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List> allTournoi()
    {
        return new ResponseEntity<>(tournoiService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/delete/{id}")
    public ResponseEntity<Tournoi> deleteTournoi(@PathVariable("id") Long id)
    {
        tournoiService.deleteById(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<Tournoi> updateTournoi(@Valid @RequestBody Tournoi tournoi)
    {
        Tournoi tournoi1 = tournoiService.updateTournoi(tournoi);
        if(tournoi1 == null) new ResponseEntity<>(tournoi,HttpStatus.CONFLICT);
        return new ResponseEntity<>(tournoi1, HttpStatus.OK);
    }

}
