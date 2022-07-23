package com.wissem.gestiondestock.services;

import java.util.List;

import com.wissem.gestiondestock.dto.ArticleDto;
import com.wissem.gestiondestock.dto.LigneCommandeClientDto;
import com.wissem.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.wissem.gestiondestock.dto.LigneVenteDto;

public interface ArticleService {

  ArticleDto save(ArticleDto dto);

  ArticleDto findById(Integer id);

  ArticleDto findByCodeArticle(String codeArticle);

  List<ArticleDto> findAll();

  List<LigneVenteDto> findHistoriqueVentes(Integer idArticle);

  List<LigneCommandeClientDto> findHistoriaueCommandeClient(Integer idArticle);

  List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle);

  List<ArticleDto> findAllArticleByIdCategory(Integer idCategory);

  void delete(Integer id);

}
