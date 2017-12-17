/**
 * Copyright (C) 2017 Spotify AB
 */
package com.ada.music.sheets.service;

import com.ada.music.sheets.domain.MyUrl;
import com.ada.music.sheets.domain.ShortUrl;
import java.net.MalformedURLException;
import java.util.concurrent.CompletableFuture;

public interface ShertenedUrlsService {

  CompletableFuture<ShortUrl> urlToShorten(String url) throws MalformedURLException;

  MyUrl findUrl(String url);
}
