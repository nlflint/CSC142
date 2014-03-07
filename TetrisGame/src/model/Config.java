package model;

public class Config {

    /**
     * Ширина стакана.
     */
    private int     width;
    /**
     * Высота стакана.
     */
    private int     height;
    /**
     * Начальный уровень.
     */
    private int     startLevel;
    /**
     * Сколько линий нужно убрать для перехода на след. уровень.
     */
    private int     linesForLevelUp;
    /**
     * Стартовая задержка в мс при движении фигуры вниз.
     */
    private int     startDelay;
    /**
     * Насколько уменьшается задержка в мс при каждом уровне.
     */
    private int     delayDecrementByLevel;
    /**
     * Кол-во случайно заполненных линий в начале игры.
     */
    private int     startRandomLines;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getStartLevel() {
        return startLevel;
    }

    public void setStartLevel(int startLevel) {
        this.startLevel = startLevel;
    }

    public int getLinesForLevelUp() {
        return linesForLevelUp;
    }

    public void setLinesForLevelUp(int linesForLevelUp) {
        this.linesForLevelUp = linesForLevelUp;
    }

    public int getStartDelay() {
        return startDelay;
    }

    public void setStartDelay(int startDelay) {
        this.startDelay = startDelay;
    }

    public int getDelayDecrementByLevel() {
        return delayDecrementByLevel;
    }

    public void setDelayDecrementByLevel(int delayDecrementByLevel) {
        this.delayDecrementByLevel = delayDecrementByLevel;
    }

    public int getStartRandomLines() {
        return startRandomLines;
    }

    public void setStartRandomLines(int startRandomLines) {
        this.startRandomLines = startRandomLines;
    }

}