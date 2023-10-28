package Model;

import java.io.IOException;

public interface IImageModel {

  /**
   * Loads an image into the model.
   *
   * @param imageName The name assigned to the loaded image.
   * @param imagePath The path to the image.
   * @throws IOException If an error occurs during the reading process.
   */
  void loadImage(String imageName, String imagePath) throws IOException;

  /**
   * Saves the image to a specified location.
   *
   * @param imageName The name of the image to save.
   * @param savePath The path where the image should be saved.
   * @throws IOException If an error occurs during the saving process.
   */
  void saveImage(String imageName, String savePath) throws IOException;

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

  void blur(String imageName, String destImageName) throws IOException;

  void sharpen(String imageName, String destImageName) throws IOException;

  void verticalFlip(String imageName, String destImageName) throws IOException;

  void sepia(String imageName, String destImageName) throws IOException;
}
