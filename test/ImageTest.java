import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import model.image.Image;
import model.image.Pixel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * JUnit test class for the Image class.
 */
public class ImageTest {

  /**
   * The Image instance to be used for testing.
   */
  private Image image;

  /**
   * The sample pixel data used for constructing the Image instance.
   */
  private Pixel[][] pixelData;

  /**
   * Sets up an Image instance with specific Pixel data for all the test cases.
   */
  @Before
  public void setUp() {
    pixelData = new Pixel[][]{
            {new Pixel(100, 150, 200), new Pixel(110, 160, 210)},
            {new Pixel(120, 170, 220), new Pixel(130, 180, 230)}
    };
    image = new Image(pixelData);
  }

  /**
   * Tests that the constructor correctly initializes an instance of the Image class.
   */
  @Test
  public void testConstructor() {
    assertNotNull(image);
  }

  /**
   * Tests the getPixels() method of the Image class.
   * Ensures it returns the correct 2D Pixel array.
   */
  @Test
  public void testGetPixels() {
    Pixel[][] pixels = image.getPixels();
    assertEquals(pixelData, pixels);
  }

  /**
   * Tests the getWidth() method of the Image class.
   * Ensures it returns the correct width of the image.
   */
  @Test
  public void testGetWidth() {
    assertEquals(2, image.getWidth());
  }

  /**
   * Tests the getHeight() method of the Image class.
   * Ensures it returns the correct height of the image.
   */
  @Test
  public void testGetHeight() {
    assertEquals(2, image.getHeight());
  }

  /**
   * Tests the getPixel() method of the Image class.
   * Ensures it returns the correct Pixel from the specified position.
   */
  @Test
  public void testGetPixel() {
    Pixel pixel = image.getPixel(1, 0);
    assertEquals(110, pixel.getRed());
    assertEquals(160, pixel.getGreen());
    assertEquals(210, pixel.getBlue());
  }

  /**
   * Tests the setPixel() method of the Image class.
   * Ensures it sets the correct Pixel at the specified position.
   */
  @Test
  public void testSetPixel() {
    Pixel newPixel = new Pixel(140, 190, 240);
    image.setPixel(1, 1, newPixel);

    Pixel retrievedPixel = image.getPixel(1, 1);
    assertEquals(140, retrievedPixel.getRed());
    assertEquals(190, retrievedPixel.getGreen());
    assertEquals(240, retrievedPixel.getBlue());
  }

  /**
   * Tests the getPixel() method of the Image class with invalid x-coordinate.
   * Ensures it throws an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetPixelInvalidXCoordinate() {
    image.getPixel(-1, 0);
  }

  /**
   * Tests the getPixel() method of the Image class with invalid y-coordinate.
   * Ensures it throws an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetPixelInvalidYCoordinate() {
    image.getPixel(0, -1);
  }

  /**
   * Tests the getPixel() method of the Image class with x-coordinate out of bounds.
   * Ensures it throws an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetPixelXCoordinateOutOfBounds() {
    image.getPixel(2, 0);
  }

  /**
   * Tests the getPixel() method of the Image class with y-coordinate out of bounds.
   * Ensures it throws an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetPixelYCoordinateOutOfBounds() {
    image.getPixel(0, 2);
  }

  /**
   * Tests the setPixel() method of the Image class with invalid x-coordinate.
   * Ensures it throws an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetPixelInvalidXCoordinate() {
    Pixel newPixel = new Pixel(140, 190, 240);
    image.setPixel(-1, 0, newPixel);
  }

  /**
   * Tests the setPixel() method of the Image class with invalid y-coordinate.
   * Ensures it throws an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetPixelInvalidYCoordinate() {
    Pixel newPixel = new Pixel(140, 190, 240);
    image.setPixel(0, -1, newPixel);
  }

  /**
   * Tests the setPixel() method of the Image class with x-coordinate out of bounds.
   * Ensures it throws an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetPixelXCoordinateOutOfBounds() {
    Pixel newPixel = new Pixel(140, 190, 240);
    image.setPixel(2, 0, newPixel);
  }

  /**
   * Tests the setPixel() method of the Image class with y-coordinate out of bounds.
   * Ensures it throws an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetPixelYCoordinateOutOfBounds() {
    Pixel newPixel = new Pixel(140, 190, 240);
    image.setPixel(0, 2, newPixel);
  }

  /**
   * Test to check horizontal flip operation on an image.
   */
  @Test
  public void testHorizontalFlip() {
    Image flippedImage = image.horizontalFlip();
    int width = image.getWidth();

    for (int y = 0; y < image.getHeight(); y++) {
      for (int x = 0; x < width; x++) {
        Pixel expectedPixel = image.getPixel(x, y);
        Pixel actualPixel = flippedImage.getPixel(width - 1 - x, y);
        assertEquals(expectedPixel, actualPixel);
      }
    }
  }

