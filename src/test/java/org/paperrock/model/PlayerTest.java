package org.paperrock.model;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
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
public class PlayerTest {

  private static final Logger LOG = Logger.getLogger(PlayerTest.class.getName());

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  public PlayerTest() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  /**
   * Test of incrementScore method, of class Player.
   */
  @Test
  public void testIncrementScore() {
    System.out.println("incrementScore");
    InputStream anyInputStream = new ByteArrayInputStream("1".getBytes());
    Config config = CommandLineParser.parseCommandlineArgs(new String[]{});
    ConsoleService console = new ConsoleService(config, anyInputStream, System.out::println);
    Player instance = new HumanPlayer(console);
    instance.incrementScore();
    assertEquals(1, instance.getScore());
  }

  /**
   * Test of resetScore method, of class Player.
   */
  @Test
  public void testResetScore() {
    System.out.println("resetScore");
    InputStream anyInputStream = new ByteArrayInputStream("1".getBytes());
    Config config = CommandLineParser.parseCommandlineArgs(new String[]{});
    ConsoleService console = new ConsoleService(config, anyInputStream, System.out::println);
    Player instance = new HumanPlayer(console);
    instance.setScore(5);
    instance.resetScore();
    assertEquals(0, instance.getScore());
  }

}
