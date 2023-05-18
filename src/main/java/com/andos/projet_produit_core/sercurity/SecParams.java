package com.andos.projet_produit_core.sercurity;

import com.auth0.jwt.algorithms.Algorithm;

/**
 * <p></p>
 *
 * @author Anderson Ouattara 2023-05-18
 */
public interface SecParams {

  public static final long EXP_TIME = 10 * 24 * 60 * 60 * 1000;
  public static final String SECRET = "nadhemb@yahoo.com";
  public static final String PREFIX = "Bearer ";
  public static final Algorithm ALGORITHME_SIGNATURE = Algorithm.HMAC256(SECRET);
}
