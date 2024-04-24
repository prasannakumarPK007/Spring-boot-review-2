package com.eventmanagement.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventmanagement.login.model.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Integer> {

}
