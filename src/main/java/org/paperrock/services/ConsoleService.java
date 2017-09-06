package org.paperrock.services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.stream.Stream;
import org.paperrock.commandline.Config;
import org.paperrock.model.Player;
import org.paperrock.model.Selection;

/**
 *
 * @author Brighton Kukasira <brighton.kukasira@gmail.com>
 */
public class ConsoleService {

  private final Config config;
  private final Consumer<? super String> printStream;
  private final InputStream source;

  public ConsoleService(Config config, InputStream source, Consumer<? super String> printStream) {
    this.config = config;
    this.printStream = printStream;
    this.source = source;
  }

  public void displayGoodByeMesasge() throws IOException {
    try (Stream<String> text = Files.lines(config.getGoodbyePath())) {
      // used system out instead of logger for better display on console
      text.forEach(printStream);
    }
  }

  public void displayMainMenu() throws IOException {
    try (Stream<String> text = Files.lines(config.getMenuPath())) {
      // used system out instead of logger for better display on console
      text.forEach(printStream);
    }
  }

  public void displayResult(String message) {
    if (message == null) {
      return;
    }
    print(message);
  }

  public void displayScores(final Player humanPlayer, final Player computerPlayer) {
    if (humanPlayer == null) {
      return;
    }
    if (computerPlayer == null) {
      return;
    }
    print("\nYour Score " + humanPlayer.getScore() + " - "
            + computerPlayer.getScore() + " Computer Score");
  }

  public void displayOverallResult(String message) {
    if (message == null) {
      return;
    }
    print("Round Ended. " + message);
    print(":::::::::::::::::::::::::::::::::::");
  }

  public int getMainMenuChoice(final AtomicBoolean quit) throws IOException {
    displayMainMenu();
    Scanner reader = new Scanner(source);
    int choice = reader.nextInt();
    if (choice == 0) {
      quit.set(true);
    }
    if (choice < 0 || 10 < choice) {
      displayTryAgainMessage();
      return getMainMenuChoice(quit);
    }
    return choice;
  }

  /**
   * Presents the player with a menu and asks player choose rock, paper or
   * scissors.
   *
   * @param quit
   * @return
   * @throws java.io.IOException
   */
  public Selection getInput(AtomicBoolean quit) throws IOException {
    displaySelectionMenu();
    Scanner reader = new Scanner(source);
    int choice = reader.nextInt();
    Selection selection = null;
    switch (choice) {
      case 0:
        quit.set(true);
        break;
      case 1:
        selection = Selection.PAPER;
        break;
      case 2:
        selection = Selection.ROCK;
        break;
      case 3:
        selection = Selection.SCISSORS;
        break;
      default:
        displayTryAgainMessage();
        return getInput(quit);
    }
    return selection;
  }

  public void displaySelectionMenu() throws IOException {
    try (Stream<String> text = Files.lines(config.getSelectionMenuPath())) {
      text.forEach(printStream);
    }
  }

  public void displayWelcomeMessage() throws IOException {
    try (Stream<String> text = Files.lines(config.getWelcomePath())) {
      text.forEach(printStream);
    }
  }

  public void displayselections(final Player humanPlayer, final Player computerPlayer) {
    print("Your Selection " + humanPlayer.getSelection()
            + " - " + computerPlayer.getSelection() + " Computer Selection");
  }

  private void print(String message) {
    // used system out instead of logger for better display on console
    printStream.accept(message);
  }

  public void displayTryAgainMessage() {
    print("Try again.");
  }
}
