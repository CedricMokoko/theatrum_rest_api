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

import com.mokoko.entities.Spettacolo;
import com.mokoko.services.SpettacoloService;

import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Spettacoli", description = "Endpoint per la gestione degli spettacoli.")
@RestController
@RequestMapping("/api/spettacoli")
@CrossOrigin(origins = "http://localhost:4200")
public class SpettacoloRestController {

	@Autowired
	private SpettacoloService spettacoloService;
	
	@PostMapping
	public Spettacolo createSpettacolo(@RequestBody Spettacolo spettacolo) {
		return spettacoloService.createSpettacolo(spettacolo);
	}
	
	@GetMapping
	public List<Spettacolo> getAllSpettacolo(){
		return spettacoloService.getAllSpettacoli();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Spettacolo> getSpettacoloById(@PathVariable String id){
		Spettacolo spettacolo = spettacoloService.getSpettacoloById(id);
		 return ResponseEntity.ok(spettacolo);
	}
	
	@GetMapping("/titolo/{titolo}")
	public ResponseEntity<List<Spettacolo>> getSpettacoloByNome(@PathVariable String titolo){
		List<Spettacolo> spettacoli = spettacoloService.getSpettacoloByTitolo(titolo);
		return ResponseEntity.ok(spettacoli);
	}
	
	@GetMapping("/teatro/{id}") //L'id qui è quello del teatro e non dello spettacolo
	public ResponseEntity<List<Spettacolo>> getSpettacoliByTeatro(@PathVariable String id){
		List<Spettacolo> spettacoli = spettacoloService.getSpettacoliByTeatro(id);
		return ResponseEntity.ok(spettacoli);
	}
	
	 @PutMapping("/id/{id}")
	 public ResponseEntity<Spettacolo> updateSpettacolo(@PathVariable String id, @RequestBody Spettacolo spettacolo){
		 Spettacolo spettacoloUpdate = spettacoloService.updateSpettacolo(id, spettacolo);
		return ResponseEntity.ok(spettacoloUpdate);
	 }
	
	@DeleteMapping("/id/{id}")
	public void  deleteSpettacoloById(@PathVariable String id){
		spettacoloService.deleteSpettacolo(id);
	}
}
