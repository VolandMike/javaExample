package net.thumbtack.school.figures.v2;

import java.util.Objects;

abstract  class Figure implements Colored {
    private int color;


    public Figure(int color) {
        super();
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

    //площадь фигуры
    public abstract double getArea();


    //Определяет, лежит ли точка внутри фигуры
    public abstract boolean isInside(int x, int y);

    public boolean isInside(Point2D point){

        return isInside(point.getX(),point.getY());
    }

    //Передвигает фигуру на (dx, dy).
    public abstract void moveRel(int x, int y);
}
