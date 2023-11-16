package model.strategy;

import model.image.Image;

/**
 * A concrete implementation of the FilterStrategy for performing color correction on an image.
 * Color correction typically involves adjusting the balance of color components to achieve a more
 * natural or desired color representation.
 */
public class ColorCorrectFilterStrategy implements FilterStrategy {

  /**
   * Applies color correction to the given image.
   *
   * @param image The image to which color correction is to be applied.
   * @return A new Image instance with color correction applied.
   */
  @Override
  public Image apply(Image image) {
    return image.colorCorrect();
  }
}
