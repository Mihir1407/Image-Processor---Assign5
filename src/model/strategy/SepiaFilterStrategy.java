package model.strategy;

import model.image.Image;

/**
 * Implements the FilterStrategy to convert an image to a sepia tone.
 */
public class SepiaFilterStrategy implements FilterStrategy {

  /**
   * Applies a sepia tone filter to the given image. This method utilizes the
   * toSepia method of the Image class to perform the conversion.
   *
   * @param image The image to which the sepia filter is to be applied.
   * @return A new Image instance with a sepia tone applied.
   */
  @Override
  public Image apply(Image image) {
    return image.toSepia();
  }
}
