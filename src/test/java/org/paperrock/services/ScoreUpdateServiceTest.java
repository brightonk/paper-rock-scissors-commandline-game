package org.paperrock.services;

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
import org.paperrock.model.ComputerPlayer;
import org.paperrock.model.HumanPlayer;
import org.paperrock.model.Player;
import org.paperrock.model.Result;

/**
 *
 * @author Brighton Kukasira <brighton.kukasira@gmail.com>
 */
public class ScoreUpdateServiceTest {

  private static final Logger LOGGER
          = Logger.getLogger(ScoreUpdateServiceTest.class.getName());

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  public ScoreUpdateServiceTest() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  /**
   * Test of updateScore method, of class ScoreUpdateService.
   */
  @Test
  public void testUpdateScoreOnDraw() {
    System.out.println("updateScore");
    Result result = Result.DRAW;
    InputStream anyInputStream = new ByteArrayInputStream("1".getBytes());
    Config config = CommandLineParser.parseCommandlineArgs(new String[]{});
    ConsoleService console = new ConsoleService(config, anyInputStream, System.out::println);
    HumanPlayer humanPlayer = new HumanPlayer(console);
    Player computerPlayer = new ComputerPlayer();
    ScoreUpdateService instance = new ScoreUpdateService();
    instance.updateScore(result, humanPlayer, computerPlayer);
    assertEquals(0, humanPlayer.getScore());
    assertEquals(0, computerPlayer.getScore());
  }

  /**
   * Test of updateScore method, of class ScoreUpdateService.
   */
  @Test
  public void testUpdateScoreOnLost() {
    System.out.println("updateScore");
    Result result = Result.LOST;
    InputStream anyInputStream = new ByteArrayInputStream("1".getBytes());
    Config config = CommandLineParser.parseCommandlineArgs(new String[]{});
    ConsoleService console = new ConsoleService(config, anyInputStream, System.out::println);
    HumanPlayer humanPlayer = new HumanPlayer(console);
    Player computerPlayer = new ComputerPlayer();
    ScoreUpdateService instance = new ScoreUpdateService();
    instance.updateScore(result, humanPlayer, computerPlayer);
    assertEquals(0, humanPlayer.getScore());
    assertEquals(1, computerPlayer.getScore());
  }

  /**
   * Test of updateScore method, of class ScoreUpdateService.
   */
  @Test
  public void testUpdateScoreOnWon() {
    System.out.println("updateScore");
    Result result = Result.WON;
    InputStream anyInputStream = new ByteArrayInputStream("1".getBytes());
    Config config = CommandLineParser.parseCommandlineArgs(new String[]{});
    ConsoleService console = new ConsoleService(config, anyInputStream, System.out::println);
    HumanPlayer humanPlayer = new HumanPlayer(console);
    Player computerPlayer = new ComputerPlayer();
    ScoreUpdateService instance = new ScoreUpdateService();
    instance.updateScore(result, humanPlayer, computerPlayer);
    assertEquals(1, humanPlayer.getScore());
    assertEquals(0, computerPlayer.getScore());
  }

}
