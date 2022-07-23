package com.wissem.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wissem.gestiondestock.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
