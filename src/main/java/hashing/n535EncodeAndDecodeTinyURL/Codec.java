package hashing.n535EncodeAndDecodeTinyURL;

import java.util.LinkedList;
import java.util.List;

public class Codec {
 int counter =0;
 List<String> list = new LinkedList<>();

 // Encodes a URL to a shortened URL.
 public String encode(String longUrl) {
  list.add(longUrl);
  return String.valueOf(counter++);
 }

 // Decodes a shortened URL to its original URL.
 public String decode(String shortUrl) {
  return list.get(Integer.parseInt(shortUrl));
 }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));