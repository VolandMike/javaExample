package net.thumbtack.school.matrix;

import java.util.*;

public class MatrixNonSimilarRows {

    private int mas[][];

    public int[][] getMas() {
        return mas;
    }


    /**
     * Создает MatrixNonSimilarRows по заданной матрице.
     *
     * @param matrix
     */
    public MatrixNonSimilarRows(int[][] matrix) {
        this.mas = matrix;

    }

    /**
     * * Дана целочисленная матрица, в которой имеется N строк,
     * а число элементов в строке для каждой строки может быть любым,
     * в том числе нулевым. Строки назовем похожими, если совпадают множества чисел,
     * встречающихся в этих строках. Найти множество строк этой матрицы максимальной размерности,
     * в котором все строки попарно непохожи друг на друга. Из похожих строк в множество включить
     * строку с наименьшим номером.
     * <p>
     * Возвращает набор непохожих строк.
     *
     * @return
     */
    public Set<int[]> getNonSimilarRows() {
        Map<Set<Integer>, int[]> map = new HashMap<>();

        for (int i[] : getMas()) {
            //создаём временный set
            Set<Integer> temp1 = new HashSet<>();
            for (int j : i) {
                temp1.add(j);
            }
            map.putIfAbsent(temp1, i);
        }

        return new HashSet<>(map.values());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatrixNonSimilarRows that = (MatrixNonSimilarRows) o;
        return Arrays.equals(mas, that.mas);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(mas);
    }
}
