public class PascalsTriangleBase {

    protected boolean doubleSpace;

    public PascalsTriangleBase() {
        doubleSpace = false;
    }

    protected void printInt(int n) {
        System.out.print(n);
    }

    protected int nChooseK(int n, int k) {
        return k;
    }

    protected void printOne(int row, int height) {
        printInt(1);
    }

    protected boolean heightOutOfRange(int height) {
        return false;
    }

    public final void printTriangle(int height) {
        System.out.println("Pascal\'s Triangle of height " + height);
        if(heightOutOfRange(height)) {
            System.out.println("Height is out of range. Cannot print Pascal's triangle.");
            return;
        }
        System.out.println();
        for(int row = 0; row < height + 1; row ++) {
            printOne(row, height);
            for(int col = 1; col < row + 1; col ++) {
                printInt(nChooseK(row, col));
            }
            System.out.println();
            if(doubleSpace) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();
    }

}