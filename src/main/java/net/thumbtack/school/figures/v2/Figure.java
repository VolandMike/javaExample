package net.thumbtack.school.figures.v2;

import java.util.Objects;

abstract class Figure implements Colored {
    private int color;


    /**
     * Конструктор класса фигура с параметром color.
     *
     * @param color - цвет фигуры
     */
    public Figure(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return color == figure.color;
    }

    @Override
    public int hashCode() {

        return Objects.hash(color);
    }

    /**
     * метод находит площадь фигуры
     *
     * @return площадь фигуры
     */
    public abstract double getArea();


    /**
     * Определяет, лежит ли точка c координатами x,y внутри фигуры
     *
     * @param x
     * @param y
     * @return true - лежит, false - не лежит
     */
    public abstract boolean isInside(int x, int y);

    /**
     * Определяет, лежит ли точка point внутри фигуры
     *
     * @param point
     * @return true - лежит, false - не лежит
     */
    public boolean isInside(Point2D point) {

        return isInside(point.getX(), point.getY());
    }

    /**
     * Передвигает фигуру на (dx, dy).
     *
     * @param x
     * @param y
     */
    public abstract void moveRel(int x, int y);

    /**
     * Вычисляет периметр фигуры
     *
     * @return периметр фигуры
     */
    public abstract double getPerimeter();
}
