package net.thumbtack.school.figures.v2;

public class CircleFactory {

    private static int circleCount;

    // Создает Circle по координатам центра и значению радиуса.
    public static Circle createCircle(Point2D center, int radius, int color) {

        circleCount++;
        return new Circle(center, radius, color);
    }

    //Возвращает количество Circle, созданных с помощью метода createCircle.
    public static int getCircleCount() {
        return circleCount;
    }

    //Устанавливает количество Circle,
    // созданных с помощью метода createCircle, равным 0 (иными словами, реинициализирует фабрику).
    public static void reset() {
        circleCount = 0;
    }

}
