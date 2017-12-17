/**
 * Copyright (C) 2017 Spotify AB
 */
package com.ada.music.sheets.domain;

import java.net.MalformedURLException;
import java.net.URL;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "short_url")
@Entity
public class ShortUrl implements MyUrl {

  @Id
  @Column(name = "url")
  private String url;

//  @Id
//  @Column(name = "id")
//  @GeneratedValue(strategy = GenerationType.AUTO)
//  private Long id;

  @JoinColumn(name="long_url")
  @OneToOne(cascade = CascadeType.ALL)
  private LongUrl longUrl;

  public ShortUrl() {
  }

  public ShortUrl(final String url, final LongUrl longUrl) throws MalformedURLException {
    this.url = url;
    this.longUrl = longUrl;
  }

  public String getId(){
    return url;
  }
  public String getUrl() {
    return longUrl.getUrl();
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final ShortUrl shortUrl = (ShortUrl) o;

    return url != null ? url.equals(shortUrl.url) : shortUrl.url == null;
  }

  @Override
  public int hashCode() {
    return url != null ? url.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "ShortUrl{" +
           "url=" + url +
           '}';
  }
}
