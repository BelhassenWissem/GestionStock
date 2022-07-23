package com.wissem.gestiondestock.services;

import java.util.List;

import com.wissem.gestiondestock.dto.EntrepriseDto;

public interface EntrepriseService {

  EntrepriseDto save(EntrepriseDto dto);

  EntrepriseDto findById(Integer id);

  List<EntrepriseDto> findAll();

  void delete(Integer id);

}
