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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import isi.utm.tn.tpdevav.model.Phase;
import isi.utm.tn.tpdevav.service.PhaseService;

@RestController
@RequestMapping("/api/phase")
public class PhaseController {

    @Autowired
    private PhaseService phaseService;

    @CrossOrigin(origins = "*")
    // @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Phase> addPhase(@Valid @RequestBody Phase phase) {
        Phase phase1 = phaseService.addPhase(phase);
        if (phase1 == null)
            new ResponseEntity<>(phase, HttpStatus.CONFLICT);
        return new ResponseEntity<>(phase1, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<Phase>> allPhase() {
        return new ResponseEntity<>(phaseService.findAllPhase(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    // @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Phase> deletePhase(@PathVariable("id") Long id) {
        phaseService.deletePhaseByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    // @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<Phase> updatePhase(@Valid @RequestBody Phase phase) {
        Phase phase1 = phaseService.updatePhase(phase);
        if (phase1 == null)
            new ResponseEntity<>(phase, HttpStatus.CONFLICT);
        return new ResponseEntity<>(phase1, HttpStatus.OK);
    }
}
