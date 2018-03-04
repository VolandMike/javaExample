package net.thumbtack.school.boxes;

import net.thumbtack.school.area.HasArea;
import net.thumbtack.school.figures.v3.Figure;



public class PairBox<T extends Figure, T1 extends Figure> implements HasArea {

    private T contentFirst;
    private T1 contentTwo;

    public PairBox(T contentFirst, T1 contentTwo) {
        this.contentFirst = contentFirst;
        this.contentTwo = contentTwo;
    }

    public T getContentFirst() {
        return contentFirst;
    }

    public void setContentFirst(T contentFirst) {
        this.contentFirst = contentFirst;
    }

    public T1 getContentTwo() {
        return contentTwo;
    }

    public void setContentTwo(T1 contentTwo) {
        this.contentTwo = contentTwo;
    }

    /**
     * метод getArea возвращает сумму площадей пары вложенных фигур
     *
     * @return
     */
    @Override
    public double getArea() {
        return getContentFirst().getArea() + getContentTwo().getArea();

    }

    /**
     * метод isAreaEqual, проверяет, равна ли сумма площадей двух фигур,
     * находящихся в этом PairBox, сумме площадей фигур, вложенных в другой pairBox
     * @param pairBox
     * @return
     */
    public boolean isAreaEqual(PairBox<? extends Figure, ? extends Figure> pairBox) {
        return getArea() == pairBox.getArea();
    }

    /**
     * метод isAreaEqual, проверяющий, равна ли эти суммы у двух разных PairBox.
     * @param pairBox1
     * @param pairBox2
     * @return
     */
    public static boolean isAreaEqual(PairBox<? extends Figure, ? extends Figure> pairBox1,
                                      PairBox<? extends Figure, ? extends Figure> pairBox2) {
        return pairBox1.getArea() == pairBox2.getArea();
    }
}
