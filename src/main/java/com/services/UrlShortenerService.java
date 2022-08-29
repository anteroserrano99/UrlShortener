package com.services;

import com.exception.InvalidInputException;
import java.util.Objects;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.utils.UrlCreationUtils;

import static com.utils.UrlCreationUtils.DEFAULT_DOMAIN;
import static com.utils.UrlCreationUtils.SLASH;


@RestController(value = "/")
public class UrlShortenerService {


  @RequestMapping(value = "seoWord")
  public static String shortUrlWithSeoWord(
      @RequestParam(value = "longUrl") String longUrl,
      @RequestParam(value = "seoWord" ) String seoWord) throws Exception {

    Objects.requireNonNull(seoWord);

    if (seoWord.trim().isEmpty()) throw new InvalidInputException("SEO word cannot be empty");

    UrlCreationUtils.checkValidUrl(longUrl);


    return DEFAULT_DOMAIN + SLASH + seoWord;

  }

  @RequestMapping(value = "random")
  public static String shortUrlWithRandomAlphanumeric(
      @RequestParam(value = "longUrl") String longUrl) throws Exception {

    UrlCreationUtils.checkValidUrl(longUrl);

    return DEFAULT_DOMAIN + SLASH + UrlCreationUtils.generateRandomAlphanumericString(4);

  }




}
