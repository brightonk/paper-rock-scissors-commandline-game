package org.paperrock.commandline;

import com.beust.jcommander.JCommander;

/**
 *
 * @author Brighton Kukasira <brighton.kukasira@gmail.com>
 */
public interface CommandLineParser {

  public static Config parseCommandlineArgs(String[] args) {
    Config config = new Config();
    new JCommander(config).parse(args);
    return config;
  }
}
