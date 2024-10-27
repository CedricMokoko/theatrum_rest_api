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

import com.mokoko.entities.Biglietto;
import com.mokoko.services.BigliettoService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Biglietti", description = "Endpoint per la gestione degli biglietti")
@RestController
@RequestMapping("/api/biglietti")
@CrossOrigin(origins = "http://localhost:4200")
public class BigliettoRestController {
	
	@Autowired
	BigliettoService bigliettoService;
	
	@PostMapping
	public ResponseEntity<List<Biglietto>> createBiglietto(@RequestBody Biglietto biglietto) {
		List<Biglietto> bigliettoTocreate = bigliettoService.createBiglietto(biglietto);
		return ResponseEntity.ok(bigliettoTocreate);
	}
	
	@GetMapping
	public List<Biglietto> getAllBiglietti(){
		return bigliettoService.getAllBiglietti();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Biglietto> getTeatroById(@PathVariable Long id){
		Biglietto biglietto = bigliettoService.getBigliettoById(id);
		return ResponseEntity.ok(biglietto);
	}
	
	@GetMapping("/replica/{id}")
	public ResponseEntity<List<Biglietto>> getBiglettiByReplica(@PathVariable String id){
		List<Biglietto> biglietti = bigliettoService.getBigliettiByReplica(id);
		return ResponseEntity.ok(biglietti);
	}
	
	@GetMapping("/cliente/{id}")
	public ResponseEntity<List<Biglietto>> getBigliettiByCliente(@PathVariable Long id){
		List<Biglietto> biglietti = bigliettoService.getBigliettiByCliente(id);
		return ResponseEntity.ok(biglietti);
	}

	
	 @PutMapping("/id/{id}")
	 public ResponseEntity<Biglietto> updateBiglietto(@PathVariable Long id, @RequestBody Biglietto biglietto){
	    Biglietto bigliettoUpdate = bigliettoService.updateBiglietto(id, biglietto);
		return ResponseEntity.ok(bigliettoUpdate);
	 }
	
	@DeleteMapping("/id/{id}")
	public void  deleteBigliettoById(@PathVariable Long id){
		bigliettoService.deleteBiglietto(id);
	}
	
	
}
