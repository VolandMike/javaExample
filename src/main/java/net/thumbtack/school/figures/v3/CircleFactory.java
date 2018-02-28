package net.thumbtack.school.figures.v3;

import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorException;

public class CircleFactory {

    private static int circleCount;

    /**
     * Создает Circle по координатам центра и значению радиуса.
     *
     * @param center координаты центра окружности
     * @param radius радиус окружности
     * @param color цвет окружности
     * @throws ColorException Ошибка при неверных параметрах Color
     */
    public static Circle createCircle(Point2D center, int radius, Color color) throws ColorException {

        circleCount++;
        return new Circle(center, radius, color);
    }
    /**
     *
     * @param center координаты центра окружности
     * @param radius радиус окружности
     * @param color цвет окружности
     * @throws ColorException Ошибка при неверных параметрах Color
     */
    public static Circle createCircle(Point2D center, int radius, String color) throws ColorException {
      return createCircle(center, radius, Color.colorFromString(color));
    }


    public static int getCircleCount() {
        return circleCount;
    }

    /**
     * Устанавливает количество Circle,
     * созданных с помощью метода createCircle, равным 0 (иными словами, реинициализирует фабрику).
     */
    public static void reset() {
        circleCount = 0;
    }

}
