package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Triangle {
    private Point2D point1;
    private Point2D point2;
    private Point2D point3;

    //   Создает Triangle по координатам трех точек.
    public Triangle(Point2D point1, Point2D point2, Point2D point3){
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }
    //Возвращает точку 1 треугольника.
    public Point2D getPoint1(){
        return point1;
    }
    //Возвращает точку 2 треугольника.
    public Point2D getPoint2(){
        return point2;
    }
    //Возвращает точку 3 треугольника.
    public Point2D getPoint3(){
        return point3;
    }
    //Устанавливает точку 1 треугольника.
    public void setPoint1(Point2D point){
        this.point1=point;
    }

    //Устанавливает точку 2 треугольника.
    public void setPoint2(Point2D point){
        this.point2 = point;
    }

    //Устанавливает точку 3 треугольника.
    public void setPoint3(Point2D point){
        this.point3=point;
    }
    //Возвращает длину стороны 1-2.
    public double getSide12(){
        int a = point2.getX()-point1.getX();
        int b = point2.getY()-point1.getY();
        return Math.sqrt(a*a+b*b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(point1, triangle.point1) &&
                Objects.equals(point2, triangle.point2) &&
                Objects.equals(point3, triangle.point3);
    }

    @Override
    public int hashCode() {

        return Objects.hash(point1, point2, point3);
    }

    //Возвращает длину стороны 1-3.
    public double getSide13(){
        int a = point3.getX()-point1.getX();
        int c = point3.getY()-point1.getY();
        return Math.sqrt(a*a+c*c);

    }

    //    Возвращает длину стороны 2-3.
    public double getSide23(){
        int b = point3.getX()-point2.getX();
        int c = point3.getY()-point2.getY();
        return Math.sqrt(b*b+c*c);
    }

    //Передвигает Triangle на (dx, dy).
    public void moveRel(int dx, int dy){
        point1.moveRel(dx,dy);
        point2.moveRel(dx,dy);
        point3.moveRel(dx,dy);
    }
    //Возвращает площадь треугольника.
    public double getArea(){
    double p = getPerimeter()/2;

        return Math.sqrt(p*(p-getSide12())*(p-getSide23())*(p-getSide13()));
    }

    //Возвращает периметр треугольника.
    public double getPerimeter(){
        return getSide12()+getSide13()+getSide23();
    }
    //Определяет, лежит ли точка (x, y) внутри Triangle.
    // Если точка лежит на стороне треугольника, считается, что она лежит внутри.
    //Векторный метод
    public boolean isInside(int x, int y) {

        //Переносим треугольник точкой point1 в (0,0)

        int twoX = point2.getX() - point1.getX();
        int twoY = point2.getY() - point1.getY();
        int threeX = point3.getX() - point1.getX();
        int threeY = point3.getY() - point1.getY();
        int fourX = x - point1.getX();
        int fourY = y - point1.getY();

        double m = (fourX * twoY - twoX * fourY) / (threeX * twoY - twoX * threeY);
        double lambda;
        if ((m >= 0) && (m <= 1)) {
            lambda = (fourX - m * threeX) / twoX;
            return (lambda >= 0) && ((m + lambda) <= 1);
        }
            return false;
        }

    //    Определяет, лежит ли точка point внутри Triangle.
    // Если точка лежит на стороне треугольника, считается, что она лежит внутри.
    public boolean isInside(Point2D point){

        return isInside(point.getX(),point.getY());
    }
}
