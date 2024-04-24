package com.eventmanagement.login.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventmanagement.login.model.Client;
import com.eventmanagement.login.repository.ClientRepo;

@Service
public class ClientService {
    @Autowired
    public ClientRepo clientRepo;

    public Client postdetails(Client client) {
        return clientRepo.save(client);
    }

    public List<Client> get() {
        return clientRepo.findAll();
    }

    public void deleteClientById(int clientId) {
        clientRepo.deleteById(clientId);
    }

    public Optional<Client> getClientById(int clientId) {
        return clientRepo.findById(clientId);
    }
}
