
package net.thumbtack.school.figures.v2;

import java.util.Objects;

public class Rectangle3D extends Rectangle {

    private int height;

    //Создает Rectangle3D по координатам углов основания (левого верхнего и правого нижнего) и высотой.
    public Rectangle3D(Point2D leftTop, Point2D rightBottom, int height,int color) {
        super(leftTop, rightBottom,color);
        this.height = height;
    }
    //Создает Rectangle3D по координатам углов основания (левого верхнего и правого нижнего) и высотой.
    public Rectangle3D(int xLeft, int yTop, int xRight, int yBottom,int height,int color) {
        super(xLeft, yTop, xRight, yBottom,color);
        this.height = height;
    }
    //Создает Rectangle3D, левый нижний угол которого находится в начале координат, а  длина, ширина и высота задаются.
    public Rectangle3D(int length, int width,int height,int color) {
        super(length, width,color);
        this.height = height;
    }
    //Создает Rectangle3D с размерами (1, 1, 1), левый нижний угол которого находится в начале координат.
    public Rectangle3D(int color) {
        super(color);
        height = 1;
    }

    public int getHeight() {

        return height;
    }


    public void setHeight(int height) {
        this.height = height;
    }


    //Возвращает объем параллелепипеда.
    public double getVolume(){
        return getArea()*height;
    }


    //Определяет, лежит ли точка (x, y, z) внутри Rectangle3D. Если точка лежит на стороне, считается, что она лежит внутри.
    public boolean isInside(int x, int y, int z){
        return isInside(x,y)&&z<=getHeight();
    }
    //Определяет, лежит ли точка point внутри Rectangle3D. Если точка лежит на стороне, считается, что она лежит внутри.
    public boolean isInside(Point3D point){
      return this.isInside(point.getX(),point.getY(),point.getZ());

    }


   public boolean isIntersects(Rectangle3D rectangle){
       return isIntersects((Rectangle)rectangle);

    }

    // Определяет, лежит ли rectangle3D целиком внутри текущего Rectangle3D.
    public boolean isInside(Rectangle3D rectangle){
        return isInside((Rectangle)rectangle)&& rectangle.getHeight()<=height;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rectangle3D that = (Rectangle3D) o;
        return height == that.height;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), height);
    }
}

