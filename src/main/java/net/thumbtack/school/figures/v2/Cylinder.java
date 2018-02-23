package net.thumbtack.school.figures.v2;

import java.util.Objects;

public class Cylinder extends Circle  {
    private int height;



    //Создает Cylinder по координатам центра, значению радиуса и высоте.
    public Cylinder(Point2D center, int raduis, int height,int color) {
        super(center, raduis,color);
        this.height = height;
    }
    //Создает Cylinder по координатам центра, значению радиуса и высоте.
    public Cylinder(int xCenter, int yCenter, int radius,int height,int color) {
        super(xCenter, yCenter, radius,color);
        this.height = height;
    }
    //Создает Cylinder  с центром в точке (0, 0) с указанными радиусом и высотой.
    public Cylinder(int radius,int height,int color) {
        super(radius,color);
        this.height = height;
    }
    //Создает Cylinder  с центром в точке (0, 0) с радиусом 1 и высотой 1.
    public Cylinder(int color) {
        super(color);
        this.height = 1;
    }



    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }



    //Возвращает объем Cylinder.
    public double getVolume(){
        return getArea()*height;
    }


    public boolean isInside(int x, int y,int z) {
        return super.isInside(x, y)&&height>=z;
    }
    //    Определяет, лежит ли точка point внутри Cylinder. Если точка лежит на поверхности, считается, что она лежит внутри.
    public boolean isInside(Point3D point){
        return this.isInside(point.getX(),point.getY(),point.getZ());
    }


}
