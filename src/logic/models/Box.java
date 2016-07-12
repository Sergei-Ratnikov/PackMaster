package logic.models;

/**
 * Created by Coder on 06.07.2016.
 */

public class Box implements Comparable<Box> {
    private final int width;
    private final int height;
    private int originX = -1;
    private int originY = -1;
    private boolean rotation = false;

    public Box(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getOriginX() {
        return originX;
    }

    public void setOriginX(int originX) {
        this.originX = originX;
    }

    public int getOriginY() {
        return originY;
    }

    public void setOriginY(int originY) {
        this.originY = originY;
    }

    public boolean getRotation() { return rotation; }

    public void setRotation(boolean rotation) { this.rotation = rotation; }

    // метод, применяемый при сортировке Arrays.sort(boxes), в данном случае - сортировка по высоте
    @Override
    public int compareTo(Box o) {
        return o.getHeight() - this.getHeight();
    }
}