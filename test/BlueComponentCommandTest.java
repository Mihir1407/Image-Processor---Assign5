import org.junit.Test;

import controller.commands.BlueComponentCommand;
import model.image.Image;
import model.mockModel;

import static org.junit.Assert.*;

public class BlueComponentCommandTest {

  @Test
  public void testBlueComponentCommand() {
    mockModel model = new mockModel();

    BlueComponentCommand cmd = new BlueComponentCommand("source", "dest", model);
    boolean commandSuccessful = cmd.execute();

    assertTrue(commandSuccessful);

    String result = mockModel.getLog();
    assertEquals("Blue Component method called.", result);
  }
}