package org.paperrock;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.paperrock.commandline.Config;
import org.paperrock.model.ComputerPlayer;
import org.paperrock.model.HumanPlayer;
import org.paperrock.model.Result;
import org.paperrock.services.ConsoleService;
import org.paperrock.services.ResultService;
import org.paperrock.services.ScoreUpdateService;

/**
 *
 * @author Brighton Kukasira <brighton.kukasira@gmail.com>
 */
public class Game {

  private final ComputerPlayer computerPlayer;
  private final ConsoleService console;
  private final HumanPlayer humanPlayer;
  private final AtomicBoolean quit;
  private final ResultService resultService;
  private final ScoreUpdateService scoreService;

  public Game(Config config) {
    this.quit = new AtomicBoolean(false);
    this.console = new ConsoleService(config, System.in, System.out::println);
    this.resultService = new ResultService();
    this.scoreService = new ScoreUpdateService();
    this.computerPlayer = new ComputerPlayer();
    this.humanPlayer = new HumanPlayer(console);
  }

  public void play() throws IOException {
    console.displayWelcomeMessage();
    repeatedExecution();
    console.displayGoodByeMesasge();
  }

  public void repeatedExecution() throws IOException {
    if (quit.get()) {
      return;
    }
    final int choice = console.getMainMenuChoice(quit);
    int remainingCycles = choice;
    while (remainingCycles > 0) {
      computerPlayer.makeSelection(quit);
      humanPlayer.makeSelection(quit);
      if (quit.get()) {
        break;
      }
      Result result = resultService.getResult(humanPlayer, computerPlayer);
      scoreService.updateScore(result, humanPlayer, computerPlayer);
      console.displayselections(humanPlayer, computerPlayer);
      console.displayResult(resultService.getResultMessage(result));
      console.displayScores(humanPlayer, computerPlayer);
      remainingCycles--;
    }
    Result result = resultService.getOverallResult(humanPlayer, computerPlayer);
    String message = resultService.getResultMessage(result);
    console.displayOverallResult(message);
    computerPlayer.resetScore();
    humanPlayer.resetScore();
    repeatedExecution();
  }
}
