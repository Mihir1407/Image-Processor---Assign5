package controller;

import java.awt.image.BufferedImage;

/**
 * Provides a concrete implementation of the AbstractImageParser
 * for the PNG image format.
 */
public class PNGParser extends AbstractImageParser {

  /**
   * Returns the image format string for the PNG format.
   *
   * @return the string "png" denoting the image format
   */
  @Override
  protected String getImageFormat() {
    return "png";
  }

  /**
   * Returns the BufferedImage type constant suitable for PNG images.
   * PNG images support transparency, hence the ARGB type is used.
   *
   * @return the constant BufferedImage.TYPE_INT_ARGB
   */
  @Override
  protected int getImageType() {
    return BufferedImage.TYPE_INT_RGB;
  }
}
