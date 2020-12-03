package com.produit.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.produit.dao.Client;
import com.produit.service.ClientService;

@CrossOrigin("*")
@RestController
public class ClientController {

	@Autowired
	ClientService clientservice;

	/*
	 *** find client by id
	 */
	@RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
	public Optional<Client> getClientById(@PathVariable Long id) {
		return clientservice.findOneClient(id);
	}

	/*
	 *** find all client
	 */
	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public List<Client> getAllClient() {
		return clientservice.findAllPlayer();
	}

	/*
	 *** save client
	 */
	@RequestMapping(value = "save/client", method = RequestMethod.POST)
	public Client savePlayer(@Valid @RequestBody Client client) {

		return clientservice.saveClient(client);
	}

	/*
	 *** update client
	 */
	@RequestMapping(value = "/update/client/{id}", method = RequestMethod.PUT)
	public Client updatePlayer(@PathVariable Long id, @RequestBody Client client) {
		return clientservice.updateClient(id, client);

	}

	/*
	 *** delete client by id
	 */
	@RequestMapping(value = "/delete/client/{id}", method = RequestMethod.DELETE)
	public Boolean deletePlayerById(@PathVariable Long id) {
		clientservice.deleteProductByid(id);
		return true;
	}

}
