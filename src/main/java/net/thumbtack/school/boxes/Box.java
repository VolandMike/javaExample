package net.thumbtack.school.boxes;

import net.thumbtack.school.area.HasArea;
import net.thumbtack.school.figures.v3.Figure;


public class Box<T extends Figure> implements HasArea {


    private T content;


    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Box(T content) {

        this.content = content;
    }


    @Override
    public double getArea() {

        return getContent().getArea();
    }


    /**
     * Cтатический метод isAreaEqual, проверяющий, равны ли площади фигур двух разных Box
     *
     * @param box
     * @param box1
     * @return
     */
    public static boolean isAreaEqual(Box<? extends Figure> box, Box<? extends Figure> box1) {
        return box1.getArea() == box.getArea();
    }

    /**
     * Метод isAreaEqual, проверяет, равна ли площадь фигуры,
     * находящейся в этом Box, площади фигуры, вложенной в другой Box.
     *
     * @param box
     * @return
     */
    public boolean isAreaEqual(Box<? extends Figure> box) {
        return getContent().getArea() == box.getArea();
    }
}
