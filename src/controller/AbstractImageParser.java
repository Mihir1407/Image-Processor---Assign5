package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.image.Image;
import model.image.Pixel;

/**
 * Provides an abstract implementation of the IImageFileParser
 * interface, defining common methods for loading and saving images
 * from/to disk. Specific image formats provide concrete
 * implementations of this class.
 */
public abstract class AbstractImageParser implements IImageFileParser {

  /**
   * Loads an image from the given path.
   *
   * @param path the path to the image file
   * @return the loaded Image object
   * @throws IOException if an error occurs while reading the file
   */
  @Override
  public Image loadImage(String path) throws IOException {
    BufferedImage bufferedImage = ImageIO.read(new File(path));

    int width = bufferedImage.getWidth();
    int height = bufferedImage.getHeight();

    Image image = new Image(new Pixel[height][width]);

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int argb = bufferedImage.getRGB(x, y);

        int red = (argb >> 16) & 0xff;
        int green = (argb >> 8) & 0xff;
        int blue = argb & 0xff;

        image.setPixel(x, y, new Pixel(red, green, blue));
      }
    }
    return image;
  }

  /**
   * Saves the given image to the specified path.
   *
   * @param path  the path where the image should be saved
   * @param image the Image object to be saved
   * @throws IOException if an error occurs while writing to the file \
   *                     or if the image data is null
   */
  @Override
  public void saveImage(String path, Image image) throws IOException {
    if (image.getPixels() == null) {
      throw new IOException("No image data to save.");
    }

    int height = image.getHeight();
    int width = image.getWidth();

    BufferedImage bufferedImage = new BufferedImage(width, height, getImageType());

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        Pixel pixel = image.getPixel(x, y);

        int red = pixel.getRed();
        int green = pixel.getGreen();
        int blue = pixel.getBlue();

        int argb = (255 << 24) | (red << 16) | (green << 8) | blue;

        bufferedImage.setRGB(x, y, argb);
      }
    }
    ImageIO.write(bufferedImage, getImageFormat(), new File(path));
  }

  /**
   * Returns the image format string appropriate for the implementing class.
   *
   * @return the image format string
   */
  protected abstract String getImageFormat();

  /**
   * Returns the BufferedImage type constant appropriate for the
   * implementing class.
   *
   * @return the image type constant
   */
  protected abstract int getImageType();
}
