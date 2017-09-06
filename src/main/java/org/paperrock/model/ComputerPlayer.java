package org.paperrock.model;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author Brighton Kukasira <brighton.kukasira@gmail.com>
 */
public class ComputerPlayer extends Player {

  /**
   * Provides a way for the computer player to make random selections.
   */
  public static final Random RANDOM_GENERATOR = new Random();

  /**
   * Provides a way for the player to make a selection. Player is able to select
   * quit option.
   *
   * @param quit
   */
  @Override
  public void makeSelection(final AtomicBoolean quit) {
    setSelection(getRandomSelection());
  }

  /**
   * A function to randomly select one of the items in a given list.
   *
   * @return
   */
  private Selection getRandomSelection() {
    final int index = RANDOM_GENERATOR.nextInt(Selection.values().length);
    return Selection.values()[index];
  }
}
