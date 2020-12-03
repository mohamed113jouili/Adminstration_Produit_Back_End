package com.produit.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produit.dao.Client;
import com.produit.dao.ClientRepository;

@Service
@Transactional
public class ClientServiceImp implements ClientService {

	@Autowired
	 ClientRepository clientrepository;
	
	
	@Override
	public Optional<Client> findOneClient(Long id) {
		return clientrepository.findById(id);
	}

	@Override
	public List<Client> findAllPlayer() {
		return clientrepository.findAll();
	}

	@Override
	public Client saveClient(Client client) {
		return clientrepository.save(client);
	}

	@Override
	public Client updateClient(Long id,Client client) {
		client.setId(id);
		return clientrepository.save(client);
	}

	@Override
	public void deleteProductByid(Long id) {
	 clientrepository.deleteById(id);
	}

}
