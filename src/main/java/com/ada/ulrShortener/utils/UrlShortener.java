/**
 * Copyright (C) 2017 Spotify AB
 */
package com.ada.ulrShortener.utils;

import static com.google.common.io.BaseEncoding.base64Url;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlShortener {

  public static final String generateShortUrl(URL url) throws MalformedURLException {
    String encoded = base64Url().encode(url.toString().getBytes());
    return encoded;
  }
}
