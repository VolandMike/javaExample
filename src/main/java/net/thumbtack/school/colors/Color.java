package net.thumbtack.school.colors;

public enum Color {
    RED("RED"),
    GREEN("GREEN"),
    BLUE("BLUE");

    Color(String blue) {

    }

    /**
     * Метод получает на вход строку - цвет, возвращает Color - цвет
     * @param colorString Строка - цвет
     * @return Сolor - цвет
     * @throws ColorException Ошибка при неверных параметрах Color
     */
    public static Color colorFromString(String colorString) throws ColorException{

        try{
            return Color.valueOf(colorString);

        }catch (NullPointerException e)
        {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }catch (IllegalArgumentException e){
            throw new ColorException(ColorErrorCode.WRONG_COLOR_STRING);
        }

    }

}
