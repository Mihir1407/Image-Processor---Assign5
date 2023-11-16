package model.strategy;

import model.image.Image;

/**
 * Implements the FilterStrategy interface to apply a sharpening filter to an image.
 */
public class SharpenFilterStrategy implements FilterStrategy {

  /**
   * Applies a sharpening filter to the given image.
   *
   * @param image The image to which the sharpening filter is to be applied.
   * @return A new Image instance with the sharpening effect applied, enhancing edges
   *         and details to make the image appear more defined.
   */
  @Override
  public Image apply(Image image) {
    return image.sharpen();
  }
}
