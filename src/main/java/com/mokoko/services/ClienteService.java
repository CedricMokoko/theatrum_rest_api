package com.mokoko.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mokoko.entities.Cliente;
import com.mokoko.exceptions.ClienteByIdNotFoundException;
import com.mokoko.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	public List<Cliente> getAllClienti(){
		return clienteRepo.findAll();
	}
	
	public Cliente getClienteById(Long id){
		Optional<Cliente> optCliente = clienteRepo.findById(id);
		if(optCliente.isEmpty()) {
			new ClienteByIdNotFoundException(id);
		}
		return optCliente.get();
	}
	
	public Cliente createCliente(Cliente cliente) {
		return clienteRepo.save(cliente);
	}
	
	public void deleteCliente(Long id) {
		Optional<Cliente> clienteToDelete = clienteRepo.findById(id);
		if(clienteToDelete.isEmpty()){
	            throw new ClienteByIdNotFoundException(id);
		}   
		clienteRepo.delete(clienteToDelete.get());
	}
	
	public Cliente updateCliente(Long id, Cliente updatedCliente){		
		Cliente existingCliente = clienteRepo.findById(id)
				.orElseThrow(() -> new ClienteByIdNotFoundException(id));
			
		existingCliente.setCognome(updatedCliente.getCognome());
		existingCliente.setNome(updatedCliente.getNome());
		existingCliente.setTelefono(updatedCliente.getTelefono());
		existingCliente.setEmail(updatedCliente.getEmail());
			
		return clienteRepo.save(existingCliente);				
	}

}
