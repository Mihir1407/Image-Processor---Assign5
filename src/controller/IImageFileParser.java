package controller;

import java.io.IOException;

import model.image.Image;

/**
 * Interface for image file parsing operations.
 * Provides methods for loading an image from a file and
 * saving an image to a file.
 */
public interface IImageFileParser {

  /**
   * Loads an image from a specified path.
   *
   * @param path The path from which to load the image.
   * @return The loaded image as an IImage object.
   * @throws IOException If there's an error during the loading process.
   */
  Image loadImage(String path) throws IOException;

  /**
   * Saves an IImage object to a specified path.
   *
   * @param path  The path where the image should be saved.
   * @param image The IImage object to be saved.
   * @throws IOException If there's an error during the saving process.
   */
  void saveImage(String path, Image image) throws IOException;
}
