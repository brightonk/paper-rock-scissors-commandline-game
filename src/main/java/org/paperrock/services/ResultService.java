package org.paperrock.services;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.paperrock.model.Player;
import org.paperrock.model.Result;
import static org.paperrock.model.Selection.PAPER;
import static org.paperrock.model.Selection.ROCK;
import static org.paperrock.model.Selection.SCISSORS;

/**
 *
 * @author Brighton Kukasira <brighton.kukasira@gmail.com>
 */
public class ResultService {

  private static final Logger LOGGER = Logger.getLogger(ResultService.class.getName());

  public Result getResult(final Player humanPlayer, final Player computerPlayer) {
    if (computerPlayer.getSelection() == humanPlayer.getSelection()) {
      return Result.DRAW;
    }
    Result result = null;
    switch (computerPlayer.getSelection()) {
      case PAPER:
        result = humanPlayer.getSelection() == SCISSORS ? Result.WON : Result.LOST;
        break;
      case ROCK:
        result = humanPlayer.getSelection() == PAPER ? Result.WON : Result.LOST;
        break;
      case SCISSORS:
        result = humanPlayer.getSelection() == ROCK ? Result.WON : Result.LOST;
        break;
      default:
        LOGGER.log(Level.WARNING, "Unsupported computer selection. Found {0}",
                computerPlayer.getSelection());
    }
    return result;
  }

  public String getResultMessage(final Result result) {
    String message = null;
    switch (result) {
      case DRAW:
        message = "It's a " + result;
        break;
      case LOST:
        message = "You " + result;
        break;
      case WON:
        message = "You " + result;
        break;
      default:
        LOGGER.log(Level.WARNING, "Unsupported result. Found {0}", result);
    }
    return message;
  }

  public Result getOverallResult(final Player humanPlayer, final Player computerPlayer) {
    if (humanPlayer == null) {
      return null;
    }
    if (computerPlayer == null) {
      return null;
    }
    if (humanPlayer.getScore() == computerPlayer.getScore()) {
      return Result.DRAW;
    }
    if (humanPlayer.getScore() > computerPlayer.getScore()) {
      return Result.WON;
    }
    if (humanPlayer.getScore() < computerPlayer.getScore()) {
      return Result.LOST;
    }
    return null;
  }
}
