package com.wissem.gestiondestock.services.strategy;

import com.flickr4java.flickr.FlickrException;
import com.wissem.gestiondestock.dto.ClientDto;
import com.wissem.gestiondestock.exception.ErrorCodes;
import com.wissem.gestiondestock.exception.InvalidOperationException;
import com.wissem.gestiondestock.model.Client;
import com.wissem.gestiondestock.services.ClientService;
import com.wissem.gestiondestock.services.FlickrService;

import java.io.InputStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("clientStrategy")
@Slf4j
public class SaveClientPhoto implements Strategy<ClientDto> {

  private FlickrService flickrService;
  private ClientService clientService;

  @Autowired
  public SaveClientPhoto(FlickrService flickrService, ClientService clientService) {
    this.flickrService = flickrService;
    this.clientService = clientService;
  }

  @Override
  public ClientDto savePhoto(Integer id, InputStream photo, String titre) throws FlickrException {
    ClientDto client = clientService.findById(id);
    String urlPhoto = flickrService.savePhoto(photo, titre);
    if (!StringUtils.hasLength(urlPhoto)) {
      throw new InvalidOperationException("Erreur lors de l'enregistrement de photo du client", ErrorCodes.UPDATE_PHOTO_EXCEPTION);
    }
    client.setPhoto(urlPhoto);
    return clientService.save(client);
  }
}
