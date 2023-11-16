import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Optional;

import model.ImageModel;
import model.image.Image;
import model.image.Pixel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * JUnit tests for the ImageModel class.
 */
public class ImageModelTest {

  private ImageModel imageModel;
  private Pixel[][] pixelData;

  /**
   * This method sets up the testing environment before each test.
   */
  @Before
  public void setUp() {
    imageModel = new ImageModel();

    pixelData = new Pixel[][]{
            {new Pixel(100, 150, 200), new Pixel(110, 160, 210)},
            {new Pixel(120, 170, 220), new Pixel(130, 180, 230)}
    };
  }

  /**
   * Test to ensure the ImageModel's constructor initializes a non-null ImageModel.
   */
  @Test
  public void testConstructor() {
    assertNotNull(imageModel);
  }

  /**
   * Test to check if the addImage method correctly adds an image to the list.
   */
  @Test
  public void testAddImage() {
    Image img = new Image(pixelData);
    try {
      imageModel.addImage(img, "TestImage");
      assertEquals(img, imageModel.getImage("TestImage"));
    } catch (IOException e) {
      fail("An exception should not occur.");
    }
  }

  /**
   * Test to ensure that the addImage method throws an IOException
   * when attempting to add a null image.
   */
  @Test(expected = IOException.class)
  public void testAddNullImage() throws IOException {
    imageModel.addImage(null, "TestImage");
  }

  /**
   * Test to ensure that the addImage method does not throw an IOException
   * when attempting to add a duplicate image with different name.
   */
  @Test
  public void testAddDuplicateImage() {
    Image img = new Image(pixelData);
    try {
      imageModel.addImage(img, "TestImage1");
      imageModel.addImage(img, "TestImage2");
    } catch (IOException e) {
      fail("An exception should not occur.");
    }
  }

  /**
   * Test to ensure the getImage method retrieves the correct image based on its name.
   */
  @Test
  public void testGetExistingImage() {
    Image img = new Image(pixelData);
    try {
      imageModel.addImage(img, "TestImage1");
      Image retrievedImage = imageModel.getImage("TestImage1");
      assertEquals(retrievedImage, retrievedImage);
    } catch (IOException e) {
      fail("An exception should not occur.");
    }
  }

  /**
   * Test to ensure the getImage method throws an IOException when
   * attempting to retrieve an image that does not exist.
   */
  @Test(expected = IOException.class)
  public void testGetNonExistingImage() throws IOException {
    imageModel.getImage("nonexistentImage");
  }

  /**
   * Test to ensure the getImage method throws an IOException when
   * attempting to retrieve an image with a null name.
   */
  @Test(expected = IOException.class)
  public void testGetImageWithNullName() throws IOException {
    imageModel.getImage(null);
  }

  /**
   * Test to ensure the getImage method throws an IOException when
   * attempting to retrieve an image with an empty name.
   */
  @Test(expected = IOException.class)
  public void testGetImageWithEmptyName() throws IOException {
    imageModel.getImage("");
  }

  /**
   * Test that redComponent method correctly extracts the red component.
   */
  @Test
  public void testRedComponentExtraction() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    imageModel.redComponent("TestImage", "redTestImage");

    Image redImage = imageModel.getImage("redTestImage");

