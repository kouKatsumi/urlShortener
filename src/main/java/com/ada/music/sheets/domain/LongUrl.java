/**
 * Copyright (C) 2017 Spotify AB
 */
package com.ada.music.sheets.domain;

import java.net.URL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "long_url")
@Entity
public class LongUrl implements MyUrl {

  private LongUrl() {
  }

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;


  @Column(name = "url")
  private URL url;

  public LongUrl(final URL url) {
    this.url = url;
  }

  private Long getId() {
    return id;
  }

  public String getUrl() {
    return url.toString();
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final LongUrl myUrl = (LongUrl) o;

    if (!id.equals(myUrl.id)) {
      return false;
    }
    return url.equals(myUrl.url);
  }

  @Override
  public int hashCode() {
    int result = id.hashCode();
    result = 31 * result + url.hashCode();
    return result;
  }


  @Override
  public String toString() {
    return "MyUrl{" +
           "id=" + id +
           ", url=" + url +
           '}';
  }

}
