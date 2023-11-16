package model.strategy;

import model.image.Image;

/**
 * A concrete implementation of the FilterStrategy that applies a blur effect to an image.
 * This strategy uses the blur method of the Image class to perform the operation.
 */
public class BlurFilterStrategy implements FilterStrategy {

  /**
   * Applies a blur effect to the given image.
   * This method delegates the blurring process to the blur method of the Image class.
   * The result is a new Image instance with the blur effect applied.
   *
   * @param image The image to which the blur effect is to be applied.
   * @return A new Image instance with the blur effect applied.
   */
  @Override
  public Image apply(Image image) {
    return image.blur();
  }
}
