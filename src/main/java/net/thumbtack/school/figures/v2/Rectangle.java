
package net.thumbtack.school.figures.v2;

import java.util.Objects;

public class Rectangle extends Figure {
    private Point2D leftTop;
    private Point2D rightBottom;


    /**
     * Создает Rectangle по координатам углов - левого верхнего и правого нижнего.
     *
     * @param leftTop
     * @param rightBottom
     * @param color
     */
    public Rectangle(Point2D leftTop, Point2D rightBottom, int color) {
        super(color);
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;

    }

    /**
     * Создает Rectangle по координатам углов - левого верхнего и правого нижнего.
     *
     * @param xLeft
     * @param yTop
     * @param xRight
     * @param yBottom
     * @param color
     */
    public Rectangle(int xLeft, int yTop, int xRight, int yBottom, int color) {

        this(new Point2D(xLeft, yTop), new Point2D(xRight, yBottom), color);
    }

    /**
     * Создает Rectangle, левый нижний угол которого находится в начале координат,
     * а  длина (по оси X) и ширина (по оси Y) задаются.
     *
     * @param length
     * @param width
     * @param color
     */
    public Rectangle(int length, int width, int color) {
        this(0, -width, length, 0, color);
    }

    /**
     * Создает Rectangle с размерами (1,1), левый нижний угол которого находится в начале координат.
     *
     * @param color
     */

    public Rectangle(int color) {
        this(0, -1, 1, 0, color);
    }

    public Point2D getTopLeft() {
        return leftTop;
    }

    public Point2D getBottomRight() {
        return rightBottom;
    }

    public void setTopLeft(Point2D topLeft) {
        this.leftTop = topLeft;
    }

    public void setBottomRight(Point2D bottomRight) {
        this.rightBottom = bottomRight;

    }

    /**
     * Возвращает длину прямоугольника.
     *
     * @return Длина Прямоугольника
     */
    public int getLength() {
        return Math.abs(getBottomRight().getX() - getTopLeft().getX());
    }

    public int getWidth() {
        return Math.abs(getTopLeft().getY() - getBottomRight().getY());
    }

    /**
     * Передвигает Rectangle на (dx, dy).
     *
     * @param dx
     * @param dy
     */
    public void moveRel(int dx, int dy) {
        getTopLeft().moveRel(dx, dy);
        getBottomRight().moveRel(dx, dy);
    }

    /**
     * Увеличивает стороны Rectangle в (nx, ny) раз при сохранении координат левой верхней вершины.
     *
     * @param nx
     * @param ny
     */
    public void enlarge(int nx, int ny) {
        rightBottom.moveTo(getLength() * nx + getTopLeft().getX(), getWidth() * ny + getTopLeft().getY());

    }

    /**
     * Возвращает площадь прямоугольника.
     *
     * @return Площадь треугольника
     */
    public double getArea() {
        return getWidth() * getLength();
    }

    /**
     * Возвращает периметр прямоугольника.
     *
     * @return Периметр прямоугольника
     */
    public double getPerimeter() {
        return 2 * (getWidth() + getLength());
    }

    /**
     * Определяет, лежит ли точка (x, y) внутри Rectangle. Если точка лежит на стороне, считается, что она лежит внутри.
     *
     * @param x
     * @param y
     * @return true - лежит, false - не лежит
     */
    public boolean isInside(int x, int y) {

        return x >= leftTop.getX() && x <= rightBottom.getX() && y >= leftTop.getY() && y <= rightBottom.getY();
    }

    /**
     * Определяет, пересекается  ли Rectangle с другим Rectangle.
     * Считается, что прямоугольники пересекаются,если у них есть хоть одна общая точка.
     *
     * @param rectangle
     * @return true - пересекается, false - не пересекается
     */
    public boolean isIntersects(Rectangle rectangle) {

        return rectangle.getTopLeft().getX() <= rightBottom.getX() && rectangle.getBottomRight().getX() >= leftTop.getX() &&
                rectangle.getTopLeft().getY() <= rightBottom.getY() && rectangle.getBottomRight().getY() >= leftTop.getY();
    }

    /**
     * Определяет, лежит ли rectangle целиком внутри текущего Rectangle.
     *
     * @param rectangle
     * @return true - лежит, false - не лежит
     */
    public boolean isInside(Rectangle rectangle) {
        return rectangle.getBottomRight().getX() <= rightBottom.getX() && rectangle.getBottomRight().getY() <= rightBottom.getY()
                && rectangle.getTopLeft().getX() >= leftTop.getX() && rectangle.getTopLeft().getY() >= leftTop.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(leftTop, rectangle.leftTop) &&
                Objects.equals(rightBottom, rectangle.rightBottom);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), leftTop, rightBottom);
    }

}

