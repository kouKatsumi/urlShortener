/**
 * Copyright (C) 2017 Spotify AB
 */
package com.ada.ulrShortener.web;

import com.ada.ulrShortener.service.ShertenedUrlsService;
import com.ada.ulrShortener.utils.UrlCreator;
import java.net.MalformedURLException;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/url", produces = "text/plain;charset=UTF-8")
class UrlController {

  private final ShertenedUrlsService service;

  @Autowired
  UrlCreator urlCreator;

  @Autowired
  public UrlController(ShertenedUrlsService service) {
    this.service = service;
  }

  @RequestMapping(value = "/{url}", method = RequestMethod.GET)
  @ResponseBody
  public ModelAndView findOne(@PathVariable("url") String url) throws MalformedURLException {
    return new ModelAndView("redirect:" + service.findUrl(url).getUrl());
  }

  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody
  public String create(@RequestBody String resource)
      throws MalformedURLException, ExecutionException, InterruptedException {
    return urlCreator.createFullUrl(service.urlToShorten(resource).get().getId());
  }

}
