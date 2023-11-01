import org.junit.Before;
import org.junit.Test;

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
}
