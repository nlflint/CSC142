package view;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import model.BoardChangeListener;
import model.TetrisGame;

public class TetrisView extends JPanel implements LayoutManager {

    private static final long       serialVersionUID        = 5839368311361333192L;

    private TetrisGame                      game;
    private TetrisComponent         view                            = new TetrisComponent();
    private int                                     cellSize                        = 8;
    private Color[]                         colors                          = new Color[] {Color.BLACK, Color.YELLOW, Color.MAGENTA, Color.BLUE, Color.GREEN, Color.LIGHT_GRAY, Color.CYAN, Color.RED};

    public TetrisView() {
        super();
        view.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        //setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        setLayout(this);
        add(view);
    }

    public void setGame(TetrisGame game) {
        this.game = game;
        game.addBoardChangeListener(new BoardChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                view.repaint();
            }
        });
    }

        /*
         * Реализация LayoutManager 
         */

    @Override
    public void addLayoutComponent(String name, Component comp) {}

    @Override
    public void removeLayoutComponent(Component comp) {}

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return null;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return null;
    }

    @Override
    public void layoutContainer(Container parent) {
        Insets parentInsets = parent.getInsets();
        Insets viewInsets = view.getInsets();
        Dimension dim = new Dimension(
                parent.getWidth() - parentInsets.left - parentInsets.right - viewInsets.left - viewInsets.right - 1,
                parent.getHeight() - parentInsets.top - parentInsets.bottom - viewInsets.top - viewInsets.bottom - 1);
        cellSize = Math.max(Math.min(dim.width / game.getBoard().getWidth() - 1, dim.height / game.getBoard().getHeight() - 1), 8);
        int width = (cellSize + 1) * game.getBoard().getWidth() + 1 + viewInsets.left + viewInsets.right;
        int height = (cellSize + 1) * game.getBoard().getHeight() + 1 + viewInsets.top + viewInsets.bottom;
        int x = (parent.getWidth() - parentInsets.left - parentInsets.right - width) / 2 + parentInsets.left;
        int y = Math.max((parent.getHeight() - parentInsets.top - parentInsets.bottom - height) / 2 + parentInsets.top, parentInsets.top);
        if (view.getWidth() != width || view.getHeight() != height) {
            view.setBounds(x, y, width, height);
        } else {
            view.setLocation(x, y);
        }
    }

    /**
     * Реализация компонента "стакан".
     *
     * @author Alexei Tereschenko <aytereschenko@gmail.com>
     */
    class TetrisComponent extends JComponent {

        private Image   image   = null;

        public TetrisComponent() {}

        private void ensureImage() {
            int width = getWidth();
            int height = getHeight();
            if (image == null || image.getWidth(null) != width || image.getHeight(null) != height) {
                image = createImage(width, height);
            }
        }

        @Override
        public void setBounds(int x, int y, int width, int height) {
            super.setBounds(x, y, width, height);
        }

        @Override
        protected void paintComponent(Graphics gg) {
            super.paintComponent(gg);
            synchronized (game) {
                Graphics2D g = (Graphics2D) gg;
                Insets insets = getInsets();
                int width = getWidth() - insets.left - insets.right;
                int height = getHeight() - insets.top - insets.bottom;
                g.translate(insets.left, insets.top);
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, width, height);
                g.setColor(Color.DARK_GRAY);
                for (int x = 0; x <= game.getBoard().getWidth(); x++) {
                    g.drawLine(x * (cellSize + 1), 0, x * (cellSize + 1), height);
                }
                for (int y = 0; y <= game.getBoard().getHeight(); y++) {
                    g.drawLine(0, y * (cellSize + 1), width, y * (cellSize + 1));
                }

                for (int y = 0; y < game.getBoard().getHeight(); y++) {
                    for (int x = 0; x < game.getBoard().getWidth(); x++) {
                        int c = game.getBoard().getCell(x, y);
                        if (c > 0) {
                            g.setColor(colors[c]);
                            g.fillRect(x * (cellSize + 1) + 1, y * (cellSize + 1) + 1, cellSize, cellSize);
                            paintCellBorder(g, x * (cellSize + 1) + 1, y * (cellSize + 1) + 1, cellSize, cellSize, cellSize / 8);
                        }
                    }
                }
                g.translate(-insets.left, -insets.top);
            }
        }
    }

    private void paintCellBorder(Graphics2D g, int x, int y, int width, int height, int depth) {
        g.setColor(new Color(255, 255, 255, 128));
        for (int i = 0; i < depth; i++) {
            g.drawLine(x + i, y + i, x + i, y + height - 1 - i);
            g.drawLine(x + 1 + i, y + i, x + width - 1 - i, y + i);
        }
        g.setColor(new Color(0, 0, 0, 128));
        for (int i = 0; i < depth; i++) {
            g.drawLine(x + width - 1 - i, y + 1 + i, x + width - 1 - i, y + height - 2 - i);
            g.drawLine(x + 1 + i, y + height - 1 - i, x + width - 1 - i, y + height - 1 - i);
        }
    }

}