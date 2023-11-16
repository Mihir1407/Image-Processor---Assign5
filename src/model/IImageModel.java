package model;

import java.io.IOException;
import java.util.Optional;

import model.image.Image;

/**
 * Represents an interface for image processing operations.
 * This interface provides methods for loading, saving, and
 * applying various transformations and effects on images.
 */
public interface IImageModel {

  /**
   * Adds a new image into the model.
   *
   * @param image     The image to be added into the model.
   * @param imageName The name by which the image should be stored.
   * @throws IOException If the image to be added to the model is null.
   */

  void addImage(Image image, String imageName) throws IOException;

  /**
   * Retrieves an image with provided name from the model.
   *
   * @param imageName The name of the image to be retrieved.
   * @throws IOException If the image to be retrieved does not exist in the model.
   */
  Image getImage(String imageName) throws IOException;

  /**
   * Extracts the red component of the image.
   *
   * @param imageName     The name of the source image.
   * @param destImageName The path where the red component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  void redComponent(String imageName, String destImageName) throws IOException;

  /**
   * Extracts the green component of the image.
   *
   * @param imageName     The name of the source image.
   * @param destImageName The path where the green component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  void greenComponent(String imageName, String destImageName) throws IOException;

  /**
   * Extracts the blue component of the image.
   *
   * @param imageName     The name of the source image.
   * @param destImageName The path where the blue component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  void blueComponent(String imageName, String destImageName) throws IOException;

  /**
   * Extracts the value component of the image.
   *
   * @param imageName     The name of the source image.
   * @param destImageName The path where the value component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  void valueComponent(String imageName, String destImageName, Optional<Double> splitPercentageOpt)
          throws IOException;

  /**
   * Extracts the luma component of the image.
   *
   * @param imageName     The name of the source image.
   * @param destImageName The path where the luma component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  void lumaComponent(String imageName, String destImageName, Optional<Double> splitPercentageOpt)
          throws IOException;

  /**
   * Extracts the intensity component of the image.
   *
   * @param imageName     The name of the source image.
   * @param destImageName The path where the intensity component image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  void intensityComponent(String imageName, String destImageName,
                          Optional<Double> splitPercentageOpt) throws IOException;

  /**
   * Applies sepia effect on the image with an optional split percentage.
   *
   * @param imageName          The name of the source image.
   * @param destImageName      The path where the sepia image should be saved.
   * @param splitPercentageOpt An optional split percentage for sepia effect.
   * @throws IOException If an error occurs during the process.
   */
  void sepia(String imageName, String destImageName, Optional<Double> splitPercentageOpt)
          throws IOException;

  /**
   * Applies sepia effect on the image.
   *
   * @param imageName     The name of the source image.
   * @param destImageName The path where the sepia image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  void horizontalFlip(String imageName, String destImageName) throws IOException;

  /**
   * Applies vertical flip effect on the image.
   *
   * @param imageName     The name of the source image.
   * @param destImageName The path where the vertically flipped image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  void verticalFlip(String imageName, String destImageName) throws IOException;

  /**
   * Applies brightening (increment/decrement) effect on the image.
   *
   * @param increment     The amount of brightness adjustment.
   * @param imageName     The name of the source image.
   * @param destImageName The path where the brightened image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  void brightenCommand(int increment, String imageName, String destImageName) throws IOException;

  /**
   * Applies blur effect on the image.
   *
   * @param imageName     The name of the source image.
   * @param destImageName The path where the blurred image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  void blur(String imageName, String destImageName, Optional<Double> splitPercentageOpt)
          throws IOException;

  /**
   * Applies sharpening effect on the image.
   *
   * @param imageName     The name of the source image.
   * @param destImageName The path where the sharpened image should be saved.
   * @throws IOException If an error occurs during the process.
   */
  void sharpen(String imageName, String destImageName, Optional<Double> splitPercentageOpt)
          throws IOException;

  /**
   * Splits the RGB components of an image into three separate images
   * Red, Green, and Blue channels.
   *
   * @param imageName          The name of the source image to be split.
   * @param destImageNameRed   The name of the destination image for the Red channel.
   * @param destImageNameGreen The name of the destination image for the Green channel.
   * @param destImageNameBlue  The name of the destination image for the Blue channel.
   * @throws IOException If an error occurs during the process.
   */
  void rgbSplit(String imageName, String destImageNameRed, String destImageNameGreen,
                String destImageNameBlue) throws IOException;

  /**
   * Combines three images representing the Red, Green, and Blue channels
   * into a single RGB image.
   *
   * @param destImageName  The name of the combined destination RGB image.
   * @param redImageName   The name of the source image for the Red channel.
   * @param greenImageName The name of the source image for the Green channel.
   * @param blueImageName  The name of the source image for the Blue channel.
   * @throws IOException If an error occurs during the process.
   */
  void rgbCombine(String destImageName, String redImageName,
                  String greenImageName, String blueImageName) throws IOException;

  /**
   * Generates a histogram representation of the image.
   *
   * @param imageName The name of the source image.
   * @return A two-dimensional array representing the histograms of the red, green, and blue color
   *         channels. Each channel's histogram is an integer array with 256 values.
   *         Index 0 to 255 of each array corresponds to the frequency of color intensity at that
   *         level.
   * @throws IOException If an error occurs during the process, such as if the specified image file
   *                     is not found.
   */
  int[][] histogram(String imageName) throws IOException;


  /**
   * Performs color correction on the image.
   *
   * @param imageName     The name of the source image.
   * @param destImageName The name of the destination image for the color-corrected result.
   * @throws IOException If an error occurs during the process.
   */
  void colorCorrect(String imageName, String destImageName, Optional<Double> splitPercentageOpt)
          throws IOException;

  /**
   * Adjusts the brightness, midtones, and white levels of the image.
   *
   * @param imageName     The name of the source image.
   * @param destImageName The name of the destination image for the adjusted result.
   * @param b             The adjustment value for brightness.
   * @param m             The adjustment value for midtones.
   * @param w             The adjustment value for white levels.
   * @throws IOException If an error occurs during the process.
   */
  void adjustLevels(String imageName, String destImageName, int b, int m, int w,
                    Optional<Double> splitPercentageOpt) throws IOException;

  /**
   * Compresses an image with a specified compression ratio.
   *
   * @param imageName     The name of the source image.
   * @param destImageName The name of the destination image for the compressed result.
   * @param percentage    The compression ratio as a percentage.
   * @throws IOException If an error occurs during the process.
   */
  void compressImage(String imageName, String destImageName, int percentage) throws IOException;
}
