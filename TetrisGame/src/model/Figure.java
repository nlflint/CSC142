package model;

import java.util.Random;

public class Figure {

    static class Cell {
        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int      x, y;
    }

    public static final int L                       = 1;
    public static final int J                       = 2;
    public static final int S                       = 3;
    public static final int Z                       = 4;
    public static final int T                       = 5;
    public static final int O                       = 6;
    public static final int I                       = 7;

    private final int               type;
    private int                             rotation        = 0;
    private final int               maxRotation;

    private final Cell[][]  pieces;
    private Cell[]                  piece;
    private static Random   rnd                     = new Random();

    public Figure() {
        this(getRandomType());
    }

    public Figure(int type) {
        this.type = type;
        switch (type) {
            case L:
                maxRotation = 4;
                pieces = new Cell[maxRotation][];
                pieces[0] = new Cell[] {new Cell(0, 0), new Cell(-1, 0), new Cell(-1, 1), new Cell(1, 0)};
                break;
            case J:
                maxRotation = 4;
                pieces = new Cell[maxRotation][];
                pieces[0] = new Cell[] {new Cell(0, 0), new Cell(-1, 0), new Cell(1, 0), new Cell(1, 1)};
                break;
            case S:
                maxRotation = 2;
                pieces = new Cell[maxRotation][];
                pieces[0] = new Cell[] {new Cell(0, 0), new Cell(1, 0), new Cell(0, 1), new Cell(-1, 1)};
                break;
            case Z:
                maxRotation = 2;
                pieces = new Cell[maxRotation][];
                pieces[0] = new Cell[] {new Cell(0, 0), new Cell(-1, 0), new Cell(0, 1), new Cell(1, 1)};
                break;
            case T:
                maxRotation = 4;
                pieces = new Cell[maxRotation][];
                pieces[0] = new Cell[] {new Cell(0, 0), new Cell(-1, 0), new Cell(1, 0), new Cell(0, 1)};
                break;
            case O:
                maxRotation = 1;
                pieces = new Cell[maxRotation][];
                pieces[0] = new Cell[] {new Cell(0, 0), new Cell(1, 0), new Cell(0, 1), new Cell(1, 1)};
                break;
            case I:
                maxRotation = 2;
                pieces = new Cell[maxRotation][];
                pieces[0] = new Cell[] {new Cell(0, 0), new Cell(-2, 0), new Cell(-1, 0), new Cell(1, 0)};
                break;
            default:
                throw new IllegalArgumentException("Invalid figure type");
        }
        for (int i = 1; i < maxRotation; i++) {
            pieces[i] = new Cell[4];
            for (int j = 0; j < 4; j++) {
                pieces[i][j] = new Cell(pieces[i - 1][j].y, -pieces[i - 1][j].x);
            }
        }
    }

    public int getType() {
        return type;
    }

    public static int getRandomType() {
        return 1 + rnd.nextInt(I);
    }

    public void rotateClockwise() {
        rotation = (rotation + 3) % maxRotation;
    }

    public void rotateCounterClockwise() {
        rotation = (rotation + 1) % maxRotation;
    }

    public Cell[] getCells() {
        return pieces[rotation];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        char[][] image = new char[4][20];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 20; j++) {
                image[i][j] = ' ';
            }
        }
        for (int i = 0; i < maxRotation; i++) {
            int x = 5 * i + 2, y = 1;
            for (int j = 0; j < 4; j++) {
                image[y + pieces[i][j].y][x + pieces[i][j].x] = '\u2588';
            }
        }
        for (int i = 0; i < 4; i++) {
            sb.append(image[i]);
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 7; i++) {
            Figure f = new Figure(i);
            System.out.println(f);
        }
    }

}