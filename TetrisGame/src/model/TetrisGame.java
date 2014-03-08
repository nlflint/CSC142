package model;

import java.awt.Point;
import java.util.Random;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;

public class TetrisGame implements Runnable {

    public static final int         MOVE_LEFT                       = 1;
    public static final int         MOVE_RIGHT                      = 2;
    public static final int         ROTATE_LEFT                     = 3;
    public static final int         ROTATE_RIGHT            = 4;
    public static final int         MOVE_DOWN                       = 5;
    public static final int         PAUSE                           = 6;

    public static final int         STATE_INIT                      = 1;
    public static final int         STATE_NORMAL            = 2;
    public static final int         STATE_FALL                      = 3;
    public static final int         STATE_PAUSE                     = 4;

    private Board                           board;
    private Config                          config;
    private Figure                          figure;
    private Figure                          nextFigure;
    private Point                           pos                                     = new Point();
    private int                                     level                           = 0;
    private int                                     nextLevelLines          = 0;                                            // кол-во для следующего левел-апа

    private Thread                          thread;
    private volatile boolean        running;

    private long                            nextTickTime            = 0;                                            // время в мс для след. тика
    private long                            tickDelay                       = 0;                                            // шаг между тиками в мс для текущей фигуры
    private long                            currentTickDelay        = 0;                                            // текущий шаг между тиками в мс

    protected EventListenerList     listenerList            = new EventListenerList();
    private ChangeEvent                     changeEvent;

    public TetrisGame() {}

    public Board getBoard() {
        return board;
    }

    public Config getConfig() {
        return config;
    }

    public synchronized void initialize(Config config) {
        this.config = config;
        board = new Board(config.getWidth(), config.getHeight());

        Random rnd = new Random();
        for (int i = 0; i < config.getStartRandomLines(); i++) {
            for (int j = 0; j < config.getWidth(); j++) {
                board.setCell(j, config.getHeight() - i - 1, rnd.nextInt(8));
            }
            board.setCell(rnd.nextInt(config.getWidth()), config.getHeight() - i - 1, 0);
        }

        figure = new Figure();
        nextFigure = new Figure();
        pos.y = 0;
        pos.x = (config.getWidth() - 1) / 2;

        board.putFigure(figure, pos.x, pos.y);

        fireBoardChanged();
        fireScoreChanged();

        tickDelay = config.getStartDelay();
        currentTickDelay = tickDelay;
        nextTickTime = System.currentTimeMillis() + tickDelay;

        level = 1;
        nextLevelLines = config.getLinesForLevelUp();

        thread = new Thread(this);
        running = true;
        thread.start();
    }

    private synchronized void gameTick() {
        board.removeFigure(figure, pos.x, pos.y);
        boolean endMove = !board.canPutFigure(figure, pos.x, pos.y + 1);
        if (endMove) {
            board.putFigure(figure, pos.x, pos.y);
            figure = nextFigure;
            nextFigure = new Figure();
            pos.y = 0;
            pos.x = (config.getWidth() - 1) / 2;
            checkFullLines();
            board.putFigure(figure, pos.x, pos.y);
            currentTickDelay = tickDelay;
        } else {
            pos.y++;
            board.putFigure(figure, pos.x, pos.y);
        }
        fireBoardChanged();
    }

    private void checkFullLines() {
        int lines = board.removeFullLines();
        while (board.getRemovedLines() >= nextLevelLines) {
            level++;
            nextLevelLines += config.getLinesForLevelUp();
            if (tickDelay > 200) {
                tickDelay -= config.getDelayDecrementByLevel();
            }
        }
    }

    public synchronized void processKeyAction(int action) {
        board.removeFigure(figure, pos.x, pos.y);
        switch (action) {
            case MOVE_LEFT:
                if (board.canPutFigure(figure, pos.x - 1, pos.y)) {
                    pos.x--;
                }
                break;
            case MOVE_RIGHT:
                if (board.canPutFigure(figure, pos.x + 1, pos.y)) {
                    pos.x++;
                }
                break;
            case MOVE_DOWN:
                currentTickDelay = 30;
                nextTickTime = System.currentTimeMillis();
                break;
            case ROTATE_LEFT:
                figure.rotateClockwise();
                if (!board.canPutFigure(figure, pos.x, pos.y)) {
                    figure.rotateCounterClockwise();
                }
                break;
            case ROTATE_RIGHT:
                break;
        }
        board.putFigure(figure, pos.x, pos.y);
        fireBoardChanged();
    }

    public void addBoardChangeListener(BoardChangeListener l) {
        listenerList.add(BoardChangeListener.class, l);
    }

    public void removeBoardChangeListener(BoardChangeListener l) {
        listenerList.remove(BoardChangeListener.class, l);
    }

    public void addScoreChangeListener(ScoreChangeListener l) {
        listenerList.add(ScoreChangeListener.class, l);
    }

    public void removeScoreChangeListener(ScoreChangeListener l) {
        listenerList.remove(ScoreChangeListener.class, l);
    }

    protected void fireBoardChanged() {
        Object[] listeners = listenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == BoardChangeListener.class) {
                if (changeEvent == null) {
                    changeEvent = new ChangeEvent(board);
                }
                ((ChangeListener) listeners[i + 1]).stateChanged(changeEvent);
            }
        }
    }

    protected void fireScoreChanged() {
        Object[] listeners = listenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == ScoreChangeListener.class) {
                if (changeEvent == null) {
                    changeEvent = new ChangeEvent(board);
                }
                ((ChangeListener) listeners[i + 1]).stateChanged(changeEvent);
            }
        }
    }


    @Override
    public void run() {
        while (running) {
            long time = System.currentTimeMillis();
            if (time >= nextTickTime) {
                gameTick();
                nextTickTime += currentTickDelay;
            } else {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {}
            }
        }
    }

}