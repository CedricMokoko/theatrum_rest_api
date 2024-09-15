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

import com.mokoko.entities.Teatro;
import com.mokoko.services.TeatroService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Teatri", description = "Endpoint per la gestione dei teatri.")
@RestController
@RequestMapping("/api/teatri")
@CrossOrigin(origins = "http://localhost:4200")
public class TeatroRestController {
	
	@Autowired
	private TeatroService teatroService;
	
	@PostMapping
	public Teatro createTeatro(@RequestBody Teatro teatro) {
		return teatroService.createTeatro(teatro);
	}
	
	@GetMapping
	public List<Teatro> getAllTeatri(){
		return teatroService.getAllTeatri();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Teatro> getTeatroById(@PathVariable String id){
		 Teatro teatro = teatroService.getTeatroById(id);
		 return ResponseEntity.ok(teatro);
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Teatro>> getTeatroByNome(@PathVariable String nome){
		List<Teatro> teatri = teatroService.getTeatroByNome(nome);
		return ResponseEntity.ok(teatri);
	}
	
	 @PutMapping("/id/{id}")
	 public ResponseEntity<Teatro> updateTeatro(@PathVariable String id, @RequestBody Teatro teatro){
	    Teatro teatroUpdate = teatroService.updateTeatro(id, teatro);
		return ResponseEntity.ok(teatroUpdate);
	 }
	
	@DeleteMapping("/id/{id}")
	public void  deleteTeatroById(@PathVariable String id){
		teatroService.deleteTeatro(id);
	}

}
