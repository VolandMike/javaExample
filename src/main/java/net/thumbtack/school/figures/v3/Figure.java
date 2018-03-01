package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorErrorCode;
import net.thumbtack.school.colors.ColorException;
import net.thumbtack.school.colors.Colored;
import net.thumbtack.school.area.HasArea;

import java.util.Objects;

public abstract class Figure implements Colored, HasArea {
    private Color color;

    /**
     * Конструктор класса фигура с параметром color.
     *
     * @param color - цвет фигуры
     */
    public Figure(Color color) throws ColorException {
        setColor(color);
    }

    public Figure(String color) throws ColorException {
        this(Color.colorFromString(color));
    }
    @Override
    public Color getColor() {
        return color;
    }
    @Override
    public void setColor(Color color) throws ColorException {
        if (color == null) throw new ColorException(ColorErrorCode.NULL_COLOR);
        this.color = color;
    }
    @Override
    public void setColor(String colorString) throws ColorException {
        this.color = Color.colorFromString(colorString);
    }




    /**
     * Определяет, лежит ли точка c координатами x,y внутри фигуры
     *
     * @param x - координата по оси х
     * @param y - координата по оси y
     * @return true - лежит, false - не лежит
     */
    public abstract boolean isInside(int x, int y);

    /**
     * Определяет, лежит ли точка point внутри фигуры
     *
     * @param point - точка с координатами (x,y)
     * @return true - лежит, false - не лежит
     */
    public boolean isInside(Point2D point) {

        return isInside(point.getX(), point.getY());
    }

    /**
     * Передвигает фигуру на (dx, dy).
     *
     * @param dx изменение по оси х
     * @param dy изменение по оси y
     */
    public abstract void moveRel(int dx, int dy);

    /**
     * Вычисляет периметр фигуры
     *
     * @return периметр фигуры
     */
    public abstract double getPerimeter();

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
}
