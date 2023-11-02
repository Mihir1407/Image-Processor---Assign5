package controller;

import java.awt.image.BufferedImage;

/**
 * Provides a concrete implementation of the AbstractImageParser
 * for the JPG image format.
 */
public class JPGParser extends AbstractImageParser {

  /**
   * Returns the image format string for the JPG format.
   *
   * @return the string "jpg" denoting the image format
   */
  @Override
  protected String getImageFormat() {
    return "jpg";
  }

  /**
   * Returns the BufferedImage type constant suitable for JPG images.
   *
   * @return the constant BufferedImage.TYPE_INT_RGB
   */
  @Override
  protected int getImageType() {
    return BufferedImage.TYPE_INT_RGB;
  }
}
