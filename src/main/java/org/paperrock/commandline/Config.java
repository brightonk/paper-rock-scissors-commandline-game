package org.paperrock.commandline;

import com.beust.jcommander.Parameter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

/**
 *
 * @author Brighton Kukasira <brighton.kukasira@gmail.com>
 */
public class Config {

  private static final String DEFAULT_GOODBYE_FILENAME = "goodbye.txt";
  private static final String DEFAULT_MAIN_MENU_FILENAME = "main-menu.txt";
  private static final String DEFAULT_SELECTION_MENU_FILENAME = "selection-menu.txt";
  private static final String DEFAULT_WELCOME_FILENAME = "welcome.txt";
  private static final Logger LOGGER = Logger.getLogger(Config.class.getName());

  @Parameter(names = "-debug", description = "Debug mode")
  private boolean debug = false;

  @Parameter(names = {"-g", "--goodbye-file"}, required = false,
          validateWith = NonEmptyStringParameterValidator.class,
          converter = StringToPathConverter.class,
          validateValueWith = FileExistsValueValidator.class,
          description = "Path to the file containing the goodbye text")
  private Path goodbyePath = Paths.get(DEFAULT_GOODBYE_FILENAME);

  @Parameter(names = {"-m", "--menu-file"}, required = false,
          validateWith = NonEmptyStringParameterValidator.class,
          converter = StringToPathConverter.class,
          validateValueWith = FileExistsValueValidator.class,
          description = "Path to the file containing the menu text")
  private Path menuPath = Paths.get(DEFAULT_MAIN_MENU_FILENAME);

  @Parameter(names = {"-s", "--selection-menu-file"},
          required = false, validateWith = NonEmptyStringParameterValidator.class,
          converter = StringToPathConverter.class,
          validateValueWith = FileExistsValueValidator.class,
          description = "Path to the file containing the selection menu text")
  private Path selectionMenuPath = Paths.get(DEFAULT_SELECTION_MENU_FILENAME);

  @Parameter(names = {"-log", "-verbose"}, description = "Level of verbosity")
  private Integer verbose = 1;

  @Parameter(names = {"-w", "--welcome-file"}, required = false,
          validateWith = NonEmptyStringParameterValidator.class,
          converter = StringToPathConverter.class,
          validateValueWith = FileExistsValueValidator.class,
          description = "Path to the file containing the welcome text")
  private Path welcomePath = Paths.get(DEFAULT_WELCOME_FILENAME);

  public Path getGoodbyePath() {
    return goodbyePath;
  }

  public Path getMenuPath() {
    return menuPath;
  }

  public Path getSelectionMenuPath() {
    return selectionMenuPath;
  }

  public Path getWelcomePath() {
    return welcomePath;
  }
}
