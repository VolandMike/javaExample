package net.thumbtack.school.boxes;


import net.thumbtack.school.figures.v3.Figure;


public class ArrayBox<T extends Figure> {
    private T[] content;


    /**
     * конструктор,  принимающий массив экземпляров вложенных объектов
     *
     * @param content
     */
    public ArrayBox(T[] content) {

        this.content = content;
    }


    public T[] getContent() {
        return content;
    }

    public void setContent(T[] content) {
        this.content = content;
    }


    /**
     * Метод setElement, устанавливает i-й элемент вложенного массива
     *
     * @param content
     * @param index
     */
    public void setElement(T content, int index) {
        getContent()[index] = content;

    }

    /**
     * Метод getElement, возвращает i-й элемент вложенного массива
     *
     * @param index
     * @return
     */
    public T getElement(int index) {
        return content[index];
    }

    /**
     * Метод isSameSize проверяет, равен ли размер вложенного массива,
     * размеру вложенного массива другого ArrayBox.
     *
     * @param ArrayBox
     * @return
     */
    public boolean isSameSize(ArrayBox<? extends Figure> ArrayBox) {
        return content.length == ArrayBox.content.length;
    }
}
