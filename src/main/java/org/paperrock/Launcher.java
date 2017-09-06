package org.paperrock;

import java.io.IOException;
import java.util.logging.Logger;
import static org.paperrock.commandline.CommandLineParser.parseCommandlineArgs;
import org.paperrock.commandline.Config;

/**
 *
 * @author Brighton Kukasira <brighton.kukasira@gmail.com>
 */
public class Launcher {

  private static final Logger LOGGER = Logger.getLogger(Launcher.class.getName());

  /**
   * @param args the command line arguments
   * @throws java.io.IOException
   */
  public static void main(String[] args) throws IOException {
    Launcher app = null;
    try {
      app = new Launcher(parseCommandlineArgs(args));
      app.init();
      app.run();
    } finally {
      if (app != null) {
        app.stop();
      }
    }
  }
  private final Game game;

  private Launcher(Config config) {
    this.game = new Game(config);
  }

  /**
   * Initialize and load resources required by the system.
   */
  private void init() {
    //  initialize any resources
  }

  /**
   * Starting point of running the application.
   */
  private void run() throws IOException {
    game.play();
  }

  /**
   * Used to perform final steps before the application shuts down.
   */
  private void stop() {
    // cleanup or release resources
  }
}
