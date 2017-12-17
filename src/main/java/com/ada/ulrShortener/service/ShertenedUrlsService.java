/**
 * Copyright (C) 2017 Spotify AB
 */
package com.ada.ulrShortener.service;

import com.ada.ulrShortener.domain.MyUrl;
import com.ada.ulrShortener.domain.ShortUrl;
import java.net.MalformedURLException;
import java.util.concurrent.CompletableFuture;

public interface ShertenedUrlsService {

  CompletableFuture<ShortUrl> urlToShorten(String url) throws MalformedURLException;

  MyUrl findUrl(String url);
}
