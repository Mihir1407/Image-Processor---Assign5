package model.strategy;

import model.image.Image;

/**
 * The FilterStrategy interface defines a contract for image
 * processing strategies that can be applied to Image objects.
 */
public interface FilterStrategy {

  /**
   * Applies a specific filtering operation to the provided image and returns the result.
   * The specifics of the filtering operation are determined by the implementing classes.
   *
   * @param image The image to which the filter is to be applied.
   * @return A new Image instance that results from applying the filter to the input image.
   */
  Image apply(Image image);
}
