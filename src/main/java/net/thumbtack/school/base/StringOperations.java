package net.thumbtack.school.base;


import java.util.StringJoiner;

public class StringOperations {
    //Возвращает суммарную длину строк, заданных массивом strings.
    public static int getSummaryLength(String[] strings) {

        int count = 0;
        for(String i : strings){
            count+=i.length();
        }
        return count;
    }
    //Возвращает двухсимвольную строку, состоящую из начального и конечного символов заданной строки.
    public static String getFirstAndLastLetterString(String first) {

        StringBuilder sb = new StringBuilder();
        sb.append(first.charAt(0));
        sb.append(first.charAt(first.length()-1));

         return String.valueOf(sb);
    }
    //Возвращает true, если обе строки в позиции index содержат один и тот же символ, иначе false.
    public static boolean isSameCharAtPosition(String first, String second, int index) {
        return first.charAt(index) == second.charAt(index);
    }


    //Возвращает true, если в обеих строках первый встреченный символ character находится в одной и той же позиции.
    // Просмотр с трок ведется от начала.
    public static boolean isSameFirstCharPosition(String first, String second, char character) {
        return first.indexOf(character) == second.indexOf(character);
    }

    //Возвращает true, если в обеих строках первый встреченный символ character находится в одной и той же позиции.
    // Просмотр строк ведется от конца
    public static boolean isSameLastCharPosition(String first, String second, char character ) {
        return first.lastIndexOf(character) == second.lastIndexOf(character);
    }

    //Возвращает true, если в обеих строках первая встреченная подстрока str начинается в одной и той же позиции.
    // Просмотр строк ведется от начала.
    public static boolean isSameFirstStringPosition(String string1, String string2, String strl) {
        return string1.indexOf(strl) == string2.indexOf(strl);

    }

    //Возвращает true, если в обеих строках первая встреченная подстрока str начинается в одной и той же позиции.
    // Просмотр строк ведется от конца.
    public static boolean isSameLastStringPosition(String first, String second, String str1) {
        return first.lastIndexOf(str1) == second.lastIndexOf(str1);
    }

    //Возвращает true, если строки равны
    public static boolean isEqual(String first, String second) {
        return first.equals(second);
    }

    //Возвращает true, если строки равны без учета регистра (например, строки “abc” и “aBC” в этом смысле равны).
    public static boolean isEqualIgnoreCase(String first, String second) {
        return first.equalsIgnoreCase(second);
    }

    //Возвращает true, если строка string1 меньше строки string2.
    public static boolean isLess(String string1, String string2) {
        return string1.compareTo(string2) < 0;
    }

    //Возвращает true, если строка string1 меньше строки string2
    // без учета регистра (например, строка “abc” меньше строки “ABCd” в этом смысле).
    public static boolean isLessIgnoreCase(String string1, String string2) {
        return string1.compareToIgnoreCase(string2) < 0;
    }

    //Возвращает строку, полученную путем сцепления двух строк.
    public static String concat(String hello, String world) {
        return hello.concat(world);
    }

