import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import controller.ImageController;
import model.MockModel;
import view.ConsoleView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test class for the ImageController class.
 * It checks all the functionalities using a mock model.
 */
public class ImageControllerTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

  private final PrintStream originalOut = System.out;

  private final PrintStream originalErr = System.err;

  /**
   * Sets up a ConsoleView instance with specific input stream for testing.
   */
  @Before
  public void setUp() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  /**
   * Restore the original streams after tests.
   */
  @After
  public void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

  /**
   * Tests the red component method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerRedComponentMock() {
    String inputData = "red-component inputName outputName";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);
    ConsoleView view = new ConsoleView();
    MockModel model = new MockModel();
    ImageController controller = new ImageController(model, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = "red-component operation successful.";
    assertEquals(expectedOutput + System.lineSeparator(), outContent.toString());
    assertTrue(model.getLog().contains("Red Component method called."));
  }

  /**
   * Tests the blue component method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerBlueComponentMock() {
    String inputData = "blue-component inputName outputName";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);
    ConsoleView view = new ConsoleView();
    MockModel model = new MockModel();
    ImageController controller = new ImageController(model, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = "blue-component operation successful.";
    assertEquals(expectedOutput + System.lineSeparator(), outContent.toString());
    assertTrue(model.getLog().contains("Blue Component method called."));
  }

  /**
   * Tests the green component method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerGreenComponentMock() {
    String inputData = "green-component inputName outputName";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);
    ConsoleView view = new ConsoleView();
    MockModel model = new MockModel();
    ImageController controller = new ImageController(model, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = "green-component operation successful.";
    assertEquals(expectedOutput + System.lineSeparator(), outContent.toString());
    assertTrue(model.getLog().contains("Green Component method called."));
  }

  /**
   * Tests the value component method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerValueComponentMock() {
    String inputData = "value-component inputName outputName";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);
    ConsoleView view = new ConsoleView();
    MockModel model = new MockModel();
    ImageController controller = new ImageController(model, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = "value-component operation successful.";
    assertEquals(expectedOutput + System.lineSeparator(), outContent.toString());
    assertTrue(model.getLog().contains("Value Component method called."));
  }

  /**
   * Tests the luma component method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerLumaComponentMock() {
    String inputData = "luma-component inputName outputName";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);
    ConsoleView view = new ConsoleView();
    MockModel model = new MockModel();
    ImageController controller = new ImageController(model, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = "luma-component operation successful.";
    assertEquals(expectedOutput + System.lineSeparator(), outContent.toString());
    assertTrue(model.getLog().contains("Luma Component method called."));
  }

  /**
   * Tests the intensity component method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerIntensityComponentMock() {
    String inputData = "intensity-component inputName outputName";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);
    ConsoleView view = new ConsoleView();
    MockModel model = new MockModel();
    ImageController controller = new ImageController(model, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = "intensity-component operation successful.";
    assertEquals(expectedOutput + System.lineSeparator(), outContent.toString());
    assertTrue(model.getLog().contains("Intensity Component method called."));
  }

  /**
   * Tests the sepia component method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerSepiaComponentMock() {
    String inputData = "sepia inputName outputName";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);
    ConsoleView view = new ConsoleView();
    MockModel model = new MockModel();
    ImageController controller = new ImageController(model, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = "sepia operation successful.";
    assertEquals(expectedOutput + System.lineSeparator(), outContent.toString());
    assertTrue(model.getLog().contains("Sepia Component method called."));
  }

  /**
   * Tests the horizontal flip method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerHorizontalFlipMock() {
    String inputData = "horizontal-flip inputName outputName";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);
    ConsoleView view = new ConsoleView();
    MockModel model = new MockModel();
    ImageController controller = new ImageController(model, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = "horizontal-flip operation successful.";
    assertEquals(expectedOutput + System.lineSeparator(), outContent.toString());
    assertTrue(model.getLog().contains("Horizontal Flip method called."));
  }

  /**
   * Tests the vertical flip method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerVerticalFlipMock() {
    String inputData = "vertical-flip inputName outputName";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);
    ConsoleView view = new ConsoleView();
    MockModel model = new MockModel();
    ImageController controller = new ImageController(model, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = "vertical-flip operation successful.";
    assertEquals(expectedOutput + System.lineSeparator(), outContent.toString());
    assertTrue(model.getLog().contains("Vertical Flip method called."));
  }

  /**
   * Tests the Blur method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerBlurMethodMock() {
    String inputData = "blur inputName outputName";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);
    ConsoleView view = new ConsoleView();
    MockModel model = new MockModel();
    ImageController controller = new ImageController(model, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = "blur operation successful.";
    assertEquals(expectedOutput + System.lineSeparator(), outContent.toString());
    assertTrue(model.getLog().contains("Blur method called."));
  }

  /**
   * Tests the Sharpen method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerSharpenMethodMock() {
    String inputData = "sharpen inputName outputName";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);
    ConsoleView view = new ConsoleView();
    MockModel model = new MockModel();
    ImageController controller = new ImageController(model, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = "sharpen operation successful.";
    assertEquals(expectedOutput + System.lineSeparator(), outContent.toString());
    assertTrue(model.getLog().contains("Sharpen method called."));
  }

  /**
   * Tests the Brightening method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerBrightenMethodMock() {

    String inputData = "brighten 10 image-name dest-image-name";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);
    ConsoleView view = new ConsoleView();
    MockModel model = new MockModel();
    ImageController controller = new ImageController(model, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = "brighten operation successful.";
    assertEquals(expectedOutput + System.lineSeparator(), outContent.toString());
    assertTrue(model.getLog().contains("Brighten method called."));
  }

  /**
   * Tests the RGB Split method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerRGBSplitMethodMock() {
    String inputData = "rgb-split image-name dest-image-name-red " +
            "dest-image-name-green dest-image-name-blue";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);
    ConsoleView view = new ConsoleView();
    MockModel model = new MockModel();
    ImageController controller = new ImageController(model, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = "rgb-split operation successful.";
    assertEquals(expectedOutput + System.lineSeparator(), outContent.toString());
    assertTrue(model.getLog().contains("RGB Split method called."));
  }

  /**
   * Tests the RGB Combine method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerRGBCombineMethodMock() {
    String inputData = "rgb-combine image-name red-image green-image blue-image";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);
    ConsoleView view = new ConsoleView();
    MockModel model = new MockModel();
    ImageController controller = new ImageController(model, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = "rgb-combine operation successful.";
    assertEquals(expectedOutput + System.lineSeparator(), outContent.toString());
    assertTrue(model.getLog().contains("RGB Combine method called."));
  }

  /**
   * Tests the Histogram method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerHistogramMethodMock() {
    String inputData = "histogram image-name dest-image-name";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);
    ConsoleView view = new ConsoleView();
    MockModel model = new MockModel();
    ImageController controller = new ImageController(model, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = "histogram operation successful.";
    assertEquals(expectedOutput + System.lineSeparator(), outContent.toString());
    assertTrue(model.getLog().contains("Histogram method called."));
  }

  /**
   * Tests the Compress method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerCompressMethodMock() {
    String inputData = "compress 80 image-name dest-image-name";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);
    ConsoleView view = new ConsoleView();
    MockModel model = new MockModel();
    ImageController controller = new ImageController(model, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = "compress operation successful.";
    assertEquals(expectedOutput + System.lineSeparator(), outContent.toString());
    assertTrue(model.getLog().contains("Compress method called."));
  }

  /**
   * Tests the RGB Color Correct method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerColorCorrectMethodMock() {
    String inputData = "color-correct image-name dest-image-name";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);
    ConsoleView view = new ConsoleView();
    MockModel model = new MockModel();
    ImageController controller = new ImageController(model, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = "color-correct operation successful.";
    assertEquals(expectedOutput + System.lineSeparator(), outContent.toString());
    assertTrue(model.getLog().contains("Color Correct method called."));
  }

  /**
   * Tests the RGB Adjusts Level method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerAdjustLevelsMethodMock() {
    String inputData = "levels-adjust 20 100 250 image-name dest-image-name";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);
    ConsoleView view = new ConsoleView();
    MockModel model = new MockModel();
    ImageController controller = new ImageController(model, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = "levels-adjust operation successful.";
    assertEquals(expectedOutput + System.lineSeparator(), outContent.toString());
    assertTrue(model.getLog().contains("Adjust Levels method called."));
  }

  /**
   * Tests the Run Script method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testRunScript() throws IOException {
    File tempScript = File.createTempFile("tempScript", ".txt");
    tempScript.deleteOnExit();
    List<String> commands = Arrays.asList(
            "red-component inputName outputName",
            "blue-component inputName outputName",
            "green-component inputName outputName",
            "value-component inputName outputName",
            "luma-component inputName outputName",
            "intensity-component inputName outputName",
            "sepia inputName outputName",
            "horizontal-flip inputName outputName",
            "vertical-flip inputName outputName",
            "brighten 10 inputName outputName",
            "compress 10 inputName outputName",
            "color-correct inputName outputName",
            "levels-adjust 20 100 250 image-name dest-image-name",
            "blur inputName outputName",
            "sharpen inputName outputName",
            "rgb-split image-name dest-image-name-red " +
                    "dest-image-name-green dest-image-name-blue",
            "rgb-combine image-name red-image green-image blue-image"
    );
    Files.write(tempScript.toPath(), commands, Charset.defaultCharset());
    String inputData = "run " + tempScript.getAbsolutePath();
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);
    ConsoleView view = new ConsoleView();
    MockModel model = new MockModel();
    ImageController controller = new ImageController(model, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    assertTrue(model.getLog().contains("Red Component method called."));
    assertTrue(model.getLog().contains("Blue Component method called."));
    assertTrue(model.getLog().contains("Green Component method called."));
    assertTrue(model.getLog().contains("Value Component method called."));
    assertTrue(model.getLog().contains("Luma Component method called."));
    assertTrue(model.getLog().contains("Intensity Component method called."));
    assertTrue(model.getLog().contains("Sepia Component method called."));
    assertTrue(model.getLog().contains("Horizontal Flip method called."));
    assertTrue(model.getLog().contains("Vertical Flip method called."));
    assertTrue(model.getLog().contains("Brighten method called."));
    assertTrue(model.getLog().contains("Compress method called."));
    assertTrue(model.getLog().contains("Color Correct method called."));
    assertTrue(model.getLog().contains("Adjust Levels method called."));
    assertTrue(model.getLog().contains("Blur method called."));
    assertTrue(model.getLog().contains("Sharpen method called."));
    assertTrue(model.getLog().contains("RGB Split method called."));
    assertTrue(model.getLog().contains("RGB Combine method called."));
  }

  /**
   * Tests the Run Script method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testInvalidRunScript() throws IOException {
    File tempScript = File.createTempFile("tempScript", ".txt");
    tempScript.deleteOnExit();
    List<String> commands = Arrays.asList(
            "red-component inputName outputName",
            "blue-component inputName outputName",
            "green-component inputName outputName",
            "value-component inputName outputName",
            "luma-component inputName outputName",
            "intensity-component inputName outputName",
            "sepia inputName outputName",
            "horizontal-flip inputName outputName",
            "vertical-flip inputName outputName",
            "brighten 10 inputName outputName",
            "blur inputName outputName",
            "sharpen inputName outputName",
            "rgb-split image-name dest-image-name-red " +
                    "dest-image-name-green dest-image-name-blue",
            "rgb-combine image-name red-image green-image blue-image"
    );
    Files.write(tempScript.toPath(), commands, Charset.defaultCharset());
    String inputData = "run hello.txt";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);
    ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    PrintStream originalErr = System.err;
    System.setErr(new PrintStream(errContent));
    ConsoleView view = new ConsoleView();
    MockModel model = new MockModel();
    ImageController controller = new ImageController(model, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedError1 = "ERROR: Error running the script file.";

    String actualErrOutput = errContent.toString();
    assertTrue(actualErrOutput.contains(expectedError1));
    System.setErr(originalErr);
  }

  /**
   * Tests the incorrect command call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testIncorrectCommandMock() {
    String inputData = "hello inputName outputName";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);
    ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    PrintStream originalErr = System.err;
    System.setErr(new PrintStream(errContent));
    ConsoleView view = new ConsoleView();
    MockModel model = new MockModel();
    ImageController controller = new ImageController(model, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedError1 = "ERROR: Unknown command hello";
    String expectedError2 = "ERROR: hello operation failed.";

    String actualErrOutput = errContent.toString();
    assertTrue(actualErrOutput.contains(expectedError1));
    assertTrue(actualErrOutput.contains(expectedError2));
    System.setErr(originalErr);

  }

  /**
   * Tests the Load command call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testLoadCommand() {
    MockModel model = new MockModel();
    String inputData = "load res/images/film_original.jpg film_original";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);
    ConsoleView view = new ConsoleView();
    ImageController controller = new ImageController(model, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = "load operation successful.";
    assertEquals(expectedOutput + System.lineSeparator(), outContent.toString());
    assertTrue(model.getLog().contains("Add Image method called."));
  }

  /**
   * Tests the save command call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testSaveCommand() {
    MockModel model = new MockModel();
    String inputData = "save res/images/film_original_save.jpg film_original";
    ByteArrayInputStream inContent = new ByteArrayInputStream(inputData.getBytes());
    System.setIn(inContent);
    ConsoleView view = new ConsoleView();
    ImageController controller = new ImageController(model, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = "save operation successful.";
    assertEquals(expectedOutput + System.lineSeparator(), outContent.toString());
    assertTrue(model.getLog().contains("Get Image method called."));
  }
}