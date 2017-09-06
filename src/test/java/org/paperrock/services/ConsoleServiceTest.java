package org.paperrock.services;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.paperrock.commandline.CommandLineParser;
import org.paperrock.commandline.Config;
import org.paperrock.model.ComputerPlayer;
import org.paperrock.model.HumanPlayer;
import org.paperrock.model.Player;
import org.paperrock.model.Selection;

/**
 *
 * @author Brighton Kukasira <brighton.kukasira@gmail.com>
 */
public class ConsoleServiceTest {

  private static final Logger LOGGER
          = Logger.getLogger(ConsoleServiceTest.class.getName());

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  public ConsoleServiceTest() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  /**
   * Test of displayGoodByeMesasge method, of class ConsoleService.
   */
  @Test
  public void testDisplayGoodByeMesasge() throws Exception {
    System.out.println("displayGoodByeMesasge");
    InputStream anyInputStream = new ByteArrayInputStream("1".getBytes());
    Config config = CommandLineParser.parseCommandlineArgs(new String[]{});
    ConsoleService instance = new ConsoleService(config, anyInputStream, System.out::println);
    instance.displayGoodByeMesasge();
  }

  /**
   * Test of displayMainMenu method, of class ConsoleService.
   */
  @Test
  public void testDisplayMainMenu() throws Exception {
    System.out.println("displayMainMenu");
    InputStream anyInputStream = new ByteArrayInputStream("1".getBytes());
    Config config = CommandLineParser.parseCommandlineArgs(new String[]{});
    ConsoleService instance = new ConsoleService(config, anyInputStream, System.out::println);
    instance.displayMainMenu();
  }

  /**
   * Test of displayResult method, of class ConsoleService.
   */
  @Test
  public void testDisplayResult() {
    System.out.println("displayResult");
    String message = "";
    InputStream anyInputStream = new ByteArrayInputStream("1".getBytes());
    Config config = CommandLineParser.parseCommandlineArgs(new String[]{});
    ConsoleService instance = new ConsoleService(config, anyInputStream, System.out::println);
    instance.displayResult(message);
  }

  /**
   * Test of displayScores method, of class ConsoleService.
   */
  @Test
  public void testDisplayScores() {
    System.out.println("displayScores");
    Player humanPlayer = null;
    Player computerPlayer = null;
    InputStream anyInputStream = new ByteArrayInputStream("1".getBytes());
    Config config = CommandLineParser.parseCommandlineArgs(new String[]{});
    ConsoleService instance = new ConsoleService(config, anyInputStream, System.out::println);
    instance.displayScores(humanPlayer, computerPlayer);
  }

  /**
   * Test of displayOverallResult method, of class ConsoleService.
   */
  @Test
  public void testDisplayOverallResult() {
    System.out.println("displayOverallResult");
    String message = "";
    InputStream anyInputStream = new ByteArrayInputStream("1".getBytes());
    Config config = CommandLineParser.parseCommandlineArgs(new String[]{});
    ConsoleService instance = new ConsoleService(config, anyInputStream, System.out::println);
    instance.displayOverallResult(message);
  }

  /**
   * Test of displayWelcomeMessage method, of class ConsoleService.
   */
  @Test
  public void testDisplayWelcomeMessage() throws Exception {
    System.out.println("displayWelcomeMessage");
    InputStream anyInputStream = new ByteArrayInputStream("1".getBytes());
    Config config = CommandLineParser.parseCommandlineArgs(new String[]{});
    ConsoleService instance = new ConsoleService(config, anyInputStream, System.out::println);
    instance.displayWelcomeMessage();
  }

  /**
   * Test of displayselections method, of class ConsoleService.
   */
  @Test
  public void testDisplayselections() {
    System.out.println("displayselections");
    InputStream anyInputStream = new ByteArrayInputStream("1".getBytes());
    Config config = CommandLineParser.parseCommandlineArgs(new String[]{});
    ConsoleService instance = new ConsoleService(config, anyInputStream, System.out::println);
    HumanPlayer humanPlayer = new HumanPlayer(instance);
    Player computerPlayer = new ComputerPlayer();
    humanPlayer.setSelection(Selection.PAPER);
    computerPlayer.setSelection(Selection.PAPER);
    instance.displayselections(humanPlayer, computerPlayer);
  }

  /**
   * Test of displayTryAgainMessage method, of class ConsoleService.
   */
  @Test
  public void testDisplayTryAgainMessage() {
    System.out.println("displayTryAgainMessage");
    InputStream anyInputStream = new ByteArrayInputStream("1".getBytes());
    Config config = CommandLineParser.parseCommandlineArgs(new String[]{});
    ConsoleService instance = new ConsoleService(config, anyInputStream, System.out::println);
    instance.displayTryAgainMessage();
  }

}
