package org.paperrock.model;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.paperrock.services.ConsoleService;

/**
 *
 * @author Brighton Kukasira <brighton.kukasira@gmail.com>
 */
public class HumanPlayer extends Player {

  /**
   * Provides a way for the player object to display a menu without knowing the
   * details about the menu.
   */
  private final ConsoleService console;

  public HumanPlayer(ConsoleService console) {
    this.console = console;
  }

  /**
   * Provides a way for the player to make a selection. Player is able to select
   * quit option.
   *
   * @param quit
   * @throws java.io.IOException
   */
  @Override
  public void makeSelection(final AtomicBoolean quit) throws IOException {
    setSelection(console.getInput(quit));
  }
}
