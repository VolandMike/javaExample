
package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorException;

import java.util.Objects;

public class Rectangle extends Figure  {
    private Point2D leftTop;
    private Point2D rightBottom;




    /**
     * Создает Rectangle по координатам углов - левого верхнего и правого нижнего.
     *
     * @param leftTop - координата левого верхнего угла
     * @param rightBottom - координата правого нижнего угла
     * @param color - цвет прямоугольника
     * @throws ColorException Ошибка при неверных параметрах Color
     */
    public Rectangle(Point2D leftTop, Point2D rightBottom, Color color) throws ColorException {
        super(color);
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;

    }

    /**
     * Создает Rectangle по координатам углов - левого верхнего и правого нижнего.
     *
     * @param leftTop - координата левого верхнего угла
     * @param rightBottom - координата правого нижнего угла
     * @param color - цвет прямоугольника
     * @throws ColorException Ошибка при неверных параметрах Color
     */
    public Rectangle(Point2D leftTop, Point2D rightBottom, String color) throws ColorException {
        this(leftTop, rightBottom, Color.colorFromString(color));

    }

    /**
     * Создает Rectangle по координатам углов - левого верхнего и правого нижнего.
     *
     * @param xLeft - координата x левого верхнего угла
     * @param yTop - координата y левого верхнего угла
     * @param xRight - координата x правого нижнего угла
     * @param yBottom - координата y правого нижнего угла
     * @param color - цвет прямоугольника
     * @throws ColorException Ошибка при неверных параметрах Color
     */
    public Rectangle(int xLeft, int yTop, int xRight, int yBottom, Color color) throws ColorException {

        this(new Point2D(xLeft, yTop), new Point2D(xRight, yBottom), color);
    }

    /**
     * Создает Rectangle по координатам углов - левого верхнего и правого нижнего.
     *
     * @param xLeft - координата x левого верхнего угла
     * @param yTop - координата y левого верхнего угла
     * @param xRight - координата x правого нижнего угла
     * @param yBottom - координата y правого нижнего угла
     * @param color - цвет прямоугольника
     * @throws ColorException Ошибка при неверных параметрах Color
     */
    public Rectangle(int xLeft, int yTop, int xRight, int yBottom, String color) throws ColorException {

        this(new Point2D(xLeft, yTop), new Point2D(xRight, yBottom), Color.colorFromString(color));
    }

    /**
     * Создает Rectangle, левый нижний угол которого находится в начале координат,
     * а  длина (по оси X) и ширина (по оси Y) задаются.
     *
     * @param length - длинна по оси X
     * @param width - длина по оси Y
     * @param color - цвет прямоугольника
     * @throws ColorException Ошибка при неверных параметрах Color
     */
    public Rectangle(int length, int width, Color color) throws ColorException {
        this(0, -width, length, 0, color);
    }

    /**
     * Создает Rectangle, левый нижний угол которого находится в начале координат,
     * а  длина (по оси X) и ширина (по оси Y) задаются.
     *
     * @param length - длинна по оси X
     * @param width - длина по оси Y
     * @param color - цвет прямоугольника
     * @throws ColorException Ошибка при неверных параметрах Color
     */
    public Rectangle(int length, int width, String color) throws ColorException {
        this(0, -width, length, 0, Color.colorFromString(color));
    }

    /**
     * Создает Rectangle с размерами (1,1), левый нижний угол которого находится в начале координат.
     *
     * @param color - цвет прямоугольника
     * @throws ColorException Ошибка при неверных параметрах Color
     */

    public Rectangle(Color color) throws ColorException {
        this(0, -1, 1, 0, color);
    }

    /**
     * Создает Rectangle с размерами (1,1), левый нижний угол которого находится в начале координат.
     *
     * @param color - цвет прямоугольника
     * @throws ColorException Ошибка при неверных параметрах Color
     */
    public Rectangle(String color) throws ColorException {
        this(0, -1, 1, 0, Color.colorFromString(color));
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
     * @param dx - Изменение по оси X
     * @param dy - Изменение по оси Y
     */
    public void moveRel(int dx, int dy) {
        getTopLeft().moveRel(dx, dy);
        getBottomRight().moveRel(dx, dy);
    }

    /**
     * Увеличивает стороны Rectangle в (nx, ny) раз при сохранении координат левой верхней вершины.
     *
     * @param nx - увеличение по оси X
     * @param ny - увеличение по оси Y
     */
    public void enlarge(int nx, int ny) {
        rightBottom.moveTo(getLength() * nx + getTopLeft().getX(), getWidth() * ny + getTopLeft().getY());

    }

    /**
     * Возвращает площадь прямоугольника.
     *
     * @return Площадь треугольника
     */
    @Override
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
     * @param x - координата X
     * @param y - координата Y
     * @return true - лежит, false - не лежит
     */
    public boolean isInside(int x, int y) {

        return x >= leftTop.getX() && x <= rightBottom.getX() && y >= leftTop.getY() && y <= rightBottom.getY();
    }

    /**
     * Определяет, пересекается  ли Rectangle с другим Rectangle.
     * Считается, что прямоугольники пересекаются,если у них есть хоть одна общая точка.
     *
     * @param rectangle - прямоугольник
     * @return true - пересекается, false - не пересекается
     */
    public boolean isIntersects(Rectangle rectangle) {

        return rectangle.getTopLeft().getX() <= rightBottom.getX() && rectangle.getBottomRight().getX() >= leftTop.getX() &&
                rectangle.getTopLeft().getY() <= rightBottom.getY() && rectangle.getBottomRight().getY() >= leftTop.getY();
    }

    /**
     * Определяет, лежит ли rectangle целиком внутри текущего Rectangle.
     *
     * @param rectangle - прямоугольник
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

