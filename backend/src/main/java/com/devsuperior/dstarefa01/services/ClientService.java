package com.devsuperior.dstarefa01.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dstarefa01.dto.ClientDTO;
import com.devsuperior.dstarefa01.entities.Client;
import com.devsuperior.dstarefa01.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	public ClientRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAllPaged(PageRequest pageRequest){
		Page<Client> list = repository.findAll(pageRequest);
		return list.map(x -> new ClientDTO(x));
	}
}
