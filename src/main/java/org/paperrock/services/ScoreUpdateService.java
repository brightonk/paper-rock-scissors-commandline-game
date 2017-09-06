package org.paperrock.services;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.paperrock.model.Player;
import org.paperrock.model.Result;

/**
 *
 * @author Brighton Kukasira <brighton.kukasira@gmail.com>
 */
public class ScoreUpdateService {

  private static final Logger LOGGER
          = Logger.getLogger(ScoreUpdateService.class.getName());

  public void updateScore(final Result result, final Player humanPlayer,
          final Player computerPlayer) {
    if (result == null) {
      return;
    }
    switch (result) {
      case DRAW:
        break;
      case LOST:
        computerPlayer.incrementScore();
        break;
      case WON:
        humanPlayer.incrementScore();
        break;
      default:
        LOGGER.log(Level.WARNING, "Unsupported result. Found {0}", result);
    }
  }
}
