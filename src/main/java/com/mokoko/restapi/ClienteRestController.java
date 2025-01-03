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

import com.mokoko.dto.ClienteDTO;
import com.mokoko.dto.LoginDTO;
import com.mokoko.dto.RegisterDTO;
import com.mokoko.entities.Cliente;
import com.mokoko.services.ClienteService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Clienti", description = "Endpoint per la gestione degli clienti")
@RestController
@RequestMapping("/api/clienti")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteRestController {
	
	@Autowired
	ClienteService clienteService;
	
	@PostMapping
	public Cliente createCliente(@RequestBody Cliente cliente) {
		return clienteService.createCliente(cliente);
	}
	
	@PostMapping("/login")
    public ResponseEntity<ClienteDTO> login(@RequestBody LoginDTO loginDTO) {
        ClienteDTO clienteDTO = clienteService.login(loginDTO.getEmail(), loginDTO.getPassword());
        return ResponseEntity.ok(clienteDTO); 
    }
	
	 @PostMapping("/register")
    public ResponseEntity<ClienteDTO> register(@RequestBody RegisterDTO registerDTO) {
		 ClienteDTO nuovoClienteDTO = clienteService.register(registerDTO);
        return ResponseEntity.ok(nuovoClienteDTO);
    }
    
	@GetMapping
	public List<Cliente> getAllClienti(){
		return clienteService.getAllClienti();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable Long id){
			Cliente cliente = clienteService.getClienteById(id);
		 return ResponseEntity.ok(cliente);
	}
	
	 @PutMapping("/id/{id}")
	 public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente){
		 Cliente clienteUpdate = clienteService.updateCliente(id, cliente);
		return ResponseEntity.ok(clienteUpdate);
	 }
	
	@DeleteMapping("/id/{id}")
	public void  deleteClienteById(@PathVariable Long id){
		clienteService.deleteCliente(id);
	}


}
