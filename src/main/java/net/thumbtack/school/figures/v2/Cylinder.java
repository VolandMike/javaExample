package net.thumbtack.school.figures.v2;


import java.util.Objects;

public class Cylinder extends Circle {
    private int height;


    /**
     * Создает Cylinder по координатам центра, значению радиуса и высоте.
     *
     * @param center
     * @param raduis
     * @param height
     * @param color
     */
    public Cylinder(Point2D center, int raduis, int height, int color) {
        super(center, raduis, color);
        this.height = height;
    }

    /**
     * Создает Cylinder по координатам центра, значению радиуса и высоте.
     *
     * @param xCenter
     * @param yCenter
     * @param radius
     * @param height
     * @param color
     */
    public Cylinder(int xCenter, int yCenter, int radius, int height, int color) {
        this(new Point2D(xCenter, yCenter), radius, height, color);
    }

    /**
     * Создает Cylinder  с центром в точке (0, 0) с указанными радиусом и высотой.
     *
     * @param radius
     * @param height
     * @param color
     */
    public Cylinder(int radius, int height, int color) {
        this(0, 0, radius, height, color);
    }

    /**
     * Создает Cylinder  с центром в точке (0, 0) с радиусом 1 и высотой 1.
     *
     * @param color
     */
    public Cylinder(int color) {
        this(0, 0, 1, 1, color);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Метод возвращает объем Cylinder.
     *
     * @return Объем Cylinder
     */
    public double getVolume() {
        return getArea() * height;
    }

    /**
     * Определяет, лежит ли точка c координатами x,y,z  внутри Cylinder.
     * Если точка лежит на поверхности, считается, что она лежит внутри.
     *
     * @param x
     * @param y
     * @param z
     * @return true - лежит, false - не лежит
     */
    public boolean isInside(int x, int y, int z) {
        return super.isInside(x, y) && height >= z;
    }

    /**
     * Определяет, лежит ли точка point  внутри Cylinder.
     * Если точка лежит на поверхности, считается, что она лежит внутри.
     *
     * @param point
     * @return true - лежит, false - не лежит
     */
    public boolean isInside(Point3D point) {
        return this.isInside(point.getX(), point.getY(), point.getZ());
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
