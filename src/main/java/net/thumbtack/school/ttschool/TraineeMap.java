package net.thumbtack.school.ttschool;

import java.util.*;

public class TraineeMap {
    private Map<Trainee, String> traineeInfo;

    public TraineeMap() {
        traineeInfo = new HashMap<>();
    }

    public Map<Trainee, String> getTraineeInfo() {
        return traineeInfo;
    }

    /**
     * Добавляет пару Trainee - String в Map.
     * Если Map уже содержит информацию об этом Trainee,
     * выбрасывает TrainingException с TrainingErrorCode.DUPLICATE_TRAINEE.
     *
     * @param trainee
     * @param institute
     */
    public void addTraineeInfo(Trainee trainee, String institute) throws TrainingException {


        if (getTraineeInfo().containsKey(trainee))
            throw new TrainingException(TrainingErrorCode.DUPLICATE_TRAINEE);

        getTraineeInfo().put(trainee, institute);


    }

    /**
     * Если в Map уже есть информация о данном Trainee,
     * заменяет пару Trainee - String в Map на новую пару,
     * иначе выбрасывает TrainingException с TrainingErrorCode.TRAINEE_NOT_FOUND.
     *
     * @param trainee
     * @param institute
     */
    public void replaceTraineeInfo(Trainee trainee, String institute) throws TrainingException {
        if (!getTraineeInfo().containsKey(trainee))
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        getTraineeInfo().replace(trainee, institute);
    }

    /**
     * Возвращает количество элементов в Map, иными словами, количество студентов.
     *
     * @return
     */
    public int getTraineesCount() {
        return getTraineeInfo().size();
    }

    /**
     * Возвращает институт, в котором учится данный Trainee.
     * Если Map не содержит информации о таком Trainee,
     * выбрасывает TrainingException с TrainingErrorCode.TRAINEE_NOT_FOUND
     *
     * @param trainee
     * @return
     */
    public String getInstituteByTrainee(Trainee trainee) throws TrainingException {
        if (!getTraineeInfo().containsKey(trainee)) throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);


        return getTraineeInfo().get(trainee);

    }


    /**
     * Удаляет информацию о Trainee из Map.
     * Если Map не содержит информации о таком Trainee,
     * выбрасывает TrainingException с TrainingErrorCode.TRAINEE_NOT_FOUND.
     *
     * @param trainee
     */
    public void removeTraineeInfo(Trainee trainee) throws TrainingException {
        if (!getTraineeInfo().containsKey(trainee)) throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        getTraineeInfo().remove(trainee);

    }

    /**
     * Возвращает Set из всех имеющихся в Map Trainee.
     *
     * @return
     */
    public Set<Trainee> getAllTrainees() {
        return new HashSet<>(getTraineeInfo().keySet());
    }


    /**
     * Возвращает Set из всех институтов.
     *
     * @return
     */
    public Set<String> getAllInstitutes() {


        return new HashSet<>(getTraineeInfo().values());
    }

    /**
     * Возвращает true, если хоть один студент учится в этом institute, иначе false.
     *
     * @param institute
     * @return
     */
    public boolean isAnyFromInstitute(String institute) {

        return (getTraineeInfo().containsValue(institute));
    }


}
