package net.thumbtack.school.file;

import com.google.gson.Gson;
import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorException;
import net.thumbtack.school.figures.v3.Point2D;
import net.thumbtack.school.figures.v3.Rectangle;
import net.thumbtack.school.ttschool.Trainee;
import net.thumbtack.school.ttschool.TrainingException;

import java.io.*;

public class FileService {
    /**
     * Записывает массив байтов в двоичный файл, имя файла задается  экземпляром класса File.
     *
     * @param file
     * @param arrayToWrite
     * @throws IOException
     */
    public static void writeByteArrayToBinaryFile(File file, byte[] arrayToWrite) {

        try (FileOutputStream f = new FileOutputStream(file)) {
            f.write(arrayToWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Записывает массив байтов в двоичный файл, имя файла задается текстовой строкой.
     *
     * @param fileName
     * @param array
     * @throws IOException
     */
    public static void writeByteArrayToBinaryFile(String fileName, byte[] array) {

        writeByteArrayToBinaryFile(new File(fileName), array);
    }

    /**
     * Читает массив байтов из двоичного файла, имя файла задается экземпляром класса File.
     *
     * @param file
     * @return
     */
    public static byte[] readByteArrayFromBinaryFile(File file) {

        try (FileInputStream f = new FileInputStream(file)) {
            byte[] array = new byte[f.available()];
            f.read(array);
            return array;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Читает массив байтов из двоичного файла, имя файла задается текстовой строкой.
     *
     * @param fileName
     * @return
     */
    public static byte[] readByteArrayFromBinaryFile(String fileName) {
        return readByteArrayFromBinaryFile(new File(fileName));
    }

    /**
     * Записывает массив байтов в ByteArrayOutputStream,
     * создает на основе данных в полученном  ByteArrayOutputStream
     * экземпляр ByteArrayInputStream и читает из ByteArrayInputStream четные байты.
     * Возвращает массив прочитанных байтов.
     *
     * @param array
     * @return
     */
    public static byte[] writeAndReadByteArrayUsingByteStream(byte[] array) throws IOException {
        byte[] buff = new byte[array.length / 2];
        try (ByteArrayOutputStream f = new ByteArrayOutputStream()) {
            f.write(array);

            byte[] arrayByte = f.toByteArray();
            buff = new byte[arrayByte.length / 2];
            int j = 0;
            for (int i = 0; i < arrayByte.length; i = i + 2) {
                buff[j] = arrayByte[i];
                j++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (ByteArrayInputStream ios = new ByteArrayInputStream(buff)) {
            byte[] result = new byte[buff.length];
            ios.read(result);
            return result;


        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * Записывает массив байтов в двоичный файл, используя буферизованный вывод,
     * имя файла задается текстовой строкой
     *
     * @param fileName
     * @param array
     */
    public static void writeByteArrayToBinaryFileBuffered(String fileName, byte[] array) {
        writeByteArrayToBinaryFileBuffered(new File(fileName), array);
    }

    /**
     * Записывает массив байтов в двоичный файл,
     * используя буферизованный вывод, имя файла задается экземпляром класса File.
     *
     * @param file
     * @param array
     */
    public static void writeByteArrayToBinaryFileBuffered(File file, byte[] array) {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {
            bos.write(array);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Читает массив байтов из двоичного файла, используя буферизованный ввод,
     * имя файла задается текстовой строкой.
     *
     * @param fileName
     * @return
     */
    public static byte[] readByteArrayFromBinaryFileBuffered(String fileName) {
        return readByteArrayFromBinaryFileBuffered(new File(fileName));
    }

    /**
     * Читает массив байтов из двоичного файла, используя буферизованный ввод,
     * имя файла задается экземпляром класса File.
     *
     * @param file
     * @return
     */
    public static byte[] readByteArrayFromBinaryFileBuffered(File file) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            byte[] result = new byte[bis.available()];
            bis.read(result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Записывает Rectangle в двоичный файл, имя файла задается экземпляром класса File.
     * Поле цвета не записывать.
     *
     * @param file
     * @param rect
     */
    public static void writeRectangleToBinaryFile(File file, Rectangle rect) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeInt(rect.getTopLeft().getX());
            dos.writeInt(rect.getTopLeft().getY());
            dos.writeInt(rect.getBottomRight().getX());
            dos.writeInt(rect.getBottomRight().getY());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Читает данные для Rectangle из двоичного файла и создает на их основе экземпляр Rectangle,
     * имя файла задается экземпляром класса File. Предполагается, что данные в файл записаны
     * в формате предыдущего упражнения. Поскольку файл не содержит цвета, установить в Rectangle цвет “RED”.
     *
     * @param file
     * @return
     */
    public static Rectangle readRectangleFromBinaryFile(File file) throws ColorException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            return new Rectangle(dis.readInt(), dis.readInt(), dis.readInt(), dis.readInt(), Color.RED);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Записывает массив из Rectangle в двоичный файл,
     * имя файла задается экземпляром класса File. Поле цвета не записывать.
     *
     * @param file
     * @param rects
     */
    public static void writeRectangleArrayToBinaryFile(File file, Rectangle[] rects) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            for (int i = 0; i < rects.length; i++) {
                dos.writeInt(rects[i].getTopLeft().getX());
                dos.writeInt(rects[i].getTopLeft().getY());
                dos.writeInt(rects[i].getBottomRight().getX());
                dos.writeInt(rects[i].getBottomRight().getY());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Предполагается, что данные в файл записаны в формате предыдущего упражнения.
     * Метод читает вначале данные о последнем записанном в файл Rectangle и создает на их основе
     * экземпляр Rectangle, затем читает данные следующего с конца Rectangle и создает на их основе
     * экземпляр Rectangle и т.д.  вплоть до данных для самого первого записанного в файл Rectangle.
     * Из созданных таким образом экземпляров Rectangle создается массив, который и возвращает метод.
     * Поскольку файл не содержит цвета, установить во всех Rectangle цвет “RED”.
     *
     * @param file
     * @return
     */
    public static Rectangle[] readRectangleArrayFromBinaryFileReverse(File file) {


        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            int size = (int) raf.length();
            Rectangle[] rect = new Rectangle[size / 16];

            for (int i = 0; i < rect.length; i++) {
                raf.seek(size - i * 16 - 16);
                rect[i] = new Rectangle(raf.readInt(), raf.readInt(), raf.readInt(), raf.readInt(), Color.RED);
            }
            return rect;
        } catch (IOException | ColorException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Записывает Rectangle в текстовый файл в одну строку, имя файла задается экземпляром класса File.
     * Поля в файле разделяются пробелами. Поле цвета не записывать.
     *
     * @param file
     * @param rect
     */
    public static void writeRectangleToTextFileOneLine(File file, Rectangle rect) {
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file))) {
            osw.write(String.valueOf(rect.getTopLeft().getX()) + " "
                    + String.valueOf(rect.getTopLeft().getY()) + " "
                    + String.valueOf(rect.getBottomRight().getX()) + " "
                    + String.valueOf(rect.getBottomRight().getY()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Читает данные для Rectangle из текстового файла и создает на их основе экземпляр Rectangle,
     * имя файла задается экземпляром класса File.
     * Предполагается, что данные в файл записаны в формате предыдущего упражнения.
     * Поскольку файл не содержит цвета, установить в Rectangle цвет “RED”
     *
     * @param file
     * @return
     */
    public static Rectangle readRectangleFromTextFileOneLine(File file) {


        try (BufferedReader bw = new BufferedReader(new FileReader(file))) {

            String[] mas = bw.readLine().split(" ");

            return new Rectangle(new Point2D(Integer.valueOf(mas[0]), Integer.valueOf(mas[1])),
                    new Point2D(Integer.valueOf(mas[2]), Integer.valueOf(mas[3])), Color.RED);

        } catch (IOException | ColorException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Записывает Rectangle в текстовый файл, каждое число в отдельной строке ,
     * имя файла задается экземпляром класса File. Поле цвета не записывать.
     *
     * @param file
     * @param rect
     */
    public static void writeRectangleToTextFileFourLines(File file, Rectangle rect) {
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file))) {
            osw.write(String.valueOf(rect.getTopLeft().getX()) + "\r\n"
                    + String.valueOf(rect.getTopLeft().getY()) + "\r\n"
                    + String.valueOf(rect.getBottomRight().getX()) + "\r\n"
                    + String.valueOf(rect.getBottomRight().getY()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Читает данные для Rectangle из текстового файла и создает на их основе экземпляр Rectangle,
     * имя файла задается экземпляром класса File.
     * Предполагается, что данные в файл записаны в формате предыдущего упражнения.
     * Поскольку файл не содержит цвета, установить в Rectangle цвет “RED”
     *
     * @param file
     * @return
     */
    public static Rectangle readRectangleFromTextFileFourLines(File file) {
        try (BufferedReader bw = new BufferedReader(new FileReader(file))) {

            StringBuilder s = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                s.append(bw.readLine()).append(" ");
            }
            String[] mas = s.toString().split(" ");

            return new Rectangle(new Point2D(Integer.valueOf(mas[0]), Integer.valueOf(mas[1])),
                    new Point2D(Integer.valueOf(mas[2]), Integer.valueOf(mas[3])), Color.RED);

        } catch (IOException | ColorException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * Записывает Trainee в текстовый файл в одну строку в кодировке UTF-8,
     * имя файла задается экземпляром класса File.
     * Имя, фамилия и оценка в файле разделяются пробелами.
     *
     * @param file
     * @param trainee
     */
    public static void writeTraineeToTextFileOneLine(File file, Trainee trainee) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter
                (new FileOutputStream(file), "UTF-8"))) {
            bw.write(trainee.getFullName() + " " + trainee.getRating());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Читает данные для Trainee из текстового файла и создает на их основе экземпляр Trainee,
     * имя файла задается экземпляром класса File.
     * Предполагается, что данные в файл записаны в формате предыдущего упражнения.
     *
     * @param file
     * @return
     */
    public static Trainee readTraineeFromTextFileOneLine(File file) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader
                (new FileInputStream(file), "UTF-8"))) {
            String[] mas = br.readLine().split(" ");
            return new Trainee(mas[0], mas[1], Integer.valueOf(mas[2]));
        } catch (IOException | TrainingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Записывает Trainee в текстовый файл в кодировке UTF-8, каждое поле в отдельной строке,
     * имя файла задается экземпляром класса File.
     *
     * @param file
     * @param trainee
     */
    public static void writeTraineeToTextFileThreeLines(File file, Trainee trainee) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter
                (new FileOutputStream(file), "UTF-8"))) {
            bw.write(trainee.getFirstName()+"\r\n"
                    + trainee.getLastName()+ "\r\n"
                    + trainee.getRating());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Читает данные для Trainee из текстового файла и создает на их основе экземпляр Trainee,
     * имя файла задается экземпляром класса File.
     * Предполагается, что данные в файл записаны в формате предыдущего упражнения.
     *
     * @param file
     * @return
     */
    public static Trainee readTraineeFromTextFileThreeLines(File file) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader
                (new FileInputStream(file), "UTF-8"))) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                s.append(br.readLine()).append(" ");
            }
            String[] mas = s.toString().split(" ");
            return new Trainee(mas[0], mas[1], Integer.valueOf(mas[2]));
        } catch (IOException | TrainingException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Сериализует Trainee в двоичный файл, имя файла задается экземпляром класса File.
     * @param file
     * @param trainee
     */
    public static void  serializeTraineeToBinaryFile(File file, Trainee trainee){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(trainee);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  Десериализует Trainee из двоичного файла, имя файла задается экземпляром класса File.
     *  Предполагается, что данные в файл записаны в формате предыдущего упражнения.

     * @param file
     * @return
     */
    public static Trainee  deserializeTraineeFromBinaryFile(File file){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Trainee) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Сериализует Trainee в формате Json в текстовую строку.
     * @param trainee
     * @return
     */
    public static String  serializeTraineeToJsonString(Trainee trainee){

        return new Gson().toJson(trainee);
    }

    /**
     *  Десериализует Trainee из текстовой строки с Json-представлением Trainee.
     * @param json
     * @return
     */
    public static Trainee  deserializeTraineeFromJsonString(String json){
        Gson gson = new Gson();
        Trainee trainee =  gson.fromJson(json,Trainee.class);

        return trainee;
    }

    /**
     *   Сериализует Trainee в формате Json в файл, имя файла задается экземпляром класса File.
     * @param file
     * @param trainee
     */
    public static void  serializeTraineeToJsonFile(File file, Trainee trainee){

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            new Gson().toJson(trainee,bw);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *    Десериализует Trainee из файла с Json-представлением Trainee,
     *    имя файла задается экземпляром класса File.

     * @param file
     * @return
     */
    public static Trainee  deserializeTraineeFromJsonFile(File file){

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            Gson gson = new Gson();
            Trainee trainee =  gson.fromJson(br,Trainee.class);
            return trainee;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
