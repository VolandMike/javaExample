
package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorException;

import java.util.Objects;

public class Rectangle3D extends Rectangle {

    private int height;

    /**
     * Создает Rectangle3D по координатам углов основания (левого верхнего и правого нижнего) и высотой.
     *
     * @param leftTop
     * @param rightBottom
     * @param height
     * @param color
     */
    public Rectangle3D(Point2D leftTop, Point2D rightBottom, int height, Color color) throws ColorException {
        super(leftTop, rightBottom, color);
        this.height = height;
    }


    public Rectangle3D(Point2D leftTop, Point2D rightBottom, int height, String color) throws ColorException {
        super(leftTop, rightBottom, color);
        this.height = height;
    }

    /**
     * Создает Rectangle3D по координатам углов основания (левого верхнего и правого нижнего) и высотой.
     *
     * @param xLeft
     * @param yTop
     * @param xRight
     * @param yBottom
     * @param height
     * @param color
     */
    public Rectangle3D(int xLeft, int yTop, int xRight, int yBottom, int height, Color color) throws ColorException {
        this(new Point2D(xLeft, yTop), new Point2D(xRight, yBottom), height, color);
    }

    public Rectangle3D(int xLeft, int yTop, int xRight, int yBottom, int height, String color) throws ColorException {
        this(new Point2D(xLeft, yTop), new Point2D(xRight, yBottom), height, color);
    }

    /**
     * Создает Rectangle3D, левый нижний угол которого находится в начале координат, а  длина, ширина и высота задаются.
     *
     * @param length
     * @param width
     * @param height
     * @param color
     */
    public Rectangle3D(int length, int width, int height, Color color) throws ColorException {
        this(0, -width, length, 0, height, color);
    }
    public Rectangle3D(int length, int width, int height, String color) throws ColorException {
        this(0, -width, length, 0, height, color);
    }

    /**
     * Создает Rectangle3D с размерами (1, 1, 1), левый нижний угол которого находится в начале координат.
     *
     * @param color
     */
    public Rectangle3D(Color color) throws ColorException {
        this(0, -1, 1, 0, 1, color);
    }
    public Rectangle3D(String color) throws ColorException {
        this(0, -1, 1, 0, 1, color);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Возвращает объем параллелепипеда.
     *
     * @return Объем параллелепипеда.
     */
    public double getVolume() {
        return getArea() * height;
    }


    /**
     * Определяет, лежит ли точка (x, y, z) внутри Rectangle3D.
     * Если точка лежит на стороне, считается, что она лежит внутри.
     *
     * @param x
     * @param y
     * @param z
     * @return true - лежит. false - не лежит
     */
    public boolean isInside(int x, int y, int z) {
        return isInside(x, y) && z <= getHeight();
    }

    /**
     * Определяет, лежит ли точка point внутри Rectangle3D.
     * Если точка лежит на стороне, считается, что она лежит внутри.
     *
     * @param point
     * @return true - лежит. false - не лежит
     */
    public boolean isInside(Point3D point) {
        return isInside(point.getX(), point.getY(), point.getZ());

    }

    /**
     * Определяет, пересекается  ли Rectangle3D с другим Rectangle3D.
     * Считается, что Rectangle3D пересекаются,если у них есть хоть одна общая точка.
     *
     * @param rectangle
     * @return true - пересекаются. false - не пересекаются
     */
    public boolean isIntersects(Rectangle3D rectangle) {
        return isIntersects((Rectangle) rectangle);

    }

    /**
     * Определяет, лежит ли rectangle3D целиком внутри текущего Rectangle3D.
     *
     * @param rectangle
     * @return true - лежит. false - не лежит
     */
    public boolean isInside(Rectangle3D rectangle) {
        return isInside((Rectangle) rectangle) && rectangle.getHeight() <= height;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rectangle3D that = (Rectangle3D) o;
        return height == that.height;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), height);
    }
}

