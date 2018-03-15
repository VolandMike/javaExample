package net.thumbtack.school.ttschool;


import java.util.*;

public class Group {
    private String name;

    private String room;

    private List<Trainee> trainee;

    public Group(String name, String room) throws TrainingException {
        setName(name);
        setRoom(room);
        trainee = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TrainingException {

        if (name == null || name.equals(""))
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_NAME);
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) throws TrainingException {
        if (room == null || room.equals(""))
            throw new TrainingException(TrainingErrorCode.GROUP_WRONG_ROOM);
        this.room = room;
    }

    public List<Trainee> getTrainees() {
        return trainee;
    }

    public void setTrainee(List<Trainee> trainee) {
        this.trainee = trainee;
    }

    /**
     * Добавляет Trainee в группу.
     *
     * @param trainee
     */
    public void addTrainee(Trainee trainee) {
        getTrainees().add(trainee);
    }

    /**
     * Удаляет Trainee из группы. Если такого Trainee в группе нет,
     * выбрасывает TrainingException с TrainingErrorCode.TRAINEE_NOT_FOUND
     *
     * @param trainee
     */
    public void removeTrainee(Trainee trainee) throws TrainingException {
        if (getTrainees().isEmpty()) throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        boolean flag = false;
        for (Trainee trainee1 : getTrainees()) {
            if (trainee1.equals(trainee)) {
                getTrainees().remove(trainee);
                flag = true;
            }
        }
        if (!flag) throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }


    /**
     * Удаляет Trainee с данным номером в списке из группы.
     * Если номер не является допустимым, выбрасывает TrainingException с TrainingErrorCode.TRAINEE_NOT_FOUND
     *
     * @param index
     */
    public void removeTrainee(int index) throws TrainingException {
        if (getTrainees().isEmpty() || index >= getTrainees().size() || index < 0) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        } else {
            trainee.remove(index);
        }

    }

    /**
     * Возвращает первый найденный в списке группы Trainee, у которого имя равно firstName.
     * Если такого Trainee в группе нет, выбрасывает TrainingException с TrainingErrorCode.TRAINEE_NOT_FOUND
     *
     * @param firstName
     * @return
     */
    public Trainee getTraineeByFirstName(String firstName) throws TrainingException {
        if (getTrainees().isEmpty()) throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        for (Trainee trainee : getTrainees()) {
            if (trainee.getFirstName().equals(firstName)) {
                return trainee;
            }

        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    /**
     * Возвращает первый найденный в списке группы Trainee,
     * у которого полное имя равно fullName. Если такого Trainee в группе нет,
     * выбрасывает TrainingException с TrainingErrorCode.TRAINEE_NOT_FOUND
     *
     * @param fullName
     * @return
     */
    public Trainee getTraineeByFullName(String fullName) throws TrainingException {
        if (getTrainees().isEmpty()) throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        for (Trainee trainee : getTrainees()) {
            if (trainee.getFullName().equals(fullName)) {
                return trainee;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    /**
     * Сортирует список Trainee группы, упорядочивая его по возрастанию имени Trainee.
     */
    public void sortTraineeListByFirstNameAscendant() {
        Collections.sort(getTrainees(), Comparator.comparing(Trainee::getFirstName));
    }

    /**
     * Сортирует список Trainee группы, упорядочивая его по убыванию оценки Trainee.
     */
    public void sortTraineeListByRatingDescendant() {
        Collections.sort(getTrainees(), (t1, t2) -> {
            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
            return Integer.compare(t2.getRating(), t1.getRating());
        });
    }

    /**
     * Переворачивает список Trainee группы, то есть последний элемент списка становится начальным,
     * предпоследний - следующим за начальным и т.д..
     */
    public void reverseTraineeList() {
        Collections.reverse(getTrainees());
    }

    /**
     * Циклически сдвигает список Trainee группы на указанное число позиций.
     * Для положительного значения positions сдвигает вправо,
     * для отрицательного - влево на модуль значения positions.
     *
     * @param positions
     */
    public void rotateTraineeList(int positions) {
        Collections.rotate(getTrainees(), positions);
    }


    /**
     * Возвращает список тех Trainee группы , которые имеют наивысшую оценку.
     * Иными словами, если в группе есть Trainee с оценкой 5, возвращает список получивших оценку 5,
     * если же таких нет, но есть Trainee с оценкой 4, возвращает список получивших оценку 4 и т.д.
     * Для пустого списка выбрасывает TrainingException с TrainingErrorCode.TRAINEE_NOT_FOUND
     *
     * @return
     */
    public List<Trainee> getTraineesWithMaxRating() throws TrainingException {
        List<Trainee> traineeListFife = new LinkedList<>();
        List<Trainee> traineeListFour = new LinkedList<>();
        List<Trainee> traineeListThree = new LinkedList<>();
        List<Trainee> traineeListTwo = new LinkedList<>();
        List<Trainee> traineeListOne = new LinkedList<>();
        for (Trainee trainee : getTrainees()) {
            switch (trainee.getRating()) {
                case 1: {
                    traineeListOne.add(trainee);
                    break;
                }
                case 2: {
                    traineeListTwo.add(trainee);
                    break;
                }
                case 3: {
                    traineeListThree.add(trainee);
                    break;
                }
                case 4: {
                    traineeListFour.add(trainee);
                    break;
                }
                case 5: {
                    traineeListFife.add(trainee);
                    break;
                }
            }

        }

        if (!traineeListFife.isEmpty()) {
            return traineeListFife;
        } else if (!traineeListFour.isEmpty()) {
            return traineeListFour;
        } else if (!traineeListThree.isEmpty()) {
            return traineeListThree;
        } else if (!traineeListTwo.isEmpty()) {
            return traineeListTwo;
        } else if (!traineeListOne.isEmpty()) {
            return traineeListOne;
        }


        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    /**
     * Проверяет, есть ли в группе хотя бы одна пара Trainee, для которых совпадают имя, фамилия и оценка.
     *
     * @return
     */
    public boolean hasDuplicates() {
        Set<Trainee> set = new HashSet<Trainee>();

        for (Trainee each : getTrainees()) if (!set.add(each)) return true;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name) &&
                Objects.equals(room, group.room) &&
                Objects.equals(trainee, group.trainee);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, room, trainee);
    }
}
