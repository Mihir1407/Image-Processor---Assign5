package controller;

import java.awt.image.BufferedImage;

/**
 * Provides a concrete implementation of the AbstractImageParser
 * for the JPEG image format.
 */
public class JPEGParser extends AbstractImageParser {

  /**
   * Returns the image format string for the JPEG format.
   *
   * @return the string "jpeg" denoting the image format
   */
  @Override
  protected String getImageFormat() {
    return "jpeg";
  }

  /**
   * Returns the BufferedImage type constant suitable for JPEG images.
   *
   * @return the constant BufferedImage.TYPE_INT_RGB
   */
  @Override
  protected int getImageType() {
    return BufferedImage.TYPE_INT_RGB;
  }
}
