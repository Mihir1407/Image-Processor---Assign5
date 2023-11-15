package model;

import java.awt.*;
import java.awt.image.BufferedImage;

public class HistogramRenderer {

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

  private static void drawHistogram(Graphics2D graphics, int[] histogram, Color color) {
    graphics.setColor(color);
    for (int i = 0; i < histogram.length - 1; i++) {
      int value = histogram[i];
      int valueNext = histogram[i + 1];
      graphics.drawLine(i, 256 - value, i + 1, 256 - valueNext);
    }
  }

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
