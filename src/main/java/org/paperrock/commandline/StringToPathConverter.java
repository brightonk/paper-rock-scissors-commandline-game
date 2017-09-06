package org.paperrock.commandline;

import com.beust.jcommander.IStringConverter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

/**
 *
 * @author Brighton Kukasira <brighton.kukasira@gmail.com>
 */
public class StringToPathConverter implements IStringConverter<Path> {

  private static final Logger LOGGER = Logger.getLogger(StringToPathConverter.class.getName());

  @Override
  public Path convert(String value) {
    return Paths.get(value);
  }
}
