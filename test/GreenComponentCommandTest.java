import org.junit.Test;

import controller.commands.GreenComponentCommand;
import model.image.Image;
import model.mockModel;

import static org.junit.Assert.*;

public class GreenComponentCommandTest {

  @Test
  public void testGreenComponentCommand() {
    mockModel model = new mockModel();

    GreenComponentCommand cmd = new GreenComponentCommand("source", "dest", model);
    boolean commandSuccessful = cmd.execute();

    assertTrue(commandSuccessful);

    String result = mockModel.getLog();
    assertEquals("Green Component method called.", result);
  }
}