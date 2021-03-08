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

import isi.utm.tn.tpdevav.model.Billet;
import isi.utm.tn.tpdevav.service.BilletService;

@RestController
@RequestMapping("/api/billet")
public class BilletController {

    @Autowired
    BilletService billetService;

    @CrossOrigin(origins = "*")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Billet> addBuillet(@Valid @RequestBody Billet billet)
    {
        Billet billet1 = billetService.addBillet(billet);
        if(billet1 == null) new ResponseEntity<>(billet,HttpStatus.CONFLICT);
        return new ResponseEntity<>(billet1, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<Billet>> allBillet()
    {
        return new ResponseEntity<>(billetService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/delete/{id}")
    public ResponseEntity<Billet> deleteBillet(@PathVariable("id") Long id)
    {
        billetService.deleteById(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    public ResponseEntity<Billet> updateBillet(@Valid @RequestBody Billet billet)
    {
        Billet billet1 = billetService.updateBillet(billet);
        if(billet1 == null) new ResponseEntity<>(billet,HttpStatus.CONFLICT);
        return new ResponseEntity<>(billet1, HttpStatus.OK);
    }    
}
