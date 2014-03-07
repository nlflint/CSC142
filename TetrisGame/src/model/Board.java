package model;

import model.Figure.Cell;

public class Board {

    private final int       width;
    private final int       height;
    private final int       matrix[][];
    private int                     removedLines    = 0;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new int[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getRemovedLines() {
        return removedLines;
    }

    public void setCell(int x, int y, int type) {
        matrix[y][x] = type;
    }

    public int getCell(int x, int y) {
        return matrix[y][x];
    }

    public boolean canPutFigure(Figure figure, int x, int y) {
        Cell[] cells = figure.getCells();
        for (int i = 0; i < cells.length; i++) {
            int cx = x + cells[i].x;
            int cy = y + cells[i].y;
            if (cx < 0 || cx >= width || cy >= height || cy >= 0 && matrix[cy][cx] != 0)
                return false;
        }
        return true;
    }

    public void putFigure(Figure figure, int x, int y) {
        fillFigureCells(figure, x, y, figure.getType());
    }

    public void removeFigure(Figure figure, int x, int y) {
        fillFigureCells(figure, x, y, 0);
    }

    private void fillFigureCells(Figure figure, int x, int y, int type) {
        Cell[] cells = figure.getCells();
        for (int i = 0; i < cells.length; i++) {
            int cx = x + cells[i].x;
            int cy = y + cells[i].y;
            if (cy >= 0) {
                matrix[cy][cx] = type;
            }
        }
    }

    public boolean isLineFull(int y) {
        for (int x = 0; x < width; x++) {
            if (matrix[y][x] == 0)
                return false;
        }
        return true;
    }

    public boolean hasFullLines() {
        for (int y = 0; y < height; y++) {
            if (isLineFull(y))
                return true;
        }
        return false;
    }

    private void removeLine(int y) {
        for (int i = y - 1; i >= 0; i--) {
            matrix[i + 1] = matrix[i];
        }
        matrix[0] = new int[width];
        removedLines++;
    }

    public int removeFullLines() {
        int lines = 0;
        for (int y = height - 1; y >= 0; y--) {
            if (isLineFull(y)) {
                removeLine(y);
                y++;
                lines++;
            }
        }
        return lines;
    }

}