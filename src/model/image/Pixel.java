package model.image;

/**
 * Represents a pixel in an image, consisting of red, green,
 * and blue color components.
 * Each color component can have a value ranging from 0 to 255.
 */
public class Pixel {
  private int red;
  private int green;
  private int blue;

  /**
   * Constructs a new Pixel with the specified red, green,
   * and blue color values.
   * The color values are clamped to ensure they lie
   * between 0 and 255.
   *
   * @param red   the red color component (0-255)
   * @param green the green color component (0-255)
   * @param blue  the blue color component (0-255)
   */
  public Pixel(int red, int green, int blue) {
    this.red = clamp(red);
    this.green = clamp(green);
    this.blue = clamp(blue);
  }

  /**
   * Clamps the given value between 0 and 255.
   *
   * @param value the value to be clamped
   * @return the clamped value, ensuring it's within the range [0, 255]
   */
  private int clamp(int value) {
    return Math.max(0, Math.min(value, 255));
  }

  /**
   * Returns the red color component of this pixel.
   *
   * @return the red color value (0-255)
   */
  public int getRed() {
    return red;
  }

  /**
   * Returns the green color component of this pixel.
   *
   * @return the green color value (0-255)
   */
  public int getGreen() {
    return green;
  }

  /**
   * Returns the blue color component of this pixel.
   *
   * @return the blue color value (0-255)
   */
  public int getBlue() {
    return blue;
  }

}
