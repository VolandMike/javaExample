package net.thumbtack.school.figures.v2;

import java.util.Objects;

public class Circle extends Figure {

    private Point2D center;
    private int raduis;

    /**
     * Создает Circle по координатам центра и значению радиуса.
     *
     * @param center
     * @param raduis
     * @param color
     */
    public Circle(Point2D center, int raduis, int color) {

        super(color);
        this.center = center;
        this.raduis = raduis;

    }

    /**
     * Создает Circle по координатам центра и значению радиуса.
     *
     * @param xCenter
     * @param yCenter
     * @param radius
     * @param color
     */
    public Circle(int xCenter, int yCenter, int radius, int color) {

        this(new Point2D(xCenter, yCenter), radius, color);
    }

    /**
     * Создает Circle с центром в точке (0,0) указанного радиуса.
     *
     * @param radius
     * @param color
     */
    public Circle(int radius, int color) {
        this(0, 0, radius, color);
    }

    /**
     * Создает Circle с центром в точке (0,0) с радиусом 1.
     *
     * @param color
     */
    public Circle(int color) {
        this(0, 0, 1, color);
    }

    public Point2D getCenter() {
        return center;
    }

    public int getRadius() {
        return raduis;
    }

    public void setCenter(Point2D center) {
        this.center = center;
    }

    public void setRadius(int radius) {
        this.raduis = radius;

    }

    /**
     * Передвигает Circle на (dx, dy).
     *
     * @param dx
     * @param dy
     */
    public void moveRel(int dx, int dy) {
        getCenter().moveRel(dx, dy);
    }

    /**
     * Увеличивает радиус Circle в n раз, не изменяя центра.
     *
     * @param n
     */
    public void enlarge(int n) {
        setRadius(getRadius() * n);
    }

    /**
     * Возвращает площадь круга.
     *
     * @return Площадь круга
     */
    public double getArea() {
        return Math.PI * getRadius() * getRadius();
    }

    /**
     * Возвращает периметр окружности.
     *
     * @return
     */
    public double getPerimeter() {
        return getRadius() * 2 * Math.PI;
    }

    /**
     * Определяет, лежит ли точка (x, y) внутри Circle по формуле - (x-x0)^2 + (y-y0)^2 <= R^2.
     * Если точка лежит на окружности, считается, что она лежит внутри.
     *
     * @param x
     * @param y
     * @return
     */
    public boolean isInside(int x, int y) {
        return (x - center.getX()) * (x - center.getX()) + (y - center.getY()) * (y - center.getY())
                <= getRadius() * getRadius();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return raduis == circle.raduis &&
                Objects.equals(center, circle.center);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), center, raduis);
    }
}