    //Возвращает true, если обе строки string1 и string2 начинаются с одной и той же подстроки prefix.
    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        return string1.startsWith(prefix) && string2.startsWith(prefix);

    }

    //Возвращает true, если обе строки string1 и string2 заканчиваются одной и той же подстрокой suffix.
    public static boolean isSameSuffix(String string1, String string2, String prefix) {
        //if(prefix.equals("")) return false;
        return string1.endsWith(prefix) && string2.endsWith(prefix) ;
    }

    //Возвращает самое длинное общее “начало” двух строк. Если у строк нет общего начала, возвращает пустую строку.
    public static String getCommonPrefix(String first, String second) {

        if(first.length() == 0 || second.length() == 0 ) return "";
        StringBuilder sb = new StringBuilder("");
        int length = second.length();
        if(isLess(first,second)) length=first.length();

            for (int i = 0; i < length;i++) {
               if(!(first.charAt(i) == second.charAt(i))) break;
                   sb.append(first.charAt(i));
            }
            return String.valueOf(sb);
    }

    //Возвращает true, если строка является палиндромом, то есть читается слева направо так же, как и справа налево.
    public static boolean isPalindrome(String first) {

        for(int i = 0 ; i < first.length()/2;i++){
            if (first.charAt(i) != first.charAt(first.length()-i-1))
                return false;
            }
            return true;
        }



    //Возвращает true, если строка является палиндромом, то есть читается слева направо так же, как и справа налево, без учета регистра.
    public static boolean isPalindromeIgnoreCase(String string) {
        return isPalindrome(string.toLowerCase());
    }

    //Возвращает самый длинный палиндром (без учета регистра) из массива заданных строк.
    // Если в массиве нет палиндромов, возвращает пустую строку.
    //убрать maxLength
    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        String res = "";
        for(String i: strings){
            if(isPalindromeIgnoreCase(i)&&res.length()<i.length()){
                res = i;
            }
        }
        return res;
    }

    //Возвращает true, если обе строки содержат один и тот же фрагмент длиной length, начиная с позиции index.
    public static boolean hasSameSubstring(String string1, String string2, int length, int index) {

        String st1;
        String st2;
        if(index+length  >string1.length() || index+length  >string2.length())return false;
        st1 = string1.substring(index, index + length);
        st2 = string2.substring(index, index + length);
            return st1.equals(st2);


    }

    //Возвращает true, если после замены в string1 всех вхождений replaceInStr1 на replaceByInStr1 и
    // замены в string2 всех вхождений replaceInStr2
    // на replaceByInStr2 полученные строки равны.
    public static boolean isEqualAfterReplaceCharacters(String first, char replaceInStr1, char replaceByInStr1, String second,
                                                        char replceInStr2, char replaceByInStr2) {
        return first.replace(replaceInStr1,replaceByInStr1).equals(second.replace(replceInStr2,replaceByInStr2));
    }

    //Возвращает true, если после замены в string1 всех вхождений строки replceInStr1 на replaceByInStr1 и замены в string2
    // всех вхождений replceInStr2 на replaceByInStr2 полученные строки равны.
    public static boolean isEqualAfterReplaceStrings(String first, String replceInStr1, String replaceByInStr1 , String second,
                                                     String replceInStr2, String replaceByInStr2) {
        return first.replace(replceInStr1,replaceByInStr1).equals(second.replace(replceInStr2,replaceByInStr2));
    }

    //Возвращает true, если строка после выбрасывания из нее всех пробелов является палиндромом, без учета регистра.
    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String first) {
        return isPalindromeIgnoreCase(first.replace(" ",""));
    }

    //Возвращает true, если две строки равны, если не принимать во внимание все пробелы в начале и конце каждой строки.
    public static boolean isEqualAfterTrimming(String first, String second) {
        return first.trim().equals(second.trim());
    }

    //Для заданного массива целых чисел создает текстовую строку, в которой числа разделены знаком “запятая”
    // (т.н. формат CSV - comma separated values). Для пустого массива возвращается пустая строка.
    public static String makeCsvStringFromInts(int[] array1) {

        if(array1.length==0)return "";
        StringJoiner sj = new StringJoiner(",");
        for(int i : array1){
            sj.add(String.valueOf(i));
        }
        return sj.toString();
    }

    //Для заданного массива вещественных чисел создает текстовую строку, в которой числа разделены знаком “запятая”,
    // причем каждое число записывается с двумя знаками после точки. Для пустого массива возвращается пустая строка.
    public static String makeCsvStringFromDoubles(double[] array1) {

        if(array1.length==0) return "";
        StringJoiner sj = new StringJoiner(",");
        for(double i : array1){
            sj.add(String.format("%.2f", i));
        }
        return sj.toString();
    }

    //То же, что и в упражнении 24, но возвращает StringBuilder.
    public static StringBuilder makeCsvStringBuilderFromInts(int[] array1) {
        return new StringBuilder(makeCsvStringFromInts(array1));
    }

    //То же, что и в упражнении 25, но возвращает StringBuilder.
    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array1) {
       return new StringBuilder(makeCsvStringFromDoubles(array1));
    }

    //Удаляет из строки символы, номера которых заданы в массиве positions. Предполагается,
    //что будут передаваться только допустимые номера, упорядоченные по возрастанию.
    // Номера позиций для удаления указаны для исходной строки. Возвращает полученный в результате StringBuilder.
    public static StringBuilder removeCharacters(String s, int[] position) {

        StringBuilder sb = new StringBuilder(s);
        int count = 0;
       for(int i :position){
          sb.deleteCharAt(i+count);
           count--;
       }
      return sb;
    }

    //Вставляет в строку символы. Массивы positions и characters имеют одинаковую длину.
    // В позицию positions[i] в исходной строке string вставляется символ characters[i].
    // Если в массиве positions один и тот же номер позиции повторяется несколько раз, это значит,
    // что в указанную позицию вставляется несколько символов, в том порядке, в котором они перечислены в массиве characters.
    // Предполагается, что будут передаваться только допустимые номера, упорядоченные по неубыванию.
    // Возвращает полученный в результате StringBuilder.
    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {

        StringBuilder sb = new StringBuilder(string);
        int count = 0;
        for(int i = 0; i < positions.length;i++){
            sb.insert(positions[i]+ count,characters[i]);
            count++;
        }
        return sb;
    }
}