package com.services;

import com.exception.InvalidInputException;
import com.urlCache.UrlCache;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.utils.UrlCreationUtils;

import static com.utils.UrlCreationUtils.DEFAULT_DOMAIN;
import static com.utils.UrlCreationUtils.SLASH;


@RestController(value = "/")
public class UrlShortenerService {

  @Autowired
  UrlCache urlCache;

  public UrlShortenerService(UrlCache urlCache){
    this.urlCache = urlCache;

  }


  @RequestMapping(value = "seoWord")
  public String shortUrlWithSeoWord(
      @RequestParam(value = "longUrl") String longUrl,
      @RequestParam(value = "seoWord" ) String seoWord) throws Exception {

    if (StringUtils.isEmpty(seoWord)) throw new InvalidInputException("SEO word cannot be empty");

    UrlCreationUtils.checkValidUrl(longUrl);

    String resultUrl = DEFAULT_DOMAIN + SLASH + seoWord;


    return urlCache.getOrPutUrl(resultUrl, longUrl);
  }

  @RequestMapping(value = "random")
  public String shortUrlWithRandomAlphanumeric(
      @RequestParam(value = "longUrl") String longUrl) throws Exception {

    UrlCreationUtils.checkValidUrl(longUrl);

    String resultUrl = DEFAULT_DOMAIN + SLASH + UrlCreationUtils.generateRandomAlphanumericString(4);

    return urlCache.getOrPutUrl(resultUrl, longUrl);

  }




}
