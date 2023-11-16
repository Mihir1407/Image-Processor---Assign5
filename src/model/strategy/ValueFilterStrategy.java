package model.strategy;

import model.image.Image;

/**
 * Implements the FilterStrategy interface to convert an image to its value component.
 */
public class ValueFilterStrategy implements FilterStrategy {

  /**
   * Applies a filter to the given image to extract the value component from each pixel.
   * The value is the highest value of the three color channels (red, green, and blue).
   * This method uses the toValueComponent method of the Image class to create a new image
   * representing the value of the original image's colors.
   *
   * @param image The image to be converted to its value component.
   * @return A new Image instance that represents the value component of the original image.
   */
  @Override
  public Image apply(Image image) {
    return image.toValueComponent();
  }
}
