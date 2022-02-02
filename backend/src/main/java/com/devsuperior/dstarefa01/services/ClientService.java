package com.devsuperior.dstarefa01.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dstarefa01.dto.ClientDTO;
import com.devsuperior.dstarefa01.entities.Client;
import com.devsuperior.dstarefa01.repositories.ClientRepository;
import com.devsuperior.dstarefa01.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	public ClientRepository repository;

	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
		Page<Client> list = repository.findAll(pageRequest);
		return list.map(x -> new ClientDTO(x));
	}

	@Transactional(readOnly = true)
	public ClientDTO findByid(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found!"));
		return new ClientDTO(entity);
	}

	@Transactional(readOnly = true)
	public ClientDTO insert(ClientDTO dto) {
		Client client = new Client(dto.getName(), dto.getCpf(), dto.getIncome(), dto.getBirthDate(), dto.getChildren());
		client = repository.save(client);
		return new ClientDTO(client);
	}

	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			Client client = repository.getOne(id);
			client.setName(dto.getName());
			client.setBirthDate(dto.getBirthDate());
			client.setChildren(dto.getChildren());
			client.setCpf(dto.getCpf());
			client.setIncome(dto.getIncome());
			client = repository.save(client);
			return new ClientDTO(client);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}
	
	@Transactional(readOnly = true)
	public void delete(Long id) {
		try {
			
		} catch (Exception e) {
			
		}
	}
}
