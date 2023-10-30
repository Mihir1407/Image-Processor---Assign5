package Model;

import java.io.IOException;

import Model.Image.IImage;

public interface IImageModel {

  /**
   * Loads an image into the model.
   *
   * @param image The name assigned to the loaded image.
   * @param imagePath The path to the image.
   * @throws IOException If an error occurs during the reading process.
   */
  void addImage(IImage image, String imagePath) throws IOException;

  /**
   * Saves the image to a specified location.
   *
   * @param imageName The name of the image to save.
   * @throws IOException If an error occurs during the saving process.
   */
  IImage getImage(String imageName) throws IOException;

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

  void horizontalFlip(String imageName, String destImageName) throws IOException;

  void brightenCommand(int increment, String imageName, String destImageName) throws IOException;

  void blur(String imageName, String destImageName) throws IOException;

  void sharpen(String imageName, String destImageName) throws IOException;

  void verticalFlip(String imageName, String destImageName) throws IOException;

  void sepia(String imageName, String destImageName) throws IOException;

  void rgbSplit(String imageName, String destImageNameRed, String destImageNameGreen,
                String destImageNameBlue) throws IOException;

  void rgbCombine(String redImageName, String greenImageName, String blueImageName, String destImageName) throws IOException;
}
