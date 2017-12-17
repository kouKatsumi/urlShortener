/**
 * Copyright (C) 2017 Spotify AB
 */
package com.ada.ulrShortener.service;

import com.ada.ulrShortener.domain.LongUrl;
import com.ada.ulrShortener.domain.MyUrl;
import com.ada.ulrShortener.domain.ShortUrl;
import com.ada.ulrShortener.repositories.SheetRepository;
import com.ada.ulrShortener.utils.UrlShortener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class UrlServiceImpl implements ShertenedUrlsService {

  private final SheetRepository sheetRepository;

  @Autowired
  public UrlServiceImpl(SheetRepository sheetRepository) {
    this.sheetRepository = sheetRepository;
  }


  @Override
  public CompletableFuture<ShortUrl> urlToShorten(final String urlAsString)
      throws MalformedURLException {
    URL url = new URL(urlAsString);
    CompletableFuture<ShortUrl> completableFuture = CompletableFuture.supplyAsync(
        () -> {
          try {
            return sheetRepository.save(new ShortUrl(UrlShortener.generateShortUrl
                (url), new LongUrl(url)));
          } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
          }
        });
    return completableFuture;
  }

  @Override
  public MyUrl findUrl(final String url) {
    return sheetRepository.findOne(url);
  }
}

