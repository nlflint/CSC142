package SimpleTetris;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import model.Config;
import model.TetrisGame;
import view.TetrisView;

public class SimpleTetris extends JFrame {

    public SimpleTetris() {
        super("SimpleTetris");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Config config = new Config();
        config.setWidth(10);
        config.setHeight(30);
        config.setStartRandomLines(5);
        config.setStartDelay(2000);
        config.setDelayDecrementByLevel(200);
        config.setLinesForLevelUp(2);
        final TetrisGame game = new TetrisGame();
        game.initialize(config);
        TetrisView tv = new TetrisView();
        tv.setGame(game);
        add(tv);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int action = 0;
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        action = TetrisGame.MOVE_LEFT;
                        break;
                    case KeyEvent.VK_RIGHT:
                        action = TetrisGame.MOVE_RIGHT;
                        break;
                    case KeyEvent.VK_UP:
                        action = TetrisGame.ROTATE_LEFT;
                        break;
                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_SPACE:
                        action = TetrisGame.MOVE_DOWN;
                        break;
                }
                if (action != 0) {
                    game.processKeyAction(action);
                }
            }
        });

        setSize(300, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpleTetris();
            }
        });
    }

}