import exception.InvalidInputException;
import java.net.URL;
import java.util.Random;

public class UrlShortenerService {

  public static void main(String[] args) {

  }


  public final static String shortDomain = "http://mydomain.com";

  public final static String slash = "/";

  public final static String alphanumeric = "0123456789abcdefghijklmnopqrstuvwxyz";

  public static String shortenUrl(String longUrl) throws Exception {

    checkValidUrl(longUrl);

    return shortDomain + slash + generateRandomAlphanumericString(4);

  }


  public static String generateRandomAlphanumericString(int length) {

    Random random = new Random();

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < length; i++) {
      result.append(alphanumeric.charAt(random.nextInt(alphanumeric.length())));

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
