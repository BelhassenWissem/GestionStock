package com.wissem.gestiondestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wissem.gestiondestock.model.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {

}
