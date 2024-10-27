package com.mokoko.services;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mokoko.dto.ClienteDTO;
import com.mokoko.dto.RegisterDTO;
import com.mokoko.entities.Cliente;
import com.mokoko.exceptions.ClienteByIdNotFoundException;
import com.mokoko.exceptions.ClienteEmailAlreadyInUse;
import com.mokoko.exceptions.InvalidCredentialsException;
import com.mokoko.repositories.ClienteRepository;
import com.mokoko.utils.EmailMaskingUtil;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
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
	
	@Transactional
	public Cliente createCliente(Cliente cliente) {
		return clienteRepo.save(cliente);
	}
	
	@Transactional
	public void deleteCliente(Long id) {
		Optional<Cliente> clienteToDelete = clienteRepo.findById(id);
		if(clienteToDelete.isEmpty()){
	            throw new ClienteByIdNotFoundException(id);
		}   
		clienteRepo.delete(clienteToDelete.get());
	}
	
	@Transactional
	public Cliente updateCliente(Long id, Cliente updatedCliente){		
		Cliente existingCliente = clienteRepo.findById(id)
				.orElseThrow(() -> new ClienteByIdNotFoundException(id));
			
		existingCliente.setCognome(updatedCliente.getCognome());
		existingCliente.setNome(updatedCliente.getNome());
		existingCliente.setEmail(updatedCliente.getEmail());
			
		return clienteRepo.save(existingCliente);				
	}
	
	
	// Metodi personalizzati
	
	public ClienteDTO convertToDTO(Cliente cliente) {
		// maskingEmail permette di nascondere alcune lettere dell'email prima di rimandarla al front-end
		String maskedEmail = EmailMaskingUtil.maskEmail(cliente.getEmail());
	    return new ClienteDTO(cliente.getId(), cliente.getCognome(), cliente.getNome(), cliente.getRuolo(), maskedEmail, cliente.getImagePath());
	}
	
	public ClienteDTO login(String logingEmail, String loginPassword) {
	    Optional<Cliente> optCliente = clienteRepo.findByEmail(logingEmail);
	    if (optCliente.isEmpty()) {
	        throw new InvalidCredentialsException(); 
	    } 
	    Cliente cliente = optCliente.get();
	    // Verifica se la password nel database corrisponde a quella passata digitata nel formulario di Login.
	    if (!passwordEncoder.matches(loginPassword, cliente.getPassword())) {
	        throw new InvalidCredentialsException();
	    }
	    return convertToDTO(cliente);
	}
	
	@Transactional
	public ClienteDTO register(RegisterDTO registerDTO) {
        Optional<Cliente> optCliente = clienteRepo.findByEmail(registerDTO.getEmail());
        if (optCliente.isPresent()) {
            throw new ClienteEmailAlreadyInUse();
        }
        // Crea un nuovo Cliente e codifica la password
        Cliente cliente = new Cliente();
        cliente.setNome(registerDTO.getNome());
        cliente.setCognome(registerDTO.getCognome());
        cliente.setEmail(registerDTO.getEmail());
        cliente.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        // Salva il nuovo Cliente nel database
        return convertToDTO(clienteRepo.save(cliente));
    }
}
