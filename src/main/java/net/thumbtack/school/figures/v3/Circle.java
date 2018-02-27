package net.thumbtack.school.figures.v3;

import net.thumbtack.school.area.HasArea;
import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorException;

import java.util.Objects;

public class Circle extends Figure implements HasArea {

    private Point2D center;
    private int raduis;


    /**
     * Создает Circle по координатам центра и значению радиуса.
     *
     * @param center координаты центра
     * @param raduis  радиус окружности
     * @param color цвет окружности
     * @throws ColorException Ошибка при неверных параметрах Color
     */
    public Circle(Point2D center, int raduis, Color color) throws ColorException {

        super(color);
        this.center = center;
        this.raduis = raduis;

    }

    /**
     * Создает Circle по координатам центра и значению радиуса.
     * Color задан строкой.
     *
     * @param center координаты центра
     * @param raduis  радиус окружности
     * @param color цвет окружности
     * @throws ColorException Ошибка при неверных параметрах Color
     */
    public Circle(Point2D center, int raduis, String color) throws ColorException {

        this(center, raduis, Color.colorFromString(color));

    }

    /**
     * Создает Circle по координатам центра и значению радиуса.
     *
     * @param xCenter координата х
     * @param yCenter координата y
     * @param radius радиус окружности
     * @param color цвет окружности
     * @throws ColorException Ошибка при неверных параметрах Color
     */
    public Circle(int xCenter, int yCenter, int radius, Color color) throws ColorException {

        this(new Point2D(xCenter, yCenter), radius, color);
    }

    /**
     * Создает Circle по координатам центра и значению радиуса.
     * Color задан строкой.
     *
     * @param xCenter координата х
     * @param yCenter координата y
     * @param radius радиус окружности
     * @param color цвет окружности
     * @throws ColorException Ошибка при неверных параметрах Color
     */
    public Circle(int xCenter, int yCenter, int radius, String color) throws ColorException {

        this(new Point2D(xCenter, yCenter), radius, Color.colorFromString(color));
    }

    /**
     * Создает Circle с центром в точке (0,0) указанного радиуса.
     *
     * @param radius радиус окружности
     * @param color цвет окружности
     * @throws ColorException Ошибка при неверных параметрах Color
     */
    public Circle(int radius, Color color) throws ColorException {
        this(0, 0, radius, color);
    }

    /**
     * Создает Circle с центром в точке (0,0) указанного радиуса.
     * Color задаётся строкой
     *
     * @param radius радиус окружности
     * @param color цвет окружности
     * @throws ColorException Ошибка при неверных параметрах Color
     */
    public Circle(int radius, String color) throws ColorException {
        this(0, 0, radius, Color.colorFromString(color));
    }

    /**
     * Создает Circle с центром в точке (0,0) с радиусом 1.
     *
     * @param color цвет окружности
     * @throws ColorException Ошибка при неверных параметрах Color
     */
    public Circle(Color color) throws ColorException {
        this(0, 0, 1, color);
    }

    /**
     * Создает Circle с центром в точке (0,0) с радиусом 1.
     * Color задаётся строкой
     *
     * @param color цвет окружности
     * @throws ColorException Ошибка при неверных параметрах Color
     */
    public Circle(String color) throws ColorException {
        this(0, 0, 1, Color.colorFromString(color));
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
     * @param dx сдвиг по оси х
     * @param dy сдвиг по оси y
     */
    public void moveRel(int dx, int dy) {
        getCenter().moveRel(dx, dy);
    }

    /**
     * Увеличивает радиус Circle в n раз, не изменяя центра.
     *
     * @param n увеличение радиуса в n раз
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
     * @return периметр окружности
     */
    public double getPerimeter() {
        return getRadius() * 2 * Math.PI;
    }

    /**
     * Определяет, лежит ли точка (x, y) внутри Circle по формуле - (x-x0)^2 + (y-y0)^2 <= R^2.
     * Если точка лежит на окружности, считается, что она лежит внутри.
     *
     * @param x координата х
     * @param y координата y
     * @return true - лежит, false - не лежит
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
