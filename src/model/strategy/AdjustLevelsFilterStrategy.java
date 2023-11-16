package model.strategy;

import model.image.Image;

/**
 * Implements the FilterStrategy to apply a levels adjustment to an image.
 * Levels adjustment alters the intensity of the shadows, midtones, and highlights of an image.
 */
public class AdjustLevelsFilterStrategy implements FilterStrategy {
  private final int b;
  private final int m;
  private final int w;

  /**
   * Constructs an AdjustLevelsFilterStrategy with specified values for shadows, midtones,
   * and highlights.
   *
   * @param b The black point value for shadows, must be in the range [0, 255] and less than
   *          'm' and 'w'.
   * @param m The midpoint value for midtones, must be in the range [0, 255] and greater than
   *          'b' and less than 'w'.
   * @param w The white point value for highlights, must be in the range [0, 255] and greater
   *          than 'b' and 'm'.
   */
  public AdjustLevelsFilterStrategy(int b, int m, int w) {
    this.b = b;
    this.m = m;
    this.w = w;
  }

  /**
   * Applies the levels adjustment to the given image using the shadow, midtone, and highlight
   * values provided at construction. The result is a new image with adjusted intensity levels.
   *
   * @param image The image to which the levels adjustment is to be applied.
   * @return A new Image instance with adjusted levels.
   */
  @Override
  public Image apply(Image image) {
    return image.adjustLevels(b, m, w);
  }
}
