package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import model.image.Image;
import model.image.Pixel;

/**
 * Implements the IImageFileParser interface for parsing PPM image files.
 */
public class PPMParser implements IImageFileParser {

  /**
   * Loads the image from a specified path in the PPM format.
   *
   * @param path the path of the PPM image file to be loaded
   * @return an Image object representing the loaded image
   * @throws IOException if there's an error reading the file or
   *                     the file is not a valid PPM
   */
  @Override
  public Image loadImage(String path) throws IOException {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(path));
    } catch (FileNotFoundException e) {
      throw new IOException("File " + path + " not found!", e);
    }

    StringBuilder builder = new StringBuilder();
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }

    sc = new Scanner(builder.toString());

    if (!sc.next().equals("P3")) {
      throw new IOException("Invalid PPM file: plain RAW file should "
              + "begin with P3");
    }

    int width = sc.nextInt();
    int height = sc.nextInt();
    int maxValue = sc.nextInt();

    if (maxValue > 255) {
      throw new IOException("Unsupported color depth. Maximum value "
              + "should be 255.");
    }

    Image image = new Image(new Pixel[height][width]);

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int red = sc.nextInt();
        int green = sc.nextInt();
        int blue = sc.nextInt();
        image.setPixel(x, y, new Pixel(red, green, blue));
      }
    }

    return image;
  }

  /**
   * Saves the given Image object to the specified path in PPM format.
   *
   * @param path  the path where the PPM image file will be saved
   * @param image the Image object to save
   * @throws IOException if there's an error writing to the file
   */
  @Override
  public void saveImage(String path, Image image) throws IOException {
    if (image.getPixels() == null) {
      throw new IOException("No image data to save.");
    }

    int height = image.getHeight();
    int width = image.getWidth();

    try (FileWriter writer = new FileWriter(new File(path))) {
      writer.write("P3\n");
      writer.write(width + " " + height + "\n");
      writer.write("255\n");

      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          Pixel pixel = image.getPixel(x, y);
          writer.write(pixel.getRed() + " " + pixel.getGreen()
                  + " " + pixel.getBlue() + " ");
        }
        writer.write("\n");
      }
    }
  }
}
