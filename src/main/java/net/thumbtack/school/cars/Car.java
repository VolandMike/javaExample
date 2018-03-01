package net.thumbtack.school.cars;

import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorErrorCode;
import net.thumbtack.school.colors.ColorException;
import net.thumbtack.school.colors.Colored;

public class Car  implements Colored {

    private String model;
    private int weight;
    private int maxSpeed;
    private Color color;


    /**
     * Создает автомобиль указанной модели, веса (в килограммах), максимальной скорости и цвета.
     * @param model модель авто
     * @param weight вес(кг)
     * @param maxSpeed Максимальная скорость
     * @param color цвет авто
     * @throws ColorException Ошибка при неверных параметрах Colo
     */
    public Car(String model, int weight, int maxSpeed, Color color) throws ColorException {
       setModel(model);
       setWeight(weight);
       setMaxSpeed(maxSpeed);
       setColor(color);
    }

    /**
     * Создает автомобиль указанной модели, веса (в килограммах), максимальной скорости и цвета.
     * @param model модель авто
     * @param weight вес(кг)
     * @param maxSpeed максимальная скорость
     * @param color цвет авто (Задаётся строкой)
     * @throws ColorException Ошибка при неверных параметрах Color
     */
    public Car(String model, int weight, int maxSpeed, String color) throws ColorException {

        this(model,weight,maxSpeed,Color.colorFromString(color));
    }

    @Override
    public void setColor(Color color) throws ColorException {
        if (color == null) throw new ColorException(ColorErrorCode.NULL_COLOR);
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(String colorString) throws ColorException {
        this.color = Color.colorFromString(colorString);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
