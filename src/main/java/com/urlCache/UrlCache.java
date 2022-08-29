package com.urlCache;

import com.exception.InvalidInputException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;


@Component
public class UrlCache {

// FIXME Use a data structure that links both short and long url together for fast searches.
  Map<String, String> cache = new HashMap<>();



  public String getOrPutUrl(String shortUrl, String longUrl) throws Exception {

    String cachedLongUrl = getLongUrl(shortUrl);

    if (cachedLongUrl != null) return cachedLongUrl;

    return putUrl(shortUrl, longUrl);
  }



  public String getLongUrl(String shortUrl) throws Exception {

    if (StringUtils.isEmpty(shortUrl)) throw new Exception("invalid string");

    return cache.get(shortUrl);
  }




  public String putUrl(String shortUrl, String longUrl) throws Exception {

    if (StringUtils.isEmpty(shortUrl)) throw new Exception("invalid string");

    if (StringUtils.isEmpty(longUrl)) throw new Exception("SEO word cannot be empty");

    cache.put(shortUrl, longUrl);

    return shortUrl;
  }


}
