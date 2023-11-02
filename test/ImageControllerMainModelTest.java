import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import controller.ImageController;
import model.ImageModel;
import model.image.Image;
import model.image.Pixel;
import view.ConsoleView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test class for the ImageController class.
 * It checks all the functionalities using the main model.
 */
public class ImageControllerMainModelTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final InputStream originalIn = System.in;
  private ImageModel imageModel;

  /**
   * Sets up the imageModel instance with specific output stream for testing.
   */
  @Before
  public void setUp() {
    System.setOut(new PrintStream(outContent));
    imageModel = new ImageModel();
  }

  /**
   * Restore the original streams after tests.
   */
  @After
  public void tearDown() {
    System.setOut(originalOut);
    System.setIn(originalIn);
  }

  /**
   * Tests the red component method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerRedComponentMainModel() throws IOException {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String allInputData = String.join(System.lineSeparator(),
            "load res/controllerTest/main_model_test_img.jpg main_model_test_img",
            "red-component main_model_test_img main_model_test_img_red",
            "save res/controllerTest/main_model_test_img_red.jpg main_model_test_img_red"
    );
    System.setIn(new ByteArrayInputStream(allInputData.getBytes()));
    ConsoleView view = new ConsoleView();
    ImageController controller = new ImageController(imageModel, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = String.join(System.lineSeparator(),
            "load operation successful.",
            "red-component operation successful.",
            "save operation successful.", "");
    assertEquals(expectedOutput, outContent.toString());
    Image redImage = imageModel.getImage("main_model_test_img_red");
    for (int y = 0; y < redImage.getHeight(); y++) {
      for (int x = 0; x < redImage.getWidth(); x++) {
        Pixel redPixel = redImage.getPixel(x, y);
        int expectedRedValue = redPixel.getRed();
        assertEquals(expectedRedValue, redPixel.getRed());
        assertEquals(0, redPixel.getGreen());
        assertEquals(0, redPixel.getBlue());
      }
    }
    System.setOut(System.out);
    System.setIn(System.in);
  }

  /**
   * Tests the red component method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerRedComponentMainModelPPM() throws IOException {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String allInputData = String.join(System.lineSeparator(),
            "load res/controllerTest/main_model_test_img_ppm.ppm main_model_test_img_ppm",
            "red-component main_model_test_img_ppm main_model_test_img_red_ppm",
            "save res/controllerTest/main_model_test_img_red_ppm.ppm main_model_test_img_red_ppm"
    );
    System.setIn(new ByteArrayInputStream(allInputData.getBytes()));
    ConsoleView view = new ConsoleView();
    ImageController controller = new ImageController(imageModel, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = String.join(System.lineSeparator(),
            "load operation successful.",
            "red-component operation successful.",
            "save operation successful.", "");
    assertEquals(expectedOutput, outContent.toString());
    Image redImage = imageModel.getImage("main_model_test_img_red_ppm");
    for (int y = 0; y < redImage.getHeight(); y++) {
      for (int x = 0; x < redImage.getWidth(); x++) {
        Pixel redPixel = redImage.getPixel(x, y);
        int expectedRedValue = redPixel.getRed();
        assertEquals(expectedRedValue, redPixel.getRed());
        assertEquals(0, redPixel.getGreen());
        assertEquals(0, redPixel.getBlue());
      }
    }
    System.setOut(System.out);
    System.setIn(System.in);
  }

  /**
   * Tests the blue component method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerBlueComponentMainModel() throws IOException {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String allInputData = String.join(System.lineSeparator(),
            "load res/controllerTest/main_model_test_img.jpg main_model_test_img",
            "blue-component main_model_test_img main_model_test_img_blue",
            "save res/controllerTest/main_model_test_img_blue.jpg main_model_test_img_blue"
    );
    System.setIn(new ByteArrayInputStream(allInputData.getBytes()));
    ConsoleView view = new ConsoleView();
    ImageController controller = new ImageController(imageModel, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = String.join(System.lineSeparator(),
            "load operation successful.",
            "blue-component operation successful.",
            "save operation successful.", "");
    assertEquals(expectedOutput, outContent.toString());
    Image blueImage = imageModel.getImage("main_model_test_img_blue");
    for (int y = 0; y < blueImage.getHeight(); y++) {
      for (int x = 0; x < blueImage.getWidth(); x++) {
        Pixel bluePixel = blueImage.getPixel(x, y);
        assertEquals(0, bluePixel.getRed());
        assertEquals(0, bluePixel.getGreen());
        int expectedBlueValue = bluePixel.getBlue();
        assertEquals(expectedBlueValue, bluePixel.getBlue());
      }
    }
    System.setOut(System.out);
    System.setIn(System.in);
  }

  /**
   * Tests the green component method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerGreenComponentMainModel() throws IOException {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String allInputData = String.join(System.lineSeparator(),
            "load res/controllerTest/main_model_test_img.jpg main_model_test_img",
            "green-component main_model_test_img main_model_test_img_green",
            "save res/controllerTest/main_model_test_img_green.jpg main_model_test_img_green"
    );
    System.setIn(new ByteArrayInputStream(allInputData.getBytes()));
    ConsoleView view = new ConsoleView();
    ImageController controller = new ImageController(imageModel, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = String.join(System.lineSeparator(),
            "load operation successful.",
            "green-component operation successful.",
            "save operation successful.", "");
    assertEquals(expectedOutput, outContent.toString());
    Image greenImage = imageModel.getImage("main_model_test_img_green");
    for (int y = 0; y < greenImage.getHeight(); y++) {
      for (int x = 0; x < greenImage.getWidth(); x++) {
        Pixel greenPixel = greenImage.getPixel(x, y);
        assertEquals(0, greenPixel.getRed());
        int expectedGreenValue = greenPixel.getGreen();
        assertEquals(expectedGreenValue, greenPixel.getGreen());
        assertEquals(0, greenPixel.getBlue());
      }
    }
    System.setOut(System.out);
    System.setIn(System.in);
  }

  /**
   * Tests the value component method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerValueComponentMainModel() throws IOException {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String allInputData = String.join(System.lineSeparator(),
            "load res/controllerTest/main_model_test_img.jpg main_model_test_img",
            "value-component main_model_test_img main_model_test_img_value",
            "save res/controllerTest/main_model_test_img_value.jpg main_model_test_img_value"
    );
    System.setIn(new ByteArrayInputStream(allInputData.getBytes()));
    ConsoleView view = new ConsoleView();
    ImageController controller = new ImageController(imageModel, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = String.join(System.lineSeparator(),
            "load operation successful.",
            "value-component operation successful.",
            "save operation successful.", "");
    assertEquals(expectedOutput, outContent.toString());
    Image valueImage = imageModel.getImage("main_model_test_img_value");
    for (int y = 0; y < valueImage.getHeight(); y++) {
      for (int x = 0; x < valueImage.getWidth(); x++) {
        Pixel valuePixel = valueImage.getPixel(x, y);
        int expectedValue = Math.max(Math.max(valuePixel.getRed(),
                valuePixel.getGreen()), valuePixel.getBlue());
        assertEquals(expectedValue, valuePixel.getRed());
        assertEquals(expectedValue, valuePixel.getGreen());
        assertEquals(expectedValue, valuePixel.getBlue());
      }
    }
    System.setOut(System.out);
    System.setIn(System.in);
  }

  /**
   * Tests the luma component method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerLumaComponentMainModel() throws IOException {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String allInputData = String.join(System.lineSeparator(),
            "load res/controllerTest/main_model_test_img.jpg main_model_test_img",
            "luma-component main_model_test_img main_model_test_img_luma",
            "save res/controllerTest/main_model_test_img_luma.jpg main_model_test_img_luma"
    );
    System.setIn(new ByteArrayInputStream(allInputData.getBytes()));
    ConsoleView view = new ConsoleView();
    ImageController controller = new ImageController(imageModel, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = String.join(System.lineSeparator(),
            "load operation successful.",
            "luma-component operation successful.",
            "save operation successful.", "");
    assertEquals(expectedOutput, outContent.toString());
    Image lumaImage = imageModel.getImage("main_model_test_img_luma");
    for (int y = 0; y < lumaImage.getHeight(); y++) {
      for (int x = 0; x < lumaImage.getWidth(); x++) {
        Pixel lumaPixel = lumaImage.getPixel(x, y);
        double lumaValue = 0.2126 * lumaPixel.getRed()
                + 0.7152 * lumaPixel.getGreen() + 0.0722 * lumaPixel.getBlue();
        int roundedLumaValue = (int) Math.round(lumaValue);
        assertEquals(roundedLumaValue, lumaPixel.getRed());
        assertEquals(roundedLumaValue, lumaPixel.getGreen());
        assertEquals(roundedLumaValue, lumaPixel.getBlue());
      }
    }
    System.setOut(System.out);
    System.setIn(System.in);
  }

  /**
   * Tests the intensity component method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerIntensityComponentMainModel() throws IOException {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String allInputData = String.join(System.lineSeparator(),
            "load res/controllerTest/main_model_test_img.jpg main_model_test_img",
            "intensity-component main_model_test_img main_model_test_img_intensity",
            "save res/controllerTest/main_model_test_img_intensity.jpg "
                    + "main_model_test_img_intensity"
    );
    System.setIn(new ByteArrayInputStream(allInputData.getBytes()));
    ConsoleView view = new ConsoleView();
    ImageController controller = new ImageController(imageModel, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = String.join(System.lineSeparator(),
            "load operation successful.",
            "intensity-component operation successful.",
            "save operation successful.", "");
    assertEquals(expectedOutput, outContent.toString());
    Image intensityImage = imageModel.getImage("main_model_test_img_intensity");
    for (int y = 0; y < intensityImage.getHeight(); y++) {
      for (int x = 0; x < intensityImage.getWidth(); x++) {
        Pixel intensityPixel = intensityImage.getPixel(x, y);
        int expectedIntensity = (intensityPixel.getRed() + intensityPixel.getGreen()
                + intensityPixel.getBlue()) / 3;
        assertEquals(expectedIntensity, intensityPixel.getRed());
        assertEquals(expectedIntensity, intensityPixel.getGreen());
        assertEquals(expectedIntensity, intensityPixel.getBlue());
      }
    }
    System.setOut(System.out);
    System.setIn(System.in);
  }

  /**
   * Tests the sepia component method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerSepiaComponentMainModel() throws IOException {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String allInputData = String.join(System.lineSeparator(),
            "load res/controllerTest/main_model_test_img.jpg main_model_test_img",
            "sepia main_model_test_img main_model_test_img_sepia",
            "save res/controllerTest/main_model_test_img_sepia.jpg main_model_test_img_sepia"
    );
    System.setIn(new ByteArrayInputStream(allInputData.getBytes()));
    ConsoleView view = new ConsoleView();
    ImageController controller = new ImageController(imageModel, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = String.join(System.lineSeparator(),
            "load operation successful.",
            "sepia operation successful.",
            "save operation successful.", "");
    assertEquals(expectedOutput, outContent.toString());
    Image originalImage = imageModel.getImage("main_model_test_img");
    Image sepiaImage = imageModel.getImage("main_model_test_img_sepia");
    for (int y = 0; y < sepiaImage.getHeight(); y++) {
      for (int x = 0; x < sepiaImage.getWidth(); x++) {
        Pixel sepiaPixel = sepiaImage.getPixel(x, y);
        Pixel originalPixel = originalImage.getPixel(x, y);
        int originalRed = originalPixel.getRed();
        int originalGreen = originalPixel.getGreen();
        int originalBlue = originalPixel.getBlue();
        int newRed = Math.min(255, (int) (0.393 * originalRed
                + 0.769 * originalGreen + 0.189 * originalBlue));
        int newGreen = Math.min(255, (int) (0.349 * originalRed
                + 0.686 * originalGreen + 0.168 * originalBlue));
        int newBlue = Math.min(255, (int) (0.272 * originalRed
                + 0.534 * originalGreen + 0.131 * originalBlue));
        assertEquals(newRed, sepiaPixel.getRed());
        assertEquals(newGreen, sepiaPixel.getGreen());
        assertEquals(newBlue, sepiaPixel.getBlue());
      }
    }
    System.setOut(System.out);
    System.setIn(System.in);
  }

  /**
   * Tests the horizontal flip method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerHorizontalFlipMainModel() throws IOException {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String allInputData = String.join(System.lineSeparator(),
            "load res/controllerTest/main_model_test_img.jpg main_model_test_img",
            "horizontal-flip main_model_test_img main_model_test_img_horizontal_flip",
            "save res/controllerTest/main_model_test_img_horizontal_flip.jpg "
                    + "main_model_test_img_horizontal_flip"
    );
    System.setIn(new ByteArrayInputStream(allInputData.getBytes()));
    ConsoleView view = new ConsoleView();
    ImageController controller = new ImageController(imageModel, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = String.join(System.lineSeparator(),
            "load operation successful.",
            "horizontal-flip operation successful.",
            "save operation successful.",
            "");
    assertEquals(expectedOutput, outContent.toString());
    Image originalImage = imageModel.getImage("main_model_test_img");
    Image flippedImage = imageModel.getImage("main_model_test_img_horizontal_flip");
    int width = originalImage.getWidth();
    for (int y = 0; y < originalImage.getHeight(); y++) {
      for (int x = 0; x < width; x++) {
        Pixel originalPixel = originalImage.getPixel(x, y);
        Pixel flippedPixel = flippedImage.getPixel(width - 1 - x, y);
        assertTrue(originalPixel.equals(flippedPixel));
      }
    }
    System.setOut(System.out);
    System.setIn(System.in);
  }

  /**
   * Tests the vertical flip method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerVerticalFlipMainModel() throws IOException {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String allInputData = String.join(System.lineSeparator(),
            "load res/controllerTest/main_model_test_img.jpg main_model_test_img",
            "vertical-flip main_model_test_img main_model_test_img_vertical_flip",
            "save res/controllerTest/main_model_test_img_vertical_flip.jpg "
                    + "main_model_test_img_vertical_flip"
    );
    System.setIn(new ByteArrayInputStream(allInputData.getBytes()));
    ConsoleView view = new ConsoleView();
    ImageController controller = new ImageController(imageModel, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = String.join(System.lineSeparator(),
            "load operation successful.",
            "vertical-flip operation successful.",
            "save operation successful.",
            "");
    assertEquals(expectedOutput, outContent.toString());
    Image originalImage = imageModel.getImage("main_model_test_img");
    Image flippedImage = imageModel.getImage("main_model_test_img_vertical_flip");
    int height = originalImage.getHeight();
    for (int y = 0; y < originalImage.getHeight(); y++) {
      for (int x = 0; x < height; x++) {
        Pixel originalPixel = originalImage.getPixel(x, y);
        Pixel flippedPixel = flippedImage.getPixel(x, height - 1 - y);
        assertTrue(originalPixel.equals(flippedPixel));
      }
    }
    System.setOut(System.out);
    System.setIn(System.in);
  }

  /**
   * Tests the Brightening method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerBrightenMainModel1() throws IOException {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String allInputData = String.join(System.lineSeparator(),
            "load res/controllerTest/main_model_test_img.jpg main_model_test_img",
            "brighten 50 main_model_test_img main_model_test_img_brightened",
            "save res/controllerTest/main_model_test_img_brightened.jpg "
                    + "main_model_test_img_brightened"
    );
    System.setIn(new ByteArrayInputStream(allInputData.getBytes()));
    ConsoleView view = new ConsoleView();
    ImageController controller = new ImageController(imageModel, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = String.join(System.lineSeparator(),
            "load operation successful.",
            "brighten operation successful.",
            "save operation successful.",
            "");
    assertEquals(expectedOutput.trim(), outContent.toString().trim());

    int increment = 50;
    Image originalImage = imageModel.getImage("main_model_test_img");
    Image brightenedImage = imageModel.getImage("main_model_test_img_brightened");

    for (int y = 0; y < originalImage.getHeight(); y++) {
      for (int x = 0; x < originalImage.getWidth(); x++) {
        Pixel originalPixel = originalImage.getPixel(x, y);
        int expectedRed = Math.min(255, originalPixel.getRed() + increment);
        int expectedGreen = Math.min(255, originalPixel.getGreen() + increment);
        int expectedBlue = Math.min(255, originalPixel.getBlue() + increment);

        Pixel brightenedPixel = brightenedImage.getPixel(x, y);
        assertEquals(expectedRed, brightenedPixel.getRed());
        assertEquals(expectedGreen, brightenedPixel.getGreen());
        assertEquals(expectedBlue, brightenedPixel.getBlue());
      }
    }
    System.setOut(System.out);
    System.setIn(System.in);
  }

  /**
   * Tests the Brightening method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerBrightenMainModel2() throws IOException {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String allInputData = String.join(System.lineSeparator(),
            "load res/controllerTest/main_model_test_img.jpg main_model_test_img",
            "brighten -30 main_model_test_img main_model_test_img_brightened2",
            "save res/controllerTest/main_model_test_img_brightened2.jpg "
                    + "main_model_test_img_brightened2"
    );
    System.setIn(new ByteArrayInputStream(allInputData.getBytes()));
    ConsoleView view = new ConsoleView();
    ImageController controller = new ImageController(imageModel, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = String.join(System.lineSeparator(),
            "load operation successful.",
            "brighten operation successful.",
            "save operation successful.",
            "");
    assertEquals(expectedOutput.trim(), outContent.toString().trim());

    int increment = -30;
    Image originalImage = imageModel.getImage("main_model_test_img");
    Image brightenedImage = imageModel.getImage("main_model_test_img_brightened2");

    for (int y = 0; y < originalImage.getHeight(); y++) {
      for (int x = 0; x < originalImage.getWidth(); x++) {
        Pixel originalPixel = originalImage.getPixel(x, y);
        int expectedRed = Math.min(255, originalPixel.getRed() + increment);
        int expectedGreen = Math.min(255, originalPixel.getGreen() + increment);
        int expectedBlue = Math.min(255, originalPixel.getBlue() + increment);

        Pixel brightenedPixel = brightenedImage.getPixel(x, y);
        assertEquals(expectedRed, brightenedPixel.getRed());
        assertEquals(expectedGreen, brightenedPixel.getGreen());
        assertEquals(expectedBlue, brightenedPixel.getBlue());
      }
    }
    System.setOut(System.out);
    System.setIn(System.in);
  }

  /**
   * Tests the Sharpen method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerSharpenMainModel() throws IOException {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String allInputData = String.join(System.lineSeparator(),
            "load res/controllerTest/main_model_sharpen_test_img.png "
                    + "main_model_sharpen_test_img",
            "sharpen main_model_sharpen_test_img main_model_test_img_sharpened",
            "save res/controllerTest/main_model_test_img_sharpened.png "
                    + "main_model_test_img_sharpened"
    );
    System.setIn(new ByteArrayInputStream(allInputData.getBytes()));
    ConsoleView view = new ConsoleView();
    ImageController controller = new ImageController(imageModel, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = String.join(System.lineSeparator(),
            "load operation successful.",
            "sharpen operation successful.",
            "save operation successful.",
            "");
    assertEquals(expectedOutput.trim(), outContent.toString().trim());

    Image sharpenedImage = imageModel.getImage("main_model_test_img_sharpened");

    Pixel[][] expectedPixels = {
            {new Pixel(191, 96, 0), new Pixel(96, 255, 96),
                    new Pixel(0, 0, 255)},
            {new Pixel(96, 255, 96), new Pixel(191, 191, 255),
                    new Pixel(255, 96, 96)},
            {new Pixel(0, 0, 255), new Pixel(255, 96, 96),
                    new Pixel(96, 191, 0)}
    };

    for (int y = 0; y < sharpenedImage.getHeight(); y++) {
      for (int x = 0; x < sharpenedImage.getWidth(); x++) {
        Pixel expectedPixel = expectedPixels[y][x];
        Pixel actualPixel = sharpenedImage.getPixel(x, y);
        assertEquals(expectedPixel.getRed(), actualPixel.getRed());
        assertEquals(expectedPixel.getGreen(), actualPixel.getGreen());
        assertEquals(expectedPixel.getBlue(), actualPixel.getBlue());
      }
    }

    System.setOut(System.out);
    System.setIn(System.in);
  }

  /**
   * Tests the Blur method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerBlurMainModel() throws IOException {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String allInputData = String.join(System.lineSeparator(),
            "load res/controllerTest/main_model_blur_test_img.jpeg "
                    + "main_model_blur_test_img",
            "blur main_model_blur_test_img main_model_test_img_blur",
            "save res/controllerTest/main_model_test_img_blur.jpeg main_model_test_img_blur"
    );
    System.setIn(new ByteArrayInputStream(allInputData.getBytes()));
    ConsoleView view = new ConsoleView();
    ImageController controller = new ImageController(imageModel, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = String.join(System.lineSeparator(),
            "load operation successful.",
            "blur operation successful.",
            "save operation successful.",
            "");
    assertEquals(expectedOutput.trim(), outContent.toString().trim());

    Image blurImage = imageModel.getImage("main_model_test_img_blur");

    Pixel[][] expectedPixels = {
            {new Pixel(37, 71, 49), new Pixel(58, 76, 65),
                    new Pixel(49, 29, 43)},
            {new Pixel(58, 76, 66), new Pixel(72, 84, 74),
                    new Pixel(58, 55, 51)},
            {new Pixel(50, 28, 44), new Pixel(57, 53, 49),
                    new Pixel(41, 70, 37)}
    };

    for (int y = 0; y < blurImage.getHeight(); y++) {
      for (int x = 0; x < blurImage.getWidth(); x++) {
        Pixel expectedPixel = expectedPixels[y][x];
        Pixel actualPixel = blurImage.getPixel(x, y);
        assertEquals(expectedPixel.getRed(), actualPixel.getRed());
        assertEquals(expectedPixel.getGreen(), actualPixel.getGreen());
        assertEquals(expectedPixel.getBlue(), actualPixel.getBlue());
      }
    }
    System.setOut(System.out);
    System.setIn(System.in);
  }

  /**
   * Tests the RGB Split method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerRGBSplitMainModel() throws IOException {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String allInputData = String.join(System.lineSeparator(),
            "load res/controllerTest/main_model_test_img.jpg main_model_test_img",
            "rgb-split main_model_test_img main_model_test_img_split_red "
                    + "main_model_test_img_split_green main_model_test_img_split_blue",
            "save res/controllerTest/main_model_test_img_split_red.jpg "
                    + "main_model_test_img_split_red",
            "save res/controllerTest/main_model_test_img_split_green.jpg "
                    + "main_model_test_img_split_green",
            "save res/controllerTest/main_model_test_img_split_blue.jpg "
                    + "main_model_test_img_split_blue"
    );
    System.setIn(new ByteArrayInputStream(allInputData.getBytes()));
    ConsoleView view = new ConsoleView();
    ImageController controller = new ImageController(imageModel, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = String.join(System.lineSeparator(),
            "load operation successful.",
            "rgb-split operation successful.",
            "save operation successful.",
            "save operation successful.",
            "save operation successful.",
            "");
    assertEquals(expectedOutput.trim(), outContent.toString().trim());

    Image redImage = imageModel.getImage("main_model_test_img_split_red");
    Image greenImage = imageModel.getImage("main_model_test_img_split_green");
    Image blueImage = imageModel.getImage("main_model_test_img_split_blue");

    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        Pixel redPixel = redImage.getPixel(x, y);
        int expectedRedValue = redPixel.getRed();
        assertEquals(expectedRedValue, redPixel.getRed());
        assertEquals(0, redPixel.getGreen());
        assertEquals(0, redPixel.getBlue());
      }
    }

    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        Pixel greenPixel = greenImage.getPixel(x, y);
        assertEquals(0, greenPixel.getRed());
        int expectedGreenValue = greenPixel.getGreen();
        assertEquals(expectedGreenValue, greenPixel.getGreen());
        assertEquals(0, greenPixel.getBlue());
      }
    }

    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        Pixel bluePixel = blueImage.getPixel(x, y);
        assertEquals(0, bluePixel.getRed());
        assertEquals(0, bluePixel.getGreen());
        int expectedBlueValue = bluePixel.getBlue();
        assertEquals(expectedBlueValue, bluePixel.getBlue());
      }
    }
    System.setOut(System.out);
    System.setIn(System.in);
  }

  /**
   * Tests the RGB Combine method call of the ImageController
   * class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerRGBCombineMainModel() throws IOException {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String allInputData = String.join(System.lineSeparator(),
            "load res/controllerTest/main_model_test_img_red.jpg "
                    + "main_model_test_img_red",
            "load res/controllerTest/main_model_test_img_green.jpg "
                    + "main_model_test_img_green",
            "load res/controllerTest/main_model_test_img_blue.jpg "
                    + "main_model_test_img_blue",
            "rgb-combine main_model_test_img_combined main_model_test_img_red "
                    + "main_model_test_img_green main_model_test_img_blue",
            "save res/controllerTest/main_model_test_img_combined.jpg "
                    + "main_model_test_img_combined"
    );
    System.setIn(new ByteArrayInputStream(allInputData.getBytes()));
    ConsoleView view = new ConsoleView();
    ImageController controller = new ImageController(imageModel, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = String.join(System.lineSeparator(),
            "load operation successful.",
            "load operation successful.",
            "load operation successful.",
            "rgb-combine operation successful.",
            "save operation successful.",
            "");
    assertEquals(expectedOutput.trim(), outContent.toString().trim());

    Image redImage = imageModel.getImage("main_model_test_img_red");
    Image greenImage = imageModel.getImage("main_model_test_img_green");
    Image blueImage = imageModel.getImage("main_model_test_img_blue");
    Image combinedImage = imageModel.getImage("main_model_test_img_combined");
    Pixel[][] combinedPixels = combinedImage.getPixels();

    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        assertEquals(combinedPixels[y][x].getRed(), redImage.getPixel(x, y).getRed());
        assertEquals(combinedPixels[y][x].getGreen(), greenImage.getPixel(x, y).getGreen());
        assertEquals(combinedPixels[y][x].getBlue(), blueImage.getPixel(x, y).getBlue());
      }
    }
    System.setOut(System.out);
    System.setIn(System.in);
  }

  /**
   * Tests the value,luma,sepia and intensity method call
   * of the ImageController class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerValueLumaSepiaIntensity() throws IOException {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String allInputData = String.join(System.lineSeparator(),
            "load res/controllerTest/main_model_test_img.jpg main_model_test_img",
            "value-component main_model_test_img main_model_test_img_value",
            "luma-component main_model_test_img_value main_model_test_img_value_luma",
            "sepia main_model_test_img_value_luma main_model_test_img_value_luma_sepia",
            "intensity-component main_model_test_img_value_luma_sepia "
                    + "main_model_test_img_value_luma_sepia_intensity",
            "save res/controllerTest/main_model_test_img_value_luma_sepia_intensity.jpg "
                    + "main_model_test_img_value_luma_sepia_intensity"
    );
    System.setIn(new ByteArrayInputStream(allInputData.getBytes()));
    ConsoleView view = new ConsoleView();
    ImageController controller = new ImageController(imageModel, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = String.join(System.lineSeparator(),
            "load operation successful.",
            "value-component operation successful.",
            "luma-component operation successful.",
            "sepia operation successful.",
            "intensity-component operation successful.",
            "save operation successful.",
            ""
    );
    assertEquals(expectedOutput.trim(), outContent.toString().trim());

    Pixel[][] expectedIntensityPixels = {
            {new Pixel(229, 229, 229), new Pixel(233, 233, 233)},
            {new Pixel(237, 237, 237), new Pixel(239, 239, 239)},
    };
    Image intensityImage =
            imageModel.getImage("main_model_test_img_value_luma_sepia_intensity");
    Pixel[][] intensityPixels = intensityImage.getPixels();

    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        assertEquals(expectedIntensityPixels[y][x].getRed(), intensityPixels[y][x].getRed());
        assertEquals(expectedIntensityPixels[y][x].getGreen(), intensityPixels[y][x].getGreen());
        assertEquals(expectedIntensityPixels[y][x].getBlue(), intensityPixels[y][x].getBlue());
      }
    }
    System.setOut(System.out);
    System.setIn(System.in);
  }

  /**
   * Tests the multiple brighten method calls
   * of the ImageController class using execute.
   * Ensures it processes the simulated console input correctly.
   */
  @Test
  public void testControllerBrightenNegativePositive() throws IOException {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String allInputData = String.join(System.lineSeparator(),
            "load res/controllerTest/main_model_test_img.jpg main_model_test_img",
            "brighten -50 main_model_test_img main_model_test_img_mix_brighten",
            "brighten 50 main_model_test_img_mix_brighten main_model_test_img_mix_brighten2",
            "save res/controllerTest/main_model_test_img_mix_brighten2.jpg "
                    + "main_model_test_img_mix_brighten2"
    );
    System.setIn(new ByteArrayInputStream(allInputData.getBytes()));
    ConsoleView view = new ConsoleView();
    ImageController controller = new ImageController(imageModel, view);
    try {
      controller.execute();
    } catch (NoSuchElementException ignored) {
    }
    String expectedOutput = String.join(System.lineSeparator(),
            "load operation successful.",
            "brighten operation successful.",
            "brighten operation successful.",
            "save operation successful.",
            ""
    );
    assertEquals(expectedOutput.trim(), outContent.toString().trim());
    Image originalImage = imageModel.getImage("main_model_test_img");
    Image brightenedImage = imageModel.getImage("main_model_test_img_mix_brighten2");

    for (int y = 0; y < originalImage.getHeight(); y++) {
      for (int x = 0; x < originalImage.getWidth(); x++) {
        Pixel originalPixel = originalImage.getPixel(x, y);
        Pixel brightenedPixel = brightenedImage.getPixel(x, y);
        assertEquals(originalPixel.getRed(), brightenedPixel.getRed());
        assertEquals(originalPixel.getGreen(), brightenedPixel.getGreen());
        assertEquals(originalPixel.getBlue(), brightenedPixel.getBlue());
      }
    }
    System.setOut(System.out);
    System.setIn(System.in);
  }
}
