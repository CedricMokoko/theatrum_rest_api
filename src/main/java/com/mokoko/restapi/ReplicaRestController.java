package com.mokoko.restapi;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mokoko.entities.Replica;
import com.mokoko.services.ReplicaService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Repliche", description = "Endpoint per la gestione delle repliche")
@RestController
@RequestMapping("/api/repliche")
@CrossOrigin(origins = "http://localhost:4200")
public class ReplicaRestController {
	
	@Autowired
	ReplicaService replicaService;
	
	@GetMapping("/spettacolo/{id}")
	public ResponseEntity<List<Replica>> getReplicheBySpettacolo(@PathVariable String id){
		List<Replica> repliche = replicaService.getReplicheBySpettacolo(id);
		return ResponseEntity.ok(repliche);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Replica> getReplicaById(@PathVariable String id){
		Replica replica = replicaService.getReplicaById(id);
		 return ResponseEntity.ok(replica);
	}
}
