package net.thumbtack.school.introduction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FirstSteps {

    /*
     * Возвращает сумму чисел x и y.
     * */
    public int sum (int x, int y){
        return x+y;
    }
    /*
     * Возвращает произведение чисел x и y.
     */
    public int mul(int x, int y) {
        return x*y;
    }
    /*
     * Возвращает частное от деления чисел x и y. Гарантируется, что y != 0.
     * */
    public int div (int x, int y){
        double z;
        if(y!=0)
        {
            z = x/y;
            return (int) z;
        }
        return 0;
    }
    /*
     * Возвращает остаток от деления чисел x и y. Гарантируется, что y != 0.
     */
    public int mod (int x, int y){
        if(y!=0)
        {
            return x%y;
        }

        return 0;
    }
    /*
    Возвращает true, если  x равен y, иначе false.
     */
    public boolean isEqual (int x, int y){
        return x == y;
    }
    /*
    Возвращает true, если  x больше y, иначе false.
     */
    public boolean isGreater (int x, int y){

        return x > y;

    }
    /*
       Прямоугольник с горизонтальными и вертикальными сторонами,
       задан двумя точками - левой верхней (xLeft, yTop) и правой нижней (xRight, yBottom).
       На плоскости OXY ось X направлена вправо, ось Y - вниз.
       Дана еще одна точка с координатами (x, y). Гарантируется, что xLeft < xRight и yTop < yBottom.
       Метод должен возвращать true, если точка лежит внутри прямоугольника , иначе false.
       Если точка лежит на границе прямоугольника, то считается, что она лежит внутри него.
     */
    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y)
    {
        return xLeft <= x && x <= xRight && yTop <= y && y <= yBottom;
    }
    /*
    Возвращает сумму чисел, заданных одномерным массивом array. Для пустого одномерного массива возвращает 0.
     */
    public int sum(int[] array){
        if(array.length == 0)return 0;

        int x = 0;

        for(int i: array){
            x+= i;
        }
        return x;
    }
    /*
Возвращает произведение чисел, заданных одномерным массивом array. Для пустого одномерного массива возвращает 0.
     */
    public int mul(int[] array){
        if(array.length == 0)return 0;
        int sum = 1;
        int x = 1;

            //int i = array.length;
            for (int elem : array) {
                sum*= elem;

            }


        return sum;

    }

    /*
Возвращает минимальное из чисел, заданных одномерным массивом array.
 Для пустого одномерного массива возвращает Integer.MAX_VALUE.
     */
    public int min(int[] array){
        if(array.length == 0)return Integer.MAX_VALUE;

        int res = array[0];
        int buff;
        for(int i : array)
        {
            buff = i;
            if(buff<res)
                res=buff;
        }
        /*for(int i = array.length - 1 ; i>0 ; i--){
            for(int j=0 ; j < i ; j++){
                if(array[j] > array[j+1]){
                    int t = array[j];
                    array[j]=array[j+1];
                    array[j+1]=t;
                }
            }
        }*/
        return res;
    }
    /*
Возвращает максимальное из чисел, заданных одномерным массивом array.
 Для пустого одномерного массива возвращает Integer.MIN_VALUE.
     */
    public int max(int[] array){
        if(array.length == 0)
            return Integer.MIN_VALUE;
      /*  for(int i = array.length - 1 ; i>0 ; i--)
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }*/
        int res = array[0];
        int buff;
        for(int i : array)
        {
            buff = i;
            if(buff>res)
                res=buff;
        }
        return res;

    }
    /*
Возвращает среднее значение для чисел, заданных одномерным массивом array. Для пустого одномерного массива возвращает 0.
     */
    public double average(int[] array){

        if(array.length == 0)return 0;

        double avg=sum(array);

        avg = avg/array.length;

        return avg;
    }
    /*
    Возвращает true, если одномерный массив array строго упорядочен по убыванию, иначе false.
    Пустой одномерный массив считается упорядоченным.
     */
    public boolean isSortedDescendant(int[] array){
        if(array.length == 0)return true;

        int x = array[0];
        for(int i = 1 ; i < array.length; i++){
            if(x<array[i]) {return false;}
            else if(x == array[i]){return false;}
            if(x>array[i]){

                x=array[i];
            }
        }
        return true;
    }
    /*
    Возводит все элементы одномерного массива array в куб.
     */
    public void cube(int[] array) {
        int cube;
        int tmp;

        for(int i = 0; i < array.length; i++){
            tmp = array[i];
            cube = tmp*tmp*tmp;
            array[i]=cube;

        }

    }
    /*
    Возвращает true, если в одномерном массиве array имеется элемент, равный value, иначе false.
     */
    public boolean find(int[]array, int value){
        for (int i : array)
        {
            if(array[i]==value) return true;
        }
        return false;
    }
    /*
      Переворачивает одномерный массив array, то есть меняет местами 0-й и последний, 1-й и предпоследний и т.д. элементы.
       */
    public void reverse(int[] array) {


        int tmp;
        for (int i = 0; i < array.length / 2; i++) {
            tmp = array[array.length - i-1];
            array[array.length - i-1] = array[i];
            array[i] = tmp;
        }

    }
    /*
    Возвращает true, если одномерный массив является палиндромом, иначе false. Пустой массив считается палиндромом.
     */
    public boolean isPalindrome(int[]array){
        if(array.length==0||array.length==1)return true;
        for(int i = 0; i < array.length/2;i++){
            if(array[array.length-i-1]!=array[i]) return false;
        }
        return true;
    }
    /*

    Возвращает сумму чисел, заданных двумерным массивом matrix.
     */
    public int sum(int[][] matrix){
        int sum = 0;

        for (int[] aMatrix : matrix)
            for (int j = 0; j < matrix.length; j++) {
                sum += aMatrix[j];
            }

        return sum;
    }
    /*
Возвращает максимальное из чисел, заданных двумерным массивом matrix.
Для пустого двумерного массива возвращает Integer.MIN_VALUE.
     */
    public int max(int[][] matrix){
        int sum = Integer.MIN_VALUE;



        try {

            for (int[] aMatrix : matrix)
                for (int j = 0; j < matrix.length; j++) {
                    if (aMatrix[j] >= sum) sum = aMatrix[j];
                }
            return sum;
        }catch (ArrayIndexOutOfBoundsException e){
            return sum;
        }
    }
    /*
  Возвращает максимальное из чисел, находящихся на главной диагонали квадратного двумерного массива matrix.
   Для пустого двумерного массива возвращает Integer.MIN_VALUE.
     */
    public int diagonalMax(int[][] matrix){

        try {
            //int sum = Integer.MIN_VALUE;

            ArrayList<Integer> temp = new ArrayList<>();


            for (int i = 0; i < matrix.length; i++)
                for (int j = 0; j < matrix.length; j++) {
                    if (i == j) temp.add(matrix[i][j]);
                }

            temp.sort((o1, o2) -> o1 - o2);
            int res =temp.get(temp.size()-1);
            System.out.println("");
            return res;
        }catch (ArrayIndexOutOfBoundsException e){
            return Integer.MIN_VALUE;
        }

    }
    /*
        public boolean isSortedDescendant(int[][] matrix)
  Возвращает true, если все строки двумерного массива matrix строго упорядочены по убыванию, иначе false.
   Пустой одномерный массив считается упорядоченным. Разные строки массива matrix могут иметь разное количество элементов.
    При написании метода рекомендуется внутри него вызвать метод из п. 13.

     */
    public boolean isSortedDescendant(int[][] matrix){
        try {
            int prevvalue;
            for (int[] aMatrix : matrix) {
                prevvalue = aMatrix[0];
                for (int j = 1; j < aMatrix.length; j++) {
                    if (aMatrix[j] >= prevvalue) {
                        return false;
                    } else {
                        prevvalue = aMatrix[j];
                    }
                }
            }

        }catch (ArrayIndexOutOfBoundsException e){
            return true;
        }

        return true;
    }
}
