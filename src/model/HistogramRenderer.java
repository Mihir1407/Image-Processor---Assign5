package model;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * This class provides static methods to render histograms from an array of values.
 * It is capable of creating a BufferedImage of a histogram for display or processing.
 */
public class HistogramRenderer {

  /**
   * Creates a BufferedImage of a histogram for the given array of histograms.
   * The histograms array will contain three histograms for red, green, and blue color channels.
   *
   * @param histograms An array of three histograms (red, green, blue), each with 256 values.
   * @return A BufferedImage representing the drawn histograms for all three color channels.
   */
  public static BufferedImage createHistogramImage(int[][] histograms) {
    int width = 256;
    int height = 256;
    BufferedImage histogramImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics2D graphics = histogramImage.createGraphics();

    graphics.setColor(Color.WHITE);
    graphics.fillRect(0, 0, width, height);

    drawGrid(graphics, width, height, 16);
    drawHistogram(graphics, histograms[0], Color.RED);
    drawHistogram(graphics, histograms[1], Color.GREEN);
    drawHistogram(graphics, histograms[2], Color.BLUE);

    graphics.dispose();
    return histogramImage;
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
}
