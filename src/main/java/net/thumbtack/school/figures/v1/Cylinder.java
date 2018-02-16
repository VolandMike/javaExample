package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Cylinder extends Circle {
    private int height;

    //Создает Cylinder по координатам центра, значению радиуса и высоте.
    public Cylinder(Point2D center, int raduis,int height) {
        super(center, raduis);
        this.height = height;
    }
    //Создает Cylinder по координатам центра, значению радиуса и высоте.
    public Cylinder(int xCenter, int yCenter, int radius,int height) {
        super(xCenter, yCenter, radius);
        this.height = height;
    }
    //Создает Cylinder  с центром в точке (0, 0) с указанными радиусом и высотой.
    public Cylinder(int radius,int height) {
        super(radius);
        this.height = height;
    }
    //Создает Cylinder  с центром в точке (0, 0) с радиусом 1 и высотой 1.
    public Cylinder() {
        super();
        this.height = 1;
    }

    @Override
    public Point2D getCenter() {
        return super.getCenter();
    }

    @Override
    public int getRadius() {
        return super.getRadius();
    }

    public int getHeight() {
        return height;
    }
    @Override
    public void setCenter(Point2D center) {
        super.setCenter(center);
    }

    @Override
    public void setRadius(int radius) {
        super.setRadius(radius);
    }


    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void moveRel(int dx, int dy) {
        super.moveRel(dx, dy);
    }

    @Override
    public void enlarge(int n) {
        super.enlarge(n);
    }

    @Override
    public double getArea() {
        return super.getArea();
    }

    @Override
    public double getPerimeter() {
        return super.getPerimeter();
    }

    public double getVolume(){
        return getArea()*height;
    }

    public boolean isInside(int x, int y,int z) {
        return super.isInside(x, y)&&height>=z;
    }
    //    Определяет, лежит ли точка point внутри Cylinder. Если точка лежит на поверхности, считается, что она лежит внутри.
    public boolean isInside(Point3D point){
        return isInside(point.getX(),point.getY(),point.getZ());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cylinder cylinder = (Cylinder) o;
        return height == cylinder.height;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), height);
    }
}
