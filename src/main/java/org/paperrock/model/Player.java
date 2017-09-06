package org.paperrock.model;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author Brighton Kukasira <brighton.kukasira@gmail.com>
 */
public abstract class Player {

  /**
   * stores the player's store for all games played.
   */
  private int score;
  /**
   * store the last selection made by the player.
   */
  private Selection selection;

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public Selection getSelection() {
    return selection;
  }

  public void setSelection(Selection selection) {
    this.selection = selection;
  }

  public void incrementScore() {
    this.score++;
  }

  public void resetScore() {
    this.score = 0;
  }

  /**
   * Provides a way for the player to make a selection. Player is able to select
   * quit option.
   *
   * @param quit
   * @throws java.io.IOException
   */
  public abstract void makeSelection(final AtomicBoolean quit) throws IOException;
}
