package model;

import java.io.IOException;

import model.image.Image;

/**
 * Represents an interface for image processing operations.
 * This interface provides methods for loading, saving, and
 * applying various transformations and effects on images.
 */
public interface IImageModel {

  /**
   * Loads an image into the model.
   *
   * @param image The name assigned to the loaded image.
   * @param imagePath The path to the image.
   * @throws IOException If an error occurs during the reading process.
   */
  void addImage(Image image, String imagePath) throws IOException;

  /**
   * Saves the image to a specified location.
   *
   * @param imageName The name of the image to save.
   * @throws IOException If an error occurs during the saving process.
   */
  Image getImage(String imageName) throws IOException;

  /**
   * Extracts the red component of the image.
   *
   * @param imageName The name of the image.
   * @param destImageName The path where the red component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  void redComponent(String imageName, String destImageName) throws IOException;

  /**
   * Extracts the green component of the image.
   *
   * @param imageName The name of the image.
   * @param destImageName The path where the green component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  void greenComponent(String imageName, String destImageName) throws IOException;

  /**
   * Extracts the blue component of the image.
   *
   * @param imageName The name of the image.
   * @param destImageName The path where the blue component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  void blueComponent(String imageName, String destImageName) throws IOException;

  /**
   * Extracts the value component of the image.
   *
   * @param imageName The name of the image.
   * @param destImageName The path where the value component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  void valueComponent(String imageName, String destImageName) throws IOException;

  /**
   * Extracts the luma component of the image.
   *
   * @param imageName The name of the image.
   * @param destImageName The path where the luma component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  void lumaComponent(String imageName, String destImageName) throws IOException;

  /**
   * Extracts the intensity component of the image.
   *
   * @param imageName The name of the image.
   * @param destImageName The path where the intensity component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  void intensityComponent(String imageName, String destImageName) throws IOException;

  /**
   * Applies horizontal flip effect on the image.
   *
   * @param imageName The name of the image.
   * @param destImageName The path where the intensity component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  void horizontalFlip(String imageName, String destImageName) throws IOException;

  /**
   * Applies brightening(increment/decrement) effect on the image.
   *
   * @param imageName The name of the image.
   * @param destImageName The path where the intensity component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  void brightenCommand(int increment, String imageName, String destImageName) throws IOException;

  /**
   * Applies blur effect on the image.
   *
   * @param imageName The name of the image.
   * @param destImageName The path where the intensity component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  void blur(String imageName, String destImageName) throws IOException;

  /**
   * Applies sharpening effect on the image.
   *
   * @param imageName The name of the image.
   * @param destImageName The path where the intensity component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  void sharpen(String imageName, String destImageName) throws IOException;

  /**
   * Applies vertical flip effect on the image.
   *
   * @param imageName The name of the image.
   * @param destImageName The path where the intensity component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  void verticalFlip(String imageName, String destImageName) throws IOException;

  /**
   * Extracts the sepia component of the image.
   *
   * @param imageName The name of the image.
   * @param destImageName The path where the intensity component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  void sepia(String imageName, String destImageName) throws IOException;

  /**
   * Splits the RGB components of an image into three separate images
   * Red, Green, and Blue channels.
   *
   * @param imageName          The name of the source image to be split.
   * @param destImageNameRed   The name of the destination image for the Red channel.
   * @param destImageNameGreen The name of the destination image for the Green channel.
   * @param destImageNameBlue  The name of the destination image for the Blue channel.
   * @throws IOException       If an error occurs during the process.
   */
  void rgbSplit(String imageName, String destImageNameRed, String destImageNameGreen,
                String destImageNameBlue) throws IOException;

  /**
   * Combines three images representing the Red, Green, and Blue channels
   * into a single RGB image.
   *
   * @param redImageName     The name of the source image for the Red channel.
   * @param greenImageName   The name of the source image for the Green channel.
   * @param blueImageName    The name of the source image for the Blue channel.
   * @param destImageName    The name of the combined destination RGB image.
   * @throws IOException     If an error occurs during the process.
   */
  void rgbCombine(String redImageName, String greenImageName, String blueImageName, String destImageName) throws IOException;
}
