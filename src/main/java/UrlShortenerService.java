import exception.InvalidInputException;
import java.net.URL;
import java.util.Random;
import static utils.UrlCreationUtils.ALPHANUMERIC;
import static utils.UrlCreationUtils.DEFAULT_DOMAIN;
import static utils.UrlCreationUtils.SLASH;

public class UrlShortenerService {

  public static void main(String[] args) {

  }



  public static String shortUrlWithSeoWord(String longUrl, String seoWord) throws Exception {

    checkValidUrl(longUrl);

    if (seoWord == null || seoWord.isEmpty()){
      throw new InvalidInputException("SEO word cannot be empty");
    }

    return DEFAULT_DOMAIN + SLASH + seoWord;

  }


  public static String shortUrlWithRandomAlphanumeric(String longUrl) throws Exception {

    checkValidUrl(longUrl);

    return DEFAULT_DOMAIN + SLASH + generateRandomAlphanumericString(4);

  }


  public static String generateRandomAlphanumericString(int length) {

    Random random = new Random();

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < length; i++) {
      result.append(ALPHANUMERIC.charAt(random.nextInt(ALPHANUMERIC.length())));

    }
    return result.toString();
  }


  private static void checkValidUrl(String longUrl) throws InvalidInputException {
    try {
      new URL(longUrl);

    } catch (Exception e) {
      throw new InvalidInputException("Informed Url is malformed");
    }
  }

}
