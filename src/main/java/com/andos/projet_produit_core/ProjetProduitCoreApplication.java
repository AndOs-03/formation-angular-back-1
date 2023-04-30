package com.andos.projet_produit_core;

import com.andos.projet_produit_core.entites.Categorie;
import com.andos.projet_produit_core.entites.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.config.RepositoryConfiguration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ProjetProduitCoreApplication implements CommandLineRunner {

  @Autowired
  RepositoryRestConfiguration repositoryRestConfiguration;

  public static void main(String[] args) {
    SpringApplication.run(ProjetProduitCoreApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    this.repositoryRestConfiguration.exposeIdsFor(Produit.class, Categorie.class);
  }
}
