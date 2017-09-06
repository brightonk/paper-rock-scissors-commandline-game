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
import org.paperrock.model.Selection;

/**
 *
 * @author Brighton Kukasira <brighton.kukasira@gmail.com>
 */
public class ResultServiceTest {

  private static final Logger LOGGER
          = Logger.getLogger(ResultServiceTest.class.getName());

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  public ResultServiceTest() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  /**
   * Test of getResult method, of class ResultService.
   */
  @Test
  public void testGetResultOnDraw() {
    System.out.println("getResult");
    InputStream anyInputStream = new ByteArrayInputStream("1".getBytes());
    Config config = CommandLineParser.parseCommandlineArgs(new String[]{});
    ConsoleService console = new ConsoleService(config, anyInputStream, System.out::println);
    HumanPlayer humanPlayer = new HumanPlayer(console);
    Player computerPlayer = new ComputerPlayer();
    humanPlayer.setSelection(Selection.PAPER);
    computerPlayer.setSelection(Selection.PAPER);
    ResultService instance = new ResultService();
    Result expResult = Result.DRAW;
    Result result = instance.getResult(humanPlayer, computerPlayer);
    assertEquals(expResult, result);
  }

  /**
   * Test of getResult method, of class ResultService.
   */
  @Test
  public void testGetResultOnLost() {
    System.out.println("getResult");
    InputStream anyInputStream = new ByteArrayInputStream("1".getBytes());
    Config config = CommandLineParser.parseCommandlineArgs(new String[]{});
    ConsoleService console = new ConsoleService(config, anyInputStream, System.out::println);
    HumanPlayer humanPlayer = new HumanPlayer(console);
    Player computerPlayer = new ComputerPlayer();
    humanPlayer.setSelection(Selection.PAPER);
    computerPlayer.setSelection(Selection.SCISSORS);
    ResultService instance = new ResultService();
    Result expResult = Result.LOST;
    Result result = instance.getResult(humanPlayer, computerPlayer);
    assertEquals(expResult, result);
  }

  /**
   * Test of getResult method, of class ResultService.
   */
  @Test
  public void testGetResultOnWon() {
    System.out.println("getResult");
    InputStream anyInputStream = new ByteArrayInputStream("1".getBytes());
    Config config = CommandLineParser.parseCommandlineArgs(new String[]{});
    ConsoleService console = new ConsoleService(config, anyInputStream, System.out::println);
    HumanPlayer humanPlayer = new HumanPlayer(console);
    Player computerPlayer = new ComputerPlayer();
    humanPlayer.setSelection(Selection.PAPER);
    computerPlayer.setSelection(Selection.ROCK);
    ResultService instance = new ResultService();
    Result expResult = Result.WON;
    Result result = instance.getResult(humanPlayer, computerPlayer);
    assertEquals(expResult, result);
  }

  /**
   * Test of getOverallResult method, of class ResultService.
   */
  @Test
  public void testGetOverallResultOnDraw() {
    System.out.println("getOverallResult");
    InputStream anyInputStream = new ByteArrayInputStream("1".getBytes());
    Config config = CommandLineParser.parseCommandlineArgs(new String[]{});
    ConsoleService console = new ConsoleService(config, anyInputStream, System.out::println);
    HumanPlayer humanPlayer = new HumanPlayer(console);
    Player computerPlayer = new ComputerPlayer();
    humanPlayer.setScore(5);
    computerPlayer.setScore(5);
    ResultService instance = new ResultService();
    Result expResult = Result.DRAW;
    Result result = instance.getOverallResult(humanPlayer, computerPlayer);
    assertEquals(expResult, result);
  }

  /**
   * Test of getOverallResult method, of class ResultService.
   */
  @Test
  public void testGetOverallResultOnLost() {
    System.out.println("getOverallResult");
    InputStream anyInputStream = new ByteArrayInputStream("1".getBytes());
    Config config = CommandLineParser.parseCommandlineArgs(new String[]{});
    ConsoleService console = new ConsoleService(config, anyInputStream, System.out::println);
    HumanPlayer humanPlayer = new HumanPlayer(console);
    Player computerPlayer = new ComputerPlayer();
    humanPlayer.setScore(4);
    computerPlayer.setScore(5);
    ResultService instance = new ResultService();
    Result expResult = Result.LOST;
    Result result = instance.getOverallResult(humanPlayer, computerPlayer);
    assertEquals(expResult, result);
  }

  /**
   * Test of getOverallResult method, of class ResultService.
   */
  @Test
  public void testGetOverallResultOnWon() {
    System.out.println("getOverallResult");
    InputStream anyInputStream = new ByteArrayInputStream("1".getBytes());
    Config config = CommandLineParser.parseCommandlineArgs(new String[]{});
    ConsoleService console = new ConsoleService(config, anyInputStream, System.out::println);
    HumanPlayer humanPlayer = new HumanPlayer(console);
    Player computerPlayer = new ComputerPlayer();
    humanPlayer.setScore(6);
    computerPlayer.setScore(5);
    ResultService instance = new ResultService();
    Result expResult = Result.WON;
    Result result = instance.getOverallResult(humanPlayer, computerPlayer);
    assertEquals(expResult, result);
  }
}
