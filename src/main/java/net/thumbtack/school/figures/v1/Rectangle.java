package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Rectangle {
    private Point2D leftTop;
    private Point2D rightBottom;

//    Создает Rectangle по координатам углов - левого верхнего и правого нижнего.
    public Rectangle(Point2D leftTop, Point2D rightBottom) {
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;

    }
    //Создает Rectangle по координатам углов - левого верхнего и правого нижнего.
    public Rectangle(int xLeft, int yTop, int xRight, int yBottom){

        this(new Point2D(xLeft,yTop),new Point2D(xRight,yBottom));
    }

//Создает Rectangle, левый нижний угол которого находится в начале координат,
// а  длина (по оси X) и ширина (по оси Y) задаются.
    public Rectangle(int length, int width){
        this(0,-width,length,0);
    }

//Создает Rectangle с размерами (1,1), левый нижний угол которого находится в начале координат.
    public Rectangle(){
        this(0,-1,1,0);
    }
//Возвращает левую верхнюю точку Rectangle.
    public Point2D getTopLeft(){
        return leftTop;
    }



    //  Возвращает правую нижнюю точку Rectangle.
    public Point2D getBottomRight(){return rightBottom;}

    //Устанавливает левую верхнюю точку Rectangle.
    public void setTopLeft(Point2D topLeft){
        this.leftTop = topLeft;
    }


    // Устанавливает правую нижнюю точку Rectangle.
    public void setBottomRight(Point2D bottomRight){
        this.rightBottom = bottomRight;

    }

    //Возвращает длину прямоугольника.
    public int getLength(){
        return Math.abs(getBottomRight().getX()-getTopLeft().getX());
    }

    //Возвращает ширину прямоугольника.
    public int getWidth(){return Math.abs(getTopLeft().getY()-getBottomRight().getY());}

    // Передвигает Rectangle на (dx, dy).
    public void moveRel(int dx, int dy){
        getTopLeft().moveRel(dx,dy);
        getBottomRight().moveRel(dx,dy);
    }

    // Увеличивает стороны Rectangle в (nx, ny) раз при сохранении координат левой верхней вершины.
    public void enlarge(int nx, int ny){
        rightBottom.moveTo(getLength()*nx +getTopLeft().getX() ,getWidth()*ny + getTopLeft().getY() );

    }


    //Возвращает площадь прямоугольника.
    public double getArea(){
        return getWidth()*getLength();
    }

    //    Возвращает периметр прямоугольника.
    public double getPerimeter(){return 2*(getWidth()+getLength());}

    //Определяет, лежит ли точка (x, y) внутри Rectangle. Если точка лежит на стороне, считается, что она лежит внутри.
    public boolean isInside(int x, int y){

        return x >= leftTop.getX() && x <= rightBottom.getX() && y >= leftTop.getY() && y <= rightBottom.getY();
    }

    //Определяет, лежит ли точка point внутри Rectangle. Если точка лежит на стороне, считается, что она лежит внутри.
    public boolean isInside(Point2D point){

        return isInside(point.getX(),point.getY());
    }

    // Определяет, пересекается  ли Rectangle с другим Rectangle. Считается, что прямоугольники пересекаются,
    // если у них есть хоть одна общая точка.
  public boolean isIntersects(Rectangle rectangle){

      return rectangle.getTopLeft().getX() <= rightBottom.getX() && rectangle.getBottomRight().getX() >= leftTop.getX() &&
              rectangle.getTopLeft().getY() <= rightBottom.getY() && rectangle.getBottomRight().getY() >= leftTop.getY();
  }
    //   Определяет, лежит ли rectangle целиком внутри текущего Rectangle.
    public boolean isInside(Rectangle rectangle){
        return rectangle.getBottomRight().getX() <= rightBottom.getX() && rectangle.getBottomRight().getY() <= rightBottom.getY()
                && rectangle.getTopLeft().getX() >= leftTop.getX() && rectangle.getTopLeft().getY() >= leftTop.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(leftTop, rectangle.leftTop) &&
                Objects.equals(rightBottom, rectangle.rightBottom);
    }

    @Override
    public int hashCode() {

        return Objects.hash(leftTop, rightBottom);
    }
}
