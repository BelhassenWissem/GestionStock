package com.wissem.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wissem.gestiondestock.model.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

}
