package com.wissem.gestiondestock.services.strategy;

import com.flickr4java.flickr.FlickrException;
import com.wissem.gestiondestock.dto.FournisseurDto;
import com.wissem.gestiondestock.exception.ErrorCodes;
import com.wissem.gestiondestock.exception.InvalidOperationException;
import com.wissem.gestiondestock.model.Fournisseur;
import com.wissem.gestiondestock.services.FlickrService;
import com.wissem.gestiondestock.services.FournisseurService;

import java.io.InputStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("fournisseurStrategy")
@Slf4j
public class SaveFournisseurPhoto implements Strategy<FournisseurDto> {

  private FlickrService flickrService;
  private FournisseurService fournisseurService;

  @Autowired
  public SaveFournisseurPhoto(FlickrService flickrService, FournisseurService fournisseurService) {
    this.flickrService = flickrService;
    this.fournisseurService = fournisseurService;
  }

  @Override
  public FournisseurDto savePhoto(Integer id, InputStream photo, String titre) throws FlickrException {
    FournisseurDto fournisseur = fournisseurService.findById(id);
    String urlPhoto = flickrService.savePhoto(photo, titre);
    if (!StringUtils.hasLength(urlPhoto)) {
      throw new InvalidOperationException("Erreur lors de l'enregistrement de photo du fournisseur", ErrorCodes.UPDATE_PHOTO_EXCEPTION);
    }
    fournisseur.setPhoto(urlPhoto);
    return fournisseurService.save(fournisseur);
  }
}
