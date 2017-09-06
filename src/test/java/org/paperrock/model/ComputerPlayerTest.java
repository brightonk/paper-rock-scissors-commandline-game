package org.paperrock.model;

import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Brighton Kukasira <brighton.kukasira@gmail.com>
 */
public class ComputerPlayerTest {

  public ComputerPlayerTest() {
  }

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  /**
   * Test of makeSelection method, of class ComputerPlayer.
   */
  @Test
  public void testMakeSelection() {
    System.out.println("makeSelection");
    AtomicBoolean quit = new AtomicBoolean();
    ComputerPlayer instance = new ComputerPlayer();
    instance.makeSelection(quit);
    assertNotNull(instance.getSelection());
    assertEquals(false, quit.get());
  }

}
