package controller;

import java.awt.*;
import java.awt.image.BufferedImage;

import model.image.Image;
import model.image.Pixel;

/**
 * This class provides static methods to render histograms from an array of values.
 * It is capable of creating an Image of a histogram for display or processing.
 */
public class HistogramRenderer {

  /**
   * Generates an Image representing the histograms of the red, green, and blue color channels.
   * Each channel's histogram is normalized to the same scale for consistent representation.
   *
   * @param histograms An array containing three integer arrays, each representing the histogram
   *                   for a color channel with 256 values.
   * @return An Image object containing the visual representation of the histograms.
   */
  public static Image createHistogramImage(int[][] histograms) {
    int width = 256;
    int height = 256;

    int maxFrequency = findMaxFrequency(histograms);

    histograms[0] = normalizeHistogram(histograms[0], maxFrequency);
    histograms[1] = normalizeHistogram(histograms[1], maxFrequency);
    histograms[2] = normalizeHistogram(histograms[2], maxFrequency);

    BufferedImage histogramImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics = histogramImage.createGraphics();

    graphics.setColor(Color.WHITE);
    graphics.fillRect(0, 0, width, height);

    drawGrid(graphics, width, height, 16);
    drawHistogram(graphics, histograms[0], Color.RED);
    drawHistogram(graphics, histograms[1], Color.GREEN);
    drawHistogram(graphics, histograms[2], Color.BLUE);

    graphics.dispose();
    return convertBufferedImageToImage(histogramImage);
  }

  /**
   * Draws a histogram for a single color channel onto the given Graphics2D context.
   * The histogram is represented as a line graph.
   *
   * @param graphics  The Graphics2D context where the histogram will be drawn.
   * @param histogram An array of 256 integers representing the frequency of each color intensity.
   * @param color     The color to draw the histogram with.
   */
  private static void drawHistogram(Graphics2D graphics, int[] histogram, Color color) {
    graphics.setColor(color);
    for (int i = 0; i < histogram.length - 1; i++) {
      int value = histogram[i];
      int valueNext = histogram[i + 1];
      graphics.drawLine(i, 256 - value, i + 1, 256 - valueNext);
    }
  }

  /**
   * Draws a grid on the given Graphics2D context to help visualize the histogram.
   * The grid is drawn with a specified size separating the lines.
   *
   * @param graphics The Graphics2D context where the grid will be drawn.
   * @param width    The width of the area where the grid should be drawn.
   * @param height   The height of the area where the grid should be drawn.
   * @param gridSize The size of each grid cell.
   */
  private static void drawGrid(Graphics2D graphics, int width, int height, int gridSize) {
    graphics.setColor(Color.LIGHT_GRAY);
    for (int i = gridSize; i < width; i += gridSize) {
      graphics.drawLine(i, 0, i, height);
    }
    for (int i = gridSize; i < height; i += gridSize) {
      graphics.drawLine(0, i, width, i);
    }
  }

  /**
   * Finds the maximum frequency among the given histograms.
   *
   * @param histograms Variable-length argument list of integer arrays representing histograms.
   * @return The maximum frequency found among the histograms.
   */
  private static int findMaxFrequency(int[]... histograms) {
    int max = 0;
    for (int[] histogram : histograms) {
      for (int freq : histogram) {
        max = Math.max(max, freq);
      }
    }
    return max;
  }

  /**
   * Normalizes the given histogram array to the specified maximum frequency.
   *
   * @param histogram    The histogram to be normalized.
   * @param maxFrequency The maximum frequency to which the histogram will be normalized.
   * @return The normalized histogram array.
   */
  private static int[] normalizeHistogram(int[] histogram, int maxFrequency) {
    for (int i = 0; i < histogram.length; i++) {
      histogram[i] = (histogram[i] * 255) / maxFrequency;
    }
    return histogram;
  }

  /**
   * Converts a BufferedImage to an Image object.
   *
   * @param bufferedImage The BufferedImage to be converted.
   * @return An Image object representing the same image as the BufferedImage.
   */
  private static Image convertBufferedImageToImage(BufferedImage bufferedImage) {
    Pixel[][] pixels = new Pixel[bufferedImage.getHeight()][bufferedImage.getWidth()];
    for (int y = 0; y < bufferedImage.getHeight(); y++) {
      for (int x = 0; x < bufferedImage.getWidth(); x++) {
        int rgb = bufferedImage.getRGB(x, y);
        Color color = new Color(rgb, true);
        pixels[y][x] = new Pixel(color.getRed(), color.getGreen(), color.getBlue());
      }
    }
    return new Image(pixels);
  }
}
