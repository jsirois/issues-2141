package org.example;

import com.google.common.base.Charsets;
import com.google.common.base.Optional;
import com.google.common.base.Supplier;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;

public class Library {
  public static String loadMotd(Optional<URL> resource) throws IOException {
    URL res = resource.or(new Supplier<URL>() {
      public URL get() {
        return Resources.getResource(Library.class, "res.txt");
      }
    });
    return Resources.toString(res, Charsets.UTF_8);
  }
}