  /**
   * Test to check vertical flip operation on an image.
   */
  @Test
  public void testVerticalFlip() {
    Image flippedImage = image.verticalFlip();
    int height = image.getHeight();

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < image.getWidth(); x++) {
        Pixel expectedPixel = image.getPixel(x, y);
        Pixel actualPixel = flippedImage.getPixel(x, height - 1 - y);
        assertEquals(expectedPixel, actualPixel);
      }
    }
  }

  /**
   * Test to check brightening operation on an image.
   */
  @Test
  public void testBrighten() {
    Image originalImage = new Image(pixelData);
    int increment = 50;
    Image brightenedImage = originalImage.brighten(increment);

    for (int y = 0; y < originalImage.getHeight(); y++) {
      for (int x = 0; x < originalImage.getWidth(); x++) {
        Pixel originalPixel = originalImage.getPixel(x, y);
        Pixel brightenedPixel = brightenedImage.getPixel(x, y);

        int expectedRed = Math.min(Math.max(originalPixel.getRed() + increment, 0), 255);
        int expectedGreen = Math.min(Math.max(originalPixel.getGreen() + increment, 0), 255);
        int expectedBlue = Math.min(Math.max(originalPixel.getBlue() + increment, 0), 255);

        assertEquals(expectedRed, brightenedPixel.getRed());
        assertEquals(expectedGreen, brightenedPixel.getGreen());
        assertEquals(expectedBlue, brightenedPixel.getBlue());
      }
    }
  }

  /**
   * Test to check brightening (decrement) operation on an image.
   */
  @Test
  public void testBrightenDecrement() {
    Image originalImage = new Image(pixelData);
    int decrement = -101;
    Image dimmedImage = originalImage.brighten(decrement);

    for (int y = 0; y < originalImage.getHeight(); y++) {
      for (int x = 0; x < originalImage.getWidth(); x++) {
        Pixel originalPixel = originalImage.getPixel(x, y);
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
   * Test to check blur operation on an image.
   */
  @Test
  public void testBlur() {
    Pixel[][] samplePixels = {
            {new Pixel(255, 0, 0), new Pixel(0, 255, 0),
                    new Pixel(0, 0, 255)},
            {new Pixel(0, 255, 0), new Pixel(0, 0, 255),
                    new Pixel(255, 0, 0)},
            {new Pixel(0, 0, 255), new Pixel(255, 0, 0),
                    new Pixel(0, 255, 0)}
    };
    Image img = new Image(samplePixels);

    Image blurredImage = img.blur();
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
   * Test to check sharpen operation on an image.
   */
  @Test
  public void testSharpen() {
    Pixel[][] samplePixels = {
            {new Pixel(255, 0, 0), new Pixel(0, 255, 0),
                    new Pixel(0, 0, 255)},
            {new Pixel(0, 255, 0), new Pixel(0, 0, 255),
                    new Pixel(255, 0, 0)},
            {new Pixel(0, 0, 255), new Pixel(255, 0, 0),
                    new Pixel(0, 255, 0)}
    };
    Image img = new Image(samplePixels);
    Image sharpenedImage = img.sharpen();
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
   * Test to check Red Component operation on an image.
   */
  @Test
  public void testRedComponentExtraction() {
    Image img = new Image(pixelData);
    Image redComponentImage = img.extractRedComponent();
    for (int y = 0; y < redComponentImage.getHeight(); y++) {
      for (int x = 0; x < redComponentImage.getWidth(); x++) {
        Pixel redPixel = redComponentImage.getPixel(x, y);
        assertEquals(pixelData[y][x].getRed(), redPixel.getRed());
        assertEquals(0, redPixel.getGreen());
        assertEquals(0, redPixel.getBlue());
      }
    }
  }

  /**
   * Test to check Green Component operation on an image.
   */
  @Test
  public void testGreenComponentExtraction() {
    Image img = new Image(pixelData);
    Image greenComponentImage = img.extractGreenComponent();
    for (int y = 0; y < greenComponentImage.getHeight(); y++) {
      for (int x = 0; x < greenComponentImage.getWidth(); x++) {
        Pixel greenPixel = greenComponentImage.getPixel(x, y);
        assertEquals(pixelData[y][x].getGreen(), greenPixel.getGreen());
        assertEquals(0, greenPixel.getRed());
        assertEquals(0, greenPixel.getBlue());
      }
    }
  }

  /**
   * Test to check Blue Component operation on an image.
   */
  @Test
  public void testBlueComponentExtraction() {
    Image img = new Image(pixelData);
    Image blueComponentImage = img.extractBlueComponent();
    for (int y = 0; y < blueComponentImage.getHeight(); y++) {
      for (int x = 0; x < blueComponentImage.getWidth(); x++) {
        Pixel bluePixel = blueComponentImage.getPixel(x, y);
        assertEquals(pixelData[y][x].getBlue(), bluePixel.getBlue());
        assertEquals(0, bluePixel.getRed());
        assertEquals(0, bluePixel.getGreen());
      }
    }
  }

  /**
   * Test to check Luma Component operation on an image.
   */
  @Test
  public void testLumaComponentConversion() {
    Image img = new Image(pixelData);
    Image lumaImage = img.toLumaComponent();
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
   * Test to check Value Component operation on an image.
   */
  @Test
  public void testValueComponentConversion() {
    Image img = new Image(pixelData);
    Image valueComponentImage = img.toValueComponent();
    for (int y = 0; y < valueComponentImage.getHeight(); y++) {
      for (int x = 0; x < valueComponentImage.getWidth(); x++) {
        Pixel originalPixel = img.getPixel(x, y);
        int value = Math.max(Math.max(originalPixel.getRed(), originalPixel.getGreen()), originalPixel.getBlue());
        Pixel valuePixel = valueComponentImage.getPixel(x, y);
        assertEquals(value, valuePixel.getRed());
        assertEquals(value, valuePixel.getGreen());
        assertEquals(value, valuePixel.getBlue());
      }
    }
  }

  /**
   * Test to check Intensity Component operation on an image.
   */
  @Test
  public void testIntensityComponentConversion() {
    Image img = new Image(pixelData);
    Image intensityComponentImage = img.toIntensityComponent();
    for (int y = 0; y < intensityComponentImage.getHeight(); y++) {
      for (int x = 0; x < intensityComponentImage.getWidth(); x++) {
        Pixel originalPixel = img.getPixel(x, y);
        int intensity = (int) Math.round(
                (originalPixel.getRed() + originalPixel.getGreen() + originalPixel.getBlue()) / 3.0);
        Pixel intensityPixel = intensityComponentImage.getPixel(x, y);
        assertEquals(intensity, intensityPixel.getRed());
        assertEquals(intensity, intensityPixel.getGreen());
        assertEquals(intensity, intensityPixel.getBlue());
      }
    }
  }

  /**
   * Test to check Sepia Component operation on an image.
   */
  @Test
  public void testSepiaComponentConversion() {
    Image img = new Image(pixelData);

    Image sepiaImage = img.toSepia();

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
   * Test to check Color Correction operation on an image.
   */
  @Test
  public void testColorCorrectImageProcessing() {
    Image img = new Image(pixelData);

    Image colorCorrectImage = img.colorCorrect();
    Pixel[][] expectedPixelData = new Pixel[][]{
            {new Pixel(150, 150, 150), new Pixel(160, 160, 160)},
            {new Pixel(170, 170, 170), new Pixel(180, 180, 180)}
    };

    for (int y = 0; y < colorCorrectImage.getHeight(); y++) {
      for (int x = 0; x < colorCorrectImage.getWidth(); x++) {
        Pixel expectedPixel = expectedPixelData[y][x];
        Pixel actualPixel = colorCorrectImage.getPixel(x, y);
        assertEquals(expectedPixel.getRed(), actualPixel.getRed());
        assertEquals(expectedPixel.getGreen(), actualPixel.getGreen());
        assertEquals(expectedPixel.getBlue(), actualPixel.getBlue());
      }
    }
  }

  /**
   * Test to check Level Adjustment operation on an image.
   */
  @Test
  public void testAdjustLevelsImageProcessing() {
    Image img = new Image(pixelData);

    int b = 20;
    int m = 50;
    int w = 100;

    Image adjustedImage = img.adjustLevels(b,m,w);
    Pixel[][] expectedPixelData = new Pixel[][]{
            {new Pixel(255, 255, 185), new Pixel(255, 255, 154)},
            {new Pixel(255, 251, 119), new Pixel(255, 233, 80)}
    };

    for (int y = 0; y < adjustedImage.getHeight(); y++) {
      for (int x = 0; x < adjustedImage.getWidth(); x++) {
        Pixel expectedPixel = expectedPixelData[y][x];
        Pixel actualPixel = adjustedImage.getPixel(x, y);
        assertEquals(expectedPixel.getRed(), actualPixel.getRed());
        assertEquals(expectedPixel.getGreen(), actualPixel.getGreen());
        assertEquals(expectedPixel.getBlue(), actualPixel.getBlue());
      }
    }
  }

  /**
   * Test to check invalid input for adjust level operation on an image.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAdjustLevelsInvalidInputOutOfRange() {
    Image image = new Image(pixelData);
    image.adjustLevels(-1, 128, 256);
  }

  /**
   * Test to check invalid input for adjust level operation on an image.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAdjustLevelsInvalidInputNotAscending() {
    Image image = new Image(pixelData);
    image.adjustLevels(50, 30, 40);
  }

  /**
   * Test to check compress operation on an image.
   */
  @Test
  public void testCompressImageProcessing() {
    Image img = new Image(pixelData);
    int percentage = 50;

    Image compressedImage = img.compress(percentage);
    Pixel[][] expectedPixelData = new Pixel[][]{
            {new Pixel(115, 165, 215), new Pixel(115, 165, 215)},
            {new Pixel(115, 165, 215), new Pixel(115, 165, 215)}
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
   * Test to check Level Adjustment operation on an image.
   */
  @Test
  public void testCompressImageProcessing4X2() {
    pixelData = new Pixel[][]{
            {new Pixel(100, 150, 200), new Pixel(110, 160, 210),
                    new Pixel(120, 170, 220),
                    new Pixel(130, 180, 230)},
            {new Pixel(140, 190, 240), new Pixel(150, 200, 250),
                    new Pixel(160, 210, 260),
                    new Pixel(170, 220, 270)}
    };
    Image img = new Image(pixelData);
    int percentage = 50;
    Image compressedImage = img.compress(percentage);

    Pixel[][] expectedPixelData = new Pixel[][]{
            {new Pixel(105, 155, 225), new Pixel(105, 155, 225),
                    new Pixel(125, 175, 240),
                    new Pixel(125, 175, 240)},
            {new Pixel(145, 195, 225), new Pixel(145, 195, 225),
                    new Pixel(165, 215, 240),
                    new Pixel(165, 215, 240)}
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
   * Test that rgbCombine method combines red, green and blue components into rgb color image.
   */
  @Test
  public void testRgbCombine() throws IOException {
    Pixel[][] redPixels = {
            {new Pixel(255, 0, 0), new Pixel(255, 0, 0)},
            {new Pixel(255, 0, 0), new Pixel(255, 0, 0)}
    };
    Image redImage = new Image(redPixels);

    Pixel[][] greenPixels = {
            {new Pixel(0, 255, 0), new Pixel(0, 255, 0)},
            {new Pixel(0, 255, 0), new Pixel(0, 255, 0)}
    };
    Image greenImage = new Image(greenPixels);

    Pixel[][] bluePixels = {
            {new Pixel(0, 0, 255), new Pixel(0, 0, 255)},
            {new Pixel(0, 0, 255), new Pixel(0, 0, 255)}
    };
    Image blueImage = new Image(bluePixels);

    Image combinedImage = Image.combineColorChannels(redImage,greenImage,blueImage);
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
   * Test to check Multiple Operations on an image.
   */
  @Test
  public void testValueHorizontalFlipRedComponentSepia() throws IOException {
    Image img = new Image(pixelData);

    Image valueImage = img.toValueComponent();
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
    Image hFlipImage = valueImage.horizontalFlip();
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

    Image redCompImage = hFlipImage.extractRedComponent();
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
    Image sepiaImage = redCompImage.toSepia();
    Pixel[][] sepiaPixels = sepiaImage.getPixels();
    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        assertEquals(expectedPixels3[y][x].getRed(), sepiaPixels[y][x].getRed());
        assertEquals(expectedPixels3[y][x].getGreen(), sepiaPixels[y][x].getGreen());
        assertEquals(expectedPixels3[y][x].getBlue(), sepiaPixels[y][x].getBlue());
      }
    }
  }
}
