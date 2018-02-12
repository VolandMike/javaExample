package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Circle {

    private Point2D center;
    private int raduis;

    //Создает Circle по координатам центра и значению радиуса.
    public Circle(Point2D center, int raduis){
        this(center.getX(),center.getY(),raduis);
    }

    //    Создает Circle по координатам центра и значению радиуса.
    public Circle(int xCenter, int yCenter, int radius){
        this.center = new Point2D(xCenter,yCenter);
        this.raduis = radius;
    }
    //Создает Circle с центром в точке (0,0) указанного радиуса.
    public Circle(int radius){
        this(0,0,radius);
    }

    //    Создает Circle с центром в точке (0,0) с радиусом 1.
    public Circle(){
        this(0,0,1);
    }

    //   Возвращает центр Circle.
    public Point2D getCenter(){
        return center;
    }

    //Возвращает радиус Circle.
    public int getRadius()
    {
        return raduis;
    }

    //Устанавливает центр Circle.
    public void setCenter(Point2D center){
        this.center = center;
    }

    //Устанавливает радиус Circle.
    public void setRadius(int radius){
        this.raduis = radius;

    }


    //Передвигает Circle на (dx, dy).
    public void moveRel(int dx, int dy){
        getCenter().moveRel(dx,dy);
    }


    //Увеличивает радиус Circle в n раз, не изменяя центра.
    public void enlarge(int n){
        setRadius(getRadius()*n);
    }
    //Возвращает площадь круга.
    public double getArea(){
        return Math.PI*getRadius()*getRadius();
    }
    //Возвращает периметр окружности.
    public double getPerimeter(){
        return getRadius()*2*Math.PI;
    }
    //Определяет, лежит ли точка (x, y) внутри Circle.
    // Если точка лежит на окружности, считается, что она лежит внутри.
    public boolean isInside(int x, int y){

        //(x-x0)^2 + (y-y0)^2 <= R^2
        return (x - center.getX()) * (x - center.getX()) - (y - center.getY()) * (y - center.getY()) <= getRadius() * getRadius();


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return raduis == circle.raduis &&
                Objects.equals(center, circle.center);
    }

    @Override
    public int hashCode() {

        return Objects.hash(center, raduis);
    }

    //Определяет, лежит ли точка point внутри Circle.
    // Если точка лежит на окружности, считается, что она лежит внутри.
    public boolean isInside(Point2D point){


        return isInside(point.getX(),point.getY());

    }

}
