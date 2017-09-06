package org.paperrock.commandline;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;
import java.util.logging.Logger;

/**
 *
 * @author Brighton Kukasira <brighton.kukasira@gmail.com>
 */
public class NonEmptyStringParameterValidator implements IParameterValidator {

  private static final Logger LOGGER = Logger.getLogger(NonEmptyStringParameterValidator.class.getName());

  @Override
  public void validate(String name, String value) throws ParameterException {
    if (value == null) {
      throw new ParameterException(name + " is not set.");
    }
    if (value.trim().isEmpty()) {
      throw new ParameterException(name + " is not set.");
    }
  }
}
