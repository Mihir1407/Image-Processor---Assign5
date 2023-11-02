package model.image;

import java.awt.image.RenderedImage;

/**
 * Represents a 2D image composed of pixels.
 * Provides methods to get pixel data, retrieve the width and
 * height of the image, and set pixel values.
 */
public class Image {
  private Pixel[][] pixels;

  /**
   * Constructs a new Image with the specified 2D array of pixels.
   *
   * @param pixels a 2D array of Pixel objects representing the image data
   */
  public Image(Pixel[][] pixels) {
    this.pixels = pixels;
  }

  /**
   * Returns the 2D array of pixels that make up this image.
   *
   * @return the 2D array of Pixel objects
   */
  public Pixel[][] getPixels() {
    return pixels;
  }

  /**
   * Retrieves the pixel at the specified (x, y) position.
   * Throws an IllegalArgumentException if the x and y coordinates are outside
   * the bounds of the image dimensions.
   *
   * @param x the x-coordinate of the desired pixel
   * @param y the y-coordinate of the desired pixel
   * @return the Pixel object at the specified position
   * @throws IllegalArgumentException if x or y coordinates are out of bounds
   */
  public Pixel getPixel(int x, int y) throws IllegalArgumentException {
    if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
      throw new IllegalArgumentException("Coordinates out of bounds!");
    }
    return pixels[y][x];
  }

  /**
   * Returns the width of this image.
   *
   * @return the width of the image in pixels
   */
  public int getWidth() {
    return pixels[0].length;
  }

  /**
   * Returns the height of this image.
   *
   * @return the height of the image in pixels
   */
  public int getHeight() {
    return pixels.length;
  }

  /**
   * Sets the pixel value at the specified (x, y) position.
   * Throws an IllegalArgumentException if the x and y
   * coordinates are outside the bounds of the image dimensions.
   *
   * @param x     the x-coordinate of the pixel to be set
   * @param y     the y-coordinate of the pixel to be set
   * @param pixel the new Pixel object to be placed at the specified position
   * @throws IllegalArgumentException if x or y coordinates are out of bounds
   */
  public void setPixel(int x, int y, Pixel pixel) {
    if (x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
      throw new IllegalArgumentException("Coordinates out of bounds!");
    }
    pixels[y][x] = pixel;
  }

}
