package com.andos.projet_produit_core.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;

/**
 * <p></p>
 *
 * @author Anderson Ouattara 2023-05-20
 */
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idImage;
  private String name;
  private String type;
//  @Column(name = "IMAGE", length = 4048576)
  @Lob
  private byte[] image;
  @OneToOne
  private Produit produit;
}
