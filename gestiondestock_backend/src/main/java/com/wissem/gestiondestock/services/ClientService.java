package com.wissem.gestiondestock.services;

import java.util.List;

import com.wissem.gestiondestock.dto.ClientDto;

public interface ClientService {

  ClientDto save(ClientDto dto);

  ClientDto findById(Integer id);

  List<ClientDto> findAll();

  void delete(Integer id);

}
