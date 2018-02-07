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
        this.leftTop=new Point2D(xLeft,yTop);
        this.rightBottom = new Point2D(xRight,yBottom);
    }

//Создает Rectangle, левый нижний угол которого находится в начале координат,
// а  длина (по оси X) и ширина (по оси Y) задаются.
    public Rectangle(int length, int width){
        this.leftTop = new Point2D(0,-width);
        this.rightBottom = new Point2D(length,0);
    }

//Создает Rectangle с размерами (1,1), левый нижний угол которого находится в начале координат.
    public Rectangle(){
        this.leftTop = new Point2D(0,-1);
        this.rightBottom = new Point2D(1,0);
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
    public double getPerimeter(){return 2*getWidth()+2*getLength();}

    //Определяет, лежит ли точка (x, y) внутри Rectangle. Если точка лежит на стороне, считается, что она лежит внутри.
    public boolean isInside(int x, int y){

        if(x<getTopLeft().getX()||x>getBottomRight().getX()||y<getTopLeft().getY()||y>getBottomRight().getY())
            return false;

return true;
    }

    //Определяет, лежит ли точка point внутри Rectangle. Если точка лежит на стороне, считается, что она лежит внутри.
    public boolean isInside(Point2D point){
        if(point.getX()<getTopLeft().getX()||point.getX()>getBottomRight().getX()||point.getY()<getTopLeft().getY()||point.getY()>getBottomRight().getY())
            return false;

        return true;}

    // Определяет, пересекается  ли Rectangle с другим Rectangle. Считается, что прямоугольники пересекаются,
    // если у них есть хоть одна общая точка.
  /*  public boolean isIntersects(Rectangle rectangle){
        if((getTopLeft().getX()<=rectangle.getTopLeft().getX()||rectangle.getBottomRight().getX()<=getBottomRight().getX())
                ||((getTopLeft().getY()<=rectangle.getTopLeft().getY()||rectangle.getBottomRight().getY()<=getBottomRight().getY())))
                return true;
        return false;}
*/
    //   Определяет, лежит ли rectangle целиком внутри текущего Rectangle.
    public boolean isInside(Rectangle rectangle){
        if(rectangle.getBottomRight().getX()<=getBottomRight().getX()&&rectangle.getBottomRight().getY()<=getBottomRight().getY()
        &&rectangle.getTopLeft().getX()>=getTopLeft().getX()&&rectangle.getTopLeft().getY()>=getTopLeft().getY())
            return true;
        return false;
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
