/**
 * Copyright (C) 2017 Spotify AB
 */
package com.ada.ulrShortener.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Controller;

@Controller
public class UrlCreator {

  private final static String PROTOCOL = "http://";
  private static final String COLON = ":";
  private static final String SLASH = "/";
  private static final String PATH = "url";

  @Autowired
  private ServerProperties sv;

  public UrlCreator() {
  }

  public final String createFullUrl(String suffix) {
    String address = sv.getAddress() == null ? "localhost" : sv.getAddress().getCanonicalHostName();
    return PROTOCOL + address + COLON + sv.getPort().toString() + SLASH + PATH + SLASH + suffix;
  }

}
