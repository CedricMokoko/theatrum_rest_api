package com.mokoko.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mokoko.entities.Citta;
import com.mokoko.services.CittaService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Città", description = "Endpoint per la gestione delle città.")
@RestController
@RequestMapping("/api/citta")
@CrossOrigin(origins = "http://localhost:4200")
public class CittaRestController {

    @Autowired
    private CittaService cittaService;

    @PostMapping
    public Citta createCitta(@RequestBody Citta citta) {
        return cittaService.createCitta(citta);
    }

    @GetMapping
    public List<Citta> getAllCittas() {
        return cittaService.getAllCittas();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Citta> getCittaById(@PathVariable String id) {
        Citta citta = cittaService.getCittaById(id);
        return ResponseEntity.ok(citta);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Citta>> getCittaByNome(@PathVariable String nome) {
        List<Citta> cittaList = cittaService.getCittaByNome(nome);
        return ResponseEntity.ok(cittaList);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Citta> updateCitta(@PathVariable String id, @RequestBody Citta citta) {
        Citta updatedCitta = cittaService.updateCitta(id, citta);
        return ResponseEntity.ok(updatedCitta);
    }

    @DeleteMapping("/id/{id}")
    public void deleteCittaById(@PathVariable String id) {
        cittaService.deleteCitta(id);
    }
}