    for (int y = 0; y < redImage.getHeight(); y++) {
      for (int x = 0; x < redImage.getWidth(); x++) {
        Pixel redPixel = redImage.getPixel(x, y);
        assertEquals(pixelData[y][x].getRed(), redPixel.getRed());
        assertEquals(0, redPixel.getGreen());
        assertEquals(0, redPixel.getBlue());
      }
    }
  }

  /**
   * Test that redComponent method throws an IOException for an invalid image name.
   */
  @Test(expected = IOException.class)
  public void testRedComponentInvalidImageName() throws IOException {
    imageModel.redComponent("invalid", "dest");
  }

  /**
   * Test that redComponent method saves the result with the correct destination image name.
   */
  @Test
  public void testRedComponentDestImageName() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    imageModel.redComponent("TestImage", "redTestImage");

    assertNotNull(imageModel.getImage("redTestImage"));
  }

  /**
   * Test that greenComponent method correctly extracts the green component.
   */
  @Test
  public void testGreenComponentExtraction() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    imageModel.greenComponent("TestImage", "greenTestImage");

    Image greenImage = imageModel.getImage("greenTestImage");

    for (int y = 0; y < greenImage.getHeight(); y++) {
      for (int x = 0; x < greenImage.getWidth(); x++) {
        Pixel greenPixel = greenImage.getPixel(x, y);
        assertEquals(0, greenPixel.getRed());
        assertEquals(pixelData[y][x].getGreen(), greenPixel.getGreen());
        assertEquals(0, greenPixel.getBlue());
      }
    }
  }

  /**
   * Test that greenComponent method throws an IOException for an invalid image name.
   */
  @Test(expected = IOException.class)
  public void testGreenComponentInvalidImageName() throws IOException {
    imageModel.greenComponent("invalid", "dest");
  }

  /**
   * Test that greenComponent method saves the result with the correct destination image name.
   */
  @Test
  public void testGreenComponentDestImageName() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    imageModel.greenComponent("TestImage", "greenTestImage");

    assertNotNull(imageModel.getImage("greenTestImage"));
  }

  /**
   * Test that blueComponent method correctly extracts the blue component.
   */
  @Test
  public void testBlueComponentExtraction() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    imageModel.blueComponent("TestImage", "blueTestImage");

    Image blueImage = imageModel.getImage("blueTestImage");

    for (int y = 0; y < blueImage.getHeight(); y++) {
      for (int x = 0; x < blueImage.getWidth(); x++) {
        Pixel bluePixel = blueImage.getPixel(x, y);
        assertEquals(0, bluePixel.getRed());
        assertEquals(0, bluePixel.getGreen());
        assertEquals(pixelData[y][x].getBlue(), bluePixel.getBlue());
      }
    }
  }

  /**
   * Test that blueComponent method throws an IOException for an invalid image name.
   */
  @Test(expected = IOException.class)
  public void testBlueComponentInvalidImageName() throws IOException {
    imageModel.blueComponent("invalid", "dest");
  }

  /**
   * Test that blueComponent method saves the result with the correct destination image name.
   */
  @Test
  public void testBlueComponentDestImageName() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    imageModel.blueComponent("TestImage", "blueTestImage");

    assertNotNull(imageModel.getImage("blueTestImage"));
  }

  /**
   * Test that valueComponent method correctly processes the image to represent the value.
   */
  @Test
  public void testValueComponentProcessing() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    imageModel.valueComponent("TestImage", "valueTestImage");

    Image valueImage = imageModel.getImage("valueTestImage");

    for (int y = 0; y < valueImage.getHeight(); y++) {
      for (int x = 0; x < valueImage.getWidth(); x++) {
        Pixel valuePixel = valueImage.getPixel(x, y);
        int maxValue = Math.max(pixelData[y][x].getRed(),
                Math.max(pixelData[y][x].getGreen(), pixelData[y][x].getBlue()));
        assertEquals(maxValue, valuePixel.getRed());
        assertEquals(maxValue, valuePixel.getGreen());
        assertEquals(maxValue, valuePixel.getBlue());
      }
    }
  }

  /**
   * Test that valueComponent method throws an IOException for an invalid image name.
   */
  @Test(expected = IOException.class)
  public void testValueComponentInvalidImageName() throws IOException {
    imageModel.valueComponent("invalid", "dest");
  }

  /**
   * Test that valueComponent method saves the result with the correct destination image name.
   */
  @Test
  public void testValueComponentDestImageName() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    imageModel.valueComponent("TestImage", "valueTestImage");

    assertNotNull(imageModel.getImage("valueTestImage"));
  }

  /**
   * Test that lumaComponent method correctly processes the image to represent the luma.
   */
  @Test
  public void testLumaComponentProcessing() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    imageModel.lumaComponent("TestImage", "lumaTestImage");

    Image lumaImage = imageModel.getImage("lumaTestImage");

    for (int y = 0; y < lumaImage.getHeight(); y++) {
      for (int x = 0; x < lumaImage.getWidth(); x++) {
        Pixel lumaPixel = lumaImage.getPixel(x, y);
        double lumaValue = (0.2126 * pixelData[y][x].getRed()
                + 0.7152 * pixelData[y][x].getGreen() + 0.0722 * pixelData[y][x].getBlue());
        int roundedLumaValue = (int) Math.round(lumaValue);
        assertEquals(roundedLumaValue, lumaPixel.getRed());
        assertEquals(roundedLumaValue, lumaPixel.getGreen());
        assertEquals(roundedLumaValue, lumaPixel.getBlue());
      }
    }
  }

  /**
   * Test that lumaComponent method throws an IOException for an invalid image name.
   */
  @Test(expected = IOException.class)
  public void testLumaComponentInvalidImageName() throws IOException {
    imageModel.lumaComponent("invalid", "dest");
  }

  /**
   * Test that lumaComponent method saves the result with the correct destination image name.
   */
  @Test
  public void testLumaComponentDestImageName() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    imageModel.lumaComponent("TestImage", "lumaTestImage");

    assertNotNull(imageModel.getImage("lumaTestImage"));
  }

  /**
   * Test that intensityComponent method correctly processes the image to represent the luma.
   */
  @Test
  public void testIntensityComponentProcessing() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    imageModel.intensityComponent("TestImage", "intensityTestImage");

    Image intensityImage = imageModel.getImage("intensityTestImage");

    for (int y = 0; y < intensityImage.getHeight(); y++) {
      for (int x = 0; x < intensityImage.getWidth(); x++) {
        Pixel intensityPixel = intensityImage.getPixel(x, y);
        int intensityValue = (pixelData[y][x].getRed() + pixelData[y][x].getGreen()
                + pixelData[y][x].getBlue()) / 3;
        assertEquals(intensityValue, intensityPixel.getRed());
        assertEquals(intensityValue, intensityPixel.getGreen());
        assertEquals(intensityValue, intensityPixel.getBlue());
      }
    }
  }

  /**
   * Test that intensityComponent method throws an IOException for an invalid image name.
   */
  @Test(expected = IOException.class)
  public void testIntensityComponentInvalidImageName() throws IOException {
    imageModel.intensityComponent("invalid", "dest");
  }

  /**
   * Test that intensityComponent method saves the result with the correct destination image name.
   */
  @Test
  public void testIntensityComponentDestImageName() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    imageModel.intensityComponent("TestImage", "intensityTestImage");

    assertNotNull(imageModel.getImage("intensityTestImage"));
  }

  /**
   * Test that sepia method correctly processes the image with the sepia formula.
   */
  @Test
  public void testSepiaProcessing() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    imageModel.sepia("TestImage", "sepiaTestImage");

    Image sepiaImage = imageModel.getImage("sepiaTestImage");

    for (int y = 0; y < sepiaImage.getHeight(); y++) {
      for (int x = 0; x < sepiaImage.getWidth(); x++) {
        Pixel sepiaPixel = sepiaImage.getPixel(x, y);
        Pixel originalPixel = img.getPixel(x, y);

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
  }

  /**
   * Test that sepiaComponent method throws an IOException for an invalid image name.
   */
  @Test(expected = IOException.class)
  public void testSepiaComponentInvalidImageName() throws IOException {
    imageModel.sepia("invalid", "dest");
  }

  /**
   * Test that sepia method saves the result with the correct destImageName.
   */
  @Test
  public void testSepiaDestImageName() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    imageModel.sepia("TestImage", "sepiaTestImage");

    assertNotNull(imageModel.getImage("sepiaTestImage"));
  }

  /**
   * Test that horizontalFlip method correctly flips the image.
   */
  @Test
  public void testHorizontalFlipProcessing() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    imageModel.horizontalFlip("TestImage", "hFlipTestImage");

    Image flippedImage = imageModel.getImage("hFlipTestImage");
    int width = img.getWidth();

    for (int y = 0; y < img.getHeight(); y++) {
      for (int x = 0; x < width; x++) {
        assertEquals(img.getPixel(x, y), flippedImage.getPixel(width - 1 - x, y));
      }
    }
  }

  /**
   * Test that horizontalFlip method throws an IOException for an invalid image name.
   */
  @Test(expected = IOException.class)
  public void testHorizontalFlipInvalidImageName() throws IOException {
    imageModel.horizontalFlip("invalid", "dest");
  }

  /**
   * Test that horizontalFlip method saves the result with the correct destImageName.
   */
  @Test
  public void testHorizontalFlipDestImageName() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    imageModel.horizontalFlip("TestImage", "hFlipTestImage");

    assertNotNull(imageModel.getImage("hFlipTestImage"));
  }

  /**
   * Test that verticalFlip method correctly flips the image.
   */
  @Test
  public void testVerticalFlipProcessing() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    imageModel.verticalFlip("TestImage", "vFlipTestImage");

    Image flippedImage = imageModel.getImage("vFlipTestImage");
    int height = img.getHeight();

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < img.getWidth(); x++) {
        assertEquals(img.getPixel(x, y), flippedImage.getPixel(x, height - 1 - y));
      }
    }
  }

  /**
   * Test that VerticalFlip method throws an IOException for an invalid image name.
   */
  @Test(expected = IOException.class)
  public void testVerticalFlipInvalidImageName() throws IOException {
    imageModel.verticalFlip("invalid", "dest");
  }

  /**
   * Test that verticalFlip method saves the result with the correct destImageName.
   */
  @Test
  public void testVerticalFlipDestImageName() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    imageModel.verticalFlip("TestImage", "vFlipTestImage");

    assertNotNull(imageModel.getImage("vFlipTestImage"));
  }

  /**
   * Test that brightenCommand method correctly brightens the image by the given increment.
   */
  @Test
  public void testBrightenCommandProcessing() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    int increment = 50;
    imageModel.brightenCommand(increment, "TestImage",
            "brightenTestImage");

    Image brightenedImage = imageModel.getImage("brightenTestImage");

    for (int y = 0; y < img.getHeight(); y++) {
      for (int x = 0; x < img.getWidth(); x++) {
        Pixel originalPixel = img.getPixel(x, y);
        int expectedRed = Math.min(255, Math.max(0, originalPixel.getRed() + increment));
        int expectedGreen = Math.min(255, Math.max(0, originalPixel.getGreen() + increment));
        int expectedBlue = Math.min(255, Math.max(0, originalPixel.getBlue() + increment));

        Pixel brightenedPixel = brightenedImage.getPixel(x, y);
        assertEquals(expectedRed, brightenedPixel.getRed());
        assertEquals(expectedGreen, brightenedPixel.getGreen());
        assertEquals(expectedBlue, brightenedPixel.getBlue());
      }
    }
  }

  /**
   * Test that brightenCommand method saves the result with the correct destImageName.
   */
  @Test
  public void testBrightenCommandDestImageName() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    imageModel.brightenCommand(50, "TestImage",
            "brightenTestImage");

    assertNotNull(imageModel.getImage("brightenTestImage"));
  }

  /**
   * Test brightenCommand for negative increments.
   */
  @Test
  public void testBrightenCommandWithNegativeIncrement() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    int decrement = -101;
    imageModel.brightenCommand(decrement, "TestImage", "dimTestImage");

    Image dimmedImage = imageModel.getImage("dimTestImage");

    for (int y = 0; y < img.getHeight(); y++) {
      for (int x = 0; x < img.getWidth(); x++) {
        Pixel originalPixel = img.getPixel(x, y);
        int expectedRed = Math.min(255, Math.max(0, originalPixel.getRed() + decrement));
        int expectedGreen = Math.min(255, Math.max(0, originalPixel.getGreen() + decrement));
        int expectedBlue = Math.min(255, Math.max(0, originalPixel.getBlue() + decrement));

        Pixel dimmedPixel = dimmedImage.getPixel(x, y);
        assertEquals(expectedRed, dimmedPixel.getRed());
        assertEquals(expectedGreen, dimmedPixel.getGreen());
        assertEquals(expectedBlue, dimmedPixel.getBlue());
      }
    }
  }

  /**
   * Test that brightenCommand method throws an IOException if the image is not found.
   */
  @Test(expected = IOException.class)
  public void testBrightenCommandImageNotFound() throws IOException {
    imageModel.brightenCommand(50, "nonExistentImage",
            "brightenSample");
  }

  /**
   * Test that blur method correctly blurs the image.
   */
  @Test
  public void testBlur() throws IOException {
    Pixel[][] samplePixels = {
      {new Pixel(255, 0, 0), new Pixel(0, 255, 0),
       new Pixel(0, 0, 255)},
      {new Pixel(0, 255, 0), new Pixel(0, 0, 255),
       new Pixel(255, 0, 0)},
      {new Pixel(0, 0, 255), new Pixel(255, 0, 0),
       new Pixel(0, 255, 0)}
    };
    Image img = new Image(samplePixels);
    imageModel.addImage(img, "TestImage");

    imageModel.blur("TestImage", "blurredTestImage");

    Image blurredImage = imageModel.getImage("blurredTestImage");
    Pixel[][] blurredPixels = blurredImage.getPixels();

    Pixel[][] expectedPixels = {
      {new Pixel(64, 64, 16), new Pixel(48, 80, 64),
       new Pixel(32, 32, 80)},
      {new Pixel(48, 80, 64), new Pixel(80, 80, 96),
       new Pixel(80, 48, 64)},
      {new Pixel(32, 32, 80), new Pixel(80, 48, 64),
       new Pixel(64, 64, 16)}
    };

    for (int y = 0; y < 3; y++) {
      for (int x = 0; x < 3; x++) {
        assertEquals(expectedPixels[y][x].getRed(), blurredPixels[y][x].getRed());
        assertEquals(expectedPixels[y][x].getGreen(), blurredPixels[y][x].getGreen());
        assertEquals(expectedPixels[y][x].getGreen(), blurredPixels[y][x].getGreen());
      }
    }
  }

  /**
   * Test that blur method throws an IOException if the image is not found.
   */
  @Test(expected = IOException.class)
  public void testBlurImageNotFound() throws IOException {
    imageModel.blur("nonExistentImage", "blurredTestImage");
  }

  /**
   * Test that sharpen method correctly sharpens the image.
   */
  @Test
  public void testSharpen() throws IOException {
    Pixel[][] samplePixels = {
      {new Pixel(255, 0, 0), new Pixel(0, 255, 0),
       new Pixel(0, 0, 255)},
      {new Pixel(0, 255, 0), new Pixel(0, 0, 255),
       new Pixel(255, 0, 0)},
      {new Pixel(0, 0, 255), new Pixel(255, 0, 0),
       new Pixel(0, 255, 0)}
    };
    Image img = new Image(samplePixels);
    imageModel.addImage(img, "sample");

    imageModel.sharpen("sample", "sharpenedSample");

    Image sharpenedImage = imageModel.getImage("sharpenedSample");
    Pixel[][] sharpenedPixels = sharpenedImage.getPixels();

    Pixel[][] expectedPixels = {
      {new Pixel(191, 96, 0), new Pixel(96, 255, 96),
       new Pixel(0, 0, 255)},
      {new Pixel(96, 255, 96), new Pixel(191, 191, 255),
       new Pixel(255, 96, 96)},
      {new Pixel(0, 0, 255), new Pixel(255, 96, 96),
       new Pixel(96, 191, 0)}
    };

    for (int y = 0; y < 3; y++) {
      for (int x = 0; x < 3; x++) {
        assertEquals(expectedPixels[y][x].getRed(), sharpenedPixels[y][x].getRed());
        assertEquals(expectedPixels[y][x].getGreen(), sharpenedPixels[y][x].getGreen());
        assertEquals(expectedPixels[y][x].getGreen(), sharpenedPixels[y][x].getGreen());
      }
    }
  }

  /**
   * Test that sharpen method throws an IOException if the image is not found.
   */
  @Test(expected = IOException.class)
  public void testSharpenImageNotFound() throws IOException {
    imageModel.sharpen("nonExistentImage", "sharpenedSample");
  }

  /**
   * Test that rgbSplit method correctly splits an image into its red, green and blue components.
   */
  @Test
  public void testRgbSplit() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "sample");

    imageModel.rgbSplit("sample", "redImage",
            "greenImage", "blueImage");

    Image redImage = imageModel.getImage("redImage");
    Image greenImage = imageModel.getImage("greenImage");
    Image blueImage = imageModel.getImage("blueImage");

    Pixel[][] redPixels = redImage.getPixels();
    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        assertEquals(pixelData[y][x].getRed(), redPixels[y][x].getRed());
        assertEquals(0, redPixels[y][x].getGreen());
        assertEquals(0, redPixels[y][x].getBlue());
      }
    }

    Pixel[][] greenPixels = greenImage.getPixels();
    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        assertEquals(0, greenPixels[y][x].getRed());
        assertEquals(pixelData[y][x].getGreen(), greenPixels[y][x].getGreen());
        assertEquals(0, greenPixels[y][x].getBlue());
      }
    }

    Pixel[][] bluePixels = blueImage.getPixels();
    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        assertEquals(0, bluePixels[y][x].getRed());
        assertEquals(0, bluePixels[y][x].getGreen());
        assertEquals(pixelData[y][x].getBlue(), bluePixels[y][x].getBlue());
      }
    }
  }

  /**
   * Test that rgbSplit method throws an IOException if the image is not found.
   */
  @Test(expected = IOException.class)
  public void testRgbSplitImageNotFound() throws IOException {
    imageModel.rgbSplit("nonExistentImage", "redImage",
            "greenImage", "blueImage");
  }

  /**
   * Test that rgbCombine method combines red, green and blue components into rgb color image.
   */
  @Test
  public void testRgbCombine() throws IOException {
    Pixel[][] redPixels = {
            {new Pixel(255, 0, 0), new Pixel(255, 0, 0)},
            {new Pixel(255, 0, 0), new Pixel(255, 0, 0)}
    };
    Image redImage = new Image(redPixels);
    imageModel.addImage(redImage, "redImage");

    Pixel[][] greenPixels = {
            {new Pixel(0, 255, 0), new Pixel(0, 255, 0)},
            {new Pixel(0, 255, 0), new Pixel(0, 255, 0)}
    };
    Image greenImage = new Image(greenPixels);
    imageModel.addImage(greenImage, "greenImage");

    Pixel[][] bluePixels = {
            {new Pixel(0, 0, 255), new Pixel(0, 0, 255)},
            {new Pixel(0, 0, 255), new Pixel(0, 0, 255)}
    };
    Image blueImage = new Image(bluePixels);
    imageModel.addImage(blueImage, "blueImage");

    imageModel.rgbCombine("combinedImage", "redImage",
            "greenImage", "blueImage");

    Image combinedImage = imageModel.getImage("combinedImage");
    Pixel[][] combinedPixels = combinedImage.getPixels();

    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        assertEquals(255, combinedPixels[y][x].getRed());
        assertEquals(255, combinedPixels[y][x].getGreen());
        assertEquals(255, combinedPixels[y][x].getBlue());
      }
    }
  }

  /**
   * Test that compressImage method correctly compresses the image by the given percentage.
   */
  @Test
  public void testCompressImageProcessing() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    int percentage = 50;
    imageModel.compressImage("TestImage", "compressTestImage", percentage);

    Image compressedImage = imageModel.getImage("compressTestImage");
    Pixel[][] expectedPixelData = new Pixel[][]{
            {new Pixel(115, 165, 215), new Pixel(115, 165, 215)},
            {new Pixel(115, 165, 215), new Pixel(115, 165, 215)},
            {new Pixel(115, 165, 215), new Pixel(125, 175, 225)}
    };

    for (int y = 0; y < compressedImage.getHeight(); y++) {
      for (int x = 0; x < compressedImage.getWidth(); x++) {
        Pixel expectedPixel = expectedPixelData[y][x];
        Pixel actualPixel = compressedImage.getPixel(x, y);
        assertEquals(expectedPixel.getRed(), actualPixel.getRed());
        assertEquals(expectedPixel.getGreen(), actualPixel.getGreen());
        assertEquals(expectedPixel.getBlue(), actualPixel.getBlue());
      }
    }
  }

  /**
   * Test that compressImage method correctly compresses the image by the given percentage on a 4x2
   * image.
   */
  @Test
  public void testCompressImageProcessing4X2() throws IOException {
    pixelData = new Pixel[][]{
            {new Pixel(100, 150, 200), new Pixel(110, 160, 210), new Pixel(120, 170, 220), new Pixel(130, 180, 230)},
            {new Pixel(140, 190, 240), new Pixel(150, 200, 250), new Pixel(160, 210, 260), new Pixel(170, 220, 270)}
    };
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    int percentage = 50;
    imageModel.compressImage("TestImage", "compressTestImage", percentage);

    Image compressedImage = imageModel.getImage("compressTestImage");

    Pixel[][] expectedPixelData = new Pixel[][]{
            {new Pixel(105, 155, 225), new Pixel(105, 155, 225), new Pixel(125, 175, 240), new Pixel(125, 175, 240)},
            {new Pixel(145, 195, 225), new Pixel(145, 195, 225), new Pixel(165, 215, 240), new Pixel(165, 215, 240)}
    };

    for (int y = 0; y < compressedImage.getHeight(); y++) {
      for (int x = 0; x < compressedImage.getWidth(); x++) {
        Pixel expectedPixel = expectedPixelData[y][x];
        Pixel actualPixel = compressedImage.getPixel(x, y);
        assertEquals(expectedPixel.getRed(), actualPixel.getRed());
        assertEquals(expectedPixel.getGreen(), actualPixel.getGreen());
        assertEquals(expectedPixel.getBlue(), actualPixel.getBlue());
      }
    }
  }

  /**
   * Test that compressImage method throws IllegalArgumentException for invalid percentage.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCompressImageInvalidPercentage() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    int percentage = 150;
    imageModel.compressImage("TestImage", "compressTestImage", percentage);
  }

  /**
   * Test that compressImage method throws an IOException if the source image is not found.
   */
  @Test(expected = IOException.class)
  public void testCompressImageNotFound() throws IOException {
    int percentage = 50;
    imageModel.compressImage("nonExistentImage", "compressTestImage", percentage);
  }

  /**
   * Test that compressImage method correctly stores the destination image.
   */
  @Test
  public void testCompressImageDestImag() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    int percentage = 50;
    imageModel.compressImage("TestImage", "compressTestImage", percentage);

    assertNotNull(imageModel.getImage("compressTestImage"));
  }

  /**
   * Test that rgbCombine method throws an IOException if any of the images are not found.
   */
  @Test(expected = IOException.class)
  public void testRgbCombineImageNotFound() throws IOException {
    imageModel.rgbCombine("combinedImage", "nonExistentRedImage",
            "nonExistentGreenImage", "nonExistentBlueImage");
  }

  /**
   * Test multiple operations on the image and check each intermediate result.
   */
  @Test
  public void testBlurSharpenRgbSplitCombine() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    imageModel.blur("TestImage", "blurredImg");

    Image blurredImage = imageModel.getImage("blurredImg");
    Pixel[][] blurredPixels = blurredImage.getPixels();

    Pixel[][] expectedPixels1 = {
            {new Pixel(62, 90, 118), new Pixel(64, 92, 120)},
            {new Pixel(66, 94, 122), new Pixel(68, 96, 124)},
    };

    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        assertEquals(expectedPixels1[y][x].getRed(), blurredPixels[y][x].getRed());
        assertEquals(expectedPixels1[y][x].getGreen(), blurredPixels[y][x].getGreen());
        assertEquals(expectedPixels1[y][x].getBlue(), blurredPixels[y][x].getBlue());
      }
    }

    imageModel.sharpen("blurredImg", "sharpenedImg");

    Image sharpenedImage = imageModel.getImage("sharpenedImg");
    Pixel[][] sharpenedPixels = sharpenedImage.getPixels();

    Pixel[][] expectedPixels2 = {
            {new Pixel(112, 161, 210), new Pixel(113, 162, 211)},
            {new Pixel(115, 164, 213), new Pixel(116, 165, 214)},
    };

    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        assertEquals(expectedPixels2[y][x].getRed(), sharpenedPixels[y][x].getRed());
        assertEquals(expectedPixels2[y][x].getGreen(), sharpenedPixels[y][x].getGreen());
        assertEquals(expectedPixels2[y][x].getBlue(), sharpenedPixels[y][x].getBlue());
      }
    }

    imageModel.rgbSplit("sharpenedImg", "redImg",
            "greenImg", "blueImg");
    Image redImage = imageModel.getImage("redImg");
    Image greenImage = imageModel.getImage("greenImg");
    Image blueImage = imageModel.getImage("blueImg");

    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        assertEquals(sharpenedPixels[y][x].getRed(), redImage.getPixel(x, y).getRed());
        assertEquals(0, redImage.getPixel(x, y).getGreen());
        assertEquals(0, redImage.getPixel(x, y).getBlue());

        assertEquals(0, greenImage.getPixel(x, y).getRed());
        assertEquals(sharpenedPixels[y][x].getGreen(), greenImage.getPixel(x, y).getGreen());
        assertEquals(0, greenImage.getPixel(x, y).getBlue());

        assertEquals(0, blueImage.getPixel(x, y).getRed());
        assertEquals(0, blueImage.getPixel(x, y).getGreen());
        assertEquals(sharpenedPixels[y][x].getBlue(), blueImage.getPixel(x, y).getBlue());
      }
    }

    imageModel.rgbCombine("combinedImg", "redImg",
            "greenImg", "blueImg");

    Image combinedImage = imageModel.getImage("combinedImg");
    Pixel[][] combinedPixels = combinedImage.getPixels();

    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        assertEquals(combinedPixels[y][x].getRed(), redImage.getPixel(x, y).getRed());
        assertEquals(combinedPixels[y][x].getGreen(), greenImage.getPixel(x, y).getGreen());
        assertEquals(combinedPixels[y][x].getBlue(), blueImage.getPixel(x, y).getBlue());
      }
    }
  }

  /**
   * Test multiple operations on the image and check each intermediate result.
   */
  @Test
  public void testSharpenBlurRgbCombineSplit() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");

    imageModel.sharpen("TestImage", "sharpenedImg");

    Image sharpenedImage = imageModel.getImage("sharpenedImg");
    Pixel[][] sharpenedPixels = sharpenedImage.getPixels();

    Pixel[][] expectedPixels2 = {
            {new Pixel(190, 255, 255), new Pixel(198, 255, 255)},
            {new Pixel(205, 255, 255), new Pixel(213, 255, 255)},
    };

    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        assertEquals(expectedPixels2[y][x].getRed(), sharpenedPixels[y][x].getRed());
        assertEquals(expectedPixels2[y][x].getGreen(), sharpenedPixels[y][x].getGreen());
        assertEquals(expectedPixels2[y][x].getBlue(), sharpenedPixels[y][x].getBlue());
      }
    }

    imageModel.blur("sharpenedImg", "blurredImg");

    Image blurredImage = imageModel.getImage("blurredImg");
    Pixel[][] blurredPixels = blurredImage.getPixels();

    Pixel[][] expectedPixels1 = {
            {new Pixel(111, 143, 143), new Pixel(113, 143, 143)},
            {new Pixel(114, 143, 143), new Pixel(116, 143, 143)},
    };

    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        assertEquals(expectedPixels1[y][x].getRed(), blurredPixels[y][x].getRed());
        assertEquals(expectedPixels1[y][x].getGreen(), blurredPixels[y][x].getGreen());
        assertEquals(expectedPixels1[y][x].getBlue(), blurredPixels[y][x].getBlue());
      }
    }

    imageModel.rgbSplit("blurredImg", "redImg",
            "greenImg", "blueImg");

    Image redImage = imageModel.getImage("redImg");
    Image greenImage = imageModel.getImage("greenImg");
    Image blueImage = imageModel.getImage("blueImg");

    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        assertEquals(blurredPixels[y][x].getRed(), redImage.getPixel(x, y).getRed());
        assertEquals(0, redImage.getPixel(x, y).getGreen());
        assertEquals(0, redImage.getPixel(x, y).getBlue());

        assertEquals(0, greenImage.getPixel(x, y).getRed());
        assertEquals(blurredPixels[y][x].getGreen(), greenImage.getPixel(x, y).getGreen());
        assertEquals(0, greenImage.getPixel(x, y).getBlue());

        assertEquals(0, blueImage.getPixel(x, y).getRed());
        assertEquals(0, blueImage.getPixel(x, y).getGreen());
        assertEquals(blurredPixels[y][x].getBlue(), blueImage.getPixel(x, y).getBlue());
      }
    }

    imageModel.rgbCombine("combinedImg", "redImg",
            "greenImg", "blueImg");
    Image combinedImage = imageModel.getImage("combinedImg");
    Pixel[][] combinedPixels = combinedImage.getPixels();

    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        assertEquals(combinedPixels[y][x].getRed(), redImage.getPixel(x, y).getRed());
        assertEquals(combinedPixels[y][x].getGreen(), greenImage.getPixel(x, y).getGreen());
        assertEquals(combinedPixels[y][x].getBlue(), blueImage.getPixel(x, y).getBlue());
      }
    }
  }

  /**
   * Test multiple operations on the image and check each intermediate result.
   */
  @Test
  public void testValueHorizontalFlipRedComponentSepia() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");

    imageModel.valueComponent("TestImage", "valueImg");

    Image valueImage = imageModel.getImage("valueImg");
    Pixel[][] valuePixels = valueImage.getPixels();

    Pixel[][] expectedPixels2 = {
            {new Pixel(200, 200, 200), new Pixel(210, 210, 210)},
            {new Pixel(220, 220, 220), new Pixel(230, 230, 230)},
    };

    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        assertEquals(expectedPixels2[y][x].getRed(), valuePixels[y][x].getRed());
        assertEquals(expectedPixels2[y][x].getGreen(), valuePixels[y][x].getGreen());
        assertEquals(expectedPixels2[y][x].getBlue(), valuePixels[y][x].getBlue());
      }
    }

    imageModel.horizontalFlip("valueImg", "HFlipImg");
    Image hFlipImage = imageModel.getImage("HFlipImg");
    Pixel[][] hFlipPixels = hFlipImage.getPixels();

    Pixel[][] expectedPixels1 = {
            {new Pixel(210, 210, 210), new Pixel(200, 200, 200)},
            {new Pixel(230, 230, 230), new Pixel(220, 220, 220)},
    };

    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        assertEquals(expectedPixels1[y][x].getRed(), hFlipPixels[y][x].getRed());
        assertEquals(expectedPixels1[y][x].getGreen(), hFlipPixels[y][x].getGreen());
        assertEquals(expectedPixels1[y][x].getBlue(), hFlipPixels[y][x].getBlue());
      }
    }

    imageModel.redComponent("HFlipImg", "redComp");
    Image redCompImage = imageModel.getImage("redComp");
    Pixel[][] redCompPixels = redCompImage.getPixels();

    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        assertEquals(expectedPixels1[y][x].getRed(), redCompPixels[y][x].getRed());
        assertEquals(0, redCompPixels[y][x].getGreen());
        assertEquals(0, redCompPixels[y][x].getBlue());
      }
    }

    Pixel[][] expectedPixels3 = {
            {new Pixel(82, 73, 57), new Pixel(78, 69, 54)},
            {new Pixel(90, 80, 62), new Pixel(86, 76, 59)},
    };

    imageModel.sepia("redComp", "sepia");
    Image sepiaImage = imageModel.getImage("sepia");
    Pixel[][] sepiaPixels = sepiaImage.getPixels();

    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        assertEquals(expectedPixels3[y][x].getRed(), sepiaPixels[y][x].getRed());
        assertEquals(expectedPixels3[y][x].getGreen(), sepiaPixels[y][x].getGreen());
        assertEquals(expectedPixels3[y][x].getBlue(), sepiaPixels[y][x].getBlue());
      }
    }
  }

  /**
   * Test multiple operations on the image and check each intermediate result.
   */
  @Test
  public void testValueLumaSepiaIntensity() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");

    imageModel.valueComponent("TestImage", "valueImg");

    Image valueImage = imageModel.getImage("valueImg");
    Pixel[][] valuePixels = valueImage.getPixels();

    Pixel[][] expectedPixels2 = {
            {new Pixel(200, 200, 200), new Pixel(210, 210, 210)},
            {new Pixel(220, 220, 220), new Pixel(230, 230, 230)},
    };

    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        assertEquals(expectedPixels2[y][x].getRed(), valuePixels[y][x].getRed());
        assertEquals(expectedPixels2[y][x].getGreen(), valuePixels[y][x].getGreen());
        assertEquals(expectedPixels2[y][x].getBlue(), valuePixels[y][x].getBlue());
      }
    }

    imageModel.valueComponent("valueImg", "lumaImg");

    Image lumaImage = imageModel.getImage("lumaImg");
    Pixel[][] lumaPixels = lumaImage.getPixels();

    Pixel[][] expectedPixels1 = {
            {new Pixel(200, 200, 200), new Pixel(210, 210, 210)},
            {new Pixel(220, 220, 220), new Pixel(230, 230, 230)},
    };

    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        assertEquals(expectedPixels1[y][x].getRed(), lumaPixels[y][x].getRed());
        assertEquals(expectedPixels1[y][x].getGreen(), lumaPixels[y][x].getGreen());
        assertEquals(expectedPixels1[y][x].getBlue(), lumaPixels[y][x].getBlue());
      }
    }

    imageModel.sepia("lumaImg", "sepiaImg");

    Image sepiaImage = imageModel.getImage("sepiaImg");
    Pixel[][] sepiaPixels = sepiaImage.getPixels();

    Pixel[][] expectedPixels3 = {
            {new Pixel(255, 240, 187), new Pixel(255, 252, 196)},
            {new Pixel(255, 255, 206), new Pixel(255, 255, 215)},
    };

    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        assertEquals(expectedPixels3[y][x].getRed(), sepiaPixels[y][x].getRed());
        assertEquals(expectedPixels3[y][x].getGreen(), sepiaPixels[y][x].getGreen());
        assertEquals(expectedPixels3[y][x].getBlue(), sepiaPixels[y][x].getBlue());
      }
    }

    imageModel.intensityComponent("sepiaImg", "intensityImg");

    Image intensityImage = imageModel.getImage("intensityImg");
    Pixel[][] intensityPixels = intensityImage.getPixels();

    Pixel[][] expectedPixels4 = {
            {new Pixel(227, 227, 227), new Pixel(234, 234, 234)},
            {new Pixel(238, 238, 238), new Pixel(241, 241, 241)},
    };

    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        assertEquals(expectedPixels4[y][x].getRed(), intensityPixels[y][x].getRed());
        assertEquals(expectedPixels4[y][x].getGreen(), intensityPixels[y][x].getGreen());
        assertEquals(expectedPixels4[y][x].getBlue(), intensityPixels[y][x].getBlue());
      }
    }
  }

  /**
   * Test brighten negative followed by positive with same value produces the original image.
   */
  @Test
  public void testBrightenNegativePositive() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    int increment = -50;
    imageModel.brightenCommand(increment, "TestImage", "brightenTestImage");

    Image brightenedImage = imageModel.getImage("brightenTestImage");

    for (int y = 0; y < img.getHeight(); y++) {
      for (int x = 0; x < img.getWidth(); x++) {
        Pixel originalPixel = img.getPixel(x, y);
        int expectedRed = Math.min(255, Math.max(0, originalPixel.getRed() + increment));
        int expectedGreen = Math.min(255, Math.max(0, originalPixel.getGreen() + increment));
        int expectedBlue = Math.min(255, Math.max(0, originalPixel.getBlue() + increment));

        Pixel brightenedPixel = brightenedImage.getPixel(x, y);
        assertEquals(expectedRed, brightenedPixel.getRed());
        assertEquals(expectedGreen, brightenedPixel.getGreen());
        assertEquals(expectedBlue, brightenedPixel.getBlue());
      }
    }

    increment = 50;
    imageModel.brightenCommand(increment, "brightenTestImage",
            "brightenTestImage");
    brightenedImage = imageModel.getImage("brightenTestImage");

    for (int y = 0; y < img.getHeight(); y++) {
      for (int x = 0; x < img.getWidth(); x++) {
        Pixel originalPixel = img.getPixel(x, y);
        int expectedRed = Math.min(255, Math.max(0, originalPixel.getRed()));
        int expectedGreen = Math.min(255, Math.max(0, originalPixel.getGreen()));
        int expectedBlue = Math.min(255, Math.max(0, originalPixel.getBlue()));

        Pixel brightenedPixel = brightenedImage.getPixel(x, y);
        assertEquals(expectedRed, brightenedPixel.getRed());
        assertEquals(expectedGreen, brightenedPixel.getGreen());
        assertEquals(expectedBlue, brightenedPixel.getBlue());
      }
    }
  }

  /**
   * Test brighten positive followed by negative with same value produces the original image.
   */
  @Test
  public void testBrightenPositiveNegative() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    int increment = 15;
    imageModel.brightenCommand(increment, "TestImage", "brightenTestImage");

    Image brightenedImage = imageModel.getImage("brightenTestImage");

    for (int y = 0; y < img.getHeight(); y++) {
      for (int x = 0; x < img.getWidth(); x++) {
        Pixel originalPixel = img.getPixel(x, y);
        int expectedRed = Math.min(255, Math.max(0, originalPixel.getRed() + increment));
        int expectedGreen = Math.min(255, Math.max(0, originalPixel.getGreen() + increment));
        int expectedBlue = Math.min(255, Math.max(0, originalPixel.getBlue() + increment));

        Pixel brightenedPixel = brightenedImage.getPixel(x, y);
        assertEquals(expectedRed, brightenedPixel.getRed());
        assertEquals(expectedGreen, brightenedPixel.getGreen());
        assertEquals(expectedBlue, brightenedPixel.getBlue());
      }
    }

    increment = -15;
    imageModel.brightenCommand(increment, "brightenTestImage",
            "brightenTestImage");
    brightenedImage = imageModel.getImage("brightenTestImage");

    for (int y = 0; y < img.getHeight(); y++) {
      for (int x = 0; x < img.getWidth(); x++) {
        Pixel originalPixel = img.getPixel(x, y);
        int expectedRed = Math.min(255, Math.max(0, originalPixel.getRed()));
        int expectedGreen = Math.min(255, Math.max(0, originalPixel.getGreen()));
        int expectedBlue = Math.min(255, Math.max(0, originalPixel.getBlue()));

        Pixel brightenedPixel = brightenedImage.getPixel(x, y);
        assertEquals(expectedRed, brightenedPixel.getRed());
        assertEquals(expectedGreen, brightenedPixel.getGreen());
        assertEquals(expectedBlue, brightenedPixel.getBlue());
      }
    }
  }

  /**
   * Test twice horizontal flip produces the original image.
   */
  @Test
  public void testTwiceHorizontalFlip() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    imageModel.horizontalFlip("TestImage", "hFlipTestImage");

    Image flippedImage = imageModel.getImage("hFlipTestImage");
    int width = img.getWidth();

    for (int y = 0; y < img.getHeight(); y++) {
      for (int x = 0; x < width; x++) {
        assertEquals(img.getPixel(x, y), flippedImage.getPixel(width - 1 - x, y));
      }
    }

    imageModel.horizontalFlip("hFlipTestImage", "hFlipTestImage");
    flippedImage = imageModel.getImage("hFlipTestImage");
    for (int y = 0; y < img.getHeight(); y++) {
      for (int x = 0; x < width; x++) {
        assertEquals(img.getPixel(x, y), flippedImage.getPixel(x, y));
      }
    }
  }

  /**
   * Test twice vertical flip produces the original image.
   */
  @Test
  public void testTwiceVerticalFlip() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    imageModel.verticalFlip("TestImage", "vFlipTestImage");

    Image flippedImage = imageModel.getImage("vFlipTestImage");
    int height = img.getHeight();

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < img.getWidth(); x++) {
        assertEquals(img.getPixel(x, y), flippedImage.getPixel(x, height - 1 - y));
      }
    }

    imageModel.verticalFlip("vFlipTestImage", "vFlipTestImage");
    flippedImage = imageModel.getImage("vFlipTestImage");
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < img.getWidth(); x++) {
        assertEquals(img.getPixel(x, y), flippedImage.getPixel(x, y));
      }
    }
  }

  /**
   * Test rgbSplit produces same components as individual component extract methods.
   */
  @Test
  public void testSplitWithComponents() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    imageModel.redComponent("TestImage", "redComponent");
    imageModel.greenComponent("TestImage", "greenComponent");
    imageModel.blueComponent("TestImage", "blueComponent");
    imageModel.rgbSplit("TestImage", "redSplit",
            "greenSplit", "blueSplit");
    Image redComponent = imageModel.getImage("redComponent");
    Image greenComponent = imageModel.getImage("greenComponent");
    Image blueComponent = imageModel.getImage("blueComponent");
    Image redSplit = imageModel.getImage("redSplit");
    Image greenSplit = imageModel.getImage("greenSplit");
    Image blueSplit = imageModel.getImage("blueSplit");
    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        assertEquals(redComponent.getPixel(x, y).getRed(), redSplit.getPixel(x, y).getRed());
        assertEquals(redComponent.getPixel(x, y).getGreen(), redSplit.getPixel(x, y).getGreen());
        assertEquals(redComponent.getPixel(x, y).getBlue(), redSplit.getPixel(x, y).getBlue());

        assertEquals(greenComponent.getPixel(x, y).getRed(), greenSplit.getPixel(x, y).getRed());
        assertEquals(greenComponent.getPixel(x, y).getGreen(),
                greenSplit.getPixel(x, y).getGreen());
        assertEquals(greenComponent.getPixel(x, y).getBlue(), greenSplit.getPixel(x, y).getBlue());

        assertEquals(blueComponent.getPixel(x, y).getRed(), blueSplit.getPixel(x, y).getRed());
        assertEquals(blueComponent.getPixel(x, y).getGreen(), blueSplit.getPixel(x, y).getGreen());
        assertEquals(blueComponent.getPixel(x, y).getBlue(), blueSplit.getPixel(x, y).getBlue());
      }
    }
  }

  /**
   * Test Horizontal flip followed by Vertical Flip.
   */
  @Test
  public void testHorizontalVerticalFlip() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    imageModel.horizontalFlip("TestImage", "hFlipTestImage");

    Image flippedImage = imageModel.getImage("hFlipTestImage");

    for (int y = 0; y < flippedImage.getHeight(); y++) {
      for (int x = 0; x < flippedImage.getWidth(); x++) {
        assertEquals(img.getPixel(x, y),
                flippedImage.getPixel(flippedImage.getWidth() - 1 - x, y));
      }
    }

    imageModel.verticalFlip("hFlipTestImage", "vFlipTestImage");
    Image flippedImage2 = imageModel.getImage("vFlipTestImage");
    for (int y = 0; y < flippedImage2.getHeight(); y++) {
      for (int x = 0; x < flippedImage2.getWidth(); x++) {
        assertEquals(img.getPixel(x, y),
                flippedImage2.getPixel(flippedImage2.getWidth() - 1 - x,
                        flippedImage2.getHeight() - 1 - y));
      }
    }
  }

  /**
   * Test Vertical flip followed by Horizontal Flip.
   */
  @Test
  public void testVerticalHorizontalFlip() throws IOException {
    Image img = new Image(pixelData);
    imageModel.addImage(img, "TestImage");
    imageModel.verticalFlip("TestImage", "vFlipTestImage");

    Image flippedImage = imageModel.getImage("vFlipTestImage");

    for (int y = 0; y < flippedImage.getHeight(); y++) {
      for (int x = 0; x < flippedImage.getWidth(); x++) {
        assertEquals(img.getPixel(x, y),
                flippedImage.getPixel(x, flippedImage.getHeight() - 1 - y));
      }
    }

    imageModel.horizontalFlip("vFlipTestImage", "hFlipTestImage");
    Image flippedImage2 = imageModel.getImage("hFlipTestImage");
    for (int y = 0; y < flippedImage2.getHeight(); y++) {
      for (int x = 0; x < flippedImage2.getWidth(); x++) {
        assertEquals(img.getPixel(x, y),
                flippedImage2.getPixel(flippedImage2.getWidth() - 1 - x,
                        flippedImage2.getHeight() - 1 - y));
      }
    }
  }
}