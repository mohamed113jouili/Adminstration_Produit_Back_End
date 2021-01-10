package com.produit.service;

import java.util.List;
import java.util.Optional;

import com.produit.dao.Client;

public interface ClientService {

	public Optional<Client> findOneClient(Long id);

	public List<Client> findAllClient();

	public Client saveClient(Client client);

	public Client updateClient(Long id,Client client);

	public void deleteProductByid(Long id);

}
