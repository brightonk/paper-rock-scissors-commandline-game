package org.paperrock.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.paperrock.commandline.CommandLineParser;
import org.paperrock.commandline.Config;
import org.paperrock.services.ConsoleService;

/**
 *
 * @author Brighton Kukasira <brighton.kukasira@gmail.com>
 */
public class HumanPlayerTest {

  private static final Logger LOGGER
          = Logger.getLogger(HumanPlayerTest.class.getName());

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  public HumanPlayerTest() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  /**
   * Test of makeSelection method, of class HumanPlayer.
   */
  @Test
  public void testMakeSelection() throws IOException {
    System.out.println("makeSelection");
    AtomicBoolean quit = new AtomicBoolean();
    InputStream anyInputStream = new ByteArrayInputStream("1".getBytes());
    Config config = CommandLineParser.parseCommandlineArgs(new String[]{});
    ConsoleService console = new ConsoleService(config, anyInputStream, System.out::println);
    HumanPlayer instance = new HumanPlayer(console);
    instance.makeSelection(quit);
  }

}
