package org.example;

import com.google.common.base.Optional;
import com.google.common.io.Resources;

import java.net.URL;

import org.example.Library;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
  @Test
  public void testDefault() throws Exception {
    assertEquals("main resource\n", Library.loadMotd(Optional.<URL>absent()));
  }

  @Test
  public void testSupplied() throws Exception {
    URL res = Resources.getResource(getClass(), "test_res.txt");
    assertEquals("test resource\n", Library.loadMotd(Optional.of(res)));
  }
}
