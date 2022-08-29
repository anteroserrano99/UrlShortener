package com.utils;

import com.exception.InvalidInputException;
import java.net.URL;
import java.util.Random;

public class UrlCreationUtils {

  public final static String ALPHANUMERIC = "0123456789abcdefghijklmnopqrstuvwxyz";


  public final static String DEFAULT_DOMAIN = "http://www.shortDomain.com";

  public final static String SLASH = "/";



  public static String generateRandomAlphanumericString(int length) {

    Random random = new Random();

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < length; i++) {
      result.append(ALPHANUMERIC.charAt(random.nextInt(ALPHANUMERIC.length())));

    }
    return result.toString();
  }


  public static void checkValidUrl(String longUrl) throws InvalidInputException {
    try {
      new URL(longUrl);

    } catch (Exception e) {
      throw new InvalidInputException("Informed Url is malformed");
    }
  }


}
