package org.paperrock.commandline;

import com.beust.jcommander.IValueValidator;
import com.beust.jcommander.ParameterException;
import java.nio.file.Path;
import java.util.logging.Logger;

/**
 *
 * @author Brighton Kukasira <brighton.kukasira@gmail.com>
 */
public class FileExistsValueValidator implements IValueValidator<Path> {

  private static final Logger LOGGER
          = Logger.getLogger(FileExistsValueValidator.class.getName());

  @Override
  public void validate(String name, Path value) throws ParameterException {
    if (!value.toFile().exists()) {
      throw new ParameterException(name + " file does not exist. "
              + value.toAbsolutePath());
    }
    if (!value.toFile().isFile()) {
      throw new ParameterException(name + " is not file. "
              + value.toAbsolutePath());
    }
  }
}
