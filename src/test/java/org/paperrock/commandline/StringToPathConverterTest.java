package org.paperrock.commandline;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Brighton Kukasira <brighton.kukasira@gmail.com>
 */
public class StringToPathConverterTest {

  private static final Logger LOG = Logger.getLogger(StringToPathConverterTest.class.getName());

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  public StringToPathConverterTest() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  /**
   * Test of convert method, of class StringToPathConverter.
   */
  @Test
  public void testConvert() {
    System.out.println("convert");
    String value = "test.txt";
    StringToPathConverter instance = new StringToPathConverter();
    Path expResult = Paths.get(value);
    Path result = instance.convert(value);
    assertEquals(expResult, result);
  }
}
