import org.junit.Before;
import org.junit.Test;

import model.image.Pixel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * JUnit test class for the Pixel class.
 */
public class PixelTest {

  /**
   * The Pixel instance to be used for testing.
   */
  private Pixel pixel;

  /**
   * Sets up a common Pixel instance with specific RGB values for all the test cases.
   */
  @Before
  public void setUp() {
    pixel = new Pixel(100, 150, 200);
  }

  /**
   * Tests that the constructor correctly initializes an instance of the Pixel class.
   */
  @Test
  public void testConstructor() {
    assertNotNull(pixel);
  }

  /**
   * Tests the getRed() method of the Pixel class.
   * Ensures it returns the correct red color component value.
   */
  @Test
  public void testGetRed() {
    assertEquals(100, pixel.getRed());
  }

  /**
   * Tests the getGreen() method of the Pixel class.
   * Ensures it returns the correct green color component value.
   */
  @Test
  public void testGetGreen() {
    assertEquals(150, pixel.getGreen());
  }

  /**
   * Tests the getBlue() method of the Pixel class.
   * Ensures it returns the correct blue color component value.
   */
  @Test
  public void testGetBlue() {
    assertEquals(200, pixel.getBlue());
  }

  /**
   * Tests that the constructor correctly clamps values above 255 down to 255.
   */
  @Test
  public void testClampingUpperBound() {
    Pixel clampedPixel = new Pixel(300, 400, 500);
    assertEquals(255, clampedPixel.getRed());
    assertEquals(255, clampedPixel.getGreen());
    assertEquals(255, clampedPixel.getBlue());
  }

  /**
   * Tests that the constructor correctly clamps values below 0 up to 0.
   */
  @Test
  public void testClampingLowerBound() {
    Pixel clampedPixel = new Pixel(-10, -20, -30);
    assertEquals(0, clampedPixel.getRed());
    assertEquals(0, clampedPixel.getGreen());
    assertEquals(0, clampedPixel.getBlue());
  }
}
