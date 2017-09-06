package org.paperrock.commandline;

import com.beust.jcommander.ParameterException;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Brighton Kukasira <brighton.kukasira@gmail.com>
 */
public class NonEmptyStringParameterValidatorTest {

  private static final Logger LOG = Logger.getLogger(NonEmptyStringParameterValidatorTest.class.getName());

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  public NonEmptyStringParameterValidatorTest() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  /**
   * Test of validate method, of class NonEmptyStringParameterValidator.
   */
  @Test
  public void testValidate() {
    System.out.println("validate");
    String name = "testKey";
    String value = "testValue";
    NonEmptyStringParameterValidator instance = new NonEmptyStringParameterValidator();
    instance.validate(name, value);
  }

  /**
   * Test of validate method, of class NonEmptyStringParameterValidator.
   */
  @Test(expected = ParameterException.class)
  public void testValidateNullValue() {
    System.out.println("validate");
    String name = "testKey";
    String value = null;
    NonEmptyStringParameterValidator instance = new NonEmptyStringParameterValidator();
    instance.validate(name, value);
  }
}
